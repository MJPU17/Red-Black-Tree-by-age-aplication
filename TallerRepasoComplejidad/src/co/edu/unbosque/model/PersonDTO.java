package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonDTO implements Comparable<PersonDTO>,Serializable{
	
	private static final long serialVersionUID = 7153861566512004245L;
	private String name;
	private LocalDate birthDay;
	private int id;
	
	public PersonDTO() {}

	public PersonDTO(String name, LocalDate birthDay, int id) {
		this.name = name;
		this.birthDay = birthDay;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(PersonDTO o) {
		return birthDay.compareTo(o.birthDay);
	}
	
	@Override
	public String toString() {
		return "["+name+", "+birthDay.toString()+", "+id+"]";
	}

}
