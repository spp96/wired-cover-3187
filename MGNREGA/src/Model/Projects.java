package Model;

public class Projects {
	private int id;
	private String name;
	private int noOfEmployee;
	private String totalWages;
	private String address;
	
	public Projects() {
		
	}

	public Projects(String name, int noOfEmployee, String totalWages, String address) {
		super();
		this.name = name;
		this.noOfEmployee = noOfEmployee;
		this.totalWages = totalWages;
		this.address = address;
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

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public String getTotalWages() {
		return totalWages;
	}

	public void setTotalWages(String totalWages) {
		this.totalWages = totalWages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Projects [id=" + id + ", name=" + name + ", noOfEmployee=" + noOfEmployee + ", totalWages=" + totalWages
				+ ", address=" + address + ", ProjectNo=" + "]";
	}
	

}
