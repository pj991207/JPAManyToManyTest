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

import com.rocket23.jpamanytomanytest.common.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "BASE_POLICY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BasePolicy extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BASE_POLICY_ID")
	private Long id;

	@Column(name = "DEFAULT_POLICT_NAME")
	private String policyName;

	@OneToMany(mappedBy = "basePolicy")
	private List<PolicyCompliance> policyComplianceList = new ArrayList<>();

	@Builder
	public BasePolicy(String policyName){
		this.policyName = policyName;
	}
}
