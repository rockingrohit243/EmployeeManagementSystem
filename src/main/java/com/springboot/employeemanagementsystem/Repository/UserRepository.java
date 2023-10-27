package com.springboot.employeemanagementsystem.Repository;

import com.springboot.employeemanagementsystem.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserDetails,Long> {
}
