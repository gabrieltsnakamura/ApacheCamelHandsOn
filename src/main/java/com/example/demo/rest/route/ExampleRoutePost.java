package com.example.demo.rest.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.example.demo.controller.PessoaController;
import com.example.demo.controller.TratarException;
import com.example.demo.dto.Pessoa;


@Component
public class ExampleRoutePost extends RouteBuilder {
	
	
	@Override
	public void configure() throws Exception {
		from("direct:ExampleDirect")
		.doTry()
			.unmarshal().json(JsonLibrary.Jackson, Pessoa.class)
			.bean(PessoaController.class, "trataEntradaPost")
		.doCatch(Exception.class)
			.bean(TratarException.class, "trataException")
		.end()
		.marshal().json(JsonLibrary.Jackson);
	}

}
