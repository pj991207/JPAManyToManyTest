package com.rocket23.jpamanytomanytest.compliance.dto;

import com.rocket23.jpamanytomanytest.compliance.entity.BasePolicy;

import lombok.Getter;

@Getter
public class ComplianceDto {
	private String policyName;
	private String complianceName;
	private String complianceNumber;
	private String complianceDetail;

}
