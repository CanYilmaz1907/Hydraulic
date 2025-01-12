package com.ecom.graphql;

import com.ecom.model.Product;
import com.ecom.service.ProductService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {

    private final ProductService productService;

    public MutationResolver(ProductService productService) {
        this.productService = productService;
    }

    @MutationMapping
    public Product saveProduct(String title, String description, String category, Double price, int stock, String image, int discount, Boolean isActive) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);
        product.setStock(stock);
        product.setImage(image);
        product.setDiscount(discount);
        product.setIsActive(isActive);

        return productService.saveProduct(product);
    }

    @MutationMapping
    public Product updateProduct(Integer id, String title, String description, String category, Double price, int stock, String image, int discount, Boolean isActive) {
        Product product = productService.getProductById(id);
        if (product != null) {
            if (title != null) product.setTitle(title);
            if (description != null) product.setDescription(description);
            if (category != null) product.setCategory(category);
            if (price != null) product.setPrice(price);
            if (stock != 0) product.setStock(stock);
            if (image != null) product.setImage(image);
            if (discount != 0) product.setDiscount(discount);
            if (isActive != null) product.setIsActive(isActive);

            return productService.saveProduct(product);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteProduct(Integer id) {
        return productService.deleteProduct(id);
    }
}
