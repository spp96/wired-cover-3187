package Usecases;

import java.util.List;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.GPMExceptions;
import Exceptions.ProjectsExceptions;
import Model.GPM;
import Model.Projects;

public class GPMMemberList {
	public static void main(String[] args) throws GPMExceptions {
	    MGNREGA_DAO dao = new MGNREGAImpl();
			
			
			List<GPM> gram = dao.listofGPM();
			gram.forEach(s -> System.out.println(s));
		}
}
