package com.froneus.app.service.a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.froneus.app.service.a.dto.MessageDTO;
import com.froneus.app.service.a.service.IServiceBConsummerService;

@Component
@Order(0)
public class StartupApplicationRunner implements ApplicationListener<ApplicationReadyEvent> {

	private static Logger log = LoggerFactory.getLogger(StartupApplicationRunner.class);
	
	@Autowired()
	private IServiceBConsummerService svc;
	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		log.info("Comienza el StartupApplicationRunner");
//		svc.consume("Service A is up!");
//		log.info("Finaliza el StartupApplicationRunner");
//	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info(">>>>>>> Comienza el StartupApplicationRunner");
		svc.consume(new MessageDTO("Service A is up!"));
		log.info(">>>>>>> Finaliza el StartupApplicationRunner");
	}

}
