package com.ubaid.app.model.database;

import java.sql.Connection;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.ubaid.app.controller.Controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//I am going to make an inheritance 
//this class is super class
//this class connect to Database
//this class has
//a static method 
//getconnection and this method is assigned to a variavle connection
//basic purpose of this method to established a connection
public class Database2
{
	static String DATABASE_URL = "jdbc:mysql://localhost:3306/sport_db_consize?rewriteBatchedStatements=true&useSSL=false";
	
	public  Statement statement;
	public  ResultSet resultSet;
	protected ResultSetMetaData metaData;
	static int counter = 0;
	public Connection connection;
	
	
	protected Controller controller;
	
	public Database2(Controller controller)
	{
		this.controller = controller;
		connection = getConnection();
		
		try
		{
			connection.setAutoCommit(false);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	
	//the following method is static method for all 
	//which return connection 
	public Connection getConnection()
	{
		
		if(counter++ == 1)
		{
			try
			{
				throw new Exception();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		MysqlDataSource dataSource = new MysqlDataSource();

		try
		{
			dataSource.setAllowPublicKeyRetrieval(true);
			dataSource.setUseSSL( false );
		    dataSource.setServerTimezone("GMT");
		    dataSource.setServerName("localhost");
		    dataSource.setDatabaseName("sport_db_consize");
		    dataSource.setPortNumber(3306);
		    dataSource.setUser("root");
		    dataSource.setPassword("password");
		    dataSource.setRewriteBatchedStatements(true);
		    Connection connection = dataSource.getConnection();
		    controller.getQueue().setIndex("Database Connected");
		    return connection;			
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
		return null;
	}
		
}
