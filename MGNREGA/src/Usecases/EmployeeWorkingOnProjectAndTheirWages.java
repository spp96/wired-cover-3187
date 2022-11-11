package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.EmployeeExceptions;
import Exceptions.ProjectsExceptions;
import Model.Employee;

public class EmployeeWorkingOnProjectAndTheirWages {
	public static void main(String[] args) throws EmployeeExceptions {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project Id ..");
		int proid = sc.nextInt();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		try {
			Employee emp = dao.listofAllEmployeeAndTheirwages(proid);
			System.out.println("In "+emp.getProject().getName()+" Project number of Employee working = "+emp.getNo_of_days()+" and their totalwages = "+ emp.getWages());
			
		} catch (ProjectsExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
