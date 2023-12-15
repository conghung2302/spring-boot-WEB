package com.example.repo;

import com.example.entity.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "select * from Product limit :p, :slt", nativeQuery = true)
    public List<Product> selectLimit(@Param("p") int p, @Param("slt") int slt);

    @Query(value = "select * from Product where name like '%:p' or name like ':p%' or name like '%:p%'", nativeQuery = true)
    public List<Product> searchProduct(@Param("p") String p);


    // @Query('select * from product wh')

    // public List<Product> searchProduct(@Param("p") int p, @Param("slt") int slt);
}
