package com.kmust.social.controller;

import com.kmust.social.common.excel.ExcelUtils;
import com.kmust.social.service.SocialFunService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    @RequestMapping(value="socialFun/uploadExcel")
    public ModelAndView uploadExcel(){
        ModelAndView mv = new ModelAndView("socialFun/importExcel");
        return mv;
    }

    /*
    schulzeFunction方法
     */
    @RequestMapping(value="socialFun/schulzeFunction")
    public ModelAndView schulzeFunction(){
        ModelAndView mv = new ModelAndView("socialFun/schulzeFunction");
        return mv;
    }


    /*
    traditionFunction方法
     */
    @RequestMapping(value="socialFun/traditionFunction")
    public ModelAndView traditionFunction(){
        ModelAndView mv = new ModelAndView("socialFun/traditionFunction");
        return mv;
    }



     /*
    validateInfo方法
     */
    @RequestMapping(value="socialFun/validateInfo")
    public ModelAndView validateInfo(){
        ModelAndView mv = new ModelAndView("socialFun/validateInfo");
        return mv;
    }

    /**
     * jfreecharts例子
     * @param request
     * @throws Exception
     */
    @RequestMapping(value="uploadExcel/jfreecharts",method={RequestMethod.GET,RequestMethod.POST})
    public  ModelAndView  jfreecharts(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView("socialFun/validateInfo");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100,"Spring　Security","Jan");
        dataset.addValue(200,"jBPM　4","Jan");
        dataset.addValue(300,"Ext　JS","Jan");
        dataset.addValue(400,"JFreeChart","Jan");

        JFreeChart chart = ChartFactory.createBarChart("chart","num","type",dataset,PlotOrientation.VERTICAL,true,false,
                false);
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("bar1.png");
            ChartUtilities.writeChartAsPNG(fos,chart,400,300);
        } finally {
            //fos.close();
        }
        String graphURL = "bar1.png";

        session.setAttribute("graphURL",graphURL);
        mv.addObject("graphURL",graphURL);
        return mv;
    }

    /**
     * 描述：导入excel文件
     * @param request
     * @throws Exception
     */
    @RequestMapping(value="uploadExcel/uploadExcelData",method={RequestMethod.GET,RequestMethod.POST})
    public  ModelAndView  uploadExcelData(HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("socialFun/resultList");

        System.out.println("通过传统方式form表单提交方式导入excel文件！");

        String playerNum = request.getParameter("playerNum");
        String refereeNum = request.getParameter("refereeNum");
        System.out.println(" 当前选手数量为 ： " + playerNum);
        System.out.println(" 当前裁判数量为 ： " + refereeNum);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        CommonsMultipartFile cf= (CommonsMultipartFile)file;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();

        File excelFile = fi.getStoreLocation();
        List<List<Object>> excelLists = ExcelUtils.readExcel(excelFile);

        //转换成偏好排序
        List<List<Object>> newExcelLists = preferenceOrder(excelLists);

        mv.addObject("excelLists",newExcelLists);

        /** 保存到session中*/
        HttpSession session = request.getSession();
        session.setAttribute("playerNum",playerNum);
        session.setAttribute("refereeNum", refereeNum);
        session.setAttribute("excelLists",newExcelLists);

        return mv;
    }

    private List<List<Object>> preferenceOrder(List<List<Object>> excelLists){
        Double temp; // 记录临时中间值
        //记录排序后的数据
        List<List<Object>> newExcelLists = new ArrayList<>();

        //每一行
        for(int i =0;i<excelLists.size();i++){
            //每一行排序
            List<Object> lists = excelLists.get(i);
            //原来的值对应的下标，保存到map
            HashMap map = new HashMap();
            for (int p = 0; p < lists.size(); p++) {
                map.put(lists.get(p), "player"+(p+1)); // 将值和下标存入Map
            }
            //记录新的排序后的每一行数据
            List<Object> newExcelRows = new ArrayList<>();
            Double [] array = new Double[lists.size()];

            //一行数据由list变数据
            for(int m =0;m<array.length;m++){
                array[m] = (Double) lists.get(m);
            }

            //排序
            for(int x=0;x<array.length-1;x++){
                for(int y=0;y<array.length - x -1;y++){
                    if(array[y] < array[y+1]){
                        System.out.println("x:"+x+"---y:"+y);
                        temp = array[y];
                        array[y] = array[y+1];
                        array[y+1] = temp;
                    }
                }
            }
            //取值
            for(int z=0;z<lists.size();z++){
                newExcelRows.add(z,map.get(array[z]));
            }
            //每一行拍好的数据，加到newExcelLists
            newExcelLists.add(newExcelRows);
        }

        return newExcelLists;
    }

}
