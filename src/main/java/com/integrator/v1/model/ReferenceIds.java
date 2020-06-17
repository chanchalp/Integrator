package com.integrator.v1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceIds {

	@JsonProperty("reserved")
    private List<Reserved> reserved;

	@JsonProperty("failed")
    private List<Failed> failed;
}
