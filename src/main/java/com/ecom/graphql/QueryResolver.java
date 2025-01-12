package com.ecom.graphql;

import com.ecom.model.Product;
import com.ecom.service.ProductService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryResolver {

    private final ProductService productService;

    public QueryResolver(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product getProductById(Integer id) {
        return productService.getProductById(id);
    }

    @QueryMapping
    public List<Product> searchProduct(String ch) {
        return productService.searchProduct(ch);
    }

    @QueryMapping
    public List<Product> getAllActiveProducts(String category) {
        return productService.getAllActiveProducts(category);
    }
}
