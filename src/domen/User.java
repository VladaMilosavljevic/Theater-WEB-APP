package domen;

public class User {
	private int id;
	private String username;
	private String password;
	private int status;
	private String ime;
	private String mail;
	public int getId() {
		return id;
	}
	public User(int id, String username, String password, int status, String ime, String mail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.ime = ime;
		this.mail = mail;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
