package com.pk.oneSignal.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpResponseDto implements Serializable {

    private static final long serialVersionUID = -773248774580930532L;

    private Map<String, List<String>> headers = new HashMap<String, List<String>>();
    private String responseBody;
    private int httpStatusCode;

    public String getResponseBody() {
	return responseBody;
    }

    public void setResponseBody(String responseBody) {
	this.responseBody = responseBody;
    }

    public int getHttpStatusCode() {
	return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
	this.httpStatusCode = httpStatusCode;
    }

    public Map<String, List<String>> getHeaders() {
	return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
	this.headers = headers;
    }

    @Override
    public String toString() {
	return "HttpResponseDto [headers=" + headers + ", responseBody=" + responseBody + ", httpStatusCode="
		+ httpStatusCode + "]";
    }

}
