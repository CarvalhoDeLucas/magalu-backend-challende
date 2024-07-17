package com.carvalhodelucas.magalums.repositories;

import com.carvalhodelucas.magalums.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
