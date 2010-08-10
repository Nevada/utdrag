package com.nevada.utdrag.gwt.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.nevada.utdrag.gwt.scaffold.service.UserService;
import com.nevada.utdrag.gwt.scaffold.service.UserServiceAsync;

public class Create extends Composite {

	private static CreateUiBinder uiBinder = GWT.create(CreateUiBinder.class);
	
	private UserServiceAsync service = GWT.create(UserService.class);

	interface CreateUiBinder extends UiBinder<Widget, Create> {
	}
	
	interface MyStyle extends CssResource {
	    String red();
	    String green();
	    String redText();
	    String greenText();
	  }

	private Listener listener;

	public interface Listener {
		void onOkClicked();
		void onCancelClicked();
	}
	
	public void setListener(Listener listener) {
		this.listener = listener;
	}

	@UiField TextBox username;
	@UiField PasswordTextBox pass1;
	@UiField PasswordTextBox pass2;
	
	@UiField Button cancel;
	@UiField Button ok;
	@UiField Label usernameLabel;
	@UiField MyStyle style2;
	@UiField HTMLPanel usernameField;
	@UiField HTMLPanel passField1;
	@UiField Label passLabel1;
	@UiField HTMLPanel passField2;
	@UiField Label passLabel2;
	
	@UiField HTMLPanel emailField;
	@UiField TextBox email;
	@UiField Label emailLabel;

	
	public Create() {
		initWidget(uiBinder.createAndBindUi(this));
		username.setFocus(true);
	}
	
	@UiHandler("email") 
	void changeEmail(ChangeEvent e) {
	     
		if(email.getText().matches("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Za-z]{2,4}$")) {
			emailLabel.setText("ok");
			emailField.addStyleName(style2.green());
			emailField.removeStyleName(style2.red());
			emailLabel.addStyleName(style2.greenText());
			emailLabel.removeStyleName(style2.redText());
		}
		else {
			emailLabel.setText("Ogiltig e-postadress.");
			emailField.addStyleName(style2.red());
			emailField.removeStyleName(style2.green());
			emailLabel.addStyleName(style2.redText());
			emailLabel.removeStyleName(style2.greenText());
		}
		
	}
	
	@UiHandler("pass2")
	void onChangePass(ChangeEvent e) {
		if(pass2.getText().equals(pass1.getText())) {
			passField1.addStyleName(style2.green());
			passLabel1.addStyleName(style2.greenText());
			passField2.addStyleName(style2.green());
			passLabel2.addStyleName(style2.greenText());
			passField1.removeStyleName(style2.red());
			passLabel1.removeStyleName(style2.redText());
			passField2.removeStyleName(style2.red());
			passLabel2.removeStyleName(style2.redText());
			passLabel1.setText("ok");
			passLabel2.setText("ok");
		}
		else {
			passField1.addStyleName(style2.red());
			passLabel1.addStyleName(style2.redText());
			passField2.addStyleName(style2.red());
			passLabel2.addStyleName(style2.redText());
			passField1.removeStyleName(style2.green());
			passLabel1.removeStyleName(style2.greenText());
			passField2.removeStyleName(style2.green());
			passLabel2.removeStyleName(style2.greenText());			
			passLabel1.setText("Lösenorden stämmer inte.");
			passLabel2.setText("Lösenorden stämmer inte.");
		}
	}
	
	@UiHandler("username")
	void onChange(ChangeEvent e) {
		service.userAlreadyExists(username.getText(), new AsyncCallback<Boolean>() {
			public void onSuccess(Boolean userAlreadyExists) {
				if(userAlreadyExists) {
					usernameLabel.setText("Användarnamnet upptaget");
					usernameLabel.removeStyleName(style2.greenText());
					usernameLabel.addStyleName(style2.redText());
					usernameField.removeStyleName(style2.green());
					usernameField.addStyleName(style2.red());
				}
				else {
					usernameLabel.setText("ok");
					usernameLabel.removeStyleName(style2.redText());
					usernameLabel.addStyleName(style2.greenText());
					usernameField.removeStyleName(style2.red());
					usernameField.addStyleName(style2.green());
				}
			}
			public void onFailure(Throwable caught) {
				usernameLabel.setText("error");
			}
		});	
	}

	@UiHandler("ok")
	void onOkClicked(ClickEvent event) {
		service.addUser(username.getText(), pass1.getText(), email.getText(), new AsyncCallback<Void>() {
			public void onFailure(Throwable caught) {
				System.out.println("..tråkigheter");
			}
			public void onSuccess(Void arg0) {
				Window.alert("användare skapad");
			}
		});
		
	}
	@UiHandler("cancel")
	void onCancelClicked(ClickEvent event) {
		if (listener != null) {
			listener.onCancelClicked();
		}
	}
}
