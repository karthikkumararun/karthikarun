package com.karthik.spring.learning.sayhelloservice;

import learning.spring.karthik.com.sayhello.SayHelloOperationRequest;
import learning.spring.karthik.com.sayhello.SayHelloOperationResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * <p>
 * WS Endpoint for Say hello service
 * </p>
 * 
 * @author Karthik Arun (karthikarun@outlook.com)
 * 
 */
@Endpoint
public class SayHelloEndpoint {

	@PayloadRoot(localPart = "SayHelloOperationRequest", namespace = "http://com.karthik.spring.learning/SayHello/")
	public SayHelloOperationResponse sayHello(SayHelloOperationRequest request) {
		SayHelloOperationResponse response = new SayHelloOperationResponse();
		if (request != null) {
			response.setHelloMessage("Hello " + request.getName() + ", good to know you!");
		}
		return response;
	}
}
