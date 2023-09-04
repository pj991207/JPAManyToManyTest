package com.rocket23.jpamanytomanytest.compliance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rocket23.jpamanytomanytest.common.entity.BaseEntity;
import com.rocket23.jpamanytomanytest.compliance.dto.ComplianceDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "COMPLIANCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Compliance extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPLIANCE_ID")
	private Long id;

	@Column(name = "COMPLIANCE_NUMBER")
	private String complianceNumber;

	@Column(name = "COMPLIANCE_NAME")
	private String complianceName;

	@OneToMany(mappedBy = "compliance")
	private List<PolicyCompliance> policyComplianceList = new ArrayList<>();

	@Builder
	public Compliance(String complianceName, String complianceNumber){
		this.complianceName = complianceName;
		this.complianceNumber = complianceNumber;
	}

	public static Compliance toEnitiy(ComplianceDto complianceDto){
		return Compliance.builder()
			.complianceName(complianceDto.getComplianceName())
			.complianceNumber(complianceDto.getComplianceNumber())
			.build();
	}
}
