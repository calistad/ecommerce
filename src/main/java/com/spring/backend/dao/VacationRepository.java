package com.spring.backend.dao;

import com.spring.backend.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
