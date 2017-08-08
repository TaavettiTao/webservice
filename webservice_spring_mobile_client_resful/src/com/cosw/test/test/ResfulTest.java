package com.cosw.test.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.cosw.test.bean.Order;
import com.cosw.test.util.HttpClientUtil;

public class ResfulTest {
	public static final String prefix = "http://localhost:8080/webservice_spring_mobile_server_resful/ws/mobile2/mo/";
	public static final String QUERY_ORDERS = prefix + "queryOrders?_type=xml";
	public static final String QUERY_ORDER1 = prefix + "queryOrder1/1";
	public static final String QUERY_ORDER2 = prefix + "queryOrder2/2";
	public static final String QUERY_ORDER3 = prefix + "queryOrder3/3";
	public static final String GET_ARRAY = prefix + "getArray/3";
	public static final String GET_ARRAY_OBJ = prefix + "getArrayObj/3";
	public static final String GET_ARRAY_OBJ_JSON = prefix
			+ "getArrayObj/3?_type=json";
	public static final String GET_ARRAY_OBJ_XML = prefix
			+ "getArrayObj/3?_type=xml";
	public static final String GET_SET_OBJ = prefix + "getSetObj";
	public static final String GET_SET_BASIC = prefix + "getSetBasic";
	public static final String GET_MAP_BASIC = prefix + "getMapBasic";

	public static void main(String[] args) {
		// queryOrders();

		/* queryOrder1(); */
		/* queryOrder2(); */
		/* queryOrder3(); */

		/* getArray(); */
		/*getArrayObj();*/
		getSetBasic();
		getSetObj();
		getMap();
	}

	public static void queryOrders() {
		Order order = new Order();
		order.setId(1);
		order.setName("我进来看看...");
		try {
			System.out.println(HttpClientUtil.postRequest(QUERY_ORDERS,
					objToJsonStr(order)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void queryOrder1() {
		try {
			System.out.println(HttpClientUtil.postRequest(QUERY_ORDER1,
					new HashMap<String, Object>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void queryOrder2() {
		try {
			System.out.println(HttpClientUtil.postRequest(QUERY_ORDER2,
					new HashMap<String, Object>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void queryOrder3() {
		try {
			System.out.println(HttpClientUtil.postRequest(QUERY_ORDER3,
					new HashMap<String, Object>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取基本数据类型数组：int[]
	public static void getArray() {
		try {
			System.out.println(HttpClientUtil.postRequest(GET_ARRAY,
					new HashMap<String, Object>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取对象类型数组：order[]
	public static void getArrayObj() {
		try {
			System.out.println(HttpClientUtil.postRequest(GET_ARRAY_OBJ,
					new HashMap<String, Object>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getSetBasic() {
		Order order = new Order();
		order.setId(1);
		order.setName("我进来看看...");
		try {
			System.out.println("getSetBasic:"+HttpClientUtil.postRequest(GET_SET_BASIC,
					objToJsonStr(order)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getSetObj() {
		Order order = new Order();
		order.setId(1);
		order.setName("我进来看看...");
		try {
			System.out.println("getSetObj:"+HttpClientUtil.postRequest(GET_SET_OBJ,
					objToJsonStr(order)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getMap() {
		Order order = new Order();
		order.setId(1);
		order.setName("我进来看看...");
		try {
			System.out.println("getMap:"+ HttpClientUtil.postRequest(GET_MAP_BASIC,
					objToJsonStr(order)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String objToJsonStr(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String mapJakcson = null;
		try {
			mapJakcson = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapJakcson;
	}
}
