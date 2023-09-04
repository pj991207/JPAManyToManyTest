package com.rocket23.jpamanytomanytest.compliance.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket23.jpamanytomanytest.compliance.dto.ComplianceDto;
import com.rocket23.jpamanytomanytest.compliance.entity.BasePolicy;
import com.rocket23.jpamanytomanytest.compliance.entity.Compliance;
import com.rocket23.jpamanytomanytest.compliance.entity.PolicyCompliance;
import com.rocket23.jpamanytomanytest.compliance.repository.BasePolicyRepository;
import com.rocket23.jpamanytomanytest.compliance.repository.ComplianceRepository;
import com.rocket23.jpamanytomanytest.compliance.repository.PolicyComplianceRepository;
import com.rocket23.jpamanytomanytest.compliance.service.ComplianceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComplianceServiceImpl implements ComplianceService {

	private final BasePolicyRepository basePolicyRepository;
	private final ComplianceRepository complianceRepository;
	private final PolicyComplianceRepository policyComplianceRepository;

	@Override
	public boolean save(ComplianceDto complianceDto) {
		try{
			BasePolicy basePolicy = BasePolicy.toEntity(complianceDto);
			Compliance compliance = Compliance.toEnitiy(complianceDto);
			PolicyCompliance policyCompliance = PolicyCompliance.toEntity(complianceDto,basePolicy,compliance);
			basePolicyRepository.save(basePolicy);
			complianceRepository.save(compliance);
			policyComplianceRepository.save(policyCompliance);
			return true;

		}catch(Exception e){
			return false;
		}
	}
}
