package com.lucy.service;

public class Contextservice {
	public String getcontext() {
		return new com.lucy.dao.Getcontext().getcontext();
	}
	public boolean xiugai(String str) {
		return new com.lucy.dao.Getcontext().xiugai(str);
	}
}
