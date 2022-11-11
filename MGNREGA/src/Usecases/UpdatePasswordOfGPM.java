package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.GPMExceptions;

public class UpdatePasswordOfGPM {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Your Username");
		
		String usernameGPM = sc.next();
		
		System.out.println("Enter New Password");
		
		String passGPM = sc.next();
		
		MGNREGA_DAO dao= new MGNREGAImpl();
		
		try {
			String res = dao.updatePasswordOfGPM(usernameGPM, passGPM);
			
			System.out.println(res);
		} catch (GPMExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
