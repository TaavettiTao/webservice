package cn.Higgin.ws.mobile.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.Higgin.ws.mobile.service.MobileService;

@Controller
public class MobileAction {
	@Autowired
	private MobileService mobileService;

	
	@RequestMapping("/queryMobile")
	public String queryMobile(Model model, String phone) throws Exception {
		// 调用service查询手机号
		String result = null;
		if (phone != null && !phone.trim().equals("")) {
			result = mobileService.queryMobile(phone);
		}
		model.addAttribute("result", result);

		// 返回逻辑视图名
		return "queryMobile";
	}
}
