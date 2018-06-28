package com.example.demo;

public class Record {
	private Integer id;
	private String itemKey;
	private String itemValue;
	
	
	public Record(Integer id,String itemKey,String itemValue) {
		this.id = id;
		this.itemKey = itemKey;
		this.itemValue = itemValue;
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public String getItemKey() {
		return itemKey;
	}
	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	
}
