package cn.itcast.springmvc.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/demo")
@Controller
public class UploadController {
	
	@Autowired
	private ServletContext servletContext;
	
	//获取属性配置文件中对应的属性值
	//@Value("${UPLOAD_PATH}")
	private String UPLOAD_PATH;

	@RequestMapping("/upload")
	public String upload(@RequestParam("file")MultipartFile multipartFile){
		
		try {
			//2.1、获取文件保存路径（upload）
			//String filePath = servletContext.getRealPath("/upload");
			
			//2.2、保存文件到具体路径下
			multipartFile.transferTo(new File(UPLOAD_PATH, multipartFile.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//重定向到页面
		return "redirect:/success.jsp";
	}
	
	@RequestMapping("/upload2")
	public String upload2(@RequestParam("files")MultipartFile[] multipartFiles){
		//处理多个上传文件
		try {
			//2.1、获取文件保存路径（upload）
			//String filePath = servletContext.getRealPath("/upload");
			
			//2.2、保存文件到具体路径下
			if(multipartFiles != null){
				for(MultipartFile multipartFile : multipartFiles){
					multipartFile.transferTo(new File(UPLOAD_PATH, multipartFile.getOriginalFilename()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//重定向到页面
		return "redirect:/success.jsp";
	}
}
