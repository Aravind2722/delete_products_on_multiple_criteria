package org.example.delete_products_on_multiple_criteria.repositories;

import org.example.delete_products_on_multiple_criteria.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    void deleteById(Long id);

    void deleteAll();

    Long deleteByName(String name);

    int deleteByCategoryName(String categoryName);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id = :categoryId")
    void deleteProductWhereIdMatchesCategoryId(Long categoryId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.createdAt < :retainDate")
    int retainProductsAfter(Date retainDate);
}
