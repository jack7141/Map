package com.hanbit.member.domain;

public class MemberBean {
	   private String id, password, name, ssn;

	   public void setId (String id){
		    this.id =id;
	   }
	   public String getId(){
			return id;
	   }
	   public String getPassword(){
		   	return password;
	   }
	   public void setPassword (String password){
	        this.password = password;
	   }
	   public void setName(String name){
		   	this.name=name;
	   }
	   public String getName(){
		   	return name;
	   }
	   public String getSsn(){
		   	return ssn;
	   }
	   public void setSsn (String ssn){
        	this.ssn =ssn;
	   }
	   public String toString(){
		   return "회원 [id=" +id+" name="+name+" password="+password+"]";
		
	   }
}

