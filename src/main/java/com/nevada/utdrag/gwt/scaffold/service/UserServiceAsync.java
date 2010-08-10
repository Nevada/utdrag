package com.nevada.utdrag.gwt.scaffold.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {

	void getString(AsyncCallback<String> callback);

	void userAlreadyExists(String user, AsyncCallback<Boolean> callback);

	void addUser(String name, String password, String email, AsyncCallback<Void> callback);

	void login(String name, String password, AsyncCallback<Boolean> callback);

}
