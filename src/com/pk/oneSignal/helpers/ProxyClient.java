package com.pk.oneSignal.helpers;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;

public class ProxyClient {

    public static void main(String[] args) throws ClientProtocolException, IOException {

	NTCredentials ntCreds = new NTCredentials("pankaj.nayak", "Im8onmobile", "WBLL0217E4364", "OM");

	CredentialsProvider credsProvider = new BasicCredentialsProvider();
	credsProvider.setCredentials(new AuthScope("webprlinvmec2.onmobile.com", 80), ntCreds);
	HttpClientBuilder clientBuilder = HttpClientBuilder.create();

	clientBuilder.useSystemProperties();
	clientBuilder.setProxy(new HttpHost("webprlinvmec2.onmobile.com", 80));
	clientBuilder.setDefaultCredentialsProvider(credsProvider);
	clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());

	HttpClient client = clientBuilder.build();
	HttpResponse response2 = client.execute(
		new HttpGet("https://onesignal.com/api/v1/apps/d22454a8-f5d3-4edc-a655-2805627628d6"));
	System.out.println(response2.toString());
    }

}
