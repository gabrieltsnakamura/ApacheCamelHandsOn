package com.example.demo.controller;

import org.apache.camel.Exchange;

import com.example.demo.dto.ValidacaoPostException;

public class TratarException {
	
	public void trataException(Exchange exchange) {
		Throwable t = exchange.getException();
		
		if (t instanceof ValidacaoPostException) {
			exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, "500");
		}
	}
}
