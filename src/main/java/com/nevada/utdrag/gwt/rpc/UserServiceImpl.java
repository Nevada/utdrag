package com.nevada.utdrag.gwt.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.nevada.utdrag.gwt.scaffold.service.UserService;
import com.nevada.utdrag.RegularUser;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {

	private static final long serialVersionUID = 1L;

	public String getString() {
		RegularUser u = new RegularUser("Joe", "pass");
		u.persist();
		RegularUser u2 = new RegularUser("Dan", "pass");
		u2.persist();
		
		return "done";
	}

	public Boolean userAlreadyExists(String user) {
		int i = RegularUser.findRegularUsersByName(user).getResultList().size();
		return (i > 0) ? true : false;
	}

	public void addUser(String name, String password, String email) {
		RegularUser user = new RegularUser(name, password);
		user.setEmail(email);
		user.persist();
	}

	public Boolean login(String name, String password) {
		int i = RegularUser.findRegularUsersByNameAndPw(name, password).getResultList().size();
		return (i > 0) ? true : false;
	}

}
