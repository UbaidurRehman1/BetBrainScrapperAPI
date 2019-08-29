package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.Quries;


public abstract class PreparedStatementsForEvents implements Quries
{
	
	protected final Connection connection;
	//event
	protected final PreparedStatement _q_event;
	protected final PreparedStatement _q_event_part;
	protected final PreparedStatement _q_event_template;
	protected final PreparedStatement _q_event_type_usage;
	protected final PreparedStatement _q_event_part_default_usage;
	protected final PreparedStatement _q_event_type;
	protected final PreparedStatement _q_event_status;
	protected final PreparedStatement _q_provider_event_relation;
	
	//two new
	protected final PreparedStatement _q_event_participant_relation;
	protected final PreparedStatement _q_event_participant_restriction;
	
	//sport
	protected final PreparedStatement _q_sport;
	
	//provider
	protected final PreparedStatement _q_provider;

	
	
	public PreparedStatementsForEvents(Controller controller)
	{
		this.connection = controller.getDatabase().connection;
		
		 _q_event = getEventStatement();
		 _q_event_part = getEventPartStatement();
		 _q_event_template = getEventTemplateStatement();
		 _q_event_type_usage = getEventTypeUsageStatement();
		 _q_event_part_default_usage = getEventPartDefaultUsageStatement();
		 _q_event_type = getEventTypeStatement();
		 _q_event_status = getEventStatusStatement();
		 _q_provider_event_relation = getProviderEventRelationStatement();
		
		 //two new
		 _q_event_participant_relation = getEventParticipationRelationStatement();
		 _q_event_participant_restriction = getEventParticipantRestrictionStatement();
		 
		//sport
		 _q_sport = getSportStatement();
		
		//provider
		 _q_provider = getProviderStatement();

	}
	
	
	
	
	private PreparedStatement getEventStatement()
	{
		try
		{
			return connection.prepareStatement(q_event);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getEventPartStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_part);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getEventTemplateStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_template);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventTypeUsageStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_type_usage);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventPartDefaultUsageStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_part_default_usage);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventStatusStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_status);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getProviderEventRelationStatement()
	{
		try
		{
			return connection.prepareStatement(q_provider_event_relation);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	//change
	private PreparedStatement getEventParticipationRelationStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_participant_relation);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	//chnage
	private PreparedStatement getEventParticipantRestrictionStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_participant_restriction);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	

	private PreparedStatement getSportStatement()
	{
		try
		{
			return connection.prepareStatement(q_sport);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getProviderStatement()
	{
		try
		{
			return connection.prepareStatement(q_provider);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


/**
*/	

}
