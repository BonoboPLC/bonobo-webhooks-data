package org.bonobo.webhooks.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resource<T> {

    String id;

    @NotBlank
    String type;

    @Valid
    @JsonProperty("attributes")
    T data;
}
