package com.imcs.maven.entity;

public class PhoneNumber {
	private int id;
	private Employee owner;
	private String type;
	private String areaCode;
	private String number;

	public PhoneNumber() {

	}

	public PhoneNumber(int id, Employee owner, String type, String areaCode, String number) {
		super();
		this.id = id;
		this.owner = owner;
		this.type = type;
		this.areaCode = areaCode;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhoneNumber [id=");
		builder.append(id);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", type=");
		builder.append(type);
		builder.append(", areaCode=");
		builder.append(areaCode);
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}

}
