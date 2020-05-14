package com.app.aforo255account.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255account.model.entity.Account;
import com.app.aforo255account.model.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionEvent {
	
	Logger log = LoggerFactory.getLogger(TransactionEvent.class);
	@Autowired
	private IAccountService repository;
	@Autowired
	ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		double newmonto=0;
		Account ojbAccount = new Account();
		Transaction transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class) ;
		log.info("transactionEvnet: {}",transactionEvent.getAccountId());
		ojbAccount = repository.findById(transactionEvent.getAccountId());
		log.info("get amount: {}",ojbAccount.getTotalAmount() );
		
		switch( transactionEvent.getType() ) {
		case "deposito":
			newmonto=ojbAccount.getTotalAmount() + transactionEvent.getAmount();
			break;
		case "retiro":
			newmonto=ojbAccount.getTotalAmount() - transactionEvent.getAmount();
			break;
			default:
				log.info("Invalid library event type");
		}
		
		log.info("set new amount {}",newmonto);
		ojbAccount.setTotalAmount(newmonto);
		repository.save(ojbAccount);
	}
}
