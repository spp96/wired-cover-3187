package Usecases;

import java.util.Scanner;

import Dao.MGNREGAImpl;
import Dao.MGNREGA_DAO;
import Exceptions.GPMExceptions;
import Model.GPM;

public class AddGPMMember {
	public static void AddGPM() throws GPMExceptions {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Gram Panchayat Member Name");
		String membername = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Address");
		
		String memberAddress = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Contact Number");
		String memberPhone = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Username");
		
		String memberUsername = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Password");
		
		String memberpass = sc.next();
		
		MGNREGA_DAO dao = new MGNREGAImpl();
		
		GPM gram = new GPM(membername,memberAddress,memberPhone,memberUsername,memberpass);
		
		String res = dao.createnewGPM(gram);
		
		System.out.println(res);
		
	}

}
