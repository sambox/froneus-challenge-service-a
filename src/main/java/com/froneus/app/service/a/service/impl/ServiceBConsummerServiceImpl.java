package com.froneus.app.service.a.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.froneus.app.service.a.client.ServiceBClient;
import com.froneus.app.service.a.dto.MessageDTO;
import com.froneus.app.service.a.service.IServiceBConsummerService;

@Service
public class ServiceBConsummerServiceImpl implements IServiceBConsummerService {

	private static Logger log = LoggerFactory.getLogger(ServiceBConsummerServiceImpl.class);
	
	@Autowired
	private ServiceBClient client;
	
	@Async
	@Override
	public MessageDTO consume(MessageDTO dto) {
		MessageDTO retorno;
		log.info(">>>>>>> Dispatching asynchronous message");
		retorno = client.transcribe(dto);
		log.info(">>>>>>> Asynchronous message dispatched");
		return retorno;
	}

}
