package org.bonobo.webhooks.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractResponseWrapper<T> {

    @Valid
    T data;

    @Valid
    List<Response> responses;

    @Valid
    JsonApi jsonapi;

    public AbstractResponseWrapper() {
    }

    public AbstractResponseWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public JsonApi getJsonapi() {
        return jsonapi;
    }

    public void setJsonapi(JsonApi jsonapi) {
        this.jsonapi = jsonapi;
    }

    public boolean addError(Response response) {
        if (responses == null) {
        	responses = new ArrayList<>();
        }
        return responses.add(response);
    }

    public static class JsonApi {
        public static final JsonApi INSTANCE = new JsonApi();

        String version = "1.2";
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractResponseWrapper [data=");
		builder.append(data);
		builder.append(", responses=");
		builder.append(responses);
		builder.append(", jsonapi=");
		builder.append(jsonapi);
		builder.append("]");
		return builder.toString();
	}
    
}
