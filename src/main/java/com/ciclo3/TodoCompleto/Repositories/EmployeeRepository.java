package com.ciclo3.TodoCompleto.Repositories;


import com.ciclo3.TodoCompleto.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}



