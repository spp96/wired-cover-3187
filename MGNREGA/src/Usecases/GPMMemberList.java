package Usecases;

import java.util.Iterator;
import java.util.List;

import CustomColors.Console;
import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.GPMExceptions;
import Exceptions.ProjectsExceptions;
import Model.GPM;
import Model.Projects;

public class GPMMemberList {
	public static void GPMList() throws GPMExceptions {
	    MGNREGA_DAO dao = new MGNREGAImpl();
   
	    List<GPM> gpmList = dao.listofGPM();
	    
	    for (GPM gpm : gpmList) {
			System.out.println("Member Id is:-"+ gpm.getId());
			System.out.println("Member Name is:-"+ gpm.getName());
			System.out.println("Member Address is:-"+ gpm.getAddress());
			System.out.println("Member Contact Number is:-"+ gpm.getPhone());
			System.out.println("Member Username is:-"+ gpm.getUsername());
			System.out.println("Member Password is:-"+ gpm.getPassword());
			System.out.println(Console.YELLOW_BOLD+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+Console.RESET);
		}
	    
	    
}
}
