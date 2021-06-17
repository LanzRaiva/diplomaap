package com.microservice.orchestration.demo.bpm;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.orchestration.demo.adapter.amqp.producer.AmqpPublisher;
import com.microservice.orchestration.demo.entity.BusinessEntity;

@Component
public class NotifyCustomerActivity implements JavaDelegate {
	private static final Logger LOG = LoggerFactory.getLogger(NotifyCustomerActivity.class);

	public static final String SERVICE_ACTION = "notify";

	@Autowired
	AmqpPublisher amqpPubClient;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("execute {} - {}", ProcessConstants.SERVICE_NAME_CUSTOMER, SERVICE_ACTION);
		BusinessEntity sc = (BusinessEntity) execution.getVariable(ProcessConstants.VAR_SC);
		amqpPubClient.publishEvent(
				ProcessUtil.buildServiceRequest(sc, ProcessConstants.SERVICE_NAME_CUSTOMER, SERVICE_ACTION));
		execution.setVariable(ProcessConstants.VAR_RESPONSE, sc);
		ProcessContext ctx = (ProcessContext) execution.getVariable(ProcessConstants.VAR_CTX);
		ctx.setResponse(sc);
	}

}
