package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.BDOExceptions;
import Exceptions.GPMExceptions;
import Model.BDO;
import Model.GPM;

public class LoginGPM {
	public static boolean GPMlogin() {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String name = sc.nextLine();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		try {
			
		GPM gpm = dao.loginGPM(name, password);
			
			System.out.println("Welcome to Gram Panchayat. "+ gpm.getName());
			return true;
			
		} catch (GPMExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		
	}

}
