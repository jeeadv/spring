package com.example.demo.demo.repository;

import com.example.demo.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
    List<UserEntity> findByRole(String role);
}
