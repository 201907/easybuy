package com.easybuy.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.bean.UserAddress;
import com.easybuy.dao.UserAddressDao;
import com.easybuy.dao.impl.UserAddressDaoImpl;
import com.easybuy.service.UserAddressService;
import com.easybuy.utils.DBManager;

public class UserAddressServiceImpl implements UserAddressService {
	private DBManager dbManager = DBManager.getInstance();
	private UserAddressDao userAddressDao = new UserAddressDaoImpl();
	/**
	 * 根据用户id查询该用户所有地址
	 * @param userId
	 * @return
	 */
	@Override
	public List<UserAddress> queryAddressByUserId(int userId) {
		List<UserAddress> userAddressList = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			userAddressList = userAddressDao.queryAddressByUserId(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userAddressList;
	}

	/**
	 * 获得用户默认地址
	 */
	@Override
	public UserAddress getUserDefaultAddress(int userId) {
		Connection conn = null;
		UserAddress userAddress = null;
		try {
			conn = dbManager.getConn();
			userAddress = userAddressDao.getUserDefaultAddress(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userAddress;
	}

	@Override
	public int getUserAddressCount(int userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			result = userAddressDao.getUserAddressCount(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public int addUserAddress(UserAddress userAddress) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			if(userAddressDao.getUserDefaultAddress(conn, userAddress.getUserId())==null) {
				userAddress.setIsDefault(1);
			}else {
				userAddress.setIsDefault(0);
			}
			result = userAddressDao.addUserAddress(conn, userAddress);
			conn.commit();
		} catch (SQLException e) {
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;	
	}

	@Override
	public List<UserAddress> getUserAddressByPage(int index, int count, int userId) {
		List<UserAddress> userAddressList = null;
		Connection conn = null;
		try {
			conn = dbManager.getConn();
			userAddressList = userAddressDao.getUserAddressByPage(conn, index, count, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userAddressList;
	}

	@Override
	public int setDefaultAddress(int userId,int id) {
		Connection conn = null;
		int result = 0;
		try {
			conn = dbManager.getConn();
			//找出用户当前默认地址
			UserAddress oldAddress = userAddressDao.getUserDefaultAddress(conn, userId);
			//取消默认地址
			userAddressDao.cancelUserDefaultAddress(conn, oldAddress.getId());
			//设置新的默认地址
			result = userAddressDao.setUserDefaultAddress(conn, id);
			//提交
			conn.commit();
		} catch (SQLException e) {
			if(conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


}
