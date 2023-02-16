package com.ty.student_app_jsp.dto;

import java.io.Serializable;

public class Student implements Serializable {
	private int sid;
	private String sname;
	private long mobnum;
	
	private String mailid;
	private String pswd;
	
	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}


	public String getPswd() {
		return pswd;
	}


	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


	public Student() {
	
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public long getMobnum() {
		return mobnum;
	}

	public void setMobnum(long mobnum) {
		this.mobnum = mobnum;
	}


	
	
@Override
	public String toString() {
		return sid+"\t\t"+sname+"\t\t"+"\t\t"+mailid+"\n";
	}
	
	
	

}
