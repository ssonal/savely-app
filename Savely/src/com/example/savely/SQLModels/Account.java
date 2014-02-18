package com.example.savely.SQLModels;

public class Account {
	
	private int id;
	private String name;
	
	public Account(){}
	
	public Account(String name)
	{
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
