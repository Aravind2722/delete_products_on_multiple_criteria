package org.example.delete_products_on_multiple_criteria.repositories;

import org.example.delete_products_on_multiple_criteria.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
