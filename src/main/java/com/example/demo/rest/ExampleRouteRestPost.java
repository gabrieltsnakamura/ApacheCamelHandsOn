package com.example.demo.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleRouteRestPost extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		rest("/example").id("example-rest")
		.post()
		.consumes("application/json")
		.produces("application/json")
		.route().routeId("example-rest-get")
		.to("direct:ExampleDirect")
		.endRest();		
	}

}
