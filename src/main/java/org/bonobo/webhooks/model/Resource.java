package org.bonobo.webhooks.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class Resource<T> {

    String id;

    @NotBlank
    String type;

    @Valid
    @JsonProperty("attributes")
    T data;
}
