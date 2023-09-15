package ru.aston.druzhinin_ri.task4.repository;

import ru.aston.druzhinin_ri.task4.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImplUser implements Repository<User>{

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";



    @Override
    public List<User> findAll() {
        List<User> setUser = new ArrayList<>();
        String sqlUsers = "SELECT * FROM USERS";
        try (Connection connection = Connector.getConnector();
             Statement statement = connection.createStatement()) {
            Class.forName("org.h2.Driver");
            ResultSet resultSet = statement.executeQuery(sqlUsers);
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String fullName = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String email = resultSet.getString(4);
                Integer orderId = resultSet.getInt(5);
                User user = new User(id, fullName, phone, email, orderId);
                setUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return setUser;
    }

    @Override
    public User findEntityById(int id) {
        User user = null;
        try(Connection connection = Connector.getConnector();
            Statement statement = connection.createStatement()){
            String sqlCode = "SELECT*FROM users  WHERE id =" + id;
            try(ResultSet resultSet = statement.executeQuery(sqlCode)) {
                while (resultSet.next()) {
                    Integer idU = resultSet.getInt(1);
                    String fullName = resultSet.getString(2);
                    String phone = resultSet.getString(3);
                    String email = resultSet.getString(4);
                    Integer orderId = resultSet.getInt(5);
                    user = new User(idU, fullName, phone, email, orderId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM USERS where id = ?";
        Boolean isDelete = false;
        try (Connection connection = Connector.getConnector();
             PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, id);
            if (statement.executeUpdate() > 0) {
                isDelete = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }

    @Override
    public boolean create(User u) {
        Boolean isCreate = false;
        String sql = "INSERT INTO USERS (full_name, phone, email, order_id) VALUES(?,?,?,?)" ;
        try (Connection connection = Connector.getConnector();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,u.getFullName());
            statement.setString(2, u.getPhone());
            statement.setString(3, u.getEmail());
            statement.setInt(4, u.getOrderId());
            if (statement.executeUpdate() > 0) {
                isCreate = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isCreate;
    }

    @Override
    public User update(User user) {
        User rsUser = null;
        String sqlUpdate = "UPDATE USERS SET full_name = ?, phone = ?, email = ?, order_id = ? WHERE id = ?";
        try (Connection connection = Connector.getConnector();
             PreparedStatement statement = connection.prepareStatement(sqlUpdate)) {
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getOrderId());
            statement.setInt(5, user.getId());
            if (statement.executeUpdate() > 0){
                rsUser = findEntityById(user.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rsUser;
    }


    public List<String> findUsersOrders() {
        String sql = "SELECT*FROM users u LEFT JOIN orders o on u.id = o.id";
        List<String> list = new ArrayList<>();
        try(Connection connection = Connector.getConnector();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                list.add("Клиент: " +resultSet.getString(2) + "Заказ: " + resultSet.getString(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
