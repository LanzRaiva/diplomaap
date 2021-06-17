package com.microservice.orchestration.demo.bpm;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.orchestration.demo.adapter.amqp.producer.AmqpRpcClient;
import com.microservice.orchestration.demo.entity.BusinessEntity;
import com.microservice.orchestration.demo.entity.ServiceResponse;

@Component
public class AllocateInventoryActivity implements JavaDelegate {
	private static final Logger LOG = LoggerFactory.getLogger(AllocateInventoryActivity.class);

	public static final String SERVICE_ACTION = "allocate";

	@Autowired
	AmqpRpcClient amqpRpcClient;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("execute {} - {}", ProcessConstants.SERVICE_NAME_INVENTORY, SERVICE_ACTION);
		BusinessEntity sc = (BusinessEntity) execution.getVariable(ProcessConstants.VAR_SC);
		ServiceResponse response = amqpRpcClient.invokeService(
				ProcessUtil.buildServiceRequest(sc, ProcessConstants.SERVICE_NAME_INVENTORY, SERVICE_ACTION));
		ProcessUtil.processResponse(execution, response);
		execution.setVariable(ProcessConstants.VAR_INVENTORY_ALLOCATED, true);
	}

}
