package com.ciclo3.TodoCompleto.Repositories;

import com.ciclo3.TodoCompleto.Models.UsersApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsersApplication extends JpaRepository<UsersApplication,String> {
}
