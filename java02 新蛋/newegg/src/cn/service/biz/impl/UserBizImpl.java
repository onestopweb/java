package cn.service.biz.impl;

import java.util.ArrayList;
import java.util.List;

import cn.service.biz.UserBiz;
import cn.service.dao.NeUserDao;
import cn.service.dao.UserLevelDao;
import cn.service.dao.impl.NeUserDaoImpl;
import cn.service.dao.impl.UserLevelDaoImpl;
import cn.entity.NeUser;
import cn.entity.User;
import cn.entity.UserLevel;

/*
 * 用户联表 业务逻辑层 实现
 * */
public class UserBizImpl implements UserBiz {

	//用户列表分页联表(用户表和用户级别表)
	public List<User> userList(int pageIndex, 
			int pageSize, int levelId,String userId ) {

		//获取用户表数据
		NeUserDao neUserDao = new NeUserDaoImpl();
		List<NeUser> neUserDaoList = neUserDao.getNeUserByPage(pageIndex, pageSize, levelId, userId);

		//获取用户级别表数据
		UserLevelDao userLevelDao = new UserLevelDaoImpl();
		List<UserLevel> userLevelDaoList = userLevelDao.userLevelList();

		List<User> list =new ArrayList<User>();
		User item = null;
		for(int i=0; i<neUserDaoList.size(); i++){
			String user_id = neUserDaoList.get(i).getNe_user_id();
			String password = neUserDaoList.get(i).getNe_password();
			String username = neUserDaoList.get(i).getNe_username();
			String tel = neUserDaoList.get(i).getNe_tel();
			String phone = neUserDaoList.get(i).getNe_phone();
			String email = neUserDaoList.get(i).getNe_email();
			String postalcode = neUserDaoList.get(i).getNe_postalcode();
			String save = neUserDaoList.get(i).getNe_save();
			String city = neUserDaoList.get(i).getNe_city();
			String borough = neUserDaoList.get(i).getNe_borough();
			String address = neUserDaoList.get(i).getNe_address();
			int level_id = neUserDaoList.get(i).getNe_level_id();
			String leve_content = null;
			for(int j=0; j<userLevelDaoList.size(); j++){
				if(neUserDaoList.get(i).getNe_level_id()==userLevelDaoList.get(j).getUser_leve_id()){
					leve_content = userLevelDaoList.get(j).getUser_leve_content();
					break;
				}
			}
			item = new User(
					user_id, 
					password, 
					username, 
					tel, 
					phone, 
					email, 
					postalcode, 
					save, 
					city, 
					borough, 
					address, 
					level_id, 
					leve_content);
			list.add(item);
		}

		return list;
	}

	//查找用用户数据联表(用户表和用户级别表)
	public User select(String userId){

		//查找用用户数据
		NeUserDao neUserDao = new NeUserDaoImpl();
		NeUser neUseritem = neUserDao.select(userId);

		//获取用户级别表数据
		UserLevelDao userLevelDao = new UserLevelDaoImpl();
		List<UserLevel> userLevelDaoList = userLevelDao.userLevelList();

		User item = null;
		String user_id = neUseritem.getNe_user_id();
		String password =  neUseritem.getNe_password();
		String username =  neUseritem.getNe_username();
		String tel =  neUseritem.getNe_tel();
		String phone =  neUseritem.getNe_phone();
		String email =  neUseritem.getNe_email();
		String postalcode =  neUseritem.getNe_postalcode();
		String save =  neUseritem.getNe_save();
		String city =  neUseritem.getNe_city();
		String borough =  neUseritem.getNe_borough();
		String address =  neUseritem.getNe_address();
		int level_id =  neUseritem.getNe_level_id();
		String leve_content = null;
		for(int i=0; i<userLevelDaoList.size(); i++){
			if(neUseritem.getNe_level_id()==userLevelDaoList.get(i).getUser_leve_id()){
				leve_content = userLevelDaoList.get(i).getUser_leve_content();
				break;
			}
		}
		item = new User(
				user_id, 
				password, 
				username, 
				tel, 
				phone, 
				email, 
				postalcode, 
				save, 
				city, 
				borough, 
				address, 
				level_id, 
				leve_content);

		return item;
	}
}
