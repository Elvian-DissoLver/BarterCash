package com.barter.barter.models;

import com.barter.barter.domain.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByAgeLessThan(int age);
}
