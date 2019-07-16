package com.ilyachuvaev.indoctrination.repository;

import com.ilyachuvaev.indoctrination.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
