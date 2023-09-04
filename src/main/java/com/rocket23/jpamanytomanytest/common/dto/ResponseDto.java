package com.rocket23.jpamanytomanytest.common.dto;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ResponseDto<T> {
	private final Boolean success;
	private final T data;

	public ResponseDto(@Nullable T data) {
		this.success = true;
		this.data = data;
	}
}
