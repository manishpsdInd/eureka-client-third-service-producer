package com.spring.camel.integration.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.camel.integration.constant.SpringCamelConstant;
import com.spring.camel.integration.dto.RequestDto;

public class FirstRouteProcessor implements Processor	{

	private static final Logger log = LoggerFactory.getLogger(FirstRouteProcessor.class);
	
	public void process(Exchange exchange) throws Exception	{
		
		log.info("FirstRouteProcessor process() enterying");
		RequestDto body = exchange.getIn().getBody(RequestDto.class);

		log.info("FirstRouteProcessor - exchangeID: " + exchange.getExchangeId());
		
		exchange.getIn().setHeader(SpringCamelConstant.HEADER_DAY_MSG, new String("GoOd MoRnInG ") + body);
		exchange.getIn().setBody(null);
		
		log.info("FirstRouteProcessor process() exiting");
	}
}