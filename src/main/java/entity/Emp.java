package entity;

import java.util.List;

public class Emp {
    private double empid;
    private String empName;
    private List<Contact> contacts;

    public Emp() {
    }

    public Emp(double empid, String empName) {
	this.empid = empid;
	this.empName = empName;
    }

    public double getEmpid() {
	return empid;
    }

    public void setEmpid(double empid) {
	this.empid = empid;
    }

    public String getEmpName() {
	return empName;
    }

    public void setEmpName(String empName) {
	this.empName = empName;
    }

    public List<Contact> getContacts() {
	return contacts;
    }

    public void setContacts(List<Contact> contacts) {
	this.contacts = contacts;
    }

}
