package epsi.talkative.repository;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	public Comment(){
		
	}
	
	public void setContenu(String contenu){
		this.contenu = contenu;
	}
	
	public String getContenu(){
		return this.contenu;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public void setTimestamp(long currentTimeMillis) {
		this.timestamp = currentTimeMillis; 
	}
	
	public long getTimestamp() {
		return this.timestamp; 
	}
	
	private long timestamp;
	private String pseudo;
	private String contenu;
	private String mail;
}