package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.ProjectsExceptions;
import Model.BDO;
import Model.Projects;

public class AddProjects {
	public static void AddPro() throws ProjectsExceptions {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Project Name");
		String projectname = sc.next();
		
		System.out.println("Enter Project Number");
		
		int pnumber = sc.nextInt();
		
		System.out.println("Total Employee Working On Project");
		int totalEmployee = sc.nextInt();
		
		System.out.println("Total Wages of Project");
		
		int totalWages = sc.nextInt();
		
		System.out.println("Project Location");
		
		String plocation = sc.next();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		Projects p = new Projects(projectname,pnumber,totalEmployee,totalWages,plocation);
		
		String res = dao.createproject(p);
		
		System.out.println(res);
		
	}

}
