package com.ty.student_app_jsp.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ty.student_app_jsp.dto.Student;



public class StudentDataBaseOperation {
	private final static String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private final static String DB_URL="jdbc:mysql://localhost:3306/veja2_db?user=root&password=root";

	public boolean insertStudent(Student newStudent)
	{
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			Class.forName(DRIVER_CLASS);
			con=DriverManager.getConnection(DB_URL);

			String query="Insert into student values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, newStudent.getSid());
			pstmt.setString(2,newStudent.getSname());
			pstmt.setLong(3,newStudent.getMobnum() );
			pstmt.setInt(4, newStudent.getMarks());
			pstmt.setString(5, newStudent.getMailid());
			pstmt.setString(6, newStudent.getPswd());

			int rowsAffected=pstmt.executeUpdate();

			return rowsAffected !=0;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


		}



		return  false;

	}

	//login validate
	public Student loginValidate(String mailid, String pswd) {

		String query="Select  * from student where emailId=? And Password=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			Class.forName(DRIVER_CLASS);
			con=DriverManager.getConnection(DB_URL);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, mailid);
			pstmt.setString(2, pswd);
			rs=pstmt.executeQuery();

			if(rs.next())
			{
				Student s=new Student();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				long mob=rs.getLong(3);
				int mark=rs.getInt(4);
				String mail=rs.getString(5);
				String password=rs.getString(6);

				s.setSid(id);
				s.setSname(name);
				s.setMobnum(mob);
				s.setMarks(mark);
				s.setMailid(mailid);
				s.setPswd(pswd);



				return s;


			}
			else
				return null;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}


	//View All Student Details
	public ArrayList<Student> getStudent()
	{

		String query="Select  * from student";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		ArrayList< Student > ar=new ArrayList();
		try {
			Class.forName(DRIVER_CLASS);
			con=DriverManager.getConnection(DB_URL);
			stmt=con.createStatement();

			rs=stmt.executeQuery(query);

			while(rs.next()) {

				int sid=rs.getInt(1);
				String name=rs.getString(2);
				long mob=rs.getLong(3);
				int marks=rs.getInt(4);
				String mail=rs.getString(5);



				Student s=new Student();

				s.setSid(sid);
				s.setSname(name);
				s.setMobnum(mob);
				s.setMarks(marks);;
				s.setMailid(mail);



				ar.add(s);

			}
			return ar;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}


		return ar;
	}

		
	public boolean forgetPassword(String mail,String password)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(DRIVER_CLASS);
			con=DriverManager.getConnection(DB_URL);
			String query="UPDATE student SET Password=? WHERE emailId=?";
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, password);
			pstmt.setString(2, mail);
			
			int rowsAffected=pstmt.executeUpdate();
			
			return rowsAffected !=0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}	
	
}
