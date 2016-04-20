/**
 * Principal <- spring security api의 Authentication(인증) interface가 상속함. 로그인아이디같은 엔티티를 나타내는 추상화 개념.
 * 
 * 인증이 되면 threadlocal의 securityContext에 Authentication이 저장됨.
 * 
 * 결국 로그인 하면 principal이라는 이름으로 저장된다고 보면 됨. 이 principal에 들어갈 수 있는 class는 UserDetails(spring interface)를 구현하거나 User를 상속하여 함 .
 * 
 * 이 project에서는 SimpleUserDetail이 그 역할을 함.(추가 정보를 제공하려면 해당 class에 구현하면 된다.)
 * 
 * 그리고 로그인하여 사용하려면 UserDetailsService의 구현체를 만들어서 loadUserByUsername 메서드를 구현해야 함.
 * 
 */
/**
 * @author 현석
 *
 */
package com.lenycer.service.user;