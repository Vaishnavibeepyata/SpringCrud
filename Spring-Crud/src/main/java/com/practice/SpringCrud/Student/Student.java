package com.practice.SpringCrud.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue
private int id;
private  String name;
private int age;


public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id,String name, int age) {
	super();
	this.id=id;
	this.name = name;
	this.age = age;
}
public int getid() {
	return id;
}
public void setid(int id) {
   this.id =id;
}
  public String getname() {
	return name;
}
public void setname(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";

}
}