package com.example.demo.demo.repository;

import com.example.demo.demo.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "authors", collectionResourceRel = "authors")
public interface UserRestRepository extends PagingAndSortingRepository<UserEntity, Long>
{

}
