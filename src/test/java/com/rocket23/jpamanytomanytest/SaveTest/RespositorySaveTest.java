package com.rocket23.jpamanytomanytest.SaveTest;

import java.security.Policy;
import java.util.List;

import javax.transaction.Transactional;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.rocket23.jpamanytomanytest.compliance.entity.BasePolicy;
import com.rocket23.jpamanytomanytest.compliance.entity.Compliance;
import com.rocket23.jpamanytomanytest.compliance.entity.PolicyCompliance;
import com.rocket23.jpamanytomanytest.compliance.repository.BasePolicyRepository;
import com.rocket23.jpamanytomanytest.compliance.repository.ComplianceRepository;
import com.rocket23.jpamanytomanytest.compliance.repository.PolicyComplianceRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class RespositorySaveTest {

	@Autowired
	BasePolicyRepository basePolicyRepository;
	@Autowired
	ComplianceRepository complianceRepository;
	@Autowired
	PolicyComplianceRepository policyComplianceRepository;

	@AfterAll
	public void cleanUp() {
		policyComplianceRepository.deleteAll();
		basePolicyRepository.deleteAll();
		complianceRepository.deleteAll();
	}

	@Test
	@Transactional
	@Rollback(false)
	public void save() {
		//given
		String policyName = "IC_NCP_1";
		BasePolicy basePolicy = BasePolicy.builder()
			.policyName(policyName).build();
		String complianceName = "ISMS-P";
		String complianceNumber = "2.9.2";
		Compliance compliance = Compliance.builder()
			.complianceName(complianceName)
			.complianceNumber(complianceNumber)
			.build();
		basePolicyRepository.save(basePolicy);
		complianceRepository.save(compliance);
		String complianceDetail = "In order to ensure the availability of the information system, it is necessary to effectively respond to traffic coming in from outside by performing a health check.";
		PolicyCompliance policyCompliance = PolicyCompliance.builder()
			.complianceDetail(complianceDetail)
			.basePolicy(basePolicy)
			.compliance(compliance)
			.build();
		policyComplianceRepository.save(policyCompliance);
		//when
		List<BasePolicy> basePolicyList = basePolicyRepository.findAll();
		List<Compliance> complianceList = complianceRepository.findAll();
		List<PolicyCompliance> policyComplianceList = policyComplianceRepository.findAll();

		//then
		Assertions.assertThat(basePolicyList.get(0).getPolicyName()).isEqualTo(policyName);
		Assertions.assertThat(complianceList.get(0).getComplianceName()).isEqualTo(complianceName);
		Assertions.assertThat(complianceList.get(0).getComplianceNumber()).isEqualTo(complianceNumber);
		Assertions.assertThat(policyComplianceList.get(0).getComplianceDetail()).isEqualTo(complianceDetail);
		Assertions.assertThat(basePolicyList.get(0).getPolicyComplianceList().get(0).getComplianceDetail()).isEqualTo(complianceDetail);
		Assertions.assertThat(complianceList.get(0).getPolicyComplianceList().get(0).getComplianceDetail()).isEqualTo(complianceDetail);
		Assertions.assertThat(basePolicyList.get(0).getPolicyComplianceList().get(0).getCompliance().getComplianceName()).isEqualTo(complianceName);
	}
}
