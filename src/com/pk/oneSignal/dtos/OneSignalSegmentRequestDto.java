package com.pk.oneSignal.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pankaj.nayak
 * @since May 2, 2017 2:39:05 PM
 */
public class OneSignalSegmentRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("app_id")
    private String oneSignalAppId;

    @JsonProperty("included_segments")
    private List<String> included_segments;

    @JsonProperty("excluded_segments")
    private List<String> excluded_segments;

    @JsonProperty("headings")
    private Map<String, String> title;

    @JsonProperty("contents")
    private Map<String, String> description;

    public List<String> getIncluded_segments() {
	return included_segments;
    }

    public void setIncluded_segments(List<String> included_segments) {
	this.included_segments = included_segments;
    }

    public List<String> getExcluded_segments() {
	return excluded_segments;
    }

    public void setExcluded_segments(List<String> excluded_segments) {
	this.excluded_segments = excluded_segments;
    }

    public String getOneSignalAppId() {
	return oneSignalAppId;
    }

    public void setOneSignalAppId(String oneSignalAppId) {
	this.oneSignalAppId = oneSignalAppId;
    }

    public Map<String, String> getTitle() {
	return title;
    }

    public void setTitle(Map<String, String> title) {
	this.title = title;
    }

    public Map<String, String> getDescription() {
	return description;
    }

    public void setDescription(Map<String, String> description) {
	this.description = description;
    }

}
