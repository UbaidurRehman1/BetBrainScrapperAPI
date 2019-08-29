package com.ubaid.app.model.insert.preparedStatement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.Quries;

public abstract class PreparedStatementsForBetting implements Quries
{
	protected final Connection connection;
	protected final PreparedStatement _q_betting_offer;
	protected final PreparedStatement _q_betting_offer_status;
	protected final PreparedStatement _q_betting_type;
	protected final PreparedStatement _q_betting_type_usage;
	protected final PreparedStatement _q_outcome;
	protected final PreparedStatement _q_outcome_status;
	protected final PreparedStatement _q_outcome_type;
	protected final PreparedStatement _q_outcome_type_usage;
	protected final PreparedStatement _q_outcome_type_betting_type_relation;
	protected final PreparedStatement _q_source;
	
	
	
	public PreparedStatementsForBetting(Controller controller)
	{
		this.connection = controller.getDatabase().connection;

		 _q_betting_offer = getBettingOfferStatement();
		 _q_betting_offer_status = getBettingOfferStatusStatement();
		 _q_betting_type = getBettingTypeStatement();
		 _q_betting_type_usage = getBettingTypeUsageStatement();
		 _q_outcome = getOutcomeStatement();
		 _q_outcome_status = getOutcomeStatusStatement();
		 _q_outcome_type = getOutcomeTypeStatement();
		 _q_outcome_type_usage = getOutComeTypeUsageStatement();
		 _q_outcome_type_betting_type_relation = getOutcomeTypeBettingTypeRelationStatement();
		 _q_source = getSourceStatement();

	}
	
	private PreparedStatement getBettingOfferStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_offer);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingOfferStatusStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_offer_status);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingTypeUsageStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_type_usage);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeStatusStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_status);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeTypeStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_type);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutComeTypeUsageStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_type_usage);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeTypeBettingTypeRelationStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_type_betting_type_relation);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getSourceStatement()
	{
		try
		{
			return connection.prepareStatement(q_source);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

}
