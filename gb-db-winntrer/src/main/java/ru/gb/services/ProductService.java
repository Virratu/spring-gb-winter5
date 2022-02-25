package ru.gb.services;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;
import ru.gb.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao products;

    public Product save(Product product){
        product.setStatus(Status.ACTIVE);
        return products.save(product);
    }

    public void deleteById(Long id) {
        products.deleteById(id); }

    public Product getProductById(Long id){
        return products.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Iterable<Product> getAllProducts(){
        return products.findAll();
    }

    public Iterable<Product> getActiveProducts() {return products.findAllByStatus(Status.ACTIVE);}

    public Iterable<Product> getActiveProducts(Sort sort) {return products.findAllByStatus(Status.ACTIVE, sort);}

    public Iterable<Product> getActiveProducts(Pageable pageable) {
        return products.findAllByStatus(Status.ACTIVE, pageable);
    }

    public void disableById(Long id){
        products.findById(id).ifPresent(
                p -> {p.setStatus(Status.DISABLE);
                      products.save(p);}
        );
    }
}
