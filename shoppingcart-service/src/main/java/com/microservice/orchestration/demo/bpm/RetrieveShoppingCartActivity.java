package com.microservice.orchestration.demo.bpm;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.orchestration.demo.dataaccess.ShoppingCartManager;
import com.microservice.orchestration.demo.entity.BusinessEntity;
import com.microservice.orchestration.demo.entity.ServiceResponse;

@Component
public class RetrieveShoppingCartActivity implements JavaDelegate {
	private static final Logger LOG = LoggerFactory.getLogger(RetrieveShoppingCartActivity.class);
	public static final String SERVICE_ACTION = "retrieve";

	@Autowired
	ShoppingCartManager shoppingCartManager;

	@Override
	public void execute(DelegateExecution ctx) throws Exception {
		LOG.info("execute {} - {}", ProcessConstants.SERVICE_NAME_SHOPPINGCART, SERVICE_ACTION);
		String scId = (String) ctx.getVariable(ProcessConstants.VAR_SC_ID);
		ServiceResponse response = shoppingCartManager.getShoppingCart(scId);
		ProcessUtil.processResponse(ctx, response);
		BusinessEntity sc = response.getItems().get(0);
		ctx.setVariable(ProcessConstants.VAR_SC, sc);
	}

}
