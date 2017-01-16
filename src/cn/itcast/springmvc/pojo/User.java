package cn.itcast.springmvc.pojo;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private Long id;
	private String name;
	private String password;
	private boolean gender;
	private Integer age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", age=" + age + ", birthday=" + birthday + "]";
	}
	
}
