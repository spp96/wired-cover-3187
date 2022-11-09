package Model;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String address;
	private String phone;
	private int no_of_days;
	private int wages;
	private int projAssigned;
	private int gpossigned;
public Employee() {
	
}
public Employee(String name, String gender, String address, String phone, int no_of_days, int wages,
		int projAssigned, int gPOAssigned) {
	super();
	this.name = name;
	this.gender = gender;
	this.address = address;
	this.phone = phone;
	this.no_of_days = no_of_days;
	this.wages = wages;
	this.projAssigned = projAssigned;
	this.gpossigned = gPOAssigned;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
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
public int getNo_of_days() {
	return no_of_days;
}
public void setNo_of_days(int no_of_days) {
	this.no_of_days = no_of_days;
}
public int getWages() {
	return wages;
}
public void setWages(int wages) {
	this.wages = wages;
}
public int getProjAssigned() {
	return projAssigned;
}
public void setProjAssigned(int projAssigned) {
	projAssigned = projAssigned;
}
public int getGPOAssigned() {
	return gpossigned;
}
public void setGPOAssigned(int gPOAssigned) {
	gpossigned = gPOAssigned;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", phone=" + phone
			+ ", no_of_days=" + no_of_days + ", wages=" + wages + ", projAssigned=" + projAssigned + ", gpossigned="
			+ gpossigned + "]";
}


}
