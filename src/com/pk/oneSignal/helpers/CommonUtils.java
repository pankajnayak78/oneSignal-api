package com.pk.oneSignal.helpers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.oneSignal.dtos.HttpResponseDto;
import com.pk.oneSignal.dtos.OneSignalResponseDto;

public class CommonUtils {

    public static HttpPost buildHTTPPost(String url, Object requestDto) {
        HttpPost post = new HttpPost(url);

        try {
            StringEntity entity = new StringEntity(createJsonBody(requestDto));
            post.setEntity(entity);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        return post;
    }

    /**
     * @param oneSignalRequest
     * @return
     */
    private static String createJsonBody(Object oneSignalRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(oneSignalRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Could not read values..";
    }

    /**
     * @param httpResponse
     * @return
     */
    public static OneSignalResponseDto handleResult(HttpResponseDto httpResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(httpResponse.getResponseBody(), OneSignalResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpClient getHttpClient() {
        NTCredentials ntCreds = new NTCredentials("pankaj.nayak", "Im8onmobile", "WBLL0217E4364", "OM");

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope("webprlinvmec2.onmobile.com", 80), ntCreds);
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();

        clientBuilder.useSystemProperties();
        clientBuilder.setProxy(new HttpHost("webprlinvmec2.onmobile.com", 80));
        clientBuilder.setDefaultCredentialsProvider(credsProvider);
        clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());

        return clientBuilder.build();
    }

}
