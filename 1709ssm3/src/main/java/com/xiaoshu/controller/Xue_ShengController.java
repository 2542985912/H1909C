package com.xiaoshu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.entity.Ban_Ji;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.XueShengBanJi;
import com.xiaoshu.entity.Xue_Sheng;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.RoleService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.service.Xue_ShengService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.WriterUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("xuesheng")
public class Xue_ShengController extends LogController{
	static Logger logger = Logger.getLogger(Xue_ShengController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private OperationService operationService;
	@Autowired
	private Xue_ShengService xss;
	@Autowired
	private JedisPool jp;
	int page=0;
	boolean panduan=true;
	@RequestMapping("xueshengIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		//List<Role> roleList = roleService.findRole(new Role());
		List<Ban_Ji> banji=xss.chaKanBanJi();
		//System.out.println(banji.get(0));
		//System.out.println(banji.get(1));
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		request.setAttribute("banjiList", banji);
		/*List<Ban_Ji> b = (List<Ban_Ji>)request.getAttribute("banjiList");
		System.out.println(b);*/
		//request.setAttribute("roleList", roleList);
		return "xuesheng";
	}
	
	
	@RequestMapping(value="userList",method=RequestMethod.POST)
	public void userList(HttpServletRequest request,Xue_Sheng x,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			Jedis jedis = jp.getResource();
			String string=null;
			string = jedis.get("list");
			if(string!=null&& page==pageNum&&panduan){
				System.out.println("redis查询");
				  WriterUtil.write(response,string);
				
			}else{

				String order = request.getParameter("order");
				String ordername = request.getParameter("ordername");
				
				
				
				PageInfo<Xue_Sheng> userList= xss.findUserPage(x,pageNum,pageSize,ordername,order);
			
				
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("total",userList.getTotal() );
				jsonObj.put("rows", userList.getList());
				String string2 = jsonObj.toString();
				jedis.set("list", string2);
				page=pageNum;
				System.out.println("mysql查询");
				panduan=true;
		        WriterUtil.write(response,jsonObj.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户展示错误",e);
			throw e;
		}
	}
	
	
	// 新增或修改
	@RequestMapping("reserveUser")
	public void reserveUser(HttpServletRequest request,Xue_Sheng xx,String[] hobby,MultipartFile tu,HttpServletResponse response){
		Integer bianhao = xx.getBianhao();
		
		JSONObject result=new JSONObject();
		try {
			if (bianhao != null) {   // userId不为空 说明是修改
			
				if(hobby!=null){
					String h="";
					for (int i = 0; i < hobby.length; i++) {
						h+=hobby[i]+" ";
						
					}
					xx.setAihao(h);
					
				}else{
					xx.setAihao("");
				}
				if(tu!=null){
					String a = tu.getOriginalFilename();
					String b=System.currentTimeMillis()+a.substring(a.lastIndexOf("."));
					
					File f=new File("E:/temp/"+b);
					tu.transferTo(f);
					xx.setZhaopian("/tupian/"+b);
				}
				xss.xiuGai(xx);
				panduan=false;
				result.put("success", true);
				
				
			}else {   // 添加
				if(xss.jiaoYan(xx.getXingming()).size()<1){  // 没有重复可以添加
					String h="";
					for (int i = 0; i < hobby.length; i++) {
						h+=hobby[i]+" ";
						
						
						
					}
					xx.setAihao(h);
					String a = tu.getOriginalFilename();
					String b=System.currentTimeMillis()+a.substring(a.lastIndexOf("."));
					
					File f=new File("E:/temp/"+b);
					tu.transferTo(f);
					xx.setZhaopian("/tupian/"+b);
					xss.tianJia(xx);
					panduan=false;
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
	
	
	@RequestMapping("deleteUser")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				xss.shanChu(Integer.parseInt(id));
			}
			panduan=false;
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
	//daochu
	@RequestMapping("daochu")
	public void delUser1(HttpServletRequest request,HttpServletResponse response){
		
		JSONObject result=new JSONObject();
		try {
		System.out.println("天地本就无情");
			List<Xue_Sheng> list=xss.chaKan();
			System.out.println(list.get(0));
			XSSFWorkbook w = new XSSFWorkbook();
			XSSFSheet sheet = w.createSheet("学生信息");
			XSSFRow row0 = sheet.createRow(0);
			String[] string = { "编号", "姓名", "性别", "爱好", "照片", "生日", "班级" };
			for (int i = 0; i < string.length; i++) {
				row0.createCell(i).setCellValue(string[i]);
			}
			for (int i = 0; i < list.size(); i++) {
				XSSFRow row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(list.get(i).getBianhao());
				row.createCell(1).setCellValue(list.get(i).getXingming());
				row.createCell(2).setCellValue(list.get(i).getXingbie());
				row.createCell(3).setCellValue(list.get(i).getAihao());
				row.createCell(4).setCellValue(list.get(i).getZhaopian());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				row.createCell(5).setCellValue(sdf.format(list.get(i).getShengri()));
				row.createCell(6).setCellValue(list.get(i).getBanjiid());

			}

			FileOutputStream f = new FileOutputStream("E:/temp/xlsx/学生表2.xlsx");
			w.write(f);
			
			
			
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	//daoru
		@RequestMapping("daoru")
		public void delUser2(HttpServletRequest request,MultipartFile tu,HttpServletResponse response){
			
			JSONObject result=new JSONObject();
			try {
				System.out.println("进来导入例如");
			InputStream i = tu.getInputStream();
			XSSFWorkbook w = new XSSFWorkbook(i);
			XSSFSheet sheet = w.getSheetAt(0);
			int num = sheet.getLastRowNum();
			for (int j = 1; j <= num; j++) {
				Xue_Sheng x = new Xue_Sheng();
				XSSFRow row = sheet.getRow(j);
				x.setBianhao(null);
				x.setXingming(row.getCell(1).getStringCellValue());
				x.setXingbie(row.getCell(2).getStringCellValue());
				x.setAihao(row.getCell(3).getStringCellValue());
				x.setZhaopian(row.getCell(4).getStringCellValue());
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				x.setShengri(s.parse(row.getCell(5).getStringCellValue()));
				if (1==((int)row.getCell(6).getNumericCellValue())) {
					x.setBanjiid(1);
				}
				if (2==(row.getCell(6).getNumericCellValue())) {
					x.setBanjiid(2);

				}

				xss.tianJia(x);

			}
				
				
				
				result.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("删除用户信息错误",e);
				result.put("errorMsg", "对不起，删除失败");
			}
			WriterUtil.write(response, result.toString());
		}
		//柱状
		@RequestMapping("zhuzhuang")
		public void zhuzhuang(HttpServletRequest request,HttpServletResponse response){
			
			JSONObject result=new JSONObject();
			try {
			
			List<XueShengBanJi> list = xss.chaKanXueShengBanJi();
			
			System.out.println(list);
			result.put("list", list);
			
			
				
				
				result.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("删除用户信息错误",e);
				result.put("errorMsg", "对不起，删除失败");
			}
			WriterUtil.write(response, result.toString());
		}
		
}
