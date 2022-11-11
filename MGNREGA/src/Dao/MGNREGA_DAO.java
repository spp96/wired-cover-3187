package Dao;

import java.sql.Connection;
import java.util.List;

import Exceptions.*;
import Model.*;

public interface MGNREGA_DAO {
    public BDO loginbdo(String username,String password)throws BDOExceptions;
	
	public GPM loginGPM(String username,String password)throws GPMExceptions;
	
	public String createproject(Projects project) throws ProjectsExceptions;
	
	public String createnewGPM(GPM gpm) throws GPMExceptions;
	
    Projects allocateprojecttoGPM(String name,int pid)throws ProjectsExceptions, GPMExceptions;
	
	public List<Projects> listofProject()throws ProjectsExceptions;
	
	public List<GPM> listofGPM()throws GPMExceptions;
	
	public String createemployee(Employee emp) throws EmployeeExceptions;
	
	public List<Employee> detailsOfEmployee()throws EmployeeExceptions;
	
	public Employee ViewDetailsEmployee(int emid) throws EmployeeExceptions;
    
    Projects assignemptoproject(int pid,int empid)throws ProjectsExceptions,EmployeeExceptions;
    
    public String updatePasswordOfGPM(String username, String password ) throws GPMExceptions;
    
    public Employee listofAllEmployeeAndTheirwages(int pid) throws EmployeeExceptions, ProjectsExceptions;
    
    public Projects totalNumbersOfDayAndTheirWages(int pid) throws ProjectsExceptions;
    
	
}
