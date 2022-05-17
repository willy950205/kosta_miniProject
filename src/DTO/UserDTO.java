package DTO;

public class UserDTO {
	private String id;
	private String password;
	private int residence;
	
	
	
	public UserDTO() {}
	
	
	public UserDTO(String id, String password, int residence) {
		super();
		this.id = id;
		this.password = password;
		this.residence = residence;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getResidence() {
		return residence;
	}
	public void setResidence(int residence) {
		this.residence = residence;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [id=");
		builder.append(id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", residence=");
		builder.append(residence);
		builder.append("]");
		return builder.toString();
	}	

}
