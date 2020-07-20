package com.xiaoshu.controller;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.entity.Clazz;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.User;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.StuService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.WriterUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("stu")
public class StuController extends LogController{
	static Logger logger = Logger.getLogger(StuController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private StuService ss;
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	private JedisPool jedisPool;
	
	//导入
	@RequestMapping("inStu")
	public void inStu(MultipartFile file,HttpServletRequest request,Student stu,HttpServletResponse response, Object FileInputStream) throws Exception{
		JSONObject result=new JSONObject();
		InputStream is = file.getInputStream();
		try {
			//1.创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(is);
			//2.读取sheet页
			HSSFSheet sheet = workbook.getSheetAt(0);
			//3.获取行
			int lastRowNum = sheet.getLastRowNum();
		
			for (int i = 1; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);
				Student student = new Student();
				student.setSname(row.getCell(1).getStringCellValue());
				student.setSex(row.getCell(2).getStringCellValue());
				String bir = row.getCell(3).getStringCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				student.setBirthday(simpleDateFormat.parse(bir));
				student.setHobby(row.getCell(4).getStringCellValue());
				if("H1909A".equals(row.getCell(5).getStringCellValue())){
					student.setCid(1);
				}else if("H1909B".equals(row.getCell(5).getStringCellValue())){
					student.setCid(2);
				}else{
					student.setCid(3);
				}
				ss.addStu(student);
				
			}
				result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存用户信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	@RequestMapping("stuIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Clazz> cList = ss.findClazz();
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		request.setAttribute("cList", cList);
		return "stu";
	}
	
	
	@RequestMapping(value="stuList",method=RequestMethod.POST)
	public void stuList(Student stu,HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			/*String sList=null;
			//建立jedis连接
			Jedis jedis = jedisPool.getResource();
			sList=jedis.get("sList");
			if (sList!=null) {
				WriterUtil.write(response,sList);
			}else {*/
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<Student> stuList= ss.findStuPage(stu,pageNum,pageSize,ordername,order);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",stuList.getTotal() );
			jsonObj.put("rows", stuList.getList());
			/*String sList1 = jsonObj.toString();
			jedis.set("sList", sList1);*/
	        WriterUtil.write(response,jsonObj.toString());
			/*}*/
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户展示错误",e);
			throw e;
		}
	}
	
	
	// 新增或修改
	@RequestMapping("reserveStu")
	public void reserveUser(MultipartFile file,HttpServletRequest request,Student stu,HttpServletResponse response){
		Integer sId = stu.getSid();
		JSONObject result=new JSONObject();
		String filename = file.getOriginalFilename();
		try {
				if (sId != null) {   // userId不为空 说明是修改
					if( ss.findByName(stu.getSname())==null){
						if (filename!=null) {
						String newfilename=UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
						file.transferTo(new File("/pic/"+newfilename));
						stu.setImg("d:/pic/"+newfilename);
						stu.setSid(sId);
						}
						ss.updateStu(stu);
						result.put("success", true);
					}else{
						result.put("success", true);
						result.put("errorMsg", "该用户名被使用");
					}					
				}else {   // 添加
					if(ss.findByName(stu.getSname())==null){  // 没有重复可以添加
						if (filename!=null) {
						String newfilename=UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
						file.transferTo(new File("d:/pic/"+newfilename));
						stu.setImg("d:/pic/"+newfilename);
						}
						ss.addStu(stu);
						result.put("success", true);
					} else {
						result.put("success", true);
						result.put("errorMsg", "该用户名被使用");
					}
				}
			if (sId != null) {   // userId不为空 说明是修改
				if( ss.findByName(stu.getSname())==null){
					stu.setSid(sId);
					ss.updateStu(stu);
					result.put("success", true);
				}else{
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
				
			}else {   // 添加
				if(ss.findByName(stu.getSname())==null){  // 没有重复可以添加
					ss.addStu(stu);
					result.put("success", true);
				} else {
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存用户信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	
	@RequestMapping("deleteStu")
	public void deleteStu(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				ss.deleteStu(Integer.parseInt(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	@RequestMapping("editPassword")
	public void editPassword(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if(currentUser.getPassword().equals(oldpassword)){
			User user = new User();
			user.setUserid(currentUser.getUserid());
			user.setPassword(newpassword);
			try {
				userService.updateUser(user);
				currentUser.setPassword(newpassword);
				session.removeAttribute("currentUser"); 
				session.setAttribute("currentUser", currentUser);
				result.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("修改密码错误",e);
				result.put("errorMsg", "对不起，修改密码失败");
			}
		}else{
			logger.error(currentUser.getUsername()+"修改密码时原密码输入错误！");
			result.put("errorMsg", "对不起，原密码输入错误！");
		}
		WriterUtil.write(response, result.toString());
	}
}
