package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.Student;

public class StudentDao
{
	
	public static Connection getConncetion()
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","Shubham@15");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return con;
	}
	public static int insertStudent(Student s)
	{
		int status = 0;
		
		try 
		{
			Connection con = StudentDao.getConncetion();
			PreparedStatement ps = con.prepareStatement("insert into student values(0,?,?,?,?,?,?)");
			
			ps.setString(1, s.getName());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getContactno());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getBirthdate());
			ps.setString(6, s.getCity());
			
			status = ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Student> viewData()
	{
		List<Student> li = new ArrayList<Student>();
		
		try 
		{
			Connection con = StudentDao.getConncetion();
			PreparedStatement ps = con.prepareStatement("select * from student");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Student s1 = new Student();
				s1.setRollNo(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setPassword(rs.getString(3));
				s1.setContactno(rs.getString(4));
				s1.setEmail(rs.getString(5));
				s1.setBirthdate(rs.getString(6));
				s1.setCity(rs.getString(7));
				
				li.add(s1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return li;
	}
}
