package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findById(Integer id);
    boolean existsUserByLogin(String login);
    User findByLogin(String login);
}
