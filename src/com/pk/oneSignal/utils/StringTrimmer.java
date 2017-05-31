package com.pk.oneSignal.utils;

public class StringTrimmer {

    public static void main(String[] args) {
	String value = "/callLog/voltron?subscriberId=$[MSISDN]&max=$[MAX]&offset=$[OFFSET]&call_type=$[CALL_TYPE]&start_date=$[START_DATE]";
	String replace = "$[START_DATE]";
	System.out.println(removeParamter(value, replace));
    }

    private static String removeParamter(String url, String replaceHolder) {

	String firstUrl = url.substring(0, url.indexOf(replaceHolder));
	int startIndexSecondUrl = url.indexOf(replaceHolder) + replaceHolder.length();
	String secondUrl = url.substring(startIndexSecondUrl);
	if (firstUrl.lastIndexOf("&") != -1) {
	    return firstUrl.substring(0, firstUrl.lastIndexOf("&")) + secondUrl;
	} else {
	    return firstUrl.substring(0, firstUrl.lastIndexOf("?") + 1)
		    + ((secondUrl.length() > 1) ? secondUrl.substring(1) : "");
	}

    }
}
