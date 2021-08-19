package com.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Role findByRole(String role);
}
