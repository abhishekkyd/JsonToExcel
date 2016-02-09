package entity;

import java.util.List;

public class Contact {
	private int contactid;
	private String type;

	private List<Address> addrs;

	public Contact(int id, String type, List<Address> addrs) {
		this.contactid = id;
		this.type = type;
		this.addrs = addrs;
	}

	public int getContactid() {
		return contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Address> getAddrs() {
		return addrs;
	}

	public void setAddrs(List<Address> addrs) {
		this.addrs = addrs;
	}

}
