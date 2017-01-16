package cn.itcast.springmvc.view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import cn.itcast.springmvc.pojo.User;

public class UserExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取数据
		List<User> userList = (List<User>) model.get("userList");

		// 工作表
		HSSFSheet sheet = workbook.createSheet("用户列表");
		
		// 设置Excel的头标题行
		HSSFRow row1 = sheet.createRow(0);
		String[] titles = { "用户名称", "年龄", "性别", "生日" };
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row1.createCell(i);
			cell.setCellValue(titles[i]);
		}

		// 获取数据列表并填写数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int j = 0; j < userList.size(); j++) {
			HSSFRow row = sheet.createRow(j + 1);
			row.createCell(0).setCellValue(userList.get(j).getName());
			row.createCell(1).setCellValue(userList.get(j).getAge());
			row.createCell(2).setCellValue(userList.get(j).isGender() ? "男" : "女");
			row.createCell(3).setCellValue(sdf.format(userList.get(j).getBirthday()));
		}

		// 设置响应中 下载文件的名称
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String("用户列表.xls".getBytes(), "ISO-8859-1"));

	}

}
