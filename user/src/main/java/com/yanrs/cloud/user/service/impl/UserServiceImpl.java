package com.yanrs.cloud.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yanrs.cloud.common.vo.req.UserRegisterReqVo;
import com.yanrs.cloud.user.bean.Userinfo;
import com.yanrs.cloud.user.bean.UserinfoExample;
import com.yanrs.cloud.user.bean.UserinfoExample.Criteria;
import com.yanrs.cloud.user.enums.UserExceptionEnum;
import com.yanrs.cloud.user.exception.UserException;
import com.yanrs.cloud.user.mapper.UserinfoMapper;
import com.yanrs.cloud.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserinfoMapper userinfoMapper;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public String register(UserRegisterReqVo userRegisterReqVo) {
		Userinfo userinfo = new Userinfo();
		// 数据拷贝到 Userinfo 中
		BeanUtils.copyProperties(userRegisterReqVo, userinfo);

		// 密码加密
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		userinfo.setPassword(bCryptPasswordEncoder.encode(userRegisterReqVo.getPassword()));

		// 数据插入
		int i = userinfoMapper.insertSelective(userinfo);
		if (i < 1) {
			throw new UserException(UserExceptionEnum.REGISTER_ERROR);
		}

		// 生成一个 accessToken
		String accessToken = UUID.randomUUID().toString().replace("-", "");

		try {
			// 将用户 id 写入 Redis 中
			stringRedisTemplate.opsForValue().set(accessToken, String.valueOf(i));
		} catch (Exception e) {
			throw new UserException(UserExceptionEnum.REGISTER_ERROR);
		}

		return accessToken;
	}

	@Override
	public Boolean checkUsername(String username) {
		UserinfoExample userinfoExample = new UserinfoExample();
		Criteria userinfoCriteria = userinfoExample.createCriteria();
		userinfoCriteria.andUsernameEqualTo(username);
		List<Userinfo> userList = userinfoMapper.selectByExample(userinfoExample);
		return userList != null && userList.size() > 0 ? true : false;
	}

	@Override
	public Boolean checkEmail(String email) {
		UserinfoExample userinfoExample = new UserinfoExample();
		Criteria userinfoCriteria = userinfoExample.createCriteria();
		userinfoCriteria.andEmailEqualTo(email);
		List<Userinfo> userList = userinfoMapper.selectByExample(userinfoExample);
		return userList != null && userList.size() > 0 ? true : false;
	}

	@Override
	public List<Userinfo> userLogin(String username, String password) {
		UserinfoExample userinfoExample = new UserinfoExample();
		Criteria userCriteria = userinfoExample.createCriteria();
		userCriteria.andUsernameEqualTo(username);
		userCriteria.andPasswordEqualTo(password);
		List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
		return userinfoList;
	}

}
