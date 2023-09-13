package ru.aston.druzhinin_ri.task4.repository;

import ru.aston.druzhinin_ri.task4.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImplOrder implements Repository<Order>{

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";


    @Override
    public List<Order> findAll() {
        String sqlOrders = "SELECT * FROM ORDERS";
        List<Order> setOrder = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
             Statement statement = connection.createStatement()) {
            Class.forName("org.h2.Driver");
            ResultSet resultSet = statement.executeQuery(sqlOrders);
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                Integer numberOfOrder = resultSet.getInt(2);
                Order order = new Order(id, numberOfOrder);
                setOrder.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return setOrder;
    }

    @Override
    public Order findEntityById(int id) {
        Order order = null;
        try(Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
            Statement statement = connection.createStatement()){
            String sqlCode = "SELECT*FROM ORDERS  WHERE id =" + id;
            try(ResultSet resultSet = statement.executeQuery(sqlCode)) {
                while (resultSet.next()) {
                    Integer idO = resultSet.getInt(1);
                    Integer numberOfOrder = resultSet.getInt(2);
                    order = new Order(idO, numberOfOrder);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM ORDERS where id = ?";
        Boolean isDelete = false;
        try (Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
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
    public boolean create(Order o) {
        Boolean isCreate = false;
        String sql = "INSERT INTO ORDERS (number_of_order) VALUES(?)" ;
        try (Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,o.getNumberOfOrder());
            if (statement.executeUpdate() > 0) {
                isCreate = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isCreate;
    }
    @Override
    public Order update(Order order) {
        Order rsOrder = null;
        String sqlUpdate = "UPDATE ORDERS SET number_of_order = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
             PreparedStatement statement = connection.prepareStatement(sqlUpdate)) {
            statement.setInt(1, order.getNumberOfOrder());
            statement.setInt(2, order.getId());
            if (statement.executeUpdate() > 0){
                rsOrder = findEntityById(order.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rsOrder;
    }

}