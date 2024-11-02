package com.example.demo.service;

import com.github.javafaker.Faker;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Faker faker = new Faker();

    @Override
    public User generateRandomUser() {

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        return new User(name, lastName);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public User getById(long id) {
        return entityManager.find(User.class,id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class,id);
        if (user != null){
            entityManager.remove(user);
        }
    }
}

