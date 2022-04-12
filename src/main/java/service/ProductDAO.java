package service;

import com.mysql.cj.protocol.x.ConfinedInputStream;
import config.SingletonConnection;
import models.Category;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String SELECT_ALL_PRODUCT = "select p.id, product_name, price, quantity, color, type\n" +
            "from category join product p on category.id = p.id_category;";

    @Override
    public List<Product> displayAllProduct() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = SingletonConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int id_category = resultSet.getInt("id_category");
                String type = resultSet.getString("type");
                Category category = new Category(id_category, type);
                productList.add(new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
