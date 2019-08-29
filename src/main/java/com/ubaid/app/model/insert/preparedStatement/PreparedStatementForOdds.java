package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.QuiriesForOdds;

public abstract class PreparedStatementForOdds implements QuiriesForOdds
{
	protected Controller controller;
	protected final Connection connection;
	
	public PreparedStatement query_for_event_id_from_betting_id;
	public PreparedStatement query_for_event_type_id_from_event_id;
	public PreparedStatement query_for_betting_type_name_on_betting_id;
	public PreparedStatement query_for_thres_hold_on_betting_id;
	public PreparedStatement query_for_sport_name_on_event_id;
	
	public PreparedStatementForOdds(Controller controller)
	{
		this.controller = controller;
		connection = controller.getDatabase2().connection;
		query_for_event_id_from_betting_id = getEventIdOnBettingId();
		query_for_event_type_id_from_event_id = getEventTypeIdOnEventId();
		query_for_betting_type_name_on_betting_id = getBettingTypeNameonBettingOfferId();
		query_for_thres_hold_on_betting_id = getThresholdOnBettingOfferId();
		query_for_sport_name_on_event_id = getSportNameOnEventId();
	}
	
	private PreparedStatement getEventIdOnBettingId()
	{
		
		try
		{
			return connection.prepareStatement(q_event_id_on_betting_id);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
		return null;
	}
	
	private PreparedStatement getEventTypeIdOnEventId()
	{
		try
		{
			return connection.prepareStatement(q_event_type_on_event_id);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
		return null;
		
	}
	
	private PreparedStatement getBettingTypeNameonBettingOfferId()
	{
		try
		{
			return connection.prepareStatement(q_betting_type_name_on_betting_id);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
		return null;		
	}
	
	private PreparedStatement getThresholdOnBettingOfferId()
	{
		try
		{
			return connection.prepareStatement(q_thres_hold_on_betting_id);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
		return null;		
	}
	
	private PreparedStatement getSportNameOnEventId()
	{
		try
		{
			return connection.prepareStatement(q_sport_name_on_event_id);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
		return null;		
	}
}
