package com.vueSpringBoot.CRUD_Vue_SpringBoot.Repo;

import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Information;

@Repository
public interface InforRepo extends JpaRepository<Information, Long> {

   boolean existsByEmail(String email);
	
//   Page findAllListByNameContainingIgnoreCase(Pageable pageable, String q);
   
}
