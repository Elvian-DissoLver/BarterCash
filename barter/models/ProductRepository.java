package com.barter.barter.models;

import com.barter.barter.domain.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<Product, Integer> {

}
