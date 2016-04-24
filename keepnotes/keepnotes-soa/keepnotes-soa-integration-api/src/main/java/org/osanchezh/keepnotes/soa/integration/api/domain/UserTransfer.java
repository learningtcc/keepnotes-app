package org.osanchezh.keepnotes.soa.integration.api.domain;

import java.io.Serializable;
import java.util.Map;


public class UserTransfer implements Serializable
{

	private static final long serialVersionUID = 3323573993039777915L;




	private String name;

	private Map<String, Boolean> roles;


	public UserTransfer(String userName, Map<String, Boolean> roles)
	{
		this.name = userName;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}


	public Map<String, Boolean> getRoles() {
		return roles;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Map<String, Boolean> roles) {
		this.roles = roles;
	}
}