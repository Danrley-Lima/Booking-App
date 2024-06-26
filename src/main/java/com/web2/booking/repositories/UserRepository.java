package com.web2.booking.repositories;

import com.web2.booking.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

   // UserModel findByEmailAndPassword(String email);

    UserDetails findByEmail(String email);
}
