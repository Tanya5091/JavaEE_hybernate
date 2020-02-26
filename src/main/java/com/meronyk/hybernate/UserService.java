package com.meronyk.hybernate;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return entityManager.merge(user);
    }

    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("FROM UserEntity", UserEntity.class).getResultList();
    }

    @Transactional
    public List<UserEntity> findLastNameUsers(String lastn) {
        return entityManager.createQuery("FROM UserEntity u WHERE u.lastName = :lastn").setParameter("lastn", lastn).getResultList();
    }

    @Transactional
    public List<UserEntity> findPartUsers(String part) {
        return entityManager.createQuery("FROM UserEntity u WHERE u.lastName LIKE CONCAT('%',:part,'%') OR u.firstName LIKE CONCAT('%',:part,'%')",UserEntity.class ).setParameter("part", part).getResultList();
    }
}