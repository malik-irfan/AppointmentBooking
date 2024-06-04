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

public class ClientDao {

    private static final String INSERT_CLIENT_SQL="INSERT INTO Client (client_name, contact_mobile, contact_mail) VALUES (?, ?, ?);";
    private static final String UPDATE_CLIENT_SQL = "UPDATE Client SET client_name = ?, contact_mobile = ?, contact_mail = ? WHERE id = ?;";
    private static final String DELETE_CLIENT_SQL = "DELETE FROM Client WHERE id = ?;";
    private static final String SELECT_CLIENT_SQL = "SELECT * FROM Client WHERE id = ?;";
    private static final String SELECT_ALL_CLIENT_SQL = "SELECT * FROM Client;";


    public static int insertClient(Client client){
        System.out.println(INSERT_CLIENT_SQL);
        int result = 0;
        // try-with-resource statement will auto close the connection
        try( Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);){
            preparedStatement.setString(1,client.getClientName());
            preparedStatement.setString(2,client.getContactMobile());
            preparedStatement.setString(3,client.getContactMail());
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    public static int updateClient(long id, Client c){
        System.out.println(UPDATE_CLIENT_SQL);
        int result = 0;
        // try-with-resource statement will auto close the connection
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL);){
            preparedStatement.setString(1,c.getClientName());
            preparedStatement.setString(2,c.getContactMail());
            preparedStatement.setString(3, c.getContactMail());
            preparedStatement.setLong(4,id);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static int deleteClient(long id){
        System.out.println(DELETE_CLIENT_SQL);
        int result = 0;
        // try-with-resource statement will auto close the connection
        try( Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL);){
            preparedStatement.setLong(1,id);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return result;

    }

    public static Client selectClient(long id){
        Client client = null;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_SQL);){
            preparedStatement.setLong(1,id);
            ResultSet rs =  preparedStatement.executeQuery();
            while (rs.next()){
                long cid = rs.getLong("id");
                String cName = rs.getString("client_name");
                String cMobile = rs.getString("contact_mobile");
                String cMail = rs.getString("contact_mail");
                client = new Client(cid,cName,cMobile,cMail);
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return client;
    }

    public static List<Client> selectAllClients(){
        List< Client > clientList = new ArrayList<>();

        System.out.println(SELECT_ALL_CLIENT_SQL);
        try(Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENT_SQL);){
            ResultSet rs =  preparedStatement.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String cName = rs.getString("client_name");
                String cMobile = rs.getString("contact_mobile");
                String cMail = rs.getString("contact_mail");
                Client client = new Client(id,cName,cMobile,cMail);
                clientList.add(client);
            }
        }catch (SQLException e){
            JDBCUtils.printSQLException(e);
        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return clientList;
    }
}
