package com.lenycer.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * SpringSecurity config
 * @EnableWebSecurity로 spring security 관련 설정을 하겠다는 의미.
 * @author 현석
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * inMemory로 login test 시 inMemoryAuthentication()와 withUser로 처리 가능
	 * security dependency에 이미 /login form이 세팅되어 있음. http://localhost/login 으로 로그인 성공 시 default 설정인 htpp://localhost/ 로 이동
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
//			.inMemoryAuthentication()
			.jdbcAuthentication()
			.dataSource(dataSource);
//				.usersByUsernameQuery("select username, password, enabled from users where username=?") //db구조가 security세팅과 다르면 user와 authority query작성 필요
//				.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
//				.withUser("lenycer").password("asdf").roles("ADMIN");
	}
	
	/**
	 * 권한 설정
	 * 권한 설정된 url 비로그인시 login page로 이동..login 후 해당 페이지로. 
	 */
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//				.antMatchers("/resources/**", "/signup", "/about").permitAll() //multi로도 가능 없지만 테스트로  
//				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") //multi access
				.antMatchers("/view/simple/**").hasRole("ADMIN")
				.antMatchers("/view/user/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/**").permitAll()
				//.anyRequest().authenticated()
				.and()
				
			.formLogin() //form base login 허용. login 페이지및 권한 미설정시 permitAll /login 로 기본 설정됨.
				.loginPage("/login") 
				.permitAll()
				.and()	//xml 기반일때 xml tag closing을 의미함.
				
			//logout 관련 설정.
			//security에서 자동 설정된 logout은 아래와 같다.
			//Invalidating the HTTP Session
			//Cleaning up any RememberMe authentication that was configured
			//Clearing the SecurityContextHolder
			//Redirect to /login?success
//			.logout()                                                                
//				.logoutUrl("/my/logout")                                                 
//				.logoutSuccessUrl("/my/index")                                           
//				.logoutSuccessHandler(logoutSuccessHandler)                              
//				.invalidateHttpSession(true)                                             
//				.addLogoutHandler(logoutHandler)                                         
//				.deleteCookies(cookieNamesToClear)                                       
//				.and()
				
			.httpBasic(); //http 기반 인증 허용
	}
	
	/**
	 * Authentication Provider 설정을 통해 userDetailsService 및 패스워드 암호화를 설정할 수도 있고 
	 * 아래와 같이 override하여 직접 지정 가능함.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new ShaPasswordEncoder(256));
	}
}
