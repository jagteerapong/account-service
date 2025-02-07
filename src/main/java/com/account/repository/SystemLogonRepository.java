package com.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entity.SystemLogon;

@Repository
public interface SystemLogonRepository extends JpaRepository<SystemLogon, String> {
	Optional<SystemLogon> findBySystemNameAndActiveStatus(String systemName, String activeStatus);
}
