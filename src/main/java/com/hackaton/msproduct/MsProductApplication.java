package com.hackaton.msproduct;

import com.hackaton.msproduct.dao.CategoryRepo;
import com.hackaton.msproduct.dao.ProductRepo;
import com.hackaton.msproduct.entities.Category;
import com.hackaton.msproduct.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MsProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CategoryRepo categoryRepo, ProductRepo productRepo){

        return args -> {
            categoryRepo.deleteAll();
            Stream.of("C1 Computers", "C2 Printers").forEach(c->{
                        categoryRepo.save(new Category(c.split(" ")[0],c.split(" ")[1],new ArrayList<>()));
            });
            categoryRepo.findAll().forEach(System.out::println);

            productRepo.deleteAll();

            Category c1= categoryRepo.findById("C1").get();
            Stream.of("P1","P2","P3","P4","P5","P6").forEach(name->{
                Product p=productRepo.save(new Product(null,name,Math.random()*1000,c1));
                c1.getProducts().add(p);
                categoryRepo.save(c1);
            });

            Category c2= categoryRepo.findById("C2").get();
            Stream.of("P7","P8").forEach(name->{
                Product p=productRepo.save(new Product(null,name,Math.random()*1000,c2));
                c2.getProducts().add(p);
                categoryRepo.save(c2);
            });
            productRepo.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}
