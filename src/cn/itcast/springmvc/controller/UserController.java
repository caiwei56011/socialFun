package cn.itcast.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.springmvc.pojo.User;

@RequestMapping("/rest/user")
@Controller
public class UserController {

	//根据用户id查询用户
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> queryUserById(@PathVariable("id")long id){
		User user = null;
		
		try {
			//int i = 1/0;
			if(id > 0){
				//根据id查询
				user = new User();
				user.setId(id);
				user.setName("传智播客 " + id);
				user.setAge(123);
			} else {
				//如果id不合法
				//返回状态为404，并没有任何数据输出
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//返回状态为500，并没有任何数据输出
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		//返回响应状态为200，并且输出数据user
		return ResponseEntity.ok(user);
	}
	
	//新增用户；不需要返回数据
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveUser(User user){
		//保存用户
		try {
			System.out.println("新增方法中的user = " + user);
			//返回数据已创建201
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//返回状态500
		//当返回的值为Void时，可以使用build()方法返回
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//更新用户；不需要返回数据
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(User user){
		//更新用户
		try {
			System.out.println("更新方法中的user = " + user);
			//返回204
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//返回状态500
		//当返回的值为Void时，可以使用build()方法返回
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//删除用户；不需要返回数据
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserByIds(@RequestParam("ids")String[] ids){
		//删除用户
		//1、如果要获取表单数据，需要添加过滤器
		//2、在提交的过程中需要添加_method参数，并且值为delete
		try {
			for(String id:ids){
				System.out.println("id = " + id);
			}
			
			//返回204
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//返回状态500
		//当返回的值为Void时，可以使用build()方法返回
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	
}
