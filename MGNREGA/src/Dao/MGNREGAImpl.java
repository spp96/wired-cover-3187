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
import Model.EmployeeList;
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
	public GPM loginGPM(String usename, String password) throws GPMExceptions {
		// TODO Auto-generated method stub
		return null;
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
	public String allocateprojecttoGPM(int pid, int gpmid) throws ProjectsExceptions, GPMExceptions {
		// TODO Auto-generated method stub
		return null;
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
	public String createemployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listofEmployee() throws EmployeeExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeList> employeeUnderProject() throws ProjectsExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignemptoproject(int pid, int empid) throws ProjectsExceptions, EmployeeExceptions {
		// TODO Auto-generated method stub
		return null;
	}

}
