package com.Hardeymorlah.PowerUserApplication.Repository;

import com.Hardeymorlah.PowerUserApplication.Model.PowerUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PowerUserRepository extends JpaRepository<PowerUsers, Integer> {
    Optional<PowerUsers> findByEmail(String email);
    Optional<PowerUsers> findByPhoneNumber(String phoneNumber);
}
