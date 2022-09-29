package com.ciclo3.TodoCompleto.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empresas")
public class Enterprise {
    @Id
    private long idEnterprise;
    @Column
    private String name;
    @Column

    private String document;
    @Column
    private String phone;
    @Column
    private String address;


    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactions;
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employees;

    @Column
    private java.sql.Date createdAt;
    @Column
    private Date updateAt;


    // constructor


    public Enterprise(long idEnterprise, String name, String document, String phone, String address, java.sql.Date createdAt, Date updateAt) {
        this.idEnterprise = idEnterprise;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    //constructor sin atributos
    public Enterprise() {
    }

    //getter y setter

    public long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public java.sql.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
