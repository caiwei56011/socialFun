package cn.itcast.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.pojo.UserForm;

@RequestMapping("/demo")
@Controller
public class DemoController {
	
	@RequestMapping("/show1")
	public ModelAndView show1(){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show1");
		
		return mv;
	}
	
	@RequestMapping("/**/show2")
	public ModelAndView show2(){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show2");
		
		return mv;
	}

	
	@RequestMapping("/show3/{userId}")
	public ModelAndView show3(@PathVariable("userId")String userId){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show3,userId=" + userId);
		
		return mv;
	}
	
	@RequestMapping(value = "/show4", method = RequestMethod.POST)
	public ModelAndView show4(){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show4,只能使用post");
		
		return mv;
	}
	
	@RequestMapping(value = "/show5", params = {"userId","name"})
	public ModelAndView show5(@RequestParam("userId") Long userId){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show5,userId = " + userId);
		
		return mv;
	}
	
	@RequestMapping("/show6")
	public ModelAndView show6(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		ModelAndView mv = new ModelAndView("test");
		StringBuilder sb = new StringBuilder();
		sb.append("request = ").append(request)
		.append("response = ").append(response)
		.append("session = ").append(session);
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show6。" + sb.toString());
		
		return mv;
	}
	
	@RequestMapping("/show7/query/{userId}")
	public ModelAndView show7(@PathVariable("userId")Long userId){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show7,userId=" + userId);
		
		return mv;
	}
	
	@RequestMapping("/show8")
	public ModelAndView show8(@RequestParam(value = "userId", required = false, defaultValue = "-1")Long userId){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show8,userId=" + userId);
		
		return mv;
	}
	
	@RequestMapping("/show9")
	public ModelAndView show9(@CookieValue(value = "testCK", defaultValue = "-1")String ckv
			,@CookieValue("JSESSIONID")String sessionId, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("test");
		
		//写cookie
		Cookie cookie = new Cookie("testCK", "itcast");
		response.addCookie(cookie);
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show9,testCK=" + ckv + ", JSESSIONID = " + sessionId);
		
		return mv;
	}
	
	@RequestMapping("/show10")
	public ModelAndView show10(User user){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show10,user=" + user);
		
		return mv;
	}
	
	@RequestMapping("/show11")
	@ResponseStatus(value = HttpStatus.OK)//响应状态
	public void show11(@RequestParam("name")String name,@RequestParam("age")Integer age
			,@RequestParam("gender")Boolean gender,@RequestParam("interests")String[] interests){
		
		System.out.println(" name = " + name);
		System.out.println(" age = " + age);
		System.out.println(" gender = " + gender);
		System.out.println(" 兴趣有： ");
		
		for(String its : interests){
			System.out.println(its);
		}
		
	}

	@RequestMapping("/show12")
	public ModelAndView show12(UserForm userForm){
		ModelAndView mv = new ModelAndView("test");
		
		StringBuilder sb = new StringBuilder();
		for( User user : userForm.getUsers()){
			sb.append(user).append("</br>");
		}
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show12,users=" + sb.toString());
		
		return mv;
	}
	
/*	@RequestMapping("/show13")
	public ModelAndView show13(){
		//forward: 表示转发到具体视图
		ModelAndView mv = new ModelAndView("forward:/hello.jsp");
		//携带数据
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show13,自定义转发到此页面");
		
		return mv;
	}
*/	
	@RequestMapping("/show13")
	public String show13(){
		return "forward:/hello.jsp";
	}
	
	//重定向 带参数
/*	@RequestMapping("/show14")
	public ModelAndView show14(){
		//redirect: 表示重定向
		ModelAndView mv = new ModelAndView("redirect:testRedirect.mvc");
		try {
			//携带数据
			mv.addObject("requestType", URLEncoder.encode("这是我的第一个注解spring mvc应用。方法名为：show14,自定义重定向到此页面", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
*/	
	//重定向 不带参数
	@RequestMapping("/show14")
	public String show14(){
		//redirect: 表示重定向
		return "redirect:testRedirect.mvc";
	}
	
	@RequestMapping("/testRedirect")
	public ModelAndView testRedirect(@RequestParam(value = "requestType", required = false) String requestType){
		//redirect: 表示重定向
		ModelAndView mv = new ModelAndView("test");
		
		try {
			if(requestType != null){
				requestType = URLDecoder.decode(requestType, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//携带数据
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：testRedirect,自定义重定向到此页面. requestType = " + requestType);

		return mv;
	}
	
	@RequestMapping("/show15")
	public ModelAndView show15(@RequestBody User user){
		ModelAndView mv = new ModelAndView("test");
		
		mv.addObject("msg", "这是我的第一个注解spring mvc应用。方法名为：show15,user=" + user);
		
		return mv;
	}
	
	@RequestMapping("/show16")
	@ResponseBody//输出响应内容
	public List<User> show16(){
		List<User> userList = new ArrayList<User>();
		for(long i = 1; i < 11; i++){
			User user = new User();
			user.setId(i);
			user.setName("传智播客 " + i);
			user.setGender(i%2==0?true:false);
			user.setBirthday(new Date());
			user.setPassword("123456");
			
			userList.add(user);
		}
		return userList;
	}

	
}
