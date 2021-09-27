package com.example.demo.service;

import com.example.demo.DB.DataBase;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public boolean addProduct(Product product) {
        DataBase.dataBaseProducts.add(product);
        return true;
    }

    public List<Product> getAllProducts() {
        return DataBase.dataBaseProducts;
    }

    public Product findProductById (long id) {
        for (Product product : DataBase.dataBaseProducts) {
            if (product.getId() == id ) {
                return product;
            }
        }
        return new Product();
    }

    public boolean deleteProduct(long id) {
        DataBase.dataBaseProducts.remove(id);
        return true;
    }

    //    public boolean addToProductUser(Long id, User user) {
//        return true;
//    }

}
