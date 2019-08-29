package com.ubaid.app.model.insert.oddshistory;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementForOdds;


public class InsertIntoOddsHistory extends PreparedStatementForOdds
{
	
	
	public InsertIntoOddsHistory(Controller controller)
	{
		super(controller);
	}
	
	
	public long getEventIDOnBettingTypeID(long id)
	{
		
		long id_ = -1;
		
		try
		{
			query_for_event_id_from_betting_id.setLong(1, id);
			
			ResultSet resultSet = query_for_event_id_from_betting_id.executeQuery();
			
			
			while(resultSet.next())
			{
				id_ = resultSet.getLong(1);
			}
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		
		return id_;
	}
	
	
	public long getEventTypeIDOnEventID(long id)
	{
		
		long id_ = -1;
		
		try
		{
			query_for_event_type_id_from_event_id.setLong(1, id);
			
			ResultSet resultSet = query_for_event_type_id_from_event_id.executeQuery();
			
			
			while(resultSet.next())
			{
				id_ = resultSet.getLong(1);
			}
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		
		return id_;
	}
	
	public String getBettingTypeNameOnBettingOfferID(long id)
	{
		String name = "";
		
		try
		{
			query_for_betting_type_name_on_betting_id.setLong(1, id);
			
			ResultSet resultSet = query_for_betting_type_name_on_betting_id.executeQuery();
			
			
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		
		return name;
		
	}
	
	public float getThresHoldOnBettingOfferID(long id)
	{
		
		float thres_hold = 0;
		
		try
		{
			query_for_thres_hold_on_betting_id.setLong(1, id);
			
			ResultSet resultSet = query_for_thres_hold_on_betting_id.executeQuery();
			
			
			while(resultSet.next())
			{
				thres_hold = resultSet.getFloat(1);
			}
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		
		return thres_hold;
	}

	public String getSportNameOnEventID(long id)
	{
		
		String name = "";
		
		try
		{
			query_for_sport_name_on_event_id.setLong(1, id);
			
			ResultSet resultSet = query_for_sport_name_on_event_id.executeQuery();
			
			
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		
		return name;
	}

}
