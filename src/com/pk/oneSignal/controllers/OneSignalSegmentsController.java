package com.pk.oneSignal.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import com.pk.oneSignal.dtos.HttpResponseDto;
import com.pk.oneSignal.dtos.OneSignalResponseDto;
import com.pk.oneSignal.dtos.OneSignalSegmentRequestDto;
import com.pk.oneSignal.helpers.CommonUtils;
import com.pk.oneSignal.helpers.HttpResponseHandler;

public class OneSignalSegmentsController {

    public static void main(String[] args) {

        System.out.println("Starting the process for OneSignal Segment Test..");

        String url = "https://onesignal.com/api/v1/notifications";
        OneSignalSegmentRequestDto oneSignalRequest = buildOneSignalRequestDto();

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
    private static com.pk.oneSignal.dtos.OneSignalSegmentRequestDto buildOneSignalRequestDto() {
        OneSignalSegmentRequestDto oneSignalRequest = new OneSignalSegmentRequestDto();

        Map<String, String> messages = new HashMap<>();
        messages.put("en", "Test messeage using java code for segment test.");

        Map<String, String> titles = new HashMap<>();
        titles.put("en", "Segment Test");

        List<String> included_segments = new ArrayList<String>();
        included_segments.add("temp");
        // included_segments.add("All RBT Users");

        List<String> excluded_segments = new ArrayList<String>();
        excluded_segments.add("All Non RBT Users");

        oneSignalRequest.setOneSignalAppId("75405546-9408-4d07-8f9d-154223ff951a");
        oneSignalRequest.setIncluded_segments(included_segments);
        oneSignalRequest.setExcluded_segments(excluded_segments);
        oneSignalRequest.setTitle(titles);
        oneSignalRequest.setDescription(messages);

        return oneSignalRequest;
    }

}
