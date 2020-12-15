package com.test;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);


    @Query(value = "SELECT u.* FROM user_tbl u WHERE MATCH(u.name) AGAINST(?1 IN BOOLEAN MODE)", nativeQuery = true)
    List<User> search(@Param("name") String name);


}