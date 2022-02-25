package ru.gb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao products;

    public Product save(Product product){
        return products.save(product);
    }

    public void deleteById(Long id) {products.deleteById(id); }

    public Product getProductById(Long id){
        return products.findById(id);
    }

    public Iterable<Product> getAllProducts(){
        return products.findAll();
    }
}
