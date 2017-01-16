package cn.itcast.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.springmvc.pojo.User;

@RequestMapping("/demo/excel")
@Controller
public class ExcelController {

	@RequestMapping("/export")
	public ModelAndView exportExcel(){
		ModelAndView mv = new ModelAndView();
		
		//1、设置视图名称
		mv.setViewName("excelView");
		
		//2、获取需要导出的数据
		List<User> userList = new ArrayList<User>();
		for(long i = 1; i < 11; i++){
			User user = new User();
			user.setId(i);
			user.setName("传智播客 " + i);
			user.setGender(i%2==0?true:false);
			user.setBirthday(new Date());
			user.setPassword("123456");
			user.setAge(10);
			userList.add(user);
		}
		mv.addObject("userList", userList);
		
		return mv;
	}
}
