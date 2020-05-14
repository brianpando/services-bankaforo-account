package com.app.aforo255account.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.aforo255account.service.TransactionEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class TransactionEventConsumer {
	private Logger log = LoggerFactory.getLogger( TransactionEventConsumer.class ) ; 
	@Autowired
	private TransactionEvent transactionEvent;
	
	//@KafkaListener(topics = {"transaction-events"})
	public void onMessage( ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		log.info("Consumer Record Account: {}",consumerRecord);
		transactionEvent.processTransactionEvent(consumerRecord);
	}
}
