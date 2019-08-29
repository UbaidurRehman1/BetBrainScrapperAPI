package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.QuriesForIDsRetrieve;


public abstract class PreparedStatementForRetrievingIDs implements QuriesForIDsRetrieve
{	
	protected final Connection connection;
	
	protected final PreparedStatement _q_betting_offer_ids;
	protected final PreparedStatement _q_betting_offer_status_ids;
	protected final PreparedStatement _q_betting_type_ids;
	protected final PreparedStatement _q_betting_type_usage_ids;
	protected final PreparedStatement _q_outcome_ids;
	protected final PreparedStatement _q_outcome_status_ids;
	protected final PreparedStatement _q_outcome_type_ids;
	protected final PreparedStatement _q_outcome_type_usage_ids;
	protected final PreparedStatement _q_outcome_type_betting_type_relation_ids;
	protected final PreparedStatement _q_source_ids;

	
	protected final PreparedStatement _q_event_ids;
	protected final PreparedStatement _q_event_part_ids;
	protected final PreparedStatement _q_event_template_ids;
	protected final PreparedStatement _q_event_type_usage_ids;
	protected final PreparedStatement _q_event_part_default_usage_ids;
	protected final PreparedStatement _q_event_type_ids;
	protected final PreparedStatement _q_event_status_ids;
	protected final PreparedStatement _q_provider_event_relation_ids;
	protected final PreparedStatement _q_sport_ids;
	protected final PreparedStatement _q_provider_ids;
	protected final PreparedStatement _q_event_participant_relation_ids;
	protected final PreparedStatement _q_event_participant_restriction_ids;
	
	protected final PreparedStatement _q_location_ids;
	protected final PreparedStatement _q_location_type_ids;
	protected final PreparedStatement _q_location_relation_ids;
	protected final PreparedStatement _q_location_relation_type_ids;

	protected final PreparedStatement _q_participant_ids;
	protected final PreparedStatement _q_participant_usage_ids;
	protected final PreparedStatement _q_participant_role_ids;
	protected final PreparedStatement _q_participant_type_role_usage_ids;
	protected final PreparedStatement _q_participant_type_ids;
	protected final PreparedStatement _q_participant_relation_ids;
	protected final PreparedStatement _q_participant_relation_type_ids;
	
	protected final PreparedStatement _q_odds_history_ids;

	
	public PreparedStatementForRetrievingIDs(Controller controller)
	{
		connection = controller.getDatabase2().connection;
		
		 _q_betting_offer_ids = getBettingOfferIDsStatement();
		 _q_betting_offer_status_ids = getBettingOfferStatusIDsStatement();
		 _q_betting_type_ids = getBettingTypeIDsStatement();
		 _q_betting_type_usage_ids = getBettingTypeUsageIDsStatement();
		 _q_outcome_ids = getOutcomeIDsStatement();
		 _q_outcome_status_ids = getOutcomeStatusIDsStatement();
		 _q_outcome_type_ids = getOutcomeTypeIDsStatement();
		 _q_outcome_type_usage_ids = getOutcomeTypeUsageIDsStatement();
		 _q_outcome_type_betting_type_relation_ids = getOutcomeTypeBettingTypeRelationIDsStatement();
		 _q_source_ids = getSourceIDsStatement();

		 
		 _q_event_ids = getEventIDsStatement();
		 _q_event_part_ids = getEventPartIDsStatement();
		 _q_event_template_ids = getEventTemplateIDsStatement();
		 _q_event_type_usage_ids = getEventTypeUsageIDsStatement();
		 _q_event_part_default_usage_ids = getEventPartDefaultUsageIDsStatement();
		 _q_event_type_ids = getEventTypeIDsStatement();
		 _q_event_status_ids = getEventStatusIDsStatement();
		 _q_provider_event_relation_ids = getProviderEventRelationIDsStatement();
		 _q_event_participant_relation_ids = getEventParticipantRelationIDsStatement();
		 _q_event_participant_restriction_ids = getEventParticipantRestrictionIDsStatement();
		
		//sport
		 _q_sport_ids = getSportIDsStatement();
		
		//provider
		 _q_provider_ids = getProviderIDsStatement();

		 
		_q_location_ids = getLocationIDsStatement();
		_q_location_type_ids = getLocationTypeIDsStatement();
		_q_location_relation_ids = getLocationRelationIDsStatement();
		_q_location_relation_type_ids = getLocationRelationTypeIDsStatement();

		
		//participant
		 _q_participant_ids = getParticipantIDsStatement();
		 _q_participant_usage_ids = getParticipantUsageIDsStatement();
		 _q_participant_role_ids = getParticipantRoleIDsStatement();
		 _q_participant_type_role_usage_ids = getParticipantTypeRoleUsageIDsStatement();
		 _q_participant_type_ids = getParticipantTypeIDsStatement();
		 _q_participant_relation_ids = getParticipantRelationIDsStatement();
		 _q_participant_relation_type_ids = getParticipantRelationTypeIDsStatement();

		 _q_odds_history_ids = getOddsHistoryIDsStatement();
	}
	
	//events ids
	private PreparedStatement getEventIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventPartIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_part_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventTemplateIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_template_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventTypeUsageIDsStatement()
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
	private PreparedStatement getEventPartDefaultUsageIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_part_default_usage_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventStatusIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_status_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getProviderEventRelationIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_provider_event_relation_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getSportIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_sports_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getProviderIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_provider_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventParticipantRelationIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_participant_relation_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventParticipantRestrictionIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_event_participant_restriction_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationRelationIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_relation_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationRelationTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_location_relation_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingOfferIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_offer_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingOfferStatusIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_offer_status_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingTypeUsageIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_betting_type_usage_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeStatusIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_status_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_outcome_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeTypeUsageIDsStatement()
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
	private PreparedStatement getOutcomeTypeBettingTypeRelationIDsStatement()
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
	private PreparedStatement getSourceIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_source_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	//participant
	private PreparedStatement getParticipantIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantUsageIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_usage_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRoleIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_role_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantTypeRoleUsageIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_type_role_usage_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRelationIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_relation_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRelationTypeIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_participant_relation_type_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOddsHistoryIDsStatement()
	{
		try
		{
			return connection.prepareStatement(q_odds_history_ids);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
}
