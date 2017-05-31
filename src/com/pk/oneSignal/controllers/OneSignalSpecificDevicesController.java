package com.pk.oneSignal.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import com.pk.oneSignal.dtos.HttpResponseDto;
import com.pk.oneSignal.dtos.OneSignalRequestDto;
import com.pk.oneSignal.dtos.OneSignalResponseDto;
import com.pk.oneSignal.helpers.CommonUtils;
import com.pk.oneSignal.helpers.HttpResponseHandler;

public class OneSignalSpecificDevicesController {

    public static void main(String[] args) {

        System.out.println("Starting the process..");

        String url = "https://onesignal.com/api/v1/notifications";
        OneSignalRequestDto oneSignalRequest = buildOneSignalRequestDto();
        HttpPost post = CommonUtils.buildHTTPPost(url, oneSignalRequest);
        post.setHeader("Content-Type", "application/json; charset=UTF-8");
        post.setHeader("Authorization", "Basic ZjBjNWRmMTItY2JmMi00MWMyLWFiMzctNzJiY2NlYzdmNzU1");

        HttpClient client = CommonUtils.getHttpClient();
        try {
            System.out.println("Executing Your Post request...");
            HttpResponseDto httpResponse = client.execute(post, new HttpResponseHandler());
            System.out.println("Response Code : " + httpResponse.getHttpStatusCode());
            OneSignalResponseDto responseDto = CommonUtils.handleResult(httpResponse);
            System.out.println("\nResponse: " + responseDto.toString());
        } catch (IOException e) {
            System.out.println("Request failed...");
            e.printStackTrace();
        }

    }

    /**
     * @return
     */
    private static com.pk.oneSignal.dtos.OneSignalRequestDto buildOneSignalRequestDto() {
        OneSignalRequestDto oneSignalRequest = new OneSignalRequestDto();

        String id = "d282f28f-4821-40a2-8bfc-689074940f83";
        String id2 = "d282f28f-4821-40a2-8bfc-689074940f84";
        String id3 = "d282f28f-4821-40a2-8bfc-689074940f85";
        List<String> registrationIds = new ArrayList<String>();
        registrationIds.add(id);
        registrationIds.add(id2);
        registrationIds.add(id3);

        Map<String, String> messages = new HashMap<>();
        messages.put("en", "This is english messeage using java code");

        Map<String, String> titles = new HashMap<>();
        titles.put("en", "English Title");

        oneSignalRequest.setOneSignalAppId("d22454a8-f5d3-4edc-a655-2805627628d6");
        oneSignalRequest.setPlayerIds(registrationIds);
        oneSignalRequest.setTitle(titles);
        oneSignalRequest.setDescription(messages);

        return oneSignalRequest;
    }

}
