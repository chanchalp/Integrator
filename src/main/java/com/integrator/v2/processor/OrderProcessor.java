package com.integrator.v2.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class OrderProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("inside order processor...");		
	}

}
