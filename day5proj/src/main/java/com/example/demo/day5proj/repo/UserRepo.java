package com.example.demo.day5proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.day5proj.model.UserModel;
@Repository
public interface UserRepo  extends JpaRepository<UserModel,Integer>{

}
