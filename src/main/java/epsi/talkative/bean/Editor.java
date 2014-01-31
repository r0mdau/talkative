package epsi.talkative.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Editor {
	public Editor() {

	}
	
	public Editor(String login, String password, String mail) {
		this.password = password;
		this.login = login;
		this.mail = mail;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setTimestamp(long currentTimeMillis) {
		this.timestamp = currentTimeMillis;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	private String login;
	private String password;
	private String mail;
	private long timestamp;
}
