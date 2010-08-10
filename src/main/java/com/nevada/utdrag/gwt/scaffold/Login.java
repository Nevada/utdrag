package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.nevada.utdrag.gwt.scaffold.service.UserService;
import com.nevada.utdrag.gwt.scaffold.service.UserServiceAsync;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	PopupPanel pop = new PopupPanel();

	private UserServiceAsync service = GWT.create(UserService.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	@UiField TextBox user;
	@UiField PasswordTextBox pass;
	@UiField Button login;
	@UiField Label error;
	@UiField Anchor create;
	
	private Listener listener;

	public interface Listener {
		void onLoginClicked(String user);
	}
	
	public void setListener(Listener listener) {
		this.listener = listener;
	}

	public Login() {
		initWidget(uiBinder.createAndBindUi(this));
		Create create = new Create();		
		create.setListener(new Create.Listener() {
			public void onCancelClicked() {
				pop.hide();
			}
			public void onOkClicked() {
				pop.hide();
			}
		});
		pop.setGlassEnabled(true);
		pop.add(create);
		pop.isModal();
		pop.setPopupPosition(300, 200);
	}

	@UiHandler("login")
	void onLoginClicked(ClickEvent event) {
		
		String name = user.getValue();
		String password = pass.getValue();
		if(name == null || password == null) {
			error.setText("Var vänlig skriv in både användarnamn och lösenord");
			return;
		}
		service.login(name, password, new AsyncCallback<Boolean>() {

			public void onFailure(Throwable arg0) {
				error.setText("error");
			}

			public void onSuccess(Boolean validLogin) {
				pass.setText("");
				if(validLogin) {
					listener.onLoginClicked(user.getValue());
				}
				else {
					error.setText("Ogiltigt användarnamn eller lösenord.");
				}
			}
		});
		
	}

	@UiHandler("create")
	void onClicked(ClickEvent event) {
		pop.show();
	}

}
