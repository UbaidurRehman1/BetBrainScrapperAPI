package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.Quries;

public abstract class PreparedStatementsForLocation implements Quries
{
	
	//location
	protected final PreparedStatement _q_location;
	protected final PreparedStatement _q_location_type;
	protected final PreparedStatement _q_location_relation;
	protected final PreparedStatement _q_location_relation_type;

	protected final Connection connection;
	
	
	public PreparedStatementsForLocation(Controller controller)
	{
		this.connection = controller.getDatabase().connection;
		
		_q_location = getLocationStatement();
		_q_location_type = getLocationTypeStatement();
		_q_location_relation = getLocationRelationStatement();
		_q_location_relation_type = getLocationRelationTypeStatement();

	}

	
	
	private PreparedStatement getLocationStatement()
	{
		try
		{
			return connection.prepareStatement(q_location);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getLocationTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getLocationRelationStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_relation);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getLocationRelationTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_relation_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

}
