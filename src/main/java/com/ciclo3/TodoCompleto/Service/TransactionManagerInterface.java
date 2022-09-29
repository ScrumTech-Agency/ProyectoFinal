package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Transaction;

import java.util.List;

public interface TransactionManagerInterface {
    public List<Transaction> getTransactions();
    public Transaction getTransaction(Long id) throws Exception;
    public String setTransaction (Transaction Transactions) throws Exception;
    public Transaction UpdateTransactionAll(Transaction TransactionUpdate, Long id) throws Exception;
    public Transaction UpdateTransaction(Transaction TransactionUpdate, Long id) throws Exception;
    public String DeleteTransaction(Long id) throws Exception;
}
