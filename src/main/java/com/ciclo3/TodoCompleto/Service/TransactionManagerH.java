package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Transaction;
import com.ciclo3.TodoCompleto.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionManagerH implements TransactionManagerInterface{
    @Autowired
    private TransactionRepository repository;

    @Override
    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) throws Exception {
        Optional<Transaction> transactionBd = repository.findById(id);
        if (transactionBd.isPresent()) {
            return transactionBd.get();
        }
        throw  new Exception("La transacción no existe");
    }

    @Override
    public String setTransaction(Transaction Transactions) throws Exception {
        repository.save(Transactions);
        return "Transacción creada exitosamente";
    }

    @Override
    public Transaction UpdateTransactionAll(Transaction TransactionUpdate, Long id) throws Exception {
        return null;
    }

    @Override
    public Transaction UpdateTransaction(Transaction TransactionUpdate, Long id) throws Exception {

        Transaction transaction_Bd = getTransaction(id);
        transaction_Bd.setAmount(TransactionUpdate.getAmount());
        transaction_Bd.setRoleTransaction(TransactionUpdate.getRoleTransaction());

        if(TransactionUpdate.getConcept() != null && !TransactionUpdate.getConcept().equals("")){
            transaction_Bd.setConcept(TransactionUpdate.getConcept());
        }
        if(TransactionUpdate.getEmpleado() != null && !TransactionUpdate.getEmpleado().equals("")){
            transaction_Bd.setEmpleado(TransactionUpdate.getEmpleado());
        }
        if(TransactionUpdate.getEnterprise() != null && !TransactionUpdate.getEnterprise().equals("")){
            transaction_Bd.setEnterprise(TransactionUpdate.getEnterprise());
        }
        if(TransactionUpdate.getCreatedAt() != null && !TransactionUpdate.getCreatedAt().equals("")){
            transaction_Bd.setCreatedAt(TransactionUpdate.getCreatedAt());
        }
        if(TransactionUpdate.getUpdatedAt() != null && !TransactionUpdate.getUpdatedAt().equals("")){
            transaction_Bd.setUpdatedAt(TransactionUpdate.getUpdatedAt());
        }

        return repository.save(transaction_Bd);
    }

    @Override
    public String DeleteTransaction(Long id) throws Exception {
        repository.deleteById(id);
        return "Transacción Eliminada Exitosamente";
    }
}
