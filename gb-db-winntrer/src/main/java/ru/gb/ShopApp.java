package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.config.JpaConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OldJdbcManufacturerDao;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

@EnableConfigurationProperties
@SpringBootApplication
public class ShopApp {

    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class, args);
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//
//
//        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
//        ProductDao productDao = context.getBean(ProductDao.class);
//        System.out.println(productDao.findById(3L));
//        System.out.println(manufacturerDao.findNameById(5L));
//        for (Product product : productDao.findAll()) {
//            System.out.println(product);
//        }
    }
}
