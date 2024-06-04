package com.spolight.appointment.appointment_booking.dao;

import com.spolight.appointment.appointment_booking.model.Client;
import com.spolight.appointment.appointment_booking.model.Employee;
import com.spolight.appointment.appointment_booking.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl {

    private static final String INSERT_EMPLOYEE_SQL ="INSERT INTO Employee (first_name, last_name) VALUES (?, ?);";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE Employee SET first_name = ?, last_name = ? WHERE id = ?;";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM Employee WHERE id = ?;";
    private static final String SELECT_EMPLOYEE_SQL = "SELECT * FROM Employee WHERE id = ?;";
    private static final String SELECT_ALL_EMPLOYEE_SQL = "SELECT * FROM Employee;";

    public static int createEmployee(Employee employee){
        System.out.println(INSERT_EMPLOYEE_SQL);
        int result = 0;
        // try-with-resource statement will auto close the connection
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);){
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static int updateEmployee(long id,Employee employee){
        System.out.println(UPDATE_EMPLOYEE_SQL);
        int result = 0;
        // try-with-resource statement will auto close the connection
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);){
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setLong(3,id);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static int deleteEmployee(long id){
        System.out.println(DELETE_EMPLOYEE_SQL);
        int result = 0;
        // try-with-resource statement will auto close the connection
        try( Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);){
            preparedStatement.setLong(1,id);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static Employee getEmployee(long id){
        Employee employee = null;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_SQL);){
            preparedStatement.setLong(1,id);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                long eid = rs.getLong("id");
                String eFName = rs.getString("first_name");
                String eLName = rs.getString("last_name");
                employee = new Employee(eid,eFName,eLName);
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    public static List<Employee> getAllEmployee(){
        List< Employee > empList = new ArrayList<>();

        System.out.println(SELECT_ALL_EMPLOYEE_SQL);
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_SQL);){
            ResultSet rs =  preparedStatement.executeQuery();

            while (rs.next()){
                long eid = rs.getLong("id");
                String eFName = rs.getString("first_name");
                String eLName = rs.getString("last_name");
                Employee employee = new Employee(eid,eFName,eLName);
                empList.add(employee);
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return empList;
    }
}
