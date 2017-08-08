package cn.Higgin.ws.mobile.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cn.Higgin.ws.mobile.bean.Order;

/**
 * 
 * @author Administrator
 * @Produces:响应支持多个 MIME 类型。在本例和上一个示例中，APPLICATION/XML 将是默认的 MIME 类型。</br>
 * 
 * <p>cxf restful 返回值支持数据类型:</p></br>
 * <p>(一)、基本类型：（@Produces需设置为：MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON）</p></br>
 *         </p>–int,float,boolean等</p></br>
 * <p>(二)、应用类型：String、自定义类型:Order、集合类型：数组,List, Set, Map</p></br>
 *
 */
@Path("/mo")
public interface MobileService {
	
	/**
	 * 返回基本类型数据：int
	 * 
	 * @param id
	 * @return
	 */
	@POST
	@Path("/queryOrder3/{id}")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public int queryOrder3(@PathParam("id") Integer id);

	@GET
	@Path("/queryMobile/{phone}")
	@Produces({ MediaType.APPLICATION_JSON })
	public String queryMobile(@PathParam("phone") String phone);

	@GET
	@Path("/queryOrder/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	// http://localhost:8080/webservice_spring_mobile_server_resful/ws/mobile2/mo/queryOrder/13167173501
	public Order queryOrder(@PathParam("id") String id);

	@GET
	@Path("/queryOrderList")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Order> queryOrderList();

	@GET
	@Path("/queryMobile1")
	@Produces({ MediaType.APPLICATION_JSON })
	// http://localhost:8080/webservice_spring_mobile_server_resful/ws/mobile2/mo/queryMobile1?phone=13167173501
	public String queryMobile1(@QueryParam("phone") String phone);

	@POST
	@Path("/queryOrder1/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order queryOrder1(@PathParam("id") int id);

	@POST
	@Path("/queryOrder2/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order queryOrder2(@PathParam("id") Integer id);

	/**
	 * 集合类型：数组 基本类型
	 * 
	 * @param id
	 * @return
	 */
	@POST
	@Path("/getArray/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public int[] getArray(@PathParam("id") Integer id);

	/**
	 * 集合类型：数组 对象类型
	 * 
	 * @param id
	 * @return
	 */
	@POST
	@Path("/getArrayObj/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order[] getArrayObject(@PathParam("id") Integer id);

	/**
	 * 集合类型：List
	 * 
	 * @param order
	 * @return
	 */
	@POST
	@Path("/queryOrders")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> queryOrders(Order order);
	
	
	@POST
	@Path("/getSetObj")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set<Order> getSetObjSet(Order order);
	
	@POST
	@Path("/getSetBasic")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Set<Integer> getSetBasicSet(Order order);
	
	@POST
	@Path("/getMapBasic")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Map<Integer,Order> getSetBasicMap(Order order);
	

}
