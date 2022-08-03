package com.hcl.henryshao.assignment11;

import java.util.ArrayList;

public class RegisteredUser {
	private int user_id;
	private String username;
	private String sex;
	private ArrayList<Course> courseArr = new ArrayList<Course>();

	public RegisteredUser(int id, String user, String sex) {
		user_id = id;
		username = user;
		this.sex = sex;
	}

	public void addCourse(int id) {
		Course newCourse = new Course(id);
		if(!courseArr.contains(newCourse)) {
			courseArr.add(newCourse);
		}		
	}
	
	public int getID() {
		return user_id;
	}
	
	public String getName() {
		return username;
	}
	
	public String getSex() {
		return sex;
	}
	
	public ArrayList<Course> getCourse(){
		return courseArr;
	}
	
	@Override
	public boolean equals (Object object) {
		boolean result = false;
	    if (object == null || object.getClass() != getClass()) {
	        result = false;
	    } else {
	    	RegisteredUser thatUser = (RegisteredUser) object;
	        if (this.user_id == thatUser.getID()) {
	            result = true;
	        }
	    }
	    return result;
	}

}

class Course {
	private int course_id;
	private String course_name;

	public Course(int id) {
		course_id = id;
		course_name = setCourse(id);
	}

	public String setCourse(int course_id) {
		switch (course_id) {
		case 1:
			return "Java";
		case 2:
			return "C++";
		case 3:
			return "Python";
		}
		return null;
	}
	
	public String getCourse(){
		return course_name;
	}
	
	public int getID() {
		return course_id;
	}
	
	@Override
	public boolean equals (Object object) {
		boolean result = false;
	    if (object == null || object.getClass() != getClass()) {
	        result = false;
	    } else {
	        Course thatCourse = (Course) object;
	        if (this.course_id == thatCourse.getID()) {
	            result = true;
	        }
	    }
	    return result;
	}
}