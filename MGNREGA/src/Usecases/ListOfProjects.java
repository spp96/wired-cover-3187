package Usecases;

import java.util.*;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.ProjectsExceptions;
import Model.*;

public class ListOfProjects {
	public static void main(String[] args) throws ProjectsExceptions {
    MGNREGA_DAO dao = new MGNREGAImpl();
		
		
		List<Projects> pro = dao.listofProject();
		pro.forEach(s -> System.out.println(s));
	}

}
