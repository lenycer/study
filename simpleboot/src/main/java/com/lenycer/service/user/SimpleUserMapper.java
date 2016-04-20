package com.lenycer.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lenycer.domain.user.SimpleUser;

public interface SimpleUserMapper {

	@Select("SELECT username, password, nick FROM users WHERE username = #{username}")
	public SimpleUser selectSimpleUser(@Param("username") String username);
	
	@Select("SELECT authority FROM authorities WHERE username = #{username}")
	public List<String> selectSimpleUserAuthorites(@Param("username") String username);
}
