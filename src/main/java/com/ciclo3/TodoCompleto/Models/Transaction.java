package com.ciclo3.TodoCompleto.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="transaction")
public class Transaction {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String concept;
    @Column
    private float amount;


    @Column
    private String tipo;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_RoleTransaction.class)
    private List<Enum_RoleTransaction> roleTransaction;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Employee empleado;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Enterprise enterprise;
    @Column
    private java.sql.Date createdAt;
    @Column
    private Date updatedAt;

    //Constructor


    public Transaction(long id, String concept, float amount, List<Enum_RoleTransaction> roleTransaction, Employee empleado, Enterprise enterprise, java.sql.Date createdAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.roleTransaction = roleTransaction;
        this.empleado = empleado;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
    }

    //Constructor vacío
    public Transaction() {
    }

    //Set y get
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Employee getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Employee empleado) {
        this.empleado = empleado;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public java.sql.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Enum_RoleTransaction> getRoleTransaction() {
        return roleTransaction;
    }

    public void setRoleTransaction(List<Enum_RoleTransaction> roleTransaction) {
        this.roleTransaction = roleTransaction;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", amount=" + amount +
                ", empleado=" + empleado +
                ", enterprise=" + enterprise +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
