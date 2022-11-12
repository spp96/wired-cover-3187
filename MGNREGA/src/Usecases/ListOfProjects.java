package Usecases;

import java.util.*;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.ProjectsExceptions;
import Model.*;

public class ListOfProjects {
	public static void proList() throws ProjectsExceptions {
    MGNREGA_DAO dao = new MGNREGAImpl();
			
		List<Projects> pro = dao.listofProject();		
		for (Projects projects : pro) {
			System.out.println("Projects Number is:-"+ projects.getProjectNo());
			System.out.println("Project Name is:-"+ projects.getName());
			System.out.println("Project Address is:-"+ projects.getAddress());
			System.out.println("Total Employee Working On Projects is:-"+ projects.getNoOfEmployee());
			System.out.println("Total Wages of Project is:-"+ projects.getTotalWages());
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
	}

}
