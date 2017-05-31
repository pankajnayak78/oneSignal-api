package com.pk.oneSignal.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author pankaj.nayak
 * @since May 2, 2017 2:39:05 PM
 */
public class OneSignalRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @com.fasterxml.jackson.annotation.JsonProperty("app_id")
    private String oneSignalAppId;

    @com.fasterxml.jackson.annotation.JsonProperty("include_player_ids")
    private List<String> playerIds;

    @com.fasterxml.jackson.annotation.JsonProperty("headings")
    private Map<String, String> title;

    @com.fasterxml.jackson.annotation.JsonProperty("contents")
    private Map<String, String> description;

    public List<String> getPlayerIds() {
	return playerIds;
    }

    public void setPlayerIds(List<String> playerIds) {
	this.playerIds = playerIds;
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
