package org.dnyanyog.dao;

import org.dnyanyog.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Products, Integer> {

}
