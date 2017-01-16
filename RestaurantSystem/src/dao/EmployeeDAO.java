package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.MySQLHelper;

public class EmployeeDAO {
	public boolean insert(Employee employee){
		boolean result = false;
		String sql = "insert into employee(id, name, position, salary) "
				+ "values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getPosition());
			ps.setInt(4, employee.getSalary());
			
			int row = ps.executeUpdate();
			if(row > 0){
				result = true;
			}
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean update(Employee employee){
		boolean result = false;
		String sql = "update employee set name = ?, position = ?, salary = ? where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(4, employee.getId());
			ps.setString(1, employee.getName());
			ps.setInt(2, employee.getPosition());
			ps.setInt(3, employee.getSalary());
			
			int row = ps.executeUpdate();
			if(row > 0){
				result = true;
			}
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean delete(String id){
		boolean result = false;
		String sql = "delete from employee where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, id);			
			
			int row = ps.executeUpdate();
			if(row > 0){
				result = true;
			}
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Employee> selectAll(){
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from employee";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				int position = rs.getInt(3);
				int salary = rs.getInt(4);
				
				Employee employee = new Employee(id, name, position, salary);
				
				employees.add(employee);
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	public List<Employee> selectByIdOrName(String idname){
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from employee where id = ? or name like ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, idname);
			ps.setString(2, "%" + idname + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				int position = rs.getInt(3);
				int salary = rs.getInt(4);
				
				Employee employee = new Employee(id, name, position, salary);
				
				employees.add(employee);
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public boolean invalidId(String id){
		boolean result = false;
		String sql = "select count(id) from employee where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int count = rs.getInt(1);
				if(count > 0)
					result = true;
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	public Employee selectById(String id) {
		Employee employee = new Employee();
		String sql = "select * from employee where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				employee.setId(rs.getString(1));
				employee.setName(rs.getString(2));
				employee.setPosition(rs.getInt(3));
				employee.setSalary(rs.getInt(4));
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
}











