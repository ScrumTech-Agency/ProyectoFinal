package com.ciclo3.TodoCompleto.Repositories;

import com.ciclo3.TodoCompleto.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
