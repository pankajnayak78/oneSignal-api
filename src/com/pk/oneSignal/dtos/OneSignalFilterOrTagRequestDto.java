package com.pk.oneSignal.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pankaj.nayak
 * @since May 30, 2017 2:39:05 PM
 */
public class OneSignalFilterOrTagRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("app_id")
    private String oneSignalAppId;

    @JsonProperty("filters")
    private List<Filter> filters;

    @JsonProperty("headings")
    private Map<String, String> title;

    @JsonProperty("contents")
    private Map<String, String> description;

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

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}
