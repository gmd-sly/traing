package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * 控制层：接收视图层的数据，并调用模型层相应的方法，将数据返回到视图层
 * 
 * @author sunliyan
 *
 */
@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/login")
	public ResultValue login(@RequestParam("userId") Integer userId,@RequestParam("userPsw") String userPsw,@RequestParam("permissionId") Integer permissionId) {
		ResultValue rv = new ResultValue();
		
		try {
			Users login = this.usersService.login(userId, userPsw, permissionId);
			if(login != null) {
				rv.setCode(0);
				
				Map<String,Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);
				
				return rv;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("登录信息不正确，请重新输入");
		return rv;
	}
	
	/**
	 *添加新用户信息
	 * 
	 * @param users  新用户信息
	 * @return
	 */
	@RequestMapping(value="/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			Users insert = this.usersService.insert(users);
			if(insert != null) {
				rv.setCode(0);
				rv.setMessage("录入用户成功");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("录入用户失败");
		return rv;
	}
	
	/**
	   *   满足条件的用户信息
	 *   
	 * @return
	 */
	@RequestMapping(value="select")
	public ResultValue select(Users users,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			//获得分页的数据
			List<Users> list = page.getContent();
			//判断是否查询到了数据
			if(list!=null && list.size()>0) {
				rv.setCode(0);
				
				Map<String,Object> map =new HashMap<>();
				//����ҳ��������ӵ�map��
				map.put("userList", list);
				
				PageUtils pageUtils = new PageUtils((int)page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				//����ҳ����Ϣ��ӵ�map��
				map.put("pageUtils", pageUtils);
				//��map��Ӵ�resultValue������
				rv.setDataMap(map);
				
				
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer status = this.usersService.updateStatus(userId, userStatus);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("�û�״̬�޸ĳɹ�");
				return rv;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�״̬�޸�ʧ�ܣ�����");
		return rv;
	}
	
	/**
	 *  ��ѯָ����ŵ��û���Ϣ
	 *  
	 * @param userId  �û���Ϣ
	 * @return
	 */
	@RequestMapping(value="/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service�еķ���������ò�ѯ�Ľ��
			Users byId = this.usersService.selectById(userId);
			//����ɹ�
			if(byId!=null) {
				//���ý����״̬Ϊ0
				rv.setCode(0);
				//����map���ϱ����ѯ���
				Map<String,Object> map =new HashMap<>();
				//����ѯ������浽map����
				map.put("userId", byId);
				//��map������ӵ�resultvalue������
				rv.setDataMap(map);
				//����resultvalue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("����û���Ϣʧ��");
		return rv;
	}
	
	@RequestMapping(value="/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service����Ӧ�ķ����޸��û���Ϣ��������޸ĳɹ�
			Integer update = this.usersService.update(users);
			//����޸ĳɹ�
			if(update > 0) {
				//���ý����״̬Ϊ0
				rv.setCode(0);
				//����ResultValue�Ķ���
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û���Ϣ�޸�ʧ��");
		return rv;
	}
	
	@RequestMapping(value = "/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service����Ӧ�ķ����޸��û���Ϣ��������޸ĳɹ�
			Integer message = this.usersService.updateMessage(users);
			
			if(message > 0) {
				rv.setCode(0);
				rv.setMessage("用户信息修改成功！！");
				//����ResultValue�Ķ���
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户信息修改失败！！");
		return rv;
	}
}
