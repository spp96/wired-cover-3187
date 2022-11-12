package Main_App;

import java.util.InputMismatchException;
import java.util.Scanner;

import CustomColors.Console;
import Exceptions.EmployeeExceptions;
import Exceptions.GPMExceptions;
import Exceptions.ProjectsExceptions;
import Usecases.AddGPMMember;
import Usecases.AddProjects;
import Usecases.AllocateProjectsToGPM;
import Usecases.AssignProjectToEmployee;
import Usecases.EmployeeDetails;
import Usecases.EmployeeWorkingOnProjectAndTheirWages;
import Usecases.Employee_TotalnoOfDaysWorkedAndTheirWages;
import Usecases.GPMMemberList;
import Usecases.InsertNewEmployee;
import Usecases.ListOfProjects;
import Usecases.LoginBDO;
import Usecases.LoginGPM;
import Usecases.UpdatePasswordOfGPM;

public class Main {
	public static void main(String[] args) {
		System.out.println( Console.BANANA_YELLOW+  "::::WELCOME To Mahatma Gandhi National Rural Employment Guarantee Act Application::::"+Console.BLACK_BACKGROUND_BRIGHT);
		System.out.println(Console.YELLOW_BOLD+ "<===================================The Hiring Club===================================>"+ Console.BLACK_BACKGROUND_BRIGHT);
		
		BDOORGPM();
	
	}
	static void BDOORGPM() {
		System.out.println(Console.DARK_BLUE + "+---------------------------+" + "\n"
						 						   + "| 1. Login As BDO |" + "\n"
						 						   + "| 2. Login As GPM |" + "\n"
						 						   + "| 3. Exit                   |" + "\n"
						 						   + "+---------------------------+" + Console.RESET);
		
		choice();
	}
	
	
	static void choice() {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println(Console.RED_BACKGROUND + "Input type should be number" + Console.RESET);
			BDOlogin();
		}
		
		if (choice == 1) {
			System.out.println(Console.WHITE_BOLD + "Welcome BDO ! Please Login to your account" + Console.RESET);
			BDOlogin();
		}
		else if (choice == 2) {
			System.out.println(Console.YELLOW_BOLD + "Welcome Gram Panchayat Member !" + Console.RESET);
			GPMlogin();
		}
		else if (choice == 3) {
			System.out.println(Console.BROWN + "Thank you ! Visit again" + Console.RESET);
			System.exit(0);
		}
		else {
			System.out.println(Console.RED_BACKGROUND + "Please choose a number from below options" + Console.RESET);
			BDOORGPM();
		}
	}
	 	static void BDOlogin() {
	 		Boolean result = LoginBDO.BDOlogin();

			if (result) BDOMethods();
			else {
				BDOlogin();
			}
		
	}
	 	static void GPMlogin() {
	 		Boolean result = LoginGPM.GPMlogin();

			if (result) GPMMethods();
			else {
				GPMlogin();
			}
			
	}
	 	
	 	static void BDOMethods() {
			System.out.println(Console.PURPLE + "+--------------------------------+" + "\n"
							 + "| Welcome To BDO                                             |" + "\n"
							 + "| 1. Create Projects                                         |" + "\n"
							 + "| 2. View List of Projects                                   |" + "\n"
							 + "| 3. Create New Gram Panchayat Member(GPM)                   |" + "\n"
							 + "| 4. View All GPM                                            |" + "\n"
							 + "| 5. Allocate Project to GPM                                 |" + "\n"
							 + "| 6. List of Employee Working on that Project and their wages|" + "\n"
							 + "| 7. Back To Login Panel                                     |" + "\n"
							 + "| 8. Exit                                                    |" + "\n"
							 + "+--------------------------------+" + Console.RESET);
			
			Scanner sc = new Scanner(System.in);
			
			int choice = 0;
			try {
				choice = sc.nextInt();
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice !=6 && choice!=7 && choice!=8) {
					System.out.println(Console.RED_BACKGROUND + "Please choose a number from below options" + Console.RESET);
					BDOMethods();
				}
				else BDOChoice(choice);
			}
			catch (InputMismatchException e) {
				
				System.out.println(Console.RED_BACKGROUND + "Input type should be number" + Console.RESET);
				BDOMethods();
			}
		}
	 	static void BDOChoice(int choice) {
			
			switch(choice) {
				case 1 : {
					
					
					try {
						AddProjects.AddPro();
					} catch (ProjectsExceptions e) {
						e.printStackTrace();
					}
					BDOMethods();
				}
				break;
				case 2 : {
					try {
						ListOfProjects.proList();
					} catch (ProjectsExceptions e) {
						e.printStackTrace();
					}
					BDOMethods();
				}
				break;
				case 3 : {
					try {
						AddGPMMember.AddGPM();
					} catch (GPMExceptions e) {
						e.printStackTrace();
					}
					BDOMethods();
				}
				break;
				case 4 : {
					try {
						GPMMemberList.GPMList();
					} catch (GPMExceptions e) {
						e.printStackTrace();
					}
					BDOMethods();
				}
				break;
				case 5 : {
					AllocateProjectsToGPM.AllocatePro();
					BDOMethods();
				}
				break;
				case 6 : {
					try {
						EmployeeWorkingOnProjectAndTheirWages.empWonProAndwages();
					} catch (EmployeeExceptions e) {
						e.printStackTrace();
					}
					BDOMethods();
				}
				break;
				case 7 : BDOORGPM();
				break;	
				case 8 : {
					System.out.println(Console.BLUE_BOLD + "Thank you ! Visit again" + Console.RESET);					
					System.exit(0);
				}
			}
	}
	 	static void GPMMethods() {
			System.out.println(Console.CYAN_BOLD + "+--------------------------------+" + "\n"
							 + "| Welcome To GPM                                             |" + "\n"
							 + "| 1. Change Password                                         |" + "\n"
							 + "| 2. Create Employee                                         |" + "\n"
							 + "| 3. View Details of Employee                                |" + "\n"
							 + "| 4. Assign Employee to a Project                            |" + "\n"
							 + "| 5. View total numbers of days Employee worked in a Project |" + "\n"
							 + "| 6. Back To Login Panel                                     |" + "\n"
							 + "| 7. Exit                                                    |" + "\n"
							 + "+--------------------------------+" + Console.RESET);
			
			Scanner sc = new Scanner(System.in);
			
			int gchoice = 0;
			try {
				gchoice = sc.nextInt();
				if (gchoice != 1 && gchoice != 2 && gchoice != 3 && gchoice != 4 && gchoice != 5 && gchoice !=6 && gchoice !=7) {
					System.out.println(Console.RED_BACKGROUND + "Please choose a number from below options" + Console.RESET);
					GPMMethods();;
				}
				else GPMChoice(gchoice);
			}
			catch (InputMismatchException e) {
				
				System.out.println(Console.RED_BACKGROUND + "Input type should be number" + Console.RESET);
				GPMMethods();
			}
		}
        static void GPMChoice(int gchoice) {
			
			switch(gchoice) {
			case 1 : {
				UpdatePasswordOfGPM.updatePass();
			        GPMMethods();
		        }
		        break;
				case 2 : {
						try {
							InsertNewEmployee.insertEmp();
						} catch (GPMExceptions e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EmployeeExceptions e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
					GPMMethods();
				}
				break;
				case 3 : {
					try {
						EmployeeDetails.empDetails();
					} catch (GPMExceptions e) {
						e.printStackTrace();
					} catch (EmployeeExceptions e) {
						e.printStackTrace();
					}
					GPMMethods();
				}
				break;
				case 4 : {
					AssignProjectToEmployee.AssignProToEmp();
					GPMMethods();
				}
				break;
				case 5 : {
					Employee_TotalnoOfDaysWorkedAndTheirWages.EmpTotalDWAndWages();
					GPMMethods();
				}
				break;
				case 6 : BDOORGPM();
				break;	
				case 7 : {
					System.out.println(Console.BLUE_BOLD + "Thank you ! Visit again" + Console.RESET);					
					System.exit(0);
				}
			}
	 	
}
}