package com.zhongwei.app.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * 
 * @author Cheng.xie HTTP请求基础类
 * 
 */
public class HttpBase {

	/**
	 * HTTP请求
	 * 
	 * @param url
	 * @return
	 */
	public static String httpGet(String url) {
		HttpGet httpRequest = new HttpGet(url);
		HttpResponse httpResponse;
		try {
			httpResponse = new DefaultHttpClient().execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(httpResponse.getEntity(),
						"UTF-8");
				String deResult = decode(result);
				Log.i("result", deResult);
				return decode(result);
			} else {
				return null;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回数据编码转换
	 * 
	 * @param unicodeStr
	 * @return
	 */
	private static String decode(String unicodeStr) {
		if (unicodeStr == null) {
			return null;
		}

		unicodeStr = unicodeStr.substring(unicodeStr.indexOf("{"),
				unicodeStr.lastIndexOf("}") + 1);

		StringBuffer retBuf = new StringBuffer();
		int maxLoop = unicodeStr.length();
		for (int i = 0; i < maxLoop; i++) {
			if (unicodeStr.charAt(i) == '\\') {
				if ((i < maxLoop - 5)
						&& ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr
								.charAt(i + 1) == 'U')))
					try {
						retBuf.append((char) Integer.parseInt(
								unicodeStr.substring(i + 2, i + 6), 16));
						i += 5;
					} catch (NumberFormatException localNumberFormatException) {
						retBuf.append(unicodeStr.charAt(i));
					}
				else
					retBuf.append(unicodeStr.charAt(i));
			} else {
				retBuf.append(unicodeStr.charAt(i));
			}
		}
		unicodeStr = retBuf.toString();
		unicodeStr = unicodeStr.replaceAll("\\\\", "");
		return unicodeStr;
	}

}
