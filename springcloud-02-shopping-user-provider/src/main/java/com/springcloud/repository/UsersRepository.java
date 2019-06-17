package com.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * 
 * �־û��㣺�����USERS����в����ķ���
 * 
 * @author Administrator
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{

	/**
	 * 修改user表中指定user_id的用户身份证号
	 * 
	 * @param userId       用户编号
	 * @param userPsw      用户密码
	 * @param permissionId 身份证号
	 * @return 成功返回登录用户完整信息，失败返回null
	 */
	@Query("select new com.springcloud.entity.Users(u.userId,u.userName,u.userPsw,u.userSex,u.userIdnum,u.userTel,u.userBirthday,u.userEmail,u.userImage,u.permissionId,u.userAddr,u.userStatus) " + "from com.springcloud.entity.Users u where u.userId=:userId and u.userPsw=:userPsw and u.permissionId=:permissionId and u.userStatus=0")
	public abstract Users login(@Param("userId") Integer userId, @Param("userPsw") String userPsw,
			@Param("permissionId") Integer permissionId);
	
	/**
	 * 修改user表中指定user_id的用户状态״̬
	 * @param userId �û����
	 * @param userStatus �û�״̬
	 * @return 成功返回，失败返回null
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);
	
	@Modifying
	@Query("update Users u set u.userIdnum=:#{#users.userIdnum},u.userSex=:#{#users.userSex},u.userTel=:#{#users.userTel},u.userBirthday=:#{#users.userBirthday},"
			+"u.userEmail=:#{#users.userEmail},u.userAddr=:#{#users.userAddr} where u.userId=:#{#users.userId}")
	public abstract Integer update(@Param("users") Users users);
	
	@Modifying
	@Query("update Users u set u.userImage=:#{#users.userImage} where u.userId=:#{#users.userId}")
	public abstract Integer updateImage(@Param("users") Users users);
	

	@Modifying
	@Query("update Users u set u.userPsw=:#{#users.userPsw} where u.userId=:#{#users.userId}")
	public abstract Integer updatePassword(@Param("users") Users users);
	

	@Modifying
	@Query("update Users u set u.userName=:#{#users.userName} where u.userId=:#{#users.userId}")
	public abstract Integer updateName(@Param("users") Users users);
}
