package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.dao.YuanGongMapper;
import com.xiaoshu.dao.gongsiMapper;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;
import com.xiaoshu.entity.YuanGong;
import com.xiaoshu.entity.YuanGongExample;
import com.xiaoshu.entity.gongsi;

@Service
public class YuanGongService {

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

	public PageInfo<YuanGong> findUserPage(YuanGong y, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"id";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		UserExample example = new UserExample();
		example.setOrderByClause(ordername+" "+order);
		Criteria criteria = example.createCriteria();
		List<YuanGong> chaKan = ygm.chaKan(y);
		
		PageInfo<YuanGong> pageInfo = new PageInfo<YuanGong>(chaKan);
		return pageInfo;
	}
	@Autowired
	private YuanGongMapper ygm;
	@Autowired
	private gongsiMapper gsm;
	
	public List<gongsi> chaKanGongSi(){
		return gsm.selectAll();
	}

	public List<YuanGong> jiaYan(String pname) {
		YuanGongExample yy=new YuanGongExample();
		com.xiaoshu.entity.YuanGongExample.Criteria c = yy.createCriteria();
		c.andPNameEqualTo(pname);
		List<YuanGong> list = ygm.selectByExample(yy);
		
		return list;
	}

	public void tianJia(YuanGong g) {
		ygm.insert(g);
		
	}

	public void xiuGai(YuanGong g) {
		ygm.updateByPrimaryKey(g);
		
	}

	public void shanChu(int i) {
		ygm.deleteByPrimaryKey(i);
		
	}
	


}
