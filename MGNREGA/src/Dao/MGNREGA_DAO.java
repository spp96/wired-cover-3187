package Dao;

import java.sql.Connection;
import java.util.List;

import Exceptions.*;
import Model.*;

public interface MGNREGA_DAO {
public BDO loginbdo(String username,String password)throws BDOExceptions;
	
	public GPM loginGPM(String usename,String password)throws GPMExceptions;
	
	public String createproject(Projects project) throws ProjectsExceptions;
	
	public String createnewGPM(GPM gpm) throws GPMExceptions;
	
	public String allocateprojecttoGPM(int pid,int gpmid)throws ProjectsExceptions, GPMExceptions;
	
	public List<Projects> listofProject()throws ProjectsExceptions;
	
	public List<GPM> listofGPM()throws GPMExceptions;
	
	public String createemployee(Employee emp);
	
	public List<Employee> listofEmployee()throws EmployeeExceptions;
	
    public List<EmployeeList> employeeUnderProject()throws ProjectsExceptions;
    
    public String assignemptoproject(int pid,int empid)throws ProjectsExceptions,EmployeeExceptions;
	
}
