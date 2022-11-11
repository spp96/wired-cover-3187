package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.EmployeeExceptions;
import Exceptions.GPMExceptions;
import Model.Employee;
import Model.GPM;

public class InsertNewEmployee {
	public static void main(String[] args) throws GPMExceptions, EmployeeExceptions {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Employee Name");
		String empname = sc.next();
		
		System.out.println("Enter Employee Gender");
		String empgender = sc.next();
		
		System.out.println("Enter Employee Address");
		
		String empAddress = sc.next();
		
		System.out.println("Enter Employee Contact Number");
		String empPhone = sc.next();
		
		System.out.println("Enter Employee Duty_Days");
		
		int empduty = sc.nextInt();
		
		System.out.println("Enter Employee Wages as Per Day");
		
		int empWages = sc.nextInt();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		Employee employee = new Employee(empname,empgender,empAddress,empPhone,empduty,empWages);
		
		String res = dao.createemployee(employee);
		
		System.out.println(res);
		
	}


}
