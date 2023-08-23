package next.school.cesar.springaula3.entity;

public class Person {
	
	private String name;
	private String birth_date;
	
	public Person() {
		
	}
	
	public Person(String name, String birth_date) {
		super();
		this.name = name;
		this.birth_date = birth_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	
	
	
}
