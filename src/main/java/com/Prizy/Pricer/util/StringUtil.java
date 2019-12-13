package com.Prizy.Pricer.util;

import org.json.JSONObject;

public class StringUtil {

	public static boolean isNullObject(Object s) {
		if (null == s) {
			return true;
		}
		return false;
	}

	public static boolean isNullJSONObject(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof JSONObject && ((JSONObject) obj).length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(String s) {
		if (null == s || 0 == s.length()) {
			return true;
		}
		return false;
	}
}
