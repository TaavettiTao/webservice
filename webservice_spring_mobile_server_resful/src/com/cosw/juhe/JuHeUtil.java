package com.cosw.juhe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JuHeUtil {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	// 配置您申请的KEY
	public static final String APPKEY = "3559743cdb3d50703dc664c3848e4d00";

	// 1.手机归属地查询

	public static String getRequest(String phone) {
		String result = null;
		String url = "http://apis.juhe.cn/mobile/get";// 请求接口地址
		Map params = new HashMap();// 请求参数
		params.put("phone", phone);// 需要查询的手机号码或手机号码前7位
		params.put("key", APPKEY);// 应用APPKEY(应用详细页查询)
		params.put("dtype", "json");// 返回数据的格式,xml或json，默认json
		try {
			result = net(url, params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				JSONObject ob= (JSONObject)object.get("result");
				System.out.println(ob);
				return "省份:"+ob.getString("province")+",城市："+ob.getString("city")+",区域代码："+ob.getString("areacode")
						+",邮政编码:"+ob.getString("zip")+",运营商:"+ob.getString("company")+",SIM卡类型:"+ob.getString("card");
				
			} else {
				return object.get("error_code") + ":" + object.get("reason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "系统查询手机归属地异常!";
	}

	public static void main(String[] args) {
		getRequest("13429667914");
	}

	/**
	 *
	 * @param strUrl
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方法
	 * @return 网络请求字符串
	 * @throws Exception
	 */
	public static String net(String strUrl, Map params, String method)
			throws Exception {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		StringBuffer sb = new StringBuffer();
		if (method == null || method.equals("GET")) {
			strUrl = strUrl + "?" + urlencode(params);
		}
		URL url = new URL(strUrl);
		conn = (HttpURLConnection) url.openConnection();
		if (method == null || method.equals("GET")) {
			conn.setRequestMethod("GET");
		} else {
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
		}
		conn.setRequestProperty("User-agent", userAgent);
		conn.setUseCaches(false);
		conn.setConnectTimeout(DEF_CONN_TIMEOUT);
		conn.setReadTimeout(DEF_READ_TIMEOUT);
		conn.setInstanceFollowRedirects(false);
		conn.connect();
		if (params != null && method.equals("POST")) {
			try {
				DataOutputStream out = new DataOutputStream(
						conn.getOutputStream());
				out.writeBytes(urlencode(params));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		InputStream is = conn.getInputStream();
		reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
		String strRead = null;
		while ((strRead = reader.readLine()) != null) {
			sb.append(strRead);
		}
		rs = sb.toString();
		if (reader != null) {
			reader.close();
		}
		if (conn != null) {
			conn.disconnect();
		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, String> data)
			throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : data.entrySet()) {
			sb.append(i.getKey()).append("=")
					.append(URLEncoder.encode(i.getValue() + "", "UTF-8"))
					.append("&");
		}
		return sb.toString();
	}
}
