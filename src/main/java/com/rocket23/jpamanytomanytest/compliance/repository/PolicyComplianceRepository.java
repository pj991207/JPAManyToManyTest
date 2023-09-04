package com.rocket23.jpamanytomanytest.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocket23.jpamanytomanytest.compliance.entity.PolicyCompliance;

@Repository
public interface PolicyComplianceRepository extends JpaRepository<PolicyCompliance, Long> {
}
