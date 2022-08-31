package com.ttj.usermgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<DAOProduct, Integer>{
	DAOProduct getProductById(@Param("productId") Integer Id);
}
