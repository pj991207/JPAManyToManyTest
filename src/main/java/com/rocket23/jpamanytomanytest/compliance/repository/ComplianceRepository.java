package com.rocket23.jpamanytomanytest.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocket23.jpamanytomanytest.compliance.entity.Compliance;

public interface ComplianceRepository extends JpaRepository<Compliance, Long> {
}
