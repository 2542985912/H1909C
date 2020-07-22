package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.Ban_JiMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.dao.Xue_ShengMapper;
import com.xiaoshu.entity.Ban_Ji;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;
import com.xiaoshu.entity.XueShengBanJi;
import com.xiaoshu.entity.Xue_Sheng;
import com.xiaoshu.entity.Xue_ShengExample;

@Service
public class Xue_ShengService {

	@Autowired
	UserMapper userMapper;

	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addUser(User t) throws Exception {
		userMapper.insert(t);
	};

	// 修改
	public void updateUser(User t) throws Exception {
		userMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	};

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public User existUserWithUserName(String userName) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}

	public PageInfo<Xue_Sheng> findUserPage(Xue_Sheng x, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"bianhao";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		UserExample example = new UserExample();
		example.setOrderByClause(ordername+" "+order);
		Criteria criteria = example.createCriteria();
		
		List<Xue_Sheng> userList = xsm.chaKan(x);
		PageInfo<Xue_Sheng> pageInfo = new PageInfo<Xue_Sheng>(userList);
		List<Xue_Sheng> userLists = xsm.chaKan();
		return pageInfo;
	}
	@Autowired
	private Ban_JiMapper bjm;
	@Autowired
	private Xue_ShengMapper xsm;

	public List<Ban_Ji> chaKanBanJi() {
		List<Ban_Ji> list = bjm.selectAll();
		return list;
	}

	public List<Xue_Sheng> jiaoYan(String xingming) {
		Xue_ShengExample x=new Xue_ShengExample();
		com.xiaoshu.entity.Xue_ShengExample.Criteria criteria = x.createCriteria();
		criteria.andXingMingEqualTo(xingming);
		List<Xue_Sheng> list = xsm.selectByExample(x);
		return list;
	}

	public void tianJia(Xue_Sheng xx) {
		xsm.insert(xx);
		
	}

	public void xiuGai(Xue_Sheng xx) {
		xsm.updateByPrimaryKey(xx);
		
	}

	public void shanChu(int parseInt) {
		xsm.deleteByPrimaryKey(parseInt);
		
	}

	public List<Xue_Sheng> chaKan() {
		List<Xue_Sheng> list = xsm.selectAll();
		return list;
	}


	public List<XueShengBanJi> chaKanXueShengBanJi(){
		System.out.println(xsm.chaKanXueShengBanJi()+"haha");
		return xsm.chaKanXueShengBanJi();
	}
}
