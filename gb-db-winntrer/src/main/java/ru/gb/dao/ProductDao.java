package ru.gb.dao;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Product;
import ru.gb.entity.enums.Status;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findAll();
    List<Product> findAllByStatus(Status status);
    List<Product> findAllByStatus(Status status, Sort sort);
    List<Product> findAllByStatus(Status status, Pageable pageable);
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
