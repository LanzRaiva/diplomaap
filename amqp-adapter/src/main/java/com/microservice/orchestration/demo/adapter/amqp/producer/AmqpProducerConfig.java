package com.microservice.orchestration.demo.adapter.amqp.producer;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({ "amqp-producer" })
@Configuration
public class AmqpProducerConfig {
	@Value("${spring.rabbitmq.exchange.rpc}")
	private String exchangeRpc;

	@Value("${spring.rabbitmq.exchange.pub}")
	public String exchangePub;

	@Bean
	public TopicExchange rpcExchange() {
		return new TopicExchange(exchangeRpc);
	}

	@Bean
	public AmqpRpcClient rpcClient() {
		return new AmqpRpcClient();
	}

	@Bean
	public TopicExchange pubExchange() {
		return new TopicExchange(exchangePub);
	}

	@Bean
	public AmqpPublisher pubClient() {
		return new AmqpPublisher();

	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
