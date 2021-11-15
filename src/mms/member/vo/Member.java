package mms.member.vo;

public class Member {

	//private int id;    // sequence 때문에 필요없음
	private String name; //식별값
	private String addr;
	private String nation;
	private String email;
	private int age;	
		

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		String result = "name: " + name + ", addr: " + addr + 
				", nation: " + nation + ", email: " + email + ", age: " + age;
		
		return result;
	}

	
}
