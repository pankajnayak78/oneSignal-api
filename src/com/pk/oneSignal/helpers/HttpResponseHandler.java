package com.pk.oneSignal.helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.pk.oneSignal.dtos.HttpResponseDto;

public class HttpResponseHandler implements ResponseHandler<HttpResponseDto> {

	@Override
	public HttpResponseDto handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

		int statusCode = getStatusCode(response);
		String jsonResponse = getBodyAsString(response);
		Map<String, List<String>> headers = getHeaders(response);

		return buildResponse(statusCode, jsonResponse, headers);
	}

	private Map<String, List<String>> getHeaders(HttpResponse response) {
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		for (Header header : response.getAllHeaders()) {
			String name = header.getName();
			List<String> headerValues = headers.get(name);
			if (headerValues == null) {
				headerValues = new ArrayList<String>();
				headers.put(name, headerValues);
			}
			headerValues.add(header.getValue());
		}
		return headers;
	}

	private HttpResponseDto buildResponse(int statusCode, String jsonResponse, Map<String, List<String>> headers) {
		HttpResponseDto result = new HttpResponseDto();
		result.setHttpStatusCode(statusCode);
		result.setResponseBody(jsonResponse);
		result.setHeaders(headers);
		return result;
	}

	private String getBodyAsString(HttpResponse response) throws IOException {
		return EntityUtils.toString(response.getEntity());
	}

	private int getStatusCode(HttpResponse response) {
		StatusLine statusLine = response.getStatusLine();
		return statusLine.getStatusCode();
	}
}
