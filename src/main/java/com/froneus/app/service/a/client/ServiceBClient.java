package com.froneus.app.service.a.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.froneus.app.service.a.dto.MessageDTO;

@FeignClient(name="service-b", url="localhost:8090/api/service-b/")
public interface ServiceBClient {

	@PostMapping("transcribe")
	public MessageDTO transcribe(@RequestBody MessageDTO dto);
}
