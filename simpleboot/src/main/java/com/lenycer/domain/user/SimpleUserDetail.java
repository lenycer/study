package com.lenycer.domain.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Security의 User를 상속해서 구현.
 * @author 현석
 *
 */
@Slf4j
public class SimpleUserDetail extends User {
	
	private static final long serialVersionUID = 5766634114194219502L;
	
	private String nick;
	
	public SimpleUserDetail(SimpleUser simpleUser) {
		super(simpleUser.getUsername(), simpleUser.getPassword(), authorities(simpleUser));
		this.nick = simpleUser.getNick();
		log.debug("SimpleUserDeatail : {}", simpleUser.toString());
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * 여러개의 role이 존재할 수 있음.
	 * @param simpleUser
	 * @return
	 */
	private static Collection<? extends GrantedAuthority> authorities(SimpleUser simpleUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(simpleUser != null && simpleUser.getRole() != null) {
			for(String role : simpleUser.getRole()) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		return authorities;
	}

}
