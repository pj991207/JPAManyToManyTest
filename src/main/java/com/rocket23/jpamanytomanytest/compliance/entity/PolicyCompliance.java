package com.rocket23.jpamanytomanytest.compliance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rocket23.jpamanytomanytest.common.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "POLICY_COMPLIANCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PolicyCompliance extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POLICY_COMPLIANCE_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BASE_POLICY_ID")
	private BasePolicy basePolicy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPLIANCE_ID")
	private Compliance compliance;

	@Column(name = "COMPLIANCE_DETAIL")
	private String complianceDetail;
}
