package cn.Higgin.ws.mobile.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.Higgin.ws.mobile.bean.Order;

import com.cosw.juhe.JuHeUtil;

public class MobileServiceImpl implements MobileService {

	@Override
	public String queryMobile(String phone) {
		return JuHeUtil.getRequest(phone);
	}

	@Override
	public Order queryOrder(String id) {
		Order order =new Order();
		order.setId(1);
		order.setName("name");
		return order;
	}

	@Override
	public List<Order> queryOrderList() {
		List<Order> orders=new ArrayList<Order>();
		Order order1=new Order();
		order1.setId(1);
		order1.setName("name");
		orders.add(order1);
		
		Order order2=new Order();
		order2.setId(2);
		order2.setName("name2");
		orders.add(order2);
		return orders;
	}

	@Override
	public String queryMobile1(String phone) {
		return phone;
	}

	@Override
	public List<Order> queryOrders(Order order) {
		System.out.println("queryOrders:"+order);
		List<Order> orders=new ArrayList<Order>();
		Order order1=new Order();
		order1.setId(1);
		order1.setName("name");
		orders.add(order1);
		
		Order order2=new Order();
		order2.setId(2);
		order2.setName("name2");
		orders.add(order2);
		return orders;
	}

	@Override
	public Order queryOrder1(int id) {
		Order order2=new Order();
		order2.setId(id);
		order2.setName("queryOrder1=>name2");
		return order2;
	}

	@Override
	public Order queryOrder2(Integer id) {
		Order order2=new Order();
		order2.setId(id);
		order2.setName("queryOrder2=>name2");
		return order2;
	}

	@Override
	public int queryOrder3(Integer id) {
		return 25;
	}

	@Override
	public int[] getArray(Integer id) {
		int[] arrays=new int[5];
		arrays[0]=1;
		arrays[1]=2;
		arrays[2]=3;
		arrays[3]=4;
		arrays[4]=5;
		return arrays;
	}

	@Override
	public Order[] getArrayObject(Integer id) {
		Order[] os=new Order[2];
		Order order2=new Order();
		order2.setId(id);
		order2.setName("queryOrder2=>name2");
		os[0]=order2;
		
		Order order3=new Order();
		order3.setId(id);
		order3.setName("queryOrder2=>name2");
		os[1]=order3;
		return os;
	}

	@Override
	public Set<Order> getSetObjSet(Order order) {
		Set<Order> orders=new HashSet<Order>();
		orders.add(order);
		return orders;
	}

	@Override
	public Set<Integer> getSetBasicSet(Order order) {
		Set<Integer> is=new HashSet<Integer>();
		is.add(1);
		is.add(2);
		is.add(3);
		is.add(4);
		is.add(5);
		return is;
	}

	@Override
	public Map<Integer, Order> getSetBasicMap(Order order) {
		Map<Integer, Order> maps=new HashMap<Integer, Order>();
		maps.put(1, order);
		return maps;
	}
}
