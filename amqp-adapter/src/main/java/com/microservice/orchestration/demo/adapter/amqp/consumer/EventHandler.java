package com.microservice.orchestration.demo.adapter.amqp.consumer;

import com.microservice.orchestration.demo.entity.ServiceRequest;
import com.microservice.orchestration.demo.entity.ServiceResponse;

public interface EventHandler {
	public ServiceResponse processRequest(ServiceRequest request);

	public void processEvent(ServiceRequest request);
}
