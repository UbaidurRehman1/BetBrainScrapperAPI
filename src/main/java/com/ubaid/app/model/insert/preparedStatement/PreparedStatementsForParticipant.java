package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.QuriesForParticipant;

//change
public abstract class PreparedStatementsForParticipant implements QuriesForParticipant
{
	
	protected final Connection connection;
	protected final PreparedStatement _q_participant;
	protected final PreparedStatement _q_participant_usage;
	protected final PreparedStatement _q_participant_role;
	protected final PreparedStatement _q_participant_type_role_usage;
	protected final PreparedStatement _q_participant_type;
	protected final PreparedStatement _q_participant_relation;
	protected final PreparedStatement _q_participant_relation_type;
	
		
	public PreparedStatementsForParticipant(Controller controller)
	{
		this.connection = controller.getDatabase().connection;

		_q_participant = getParticipantStatement();
		_q_participant_usage = getParticipantUsageStatement();
		_q_participant_role = getParticipantRoleStatement();
		_q_participant_type_role_usage = getParticipantTypeRoleUsageStatement();
		_q_participant_type = getParticipantTypeStatement();
		_q_participant_relation = getParticipantRelationStatement();
		_q_participant_relation_type = getParticipantRelationTypeStatement();
		
	}

	
	
	
	private PreparedStatement getParticipantStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantUsageStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_usage);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRoleStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_role);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantTypeRoleUsageStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_type_role_usage);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRelationStatement()
	{
		try
		{
			return connection.prepareStatement(q_participation_relation);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRelationTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_relation_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

}
