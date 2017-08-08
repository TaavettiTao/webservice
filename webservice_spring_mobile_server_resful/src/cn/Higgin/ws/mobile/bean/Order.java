package cn.Higgin.ws.mobile.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Administrator
 * 如果返回值为Order、List<Order>类型，且数据格式是xml,
 * 则必须添加下面的注解。
 */
@XmlRootElement(name="order")
public class Order {
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + "]";
	}
}
