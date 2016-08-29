package com.soni.app.batch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.soni.app.batch.model.TradLifePolicy;

public class MyListDao {
	Connection con;
	PreparedStatement ps;
	int i;
	public int insertData(TradLifePolicy tradLife){
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","soni","root123");
			String sql="insert into  Policy values('"+tradLife.getFirstName()+"','"+tradLife.getLastName()+"','"+tradLife.getPolicyNumber()+"','"+tradLife.getProductType()+"','"+tradLife.getProductName()+"','"+tradLife.getPolicyName()+"',sysdate,'"+tradLife.getPolicySatus()+"' , '"+tradLife.getEmail()+"' ,'"+tradLife.getAddress()+"', '"+ tradLife.getPhone()+"', '"+tradLife.getNation()+"', '"+tradLife.getState()+"', '"+tradLife.getPincode()+"', '"+tradLife.getBank()+"', '"+tradLife.getPaymentMode() +"', '"+ tradLife.getAmount()+"', '"+tradLife.getType()+"', '"+tradLife.getIssue() +"', '"+ tradLife.getPartyType() +"', '"+tradLife.getPartyName()+"', '"+tradLife.getPartyStatus() +"', '"+tradLife.getPartyNumber()+"', '"+tradLife.getPartyStatus()+"', '"+tradLife.getPartyNumber()+"', '"+tradLife.getDesig()+"', '"+tradLife.getIncome()+"', '"+tradLife.getSource()+"')";
			
			ps=con.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i==1){
				System.out.println("data writes successfull");
				return 1;
			}
			
		}
		catch(Exception e){
			System.out.println("insert data exception occured"+e);
			e.printStackTrace();
		}
		return 0;
	}

}
