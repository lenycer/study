package com.lenycer.domain.user;

import java.util.List;

import lombok.Data;

@Data
public class SimpleUser {

	private Long id;
	
	private String username;
	
	private String password;
	
	private List<String> role;
	
	private String nick;
}
