package com.stark.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.stark.app.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stark.app.dao.UserMapper;
import com.stark.app.model.User;
import com.stark.app.service.IUserService;

/**
 * User Service
 * @author stark
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int saveVo(User vo) throws Exception {
		int result = -1;
		try {
			result = this.userMapper.insert(vo);
		} catch (Exception e) {
			throw new Exception("新增出错!");
		}
		return result;
	}

	@Override
	public int deleteVo(String id) throws Exception {
		int result = -1;
		try {
			result = this.userMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new Exception("删除出错!");
		}
		return result;
	}

	@Override
	public int modifyVo(User vo) throws Exception {
		int result = -1;
		try {
			result = this.userMapper.updateByPrimaryKey(vo);
		} catch (Exception e) {
			throw new Exception("修改出错!");
		}
		return result;
	}

	@Override
	public User findById(String id) throws Exception {
		User result = null;
		try {
			result = this.userMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new Exception("查询出错!");
		}
		return result;
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> result = new ArrayList<User>();
		try {
			UserExample userE = new UserExample();
			userE.createCriteria().andDescriptionIsNull();
			result = this.userMapper.selectByExample(userE);
		} catch (Exception e) {
			throw new Exception("查询出错!");
		}
		return result;
	}




}
