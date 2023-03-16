package com.products.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.catalogue.beans.Items;


public interface ItemsRepository extends JpaRepository<Items, Long>{


}
