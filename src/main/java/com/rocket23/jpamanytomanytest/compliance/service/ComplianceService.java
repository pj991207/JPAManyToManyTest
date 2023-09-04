package com.rocket23.jpamanytomanytest.compliance.service;

import com.rocket23.jpamanytomanytest.common.dto.ResponseDto;
import com.rocket23.jpamanytomanytest.compliance.dto.ComplianceDto;

public interface ComplianceService {
	boolean save(ComplianceDto complianceDto);
}
