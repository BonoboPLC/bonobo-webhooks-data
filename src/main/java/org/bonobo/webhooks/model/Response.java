package org.bonobo.webhooks.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	@NotNull
	@ApiModelProperty(value = "the event id", required = true, example = "00112233-4455-6677-8899-aabbccddeeff")
	private String eventId;
    
    String status;
    String code;
    String title;
    String detail;
    List<Link> links;
    Map<String, Object> meta;
    Source source;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Source {
        String pointer;
        String parameter;

        public String getParameter() {
            return parameter;
        }

        public String getPointer() {
            return pointer;
        }
    }

    public Source getSource() {
        return source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public void addMeta(String key, Object value) {
    	if (this.meta == null)
    		this.meta = new HashMap<String, Object>();    	
        this.meta.put(key, value);
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addPointerSource(String pointer) {
        final Source source = new Source();
        source.pointer = pointer;
        this.source = source;
    }

    public void addParameterSource(String parameter) {
        final Source source = new Source();
        source.parameter = parameter;
        this.source = source;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [eventId=");
		builder.append(eventId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", code=");
		builder.append(code);
		builder.append(", title=");
		builder.append(title);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", links=");
		builder.append(links);
		builder.append(", meta=");
		builder.append(meta);
		builder.append(", source=");
		builder.append(source);
		builder.append("]");
		return builder.toString();
	}
    
}
