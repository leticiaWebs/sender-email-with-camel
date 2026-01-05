package com.enviodeemail.email_service.repository;

import com.enviodeemail.email_service.domain.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriberRespository extends JpaRepository<Subscriber, Long> {

    Optional<Subscriber> findByEmail(String email);

    List<Subscriber> findByEmailContaining(String email);
}
