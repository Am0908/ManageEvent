package com.example.ManageEvents.repository;

import com.example.ManageEvents.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
