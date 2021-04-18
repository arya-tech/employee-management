package com.em.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.em.entites.Manager;

@Repository
public interface ManagerRepositories extends JpaRepository<Manager, Serializable> {

	public Manager findByEmail(String emailId);

}
