package com.ciclo3.TodoCompleto.Repositories;

import com.ciclo3.TodoCompleto.Models.Employee;
import com.ciclo3.TodoCompleto.Models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmployee extends JpaRepository<Employee,Long> {
}
