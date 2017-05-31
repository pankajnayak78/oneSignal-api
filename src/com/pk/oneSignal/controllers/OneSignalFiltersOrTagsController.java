package com.pk.oneSignal.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import com.pk.oneSignal.dtos.Filter;
import com.pk.oneSignal.dtos.Filter.Operators;
import com.pk.oneSignal.dtos.Filter.Relation;
import com.pk.oneSignal.dtos.HttpResponseDto;
import com.pk.oneSignal.dtos.OneSignalFilterOrTagRequestDto;
import com.pk.oneSignal.dtos.OneSignalResponseDto;
import com.pk.oneSignal.helpers.CommonUtils;
import com.pk.oneSignal.helpers.HttpResponseHandler;

public class OneSignalFiltersOrTagsController {

    public static void main(String[] args) {

        System.out.println("Starting the process for OneSignal Filter Test..");

        String url = "https://onesignal.com/api/v1/notifications";
        OneSignalFilterOrTagRequestDto oneSignalRequest = buildOneSignalRequestDto();

        HttpPost post = CommonUtils.buildHTTPPost(url, oneSignalRequest);
        post.setHeader("Content-Type", "application/json; charset=UTF-8");
        post.setHeader("Authorization", "Basic OGFmNzE2NWYtNzdhZC00Y2RjLTg1NWEtMzM5MWRhY2RiMWRk");

        HttpClient client = CommonUtils.getHttpClient();
        try {
            System.out.println("Executing Your Post request...");
            HttpResponseDto httpResponse = client.execute(post, new HttpResponseHandler());
            System.out.println("Response Code : " + httpResponse.getHttpStatusCode());
            OneSignalResponseDto responseDto = CommonUtils.handleResult(httpResponse);
            System.out.println("Response: " + responseDto.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return
     */
    private static OneSignalFilterOrTagRequestDto buildOneSignalRequestDto() {
        OneSignalFilterOrTagRequestDto oneSignalRequest = new OneSignalFilterOrTagRequestDto();

        Map<String, String> messages = new HashMap<>();
        messages.put("en", "Test messeage using java code for Filter test with relation.");

        Map<String, String> titles = new HashMap<>();
        titles.put("en", "Filter Test");

        oneSignalRequest.setOneSignalAppId("75405546-9408-4d07-8f9d-154223ff951a");
        oneSignalRequest.setTitle(titles);
        oneSignalRequest.setDescription(messages);
        oneSignalRequest.setFilters(getFilters());

        return oneSignalRequest;
    }

    private static List<Filter> getFilters() {
        List<Filter> filters = new ArrayList<>();

        Filter firstFilter = new Filter();
        firstFilter.setField("tag");
        firstFilter.setKey("circle");
        firstFilter.setRelation(Relation.EQUALTO.getRelation());
        firstFilter.setValue("TIM");
        filters.add(firstFilter);

        Filter operator = new Filter();
        operator.setOperator(Operators.AND.getOperator());
        filters.add(operator);

        Filter secondFilter = new Filter();
        secondFilter.setField("tag");
        secondFilter.setKey("user_type");
        secondFilter.setRelation(Relation.EQUALTO.getRelation());
        secondFilter.setValue("registered");
        filters.add(secondFilter);

        Filter secondOperator = new Filter();
        secondOperator.setOperator(Operators.AND.getOperator());
        filters.add(secondOperator);

        Filter thirdFilter = new Filter();
        thirdFilter.setField("tag");
        thirdFilter.setKey("current_rbt_language");
        thirdFilter.setRelation(Relation.EQUALTO.getRelation());
        thirdFilter.setValue("ka - ringback_profile");
        filters.add(thirdFilter);

        return filters;
    }

}
