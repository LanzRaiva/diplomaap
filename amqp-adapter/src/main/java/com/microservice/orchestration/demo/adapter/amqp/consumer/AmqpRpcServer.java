package com.microservice.orchestration.demo.adapter.amqp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.orchestration.demo.entity.ServiceRequest;
import com.microservice.orchestration.demo.entity.ServiceResponse;

public class AmqpRpcServer {
	private static final Logger LOG = LoggerFactory.getLogger(AmqpRpcServer.class);

	@Autowired
	EventHandler eventHandler;

	@RabbitListener(queues = "#{serviceQueue.name}")
	public ServiceResponse process(ServiceRequest request) {
		LOG.trace("RPC service request: {}", request);
		LOG.trace("Handled by: {}", eventHandler.getClass());
		return eventHandler.processRequest(request);
	}
}
