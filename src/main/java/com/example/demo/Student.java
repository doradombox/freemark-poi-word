package com.example.demo;

public class Student {
	private String name;
	private String zhuanye;
	private String chengji;
	private String state;
	
	
	
	public Student(String name, String zhuanye, String chengji, String state) {
		super();
		this.name = name;
		this.zhuanye = zhuanye;
		this.chengji = chengji;
		this.state = state;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public String getChengji() {
		return chengji;
	}
	public void setChengji(String chengji) {
		this.chengji = chengji;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
