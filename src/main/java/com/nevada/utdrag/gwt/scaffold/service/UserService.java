package com.nevada.utdrag.gwt.scaffold.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	
	String getString();
	
	Boolean userAlreadyExists(String user);

	void addUser(String name, String password, String email);
	
	Boolean login(String name, String password);
}
