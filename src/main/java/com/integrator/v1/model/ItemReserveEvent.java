package com.integrator.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemReserveEvent {

	@JsonProperty("event")
	private String event;
	
	@JsonProperty("event_date")
	private String eventDate;
	
	@JsonProperty("reference_ids")
	private ReferenceIds referenceIds;
}
