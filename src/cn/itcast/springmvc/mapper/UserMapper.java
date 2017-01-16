package cn.itcast.springmvc.mapper;

import org.apache.ibatis.annotations.Param;

import cn.itcast.springmvc.pojo.User;

public interface UserMapper {
	
	/**
	 * 根据用户id查询用户 
	 * @param id 用户id
	 * @return 用户
	 */
	public User queryUserById(@Param("id") Long id);

}
