package org.midstr.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Computer {

	private String name;
	private String ip;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name").append(name).append(
				"ip").append(ip).toString();
	}
}
