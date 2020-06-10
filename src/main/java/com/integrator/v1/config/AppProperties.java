package com.integrator.v1.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:application.properties"})
public class AppProperties {
	
	@Value("${wms.api.receiveorder.url}")
	String wmsReceiveOrderApiUrl;

	public String getWmsReceiveOrderApiUrl() {
		return wmsReceiveOrderApiUrl;
	}

	public void setWmsReceiveOrderApiUrl(String wmsReceiveOrderApiUrl) {
		this.wmsReceiveOrderApiUrl = wmsReceiveOrderApiUrl;
	}
	
}
