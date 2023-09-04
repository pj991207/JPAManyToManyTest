package com.rocket23.jpamanytomanytest.compliance.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocket23.jpamanytomanytest.common.dto.ResponseDto;
import com.rocket23.jpamanytomanytest.compliance.dto.ComplianceDto;
import com.rocket23.jpamanytomanytest.compliance.service.ComplianceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test/")
@RequiredArgsConstructor
public class ComplianceController {

	private final ComplianceService complianceService;
	@PostMapping("/save")
	public ResponseDto<?> record(@RequestBody ComplianceDto complianceDto){
		if(complianceService.save(complianceDto)){
			return new ResponseDto<>(null);
		}
		return null;
	}

}
