package com.Alpaca.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Alpaca.forum.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
