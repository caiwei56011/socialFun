package com.kmust.social.controller;

import com.kmust.social.common.excel.ExcelUtils;
import com.kmust.social.service.SocialFunService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * SocialFunController
 *
 * @author Cai Wei
 * @date 2017/1/9
 */
@Controller
public class SocialFunController {


    @Resource
    private SocialFunService socialFunService;

    /*
        跳转到上传excel页面.
     */
    @RequestMapping(value="socialFun/uploadExcel52")
    public ModelAndView uploadExcel52(){
        ModelAndView mv = new ModelAndView("socialFun/importExcel");
        return mv;
    }

    @RequestMapping(value="socialFun/uploadExcel105")
    public ModelAndView uploadExcel105(){
        ModelAndView mv = new ModelAndView("socialFun/importExcel");
        return mv;
    }

    @RequestMapping(value="socialFun/uploadExcel210")
    public ModelAndView uploadExcel210(){
        ModelAndView mv = new ModelAndView("socialFun/importExcel");
        return mv;
    }

    @RequestMapping(value="socialFun/uploadExcel416")
    public ModelAndView uploadExcel416(){
        ModelAndView mv = new ModelAndView("socialFun/importExcel");
        return mv;
    }

    @RequestMapping(value="socialFun/uploadExcel827")
    public ModelAndView uploadExcel827(){
        ModelAndView mv = new ModelAndView("socialFun/importExcel");
        return mv;
    }

    /**
     * 描述：通过传统方式form表单提交方式导入excel文件
     * @param request
     * @throws Exception
     */
    @RequestMapping(value="uploadExcel/formUpload",method={RequestMethod.GET,RequestMethod.POST})
    public  ModelAndView  uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过传统方式form表单提交方式导入excel文件！");

        ModelAndView mv = new ModelAndView("socialFun/evaluationInfo");
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        CommonsMultipartFile cf= (CommonsMultipartFile)file;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();

        File excelFile = fi.getStoreLocation();
        //List<List<Object>> excelLists = ExcelUtils.readExcel(excelFile);
        //mv.addObject("excelLists",excelLists);

        String originalFilename = file.getOriginalFilename();
        String[] splitFileName = originalFilename.split("\\.");
        String newFileNameLength = splitFileName[0];

        String evaluationInfo = socialFunService.onlineProductsEvaluation(excelFile,newFileNameLength);
        System.out.print(evaluationInfo);
        if(evaluationInfo == null || evaluationInfo.equals("".trim())){
            System.out.print("执行失败！");
        }else {
            System.out.print("执行成功！");
        }
        
        mv.addObject("evaluationInfo",evaluationInfo);

        return mv;
    }

    /**
     * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件
     * @param request
     * @param response
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/uploadExcel/ajaxUpload")
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");

        InputStream in =null;

        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }

        CommonsMultipartFile cf= (CommonsMultipartFile)file;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();

        File excelFile = fi.getStoreLocation();
        List<List<Object>> lists = ExcelUtils.readExcel(excelFile);

        in = file.getInputStream();

    }

}
