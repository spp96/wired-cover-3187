package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.BDOExceptions;
import Model.BDO;

public class LoginBDO {
	public static boolean BDOlogin() {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String name = sc.nextLine();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		try {
			
		BDO bdo = dao.loginbdo(name, password);
			
			System.out.println("Welcome B.D.O "+ bdo.getUsername());
			
			return true;
			
		} catch (BDOExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		
	}

}
