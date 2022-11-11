package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.*;
import Model.Projects;

public class AssignProjectToEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id ");
		int emid = sc.nextInt();
		
		System.out.println("Enter Project No..");
		int prono = sc.nextInt();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		
		try {
			Projects pro =	dao.assignemptoproject(emid, prono);
			System.out.println(" Employee Id "+emid+ " assign project to "+pro.getName());
			
		} catch (EmployeeExceptions e) {
			
			System.out.println(e.getMessage());
			
			e.printStackTrace();
		} catch (ProjectsExceptions e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
