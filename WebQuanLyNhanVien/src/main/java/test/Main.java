package test;

import java.sql.Connection;
import java.util.ArrayList;

import dao.EmployeeDAO;
import dao.WorkDAO;
import model.Employee;
import model.Work;
import utils.JDBCUtil;

public class Main {
	public static void main(String[] args) {
		
		Employee e = EmployeeDAO.getInstance().getObject(15);
		
		System.out.println(e);
	}
}
