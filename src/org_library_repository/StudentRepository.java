package org_library_repository;
import java.util.*;
import org_library_model.StudentModel;

public class StudentRepository extends DBConfig{
	int value;
	List <StudentModel> lst=new ArrayList();
	public boolean isAddStudent(StudentModel studModel)
	{
		try {
			stmt=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			stmt.setInt(1, studModel.getStid());
			stmt.setString(2, studModel.getStname());
			stmt.setString(3, studModel.getStcontact());
			stmt.setString(4, studModel.getStemail());
			stmt.setString(5, studModel.getStyear());
			stmt.setString(6, studModel.getUsername());
			stmt.setString(7, studModel.getPassword());
			value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return false;
		}
	}
	
	public List<StudentModel> viewStudentInfo()
	{
		
		try {
			stmt=conn.prepareStatement("select * from student");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				StudentModel sModel=new StudentModel();
				sModel.setStid(rs.getInt(1));
				sModel.setStname(rs.getNString(2));
				sModel.setStcontact(rs.getNString(3));
				sModel.setStemail(rs.getNString(4));
				sModel.setStyear(rs.getNString(5));
				sModel.setUsername(rs.getString(6));
				sModel.setPassword(rs.getString(7));
				lst.add(sModel);
			}
			return lst.size()>0?lst:null;
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return null;
		}
	}

	public boolean isUpdateStudentInfo(StudentModel sModel) 
	{
		try {
			stmt=conn.prepareStatement("update student set st_name=?,st_contact=?,st_email=?,st_year=?,username=?,password=? where st_id=?");
			stmt.setString(1,sModel.getStname() );
			stmt.setString(2, sModel.getStcontact());
			stmt.setString(3, sModel.getStemail());
			stmt.setString(4, sModel.getStyear());
			stmt.setString(5, sModel.getUsername());
			stmt.setString(6, sModel.getPassword());
			stmt.setInt(7,sModel.getStid());
			value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return false;
		}
	}

	public boolean isDeleteStudent(int sid) 
	{
	   try {
		   stmt=conn.prepareStatement("delete from student where st_id=?");
		   stmt.setInt(1, sid);
		   value=stmt.executeUpdate();  //0 or 1
		   if(value>0)
		   {
			   return true;
		   }
		   else
		   {
			   return false;
		   }
	   }
	   catch(Exception ex)
	   {
		   System.out.println("Exception is "+ex);
		   return false;
	   }
	}

	public int isValidStudent(String user1, String pass1)
	{
		try {
			stmt=conn.prepareStatement("select st_id from student where username=? and password=?");
			stmt.setString(1, user1);
			stmt.setString(2, pass1);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1); 
			}
			return 0;
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return 0;
		}
		
	}

	public List<StudentModel> showMyInfo(String user1, String pass1)
	{
//		List<StudentModel> lst=new ArrayList<StudentModel>();
		try {
			stmt=conn.prepareStatement("select * from student where username=? and password=?");
			stmt.setString(1, user1);
			stmt.setString(2, pass1);
			rs=stmt.executeQuery();			
			while(rs.next())
			{
			  StudentModel smodel=new StudentModel();
			  smodel.setStid(rs.getInt(1));
				smodel.setStname(rs.getString(2));
				smodel.setStcontact(rs.getString(3));
				smodel.setStemail(rs.getString(4));
				smodel.setStyear(rs.getString(5));
				smodel.setUsername(rs.getString(6));
				smodel.setPassword(rs.getString(7));
				lst.add(smodel);
			}
			return lst.size()>0?lst:null;
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return null;
		}
	}
}
