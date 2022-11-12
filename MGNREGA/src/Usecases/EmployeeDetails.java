package Usecases;

import java.util.List;
import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.EmployeeExceptions;
import Exceptions.GPMExceptions;
import Model.Employee;
import Model.GPM;

public class EmployeeDetails {
	public static void empDetails() throws GPMExceptions, EmployeeExceptions {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID ");
		int id = sc.nextInt();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		try {
			Employee emp = dao.ViewDetailsEmployee(id);
			System.out.println("Employee ID:-"+emp.getId()
			                   +"\n"+ "Employee Name:- "+emp.getName()+"\n"+
					            "Employee Gender:- "+emp.getGender() +"\n"+
					            "Employee Address:- "+emp.getAddress()+"\n"+
			                    "Employee Phone No.:- "+ emp.getPhone()+"\n"+
					            "Number of days Employee Worked is:-"+emp.getNo_of_days()+"\n"+
					            "Employee Wages:- "+emp.getWages());
				
			
		} catch (EmployeeExceptions e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

}
}
