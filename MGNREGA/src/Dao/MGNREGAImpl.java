package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Exceptions.BDOExceptions;
import Exceptions.EmployeeExceptions;
import Exceptions.GPMExceptions;
import Exceptions.ProjectsExceptions;
import Model.BDO;
import Model.Employee;
import Model.GPM;
import Model.Projects;
import Utility.DBUtil;

public class MGNREGAImpl implements MGNREGA_DAO {

	private String username;

	@Override
	public BDO loginbdo(String username, String password) throws BDOExceptions {
		// TODO Auto-generated method stub
        BDO bdo = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement(" select username from bdo where username= ? AND password= ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
		ResultSet rs =	ps.executeQuery();
		
		if(rs.next()) {
			
			String name = rs.getString("username");
			
		bdo = new BDO();
			bdo.setUsername(name);
			
		}
		else {
			throw new BDOExceptions("Invalid Username or password..");
		}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDOExceptions(e.getMessage());
			
		}	
		return bdo;
	}

	@Override
	public GPM loginGPM(String username, String password) throws GPMExceptions {
		 GPM gpm = null;
			
			try(Connection conn = DBUtil.provideConnection()) {
				
			PreparedStatement ps = conn.prepareStatement(" select name from gpm where username= ? AND password= ?");
				
				ps.setString(1, username);
				ps.setString(2, password);
				
			ResultSet rs =	ps.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString("name");
				
				gpm = new GPM();
				gpm.setName(name);
				
			}
			else {
				throw new GPMExceptions("Invalid Username or password..");
			}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new GPMExceptions(e.getMessage());
				
			}	
			return gpm;
	}

	@Override
	public String createproject(Projects project) throws ProjectsExceptions {
		// TODO Auto-generated method stub
		
		String message = "Not Inserted";
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into projects(name, projectNo,address,noOfEmployee,totalwages) values(?,?,?,?,?)");
			
			ps.setString(1, project.getName());
			ps.setInt(2, project.getProjectNo());
			ps.setString(3, project.getAddress());
			ps.setInt(4, project.getNoOfEmployee());
			ps.setInt(5, project.getTotalWages());
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				message="Project added successfully......";
			}
			
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new ProjectsExceptions(e.getMessage());
			}
			return message;
			
	}

	@Override
	public String createnewGPM(GPM gpm) throws GPMExceptions {
		// TODO Auto-generated method stub
		
       String message = "Not Inserted";
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into GPM(name,address,phone,username,password) values(?,?,?,?,?)");
			
			ps.setString(1, gpm.getName());
			ps.setString(2, gpm.getAddress());
			ps.setString(3, gpm.getPhone());
			ps.setString(4, gpm.getUsername());
			ps.setString(5, gpm.getPassword());
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				message="New GPM Member Added......";
			}
			
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new GPMExceptions(e.getMessage());
			}
			return message;
	}
	@Override
	public List<Projects> listofProject() throws ProjectsExceptions {
		// TODO Auto-generated method stub
		
		List<Projects> project= new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Projects");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				String proname= rs.getString("name");
				int pronum = rs.getInt("projectNo");
				String address=rs.getString("address");
				int list_of_employeeworking=rs.getInt("noOfEmployee");
				int wages= rs.getInt("totalwages");
				
				
				Projects pro= new Projects();
		
				pro.setName(proname);
				pro.setProjectNo(pronum);
				pro.setAddress(address);
				pro.setNoOfEmployee(list_of_employeeworking);
				pro.setTotalWages(wages);
				project.add(pro);

			}
			
			  
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new ProjectsExceptions();
		}
		
		
		
		
		return project;
	}

	@Override
	public List<GPM> listofGPM() throws GPMExceptions {
		// TODO Auto-generated method stub
List<GPM> GramPanchayatMember= new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from GPM");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int mid = rs.getInt("id");
				String memberName = rs.getString("name");
				String memberAddress = rs.getString("address");
				String memberPhone = rs.getString("phone");
				String memberUsername = rs.getString("username");
				String memberPass = rs.getString("password");
							
				
				GPM gpmList= new GPM();
				
				gpmList.setId(mid);
				gpmList.setName(memberName);
				gpmList.setAddress(memberAddress);
				gpmList.setPhone(memberPhone);
				gpmList.setUsername(memberUsername);
				gpmList.setPassword(memberPass);
				
				GramPanchayatMember.add(gpmList);

			}
			
			  
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new GPMExceptions();
		}
			
		return GramPanchayatMember;
	}
	
	@Override
	public Projects allocateprojecttoGPM(String name, int pid) throws ProjectsExceptions, GPMExceptions {
		  Projects pro = null;
			
			try (Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select id from gpm where name = ?");
				
				ps.setString(1, name);
				
				ResultSet rs1 = ps.executeQuery();
				
				if(rs1.next()) {
				PreparedStatement ps2=conn.prepareStatement("select projectNo,name from projects where projectNo = ?");
				int gid = rs1.getInt("id");
				
				ps2.setInt(1, pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					String ProName = rs2.getString("name");
					
				PreparedStatement ps3 = conn.prepareStatement("insert into allocate_project values(?,?)");
				
				ps3.setInt(1, gid);
				ps3.setInt(2, pid);
				
			 	int x = ps3.executeUpdate();
			 	if(x>0) {
			 		pro = new Projects();
			 		pro.setName(ProName);
			 		
			 	}
			 	else {
			 		throw new ProjectsExceptions("Technical eror......");
			 	}
					
					
				}
				else {
					throw new ProjectsExceptions("Invalid Project id....");
				}
					
					
				}
				else {
					throw new GPMExceptions("B.D.O is not found "+name);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new GPMExceptions(e.getMessage());
			}
			
			return pro;
	}

	@Override
	public String createemployee(Employee emp) throws EmployeeExceptions {
		 String message = "Not Inserted";
			
			try (Connection conn=DBUtil.provideConnection()){
				PreparedStatement ps = conn.prepareStatement("insert into employee(name,gender,address,phone,no_duty_day,wages) values(?,?,?,?,?,?)");
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getGender());
				ps.setString(3, emp.getAddress());
				ps.setString(4, emp.getPhone());
				ps.setInt(5, emp.getNo_of_days());
				int total = emp.getNo_of_days()*emp.getWages();
				ps.setInt(6,total);
				
				int x=ps.executeUpdate();
				if(x>0)
				{
					message="New Employee Added......";
				}
				
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new EmployeeExceptions(e.getMessage());
				}
				return message;
	}

	@Override
	public List<Employee> detailsOfEmployee() throws EmployeeExceptions {
     List<Employee> emplist=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from employee");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String gender = rs.getString("gender");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				int noofady=rs.getInt("no_duty_day");
				int proassigned = rs.getInt("projAssigned");
				int gpoassigned = rs.getInt("gpossigned");
				int amount=rs.getInt("wages");
				
				Employee emp=new Employee();
				
				emp.setId(id);
				emp.setName(name);
				emp.setGender(gender);
				emp.setAddress(address);
				emp.setPhone(phone);
				emp.setNo_of_days(noofady);
				emp.setProjAssigned(proassigned);
				emp.setGpossigned(gpoassigned);
				emp.setWages(amount);
				emplist.add(emp);
			}
			
		} catch (SQLException e) {
			throw new EmployeeExceptions(e.getMessage());
		}
		
		if(emplist.size()==0)
		{
			throw new EmployeeExceptions("No Employee Found...");
		}

		return emplist;
	}

	@Override
	public Employee ViewDetailsEmployee(int emid) throws EmployeeExceptions {
          Employee emp = null;
		
		try (Connection conn = DBUtil.provideConnection()) {
			
		PreparedStatement ps =	conn.prepareStatement("select * from employee where id = ?");
		ps.setInt(1, emid);
		
		ResultSet rs1 = ps.executeQuery();
		
		if(rs1.next()) {
			int empid = rs1.getInt("id");
			String ename =rs1.getString("name");
			String gender = rs1.getString("gender");
			String address = rs1.getString("address");
			String phone = rs1.getString("phone");
			int douty = rs1.getInt("no_duty_day");
			int proId = rs1.getInt("projAssigned");
			int wages = rs1.getInt("wages");
			
			PreparedStatement ps2 = conn.prepareStatement("select name from projects where projectNo = ?");
			
			ps2.setInt(1, proId);
			
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next()) {
				String ProName = rs2.getString("name");
				
				emp = new Employee();
				emp.setName(ename);
				emp.setGender(gender);
				emp.setAddress(address);
				emp.setId(empid);
				emp.setPhone(phone);
				Projects pro = new Projects();
				pro.setName(ProName);
				emp.setProject(pro);
				emp.setWages(wages);
				
				
				
			}
					
		}
		else {
			throw new EmployeeExceptions("Invalid Employee Id"+ emid);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeExceptions(e.getMessage());
		}	
		
		return emp;
	}

	@Override
	public Projects assignemptoproject(int pid, int empid) throws ProjectsExceptions, EmployeeExceptions {
		Projects pro = null;
		
		try (Connection conn = DBUtil.provideConnection()) {
					
					PreparedStatement ps = conn.prepareStatement("select id from employee where id = ?");
					
					ps.setInt(1, empid);
					
					ResultSet rs1 = ps.executeQuery();
					
					if(rs1.next()) {
					PreparedStatement ps2=conn.prepareStatement("select projectNo,name from projects where projectNo = ?");
					
					ps2.setInt(1, pid);
					
					ResultSet rs2 = ps2.executeQuery();
					
					if(rs2.next()) {
						String ProName = rs2.getString("name");
						
					PreparedStatement ps3 = conn.prepareStatement("update employee set projAssigned =? where id = ?");
					
					ps3.setInt(1, pid);
					ps3.setInt(2, empid);
					
				 	int x = ps3.executeUpdate();
				 	if(x>0) {
				 		pro = new Projects();
				 		pro.setName(ProName);
				 		
				 	}
				 	else {
				 		throw new ProjectsExceptions("Technical eror......");
				 	}
						
						
					}
					else {
						throw new ProjectsExceptions("Invalid Project id....");
					}
						
						
					}
					else {
						throw new EmployeeExceptions("Employee is not found "+empid);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new EmployeeExceptions(e.getMessage());
				}
							
				
				return pro;

	}

	@Override
	public String updatePasswordOfGPM(String username, String password) throws GPMExceptions {
		String message = "Not Updated....";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps =conn.prepareStatement("update gpm set password = ? where username = ?");
			
			ps.setString(1, password);
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Password Updated Successfully.....!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new GPMExceptions(e.getMessage());
		}
		return message;
				
	}

	@Override
	public Employee listofAllEmployeeAndTheirwages(int pid) throws EmployeeExceptions, ProjectsExceptions {
         Employee emp = null;
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from projects where projectNo =?");
			
			ps.setInt(1, pid);
			
			ResultSet rs1 = ps.executeQuery();
			
			if(rs1.next()) {
			PreparedStatement ps1=conn.prepareStatement(" select count(projAssigned)totalemployee ,sum(wages)total_wages,p. name  from employee e INNER JOIN Projects p ON e.projAssigned = p.projectNO where p.projectNo=?");
				
				ps1.setInt(1, pid);
				ResultSet rs2 = ps1.executeQuery();
				if(rs2.next()) {
					int totalepm = rs2.getInt("totalemployee");
					int totalwage = rs2.getInt("total_wages");
					String name = rs2.getString("name");
					
					
					emp = new Employee();
					emp.setNo_of_days(totalepm);
					emp.setWages(totalwage);
					Projects proj = new Projects();
					proj.setName(name);
					emp.setProject(proj);
				}
				
			}
			else
				throw new ProjectsExceptions("invaid Project ID : "+pid);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectsExceptions(e.getMessage());
		}
		
		return emp;
		
	}

	@Override
	public Projects totalNumbersOfDayAndTheirWages(int pid) throws ProjectsExceptions {
	Projects project = null;
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps1 = conn.prepareStatement("select name from projects where projectno = ?");
			
			ps1.setInt(1, pid);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
			PreparedStatement ps2 =conn.prepareCall("select sum(no_duty_day)totaldays ,sum(wages)totalwages,p.name  from employee e INNER JOIN Projects p ON e.projAssigned = p.projectNO where p.projectNo=?");
				ps2.setInt(1, pid);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					int days = rs2.getInt("totaldays");
					int wages = rs2.getInt("totalwages");
					String name = rs2.getString("name");
					
					project = new Projects();
					project.setNoOfEmployee(days);
					project.setTotalWages(wages);
					project.setName(name);
				}
				
				
			}
			else
				throw new ProjectsExceptions("Invaid Project Id ");
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ProjectsExceptions(e.getMessage());
		}
		
		
		return project;
	}

}

