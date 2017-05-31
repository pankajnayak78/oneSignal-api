package com.pk.oneSignal.dtos;

import java.io.Serializable;
import java.util.List;

/**
 * @author pankaj.nayak
 * @since May 2, 2017 2:54:39 PM
 */
public class OneSignalResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @com.fasterxml.jackson.annotation.JsonProperty("id")
    private String responseMessageid;

    @com.fasterxml.jackson.annotation.JsonProperty("recipients")
    private int recipients;

    @com.fasterxml.jackson.annotation.JsonProperty("errors")
    private List<String> errors;

    public String getResponseMessageid() {
	return responseMessageid;
    }

    public void setResponseMessageid(String responseMessageid) {
	this.responseMessageid = responseMessageid;
    }

    public int getRecipients() {
	return recipients;
    }

    public void setRecipients(int recipients) {
	this.recipients = recipients;
    }

    public List<String> getErrors() {
	return errors;
    }

    public void setErrors(List<String> errors) {
	this.errors = errors;
    }

    @Override
    public String toString() {
	return "OneSignalResponseDto [responseMessageid=" + responseMessageid + ", recipients=" + recipients
		+ ", errors=" + errors + "]";
    }

}
