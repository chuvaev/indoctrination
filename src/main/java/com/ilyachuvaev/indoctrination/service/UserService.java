package com.ilyachuvaev.indoctrination.service;

import com.ilyachuvaev.indoctrination.entity.User;
import com.ilyachuvaev.indoctrination.exception.UserNotFoundException;
import com.ilyachuvaev.indoctrination.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository repository;
  private final int size = 5;

  public User getById(Long id){
    Optional<User> user = repository.findById(id);
    return user.orElseThrow(() -> new UserNotFoundException("User with id = " + id + " not found!"));
  }

  public User saveOrUpdate(User user){
    if (user != null){
      repository.save(user);
    } else {
      throw new UserNotFoundException("User not found");
    }
    return user;
  }

  public long delete(Long id){
    Optional<User> user = repository.findById(id);
    user.ifPresentOrElse(
        v ->repository.deleteById(id),
        () -> new UserNotFoundException("User with id = " + id + " not found!")
    );
    return id;
  }

  public java.util.List<User> getContacts(){
    ArrayList<User> users = new ArrayList<>(size);
    users.addAll(getAllUsers());
    return users;
  }

  public java.util.List<User> getAllUsers(){return (List<User>) repository.findAll();}
}
