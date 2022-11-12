package Model;

public class Projects {
	private String name;
	private int projectNo;
	private int noOfEmployee;
	private int totalWages;
	private String address;
	
	public Projects() {
		
	}

	public Projects(String name, int projectNo, int noOfEmployee, int totalWages, String address) {
		super();
		this.name = name;
		this.projectNo = projectNo;
		this.noOfEmployee = noOfEmployee;
		this.totalWages = totalWages;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public int getTotalWages() {
		return totalWages;
	}

	public void setTotalWages(int totalWages) {
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
		return "Projects [name=" + name + ", projectNo=" + projectNo + ", noOfEmployee=" + noOfEmployee
				+ ", totalWages=" + totalWages + ", address=" + address + "]";
	}


}
