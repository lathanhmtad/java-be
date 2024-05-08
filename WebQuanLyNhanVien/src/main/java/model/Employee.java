package model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
	private int id;
	private String fullName;
	private Date dob;
	private String address;
	private Date workStartDate;
	private Date workEndDate;
	private double salary;
	private Work work;
	
	
	public void setWork(int id) {
		work = new Work();
		work.setId(id);
	}
	
	public void setWork(Work work) {
		this.work = work;
	}
}
