import java.io.Serializable;

class Employee implements Serializable{

	
	private String name = null;
	private String address = null;
	private String telno = null;
	
	public Employee(String name, String address, String telno) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
		this.telno = telno;
	}
	
	public String toString() {
		return this.name + " " + this.address + " " + this.telno;
		
	}
}