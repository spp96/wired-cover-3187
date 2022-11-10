package Model;

public class GPM {

private int id;
private String name;
private String address;
private String phone;
private String username;
private String password;

public GPM() {
	
 }

public GPM(String name, String address, String phone, String username, String password) {
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.username = username;
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getUsername() {
	return username;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

@Override
public String toString() {
	return "GPM [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", username=" + username
			+ ", password=" + password + "]";
}

}
