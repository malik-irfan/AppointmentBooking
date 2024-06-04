package com.spolight.appointment.appointment_booking.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils {

    private static String jdbcUserName = "sa";
    private static String jdbcPassword = "P@ssw0rd";
    private static String jdbcURL = "jdbc:sqlserver://10.96.214.36:1433;database=TestDemo;user="+jdbcUserName+";password="+jdbcPassword+";encrypt=true;trustServerCertificate=true;";


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
       // try {
            //register driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            DriverManager.setLoginTimeout(5);
            connection = DriverManager.getConnection(jdbcURL);
       /* }catch(SQLException e ) {
            e.printStackTrace();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return connection;
    }



    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    public static Date getSQLDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }


    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }
}
