package org.osanchezh.keepnotes.soa.integration.api.domain;

import java.io.Serializable;

public class TokenTransfer implements Serializable
{
	private static final long serialVersionUID = -303849046870538721L;
	private String token;

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken()
	{
		return this.token;
	}

}