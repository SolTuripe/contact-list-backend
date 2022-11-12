package com.contactlist.fullstackbackend.repository;

import com.contactlist.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
