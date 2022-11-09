package Model;

public class EmployeeList {
	private String empname;
	private String pname;
	private int amount;
	
	public EmployeeList() {
		
	}

	public EmployeeList(String empname, String pname, int amount) {
		super();
		this.empname = empname;
		this.pname = pname;
		this.amount = amount;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "EmployeeList [empname=" + empname + ", pname=" + pname + ", amount=" + amount + "]";
	}
	
}
