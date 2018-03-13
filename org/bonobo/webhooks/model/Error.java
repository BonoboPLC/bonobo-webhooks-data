package org.bonobo.webhooks.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
		builder.append("Error [id=");
		builder.append(id);
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
