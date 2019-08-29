package com.example.stockspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Login;
import com.example.stockspring.model.UpdateUser;
import com.example.stockspring.model.User;
/*
@Repository
public class UserDaoImpl implements UserDao {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDao dao=new UserDaoImpl();
		User user=new User();
		user.setId(12352);
		user.setUsername("sati12392");
		user.setPassword("1234");
		user.setUsertype("admin");
		user.setEmail("satirtha.saha@cognizant.com");
		user.setMobilenumber(916348584);
		user.setConfirmed(1);
		//System.out.println(dao.insertuser(user));
		if(dao.registerUser(user))
		{
			System.out.println("Successfull insertion");
		}
		else
			System.out.println("Not inserted");
		/*
		 * Login login=new Login(); login.setUsername("sati");
		 * login.setPassword("1234"); if(dao.loginUser(login)==null)
		 * System.out.println("Incorrect password"); else
		 * System.out.println(dao.loginUser(login)); UpdateUser updateUser=new
		 * UpdateUser(); updateUser.setUsername("sati"); updateUser.setPassword("4321");
		 * updateUser.setEmail("sati@cognizant.com"); if(dao.updateUser(updateUser))
		 * System.out.println("Updation successful"); else
		 * System.out.println("Updation unsuccessful");
		 
		
	}

	public User loginUser(Login login) {
		// TODO Auto-generated method stub
		User user=new User();
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		System.out.println("=============================");
		PreparedStatement ps=conn.prepareStatement("select * from user where username=? and password=?");
		//ps.setInt(1, user.getuserexchange_id());
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		ResultSet rs=	ps.executeQuery();
		if(rs==null)
			user=null;
		else {
		while(rs.next())
		{
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setUsertype(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setMobilenumber(rs.getInt(6));
			user.setConfirmed(rs.getInt(7));
			
		}}
		}catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return user;
	}

	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		System.out.println(user);
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		System.out.println("=============================");
		PreparedStatement ps=conn.prepareStatement("insert into user(id,username, password, usertype, email, mobilenumber, confirmed) values(?,?,?,?,?,?,?)");
		
		ps.setInt(1, user.getId());
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getUsertype());
		ps.setString(5, user.getEmail());
		ps.setLong(6, user.getMobilenumber());
		ps.setInt(7, user.getConfirmed());
		
		int rs=	ps.executeUpdate();
		flag=true;
		}catch(SQLException sql)
		{
			flag=false;
		}
		System.out.println(flag);
		return flag;
	}

	public boolean updateUser(UpdateUser updateUser) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		System.out.println("=============================");
		PreparedStatement ps=conn.prepareStatement("update user set password=?, email=?, mobilenumber=? where username=?");
		//ps.setInt(1, user.getuserexchange_id());
		ps.setString(1, updateUser.getPassword());
		ps.setString(2, updateUser.getEmail());
		ps.setLong(3, updateUser.getMobilenumber());
		ps.setString(4, updateUser.getUsername());
		
		boolean rs=	ps.execute();
		flag=true;
		}catch(SQLException sql)
		{
			flag=false;
		}
		return flag;
	}


}*/
