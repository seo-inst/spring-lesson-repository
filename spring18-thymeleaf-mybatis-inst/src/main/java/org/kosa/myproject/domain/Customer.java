package org.kosa.myproject.domain;

public class Customer {
	private String id;
	private String name;
	private String address;
	private Car car;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Customer(String id, String name, String address, Car car) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.car = car;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", car=" + car + "]";
	}
	
	
}
