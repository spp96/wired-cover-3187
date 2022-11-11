package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.GPMExceptions;
import Exceptions.ProjectsExceptions;
import Model.*;

public class AllocateProjectsToGPM {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gram Panchayite name ");
		String name = sc.next();
		
		System.out.println("Enter Project No ...");
		int projectId = sc.nextInt();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
	 try {
		Projects pro =	dao.allocateprojecttoGPM(name, projectId);
		
		System.out.println(name+ " Project allocte to "+ pro.getName());
	} catch (ProjectsExceptions e) {
		
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	} catch (GPMExceptions e) {
		
		e.printStackTrace();
		
		System.out.println(e.getMessage());
	}
		
	}
}
