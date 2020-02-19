package com.capgemini.onlineWallet.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.onlineWallet.daos.LoginDao;
import com.capgemini.onlineWallet.model.Login;
import com.capgemini.onlineWallet.util.DbUtil;


public class LoginDaoImpl implements LoginDao {
	Connection con=null;
	public LoginDaoImpl() {
		con=DbUtil.createConnection();
	}

	@Override
	public Login loginUser(int userId, String pass) {
		Login login=new Login();
		try {
			
			//System.out.println("Hi");
			String sql="select * from walletUser where userId=? "
					+ "and password=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setString(2, pass);
			ResultSet rs= pst.executeQuery();
			//System.out.println("1111111111");
			if(rs.next()) {
				//System.out.println("Hiii");
				login.setUserId(rs.getInt(1));
				login.setUserName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setPhoneNumber(rs.getString(4));
				login.setLoginName(rs.getString(5));
				//System.out.println(rs.getInt(1 ));
			}
			//System.out.println(login.getLoginName());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public int registerUser(Login login) {
		int uid = -1;
		try {
			Statement stat=con.createStatement();			
			ResultSet rs=stat.executeQuery("select userIdIncrement.NEXTVAL from dual");
			rs.next();
			 uid=(int)rs.getLong(1);
		   String sql="insert into walletUser values(?,?,?,?,?)";
		//System.out.println("Register");
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, uid);
		pst.setString(2, login.getUserName());
		pst.setString(3, login.getPassword());
		pst.setString(4, login.getPhoneNumber());
		pst.setString(5, login.getLoginName());
		pst.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return uid;
	}

	@Override
	public int changePassword(String oldPassword, String newPassword, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
