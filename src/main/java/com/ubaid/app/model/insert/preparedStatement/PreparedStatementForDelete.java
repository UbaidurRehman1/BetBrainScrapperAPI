package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.QuiriesForDeletion;

public abstract class PreparedStatementForDelete implements QuiriesForDeletion
{
	protected final Connection connection;
	
	protected final PreparedStatement _q_betting_offer_delete;
	protected final PreparedStatement _q_betting_offer_status_delete;
	protected final PreparedStatement _q_betting_type_delete;
	protected final PreparedStatement _q_betting_type_usage_delete;
	protected final PreparedStatement _q_outcome_delete;
	protected final PreparedStatement _q_outcome_status_delete;
	protected final PreparedStatement _q_outcome_type_delete;
	protected final PreparedStatement _q_outcome_type_usage_delete;
	protected final PreparedStatement _q_outcome_type_betting_type_relation_delete;
	protected final PreparedStatement _q_source_delete;

	
	protected final PreparedStatement _q_event_delete;
	protected final PreparedStatement _q_event_part_delete;
	protected final PreparedStatement _q_event_template_delete;
	protected final PreparedStatement _q_event_type_usage_delete;
	protected final PreparedStatement _q_event_part_default_usage_delete;
	protected final PreparedStatement _q_event_type_delete;
	protected final PreparedStatement _q_event_status_delete;
	protected final PreparedStatement _q_provider_event_relation_delete;
	protected final PreparedStatement _q_sport_delete;
	protected final PreparedStatement _q_provider_delete;
	protected final PreparedStatement _q_event_participant_relation_delete;
	protected final PreparedStatement _q_event_participant_restriction_delete;
	
	protected final PreparedStatement _q_location_delete;
	protected final PreparedStatement _q_location_type_delete;
	protected final PreparedStatement _q_location_relation_delete;
	protected final PreparedStatement _q_location_relation_type_delete;

	protected final PreparedStatement _q_participant_delete;
	protected final PreparedStatement _q_participant_usage_delete;
	protected final PreparedStatement _q_participant_role_delete;
	protected final PreparedStatement _q_participant_type_role_usage_delete;
	protected final PreparedStatement _q_participant_type_delete;
	protected final PreparedStatement _q_participant_relation_delete;
	protected final PreparedStatement _q_participant_relation_type_delete;

	protected final PreparedStatement _q_odds_history_delete;
	
	public PreparedStatementForDelete(Controller controller)
	{
		connection = controller.getDatabase2().connection;
		
		 _q_betting_offer_delete = getBettingOfferDeleteStatement();
		 _q_betting_offer_status_delete = getBettingOfferStatusDeleteStatement();
		 _q_betting_type_delete = getBettingTypeDeleteStatement();
		 _q_betting_type_usage_delete = getBettingTypeUsageDeleteStatement();
		 _q_outcome_delete = getOutcomeDeleteStatement();
		 _q_outcome_status_delete = getOutcomeStatusDeleteStatement();
		 _q_outcome_type_delete = getOutcomeTypeDeleteStatement();
		 _q_outcome_type_usage_delete = getOutcomeTypeUsageDeleteStatement();
		 _q_outcome_type_betting_type_relation_delete = getOutcomeTypeBettingTypeRelationDeleteStatement();
		 _q_source_delete = getSourceDeleteStatement();

		 
		 _q_event_delete = getEventDeleteStatement();
		 _q_event_part_delete = getEventPartDeleteStatement();
		 _q_event_template_delete = getEventTemplateDeleteStatement();
		 _q_event_type_usage_delete = getEventTypeUsageDeleteStatement();
		 _q_event_part_default_usage_delete = getEventPartDefaultUsageDeleteStatement();
		 _q_event_type_delete = getEventTypeDeleteStatement();
		 _q_event_status_delete = getEventStatusDeleteStatement();
		 _q_provider_event_relation_delete = getProviderEventRelationDeleteStatement();
		 _q_event_participant_relation_delete = getEventParticipantRelationDeleteStatement();
		 _q_event_participant_restriction_delete = getEventParticipantRestrictionDeleteStatement();
		
		//sport
		 _q_sport_delete = getSportDeleteStatement();
		
		//provider
		 _q_provider_delete = getProviderDeleteStatement();

		 
		_q_location_delete = getLocationDeleteStatement();
		_q_location_type_delete = getLocationTypeDeleteStatement();
		_q_location_relation_delete = getLocationRelationDeleteStatement();
		_q_location_relation_type_delete = getLocationRelationTypeDeleteStatement();

		
		//participant
		 _q_participant_delete = getParticipantDeleteStatement();
		 _q_participant_usage_delete = getParticipantUsageDeleteStatement();
		 _q_participant_role_delete = getParticipantRoleDeleteStatement();
		 _q_participant_type_role_usage_delete = getParticipantTypeRoleUsageDeleteStatement();
		 _q_participant_type_delete = getParticipantTypeDeleteStatement();
		 _q_participant_relation_delete = getParticipantRelationDeleteStatement();
		 _q_participant_relation_type_delete = getParticipantRelationTypeDeleteStatement();
		 
		 _q_odds_history_delete = getOddsHistoryDeleteStatement();


	}
	
	//events Delete
	private PreparedStatement getEventDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventPartDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_part_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventTemplateDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_template_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventTypeUsageDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_type_usage_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventPartDefaultUsageDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_part_default_usage_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventStatusDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_status_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getProviderEventRelationDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(provider_event_relation_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getSportDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(sport_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getProviderDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(provider_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventParticipantRelationDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_relation_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getEventParticipantRestrictionDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_restriction_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(location_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(location_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationRelationDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(location_relation_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getLocationRelationTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(location_relation_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingOfferDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(betting_offer_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingOfferStatusDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(betting_offer_status_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(betting_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getBettingTypeUsageDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(betting_type_usgae_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeStatusDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_status_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeTypeUsageDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_type_usage_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getOutcomeTypeBettingTypeRelationDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_type_betting_type_relation_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getSourceDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(source_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	//participant
	private PreparedStatement getParticipantDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantUsageDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_usage_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRoleDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantTypeRoleUsageDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_type_role_usage_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRelationDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipantRelationTypeDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_type_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getOddsHistoryDeleteStatement()
	{
		try
		{
			return connection.prepareStatement(odds_history_d);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

}
