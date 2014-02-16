package com.example.savely;

public class Entry {
	
	private int id;
	private int accountId;
	private int categoryId;
	private int typeId;
	private String details;
	
	public Entry(){}
	
	public Entry(String details, int accountId, int categoryId, int typeId)
	{
		super();
		this.setAccountId(accountId);
		this.setCategoryId(categoryId);
		this.setDetails(details);
		this.setTypeId(typeId);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
