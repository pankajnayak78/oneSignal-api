package com.pk.oneSignal.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author pankaj.nayak
 * @since May 30, 2017 3:49:19 PM
 */
@JsonInclude(Include.NON_NULL)
public class Filter {

    public enum Operators {
        AND("AND"), OR("OR");

        private String operator;

        private Operators(String value) {
            this.operator = value;
        }

        public String getOperator() {
            return operator;
        }
    }

    public enum Relation {

        LESSTHAN("<"), GREATERTHAN(">"), EQUALTO("="), NOTEQUALTO("!="), EXISTS("exists"), NOTEXISTS("not_exists");

        private String relation;

        private Relation(String value) {
            this.relation = value;
        }

        public String getRelation() {
            return relation;
        }

    }

    @JsonProperty("field")
    private String field;

    @JsonProperty("key")
    private String key;

    @JsonProperty("relation")
    private String relation;

    @JsonProperty("value")
    private String value;

    @JsonProperty("operator")
    private String operator;

    @JsonProperty("hours_ago")
    private String hours_ago;

    @JsonProperty("radius")
    private String radius;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("long")
    private String longitude;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHours_ago() {
        return hours_ago;
    }

    public void setHours_ago(String hours_ago) {
        this.hours_ago = hours_ago;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
