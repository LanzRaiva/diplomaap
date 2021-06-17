package com.microservice.orchestration.demo.bpm;

import java.io.Serializable;
import com.microservice.orchestration.demo.entity.BusinessEntity;
import com.microservice.orchestration.demo.entity.ErrorMessage;

public class ProcessContext implements Serializable {
	private static final long serialVersionUID = 1L;
	private BusinessEntity response;

	public BusinessEntity getResponse() {
		return response;
	}

	public void setResponse(BusinessEntity response) {
		this.response = response;
	}

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}

	private ErrorMessage error;
}
