package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.ProjectsExceptions;
import Model.Projects;

public class Employee_TotalnoOfDaysWorkedAndTheirWages {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID ...");
		int proid = sc.nextInt();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		try {
			Projects pro = dao.totalNumbersOfDayAndTheirWages(proid);
			System.out.println("In "+pro.getName()+" total number of days Employee worked is "
							+pro.getNoOfEmployee()+" days and their total wages is "+
					pro.getTotalWages());
			
			
		} catch (ProjectsExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
