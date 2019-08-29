package com.ubaid.app.model.insert.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.indexing.IndexQueries;

public abstract class PreparedStatementsForIndexing implements IndexQueries
{

	protected Connection connection;
	
	//indexing
	//event
	protected PreparedStatement event_add_index_q;
	protected PreparedStatement event_part_add_index_q;
	protected PreparedStatement event_template_add_index_q;
	protected PreparedStatement event_type_usage_add_index_q;
	protected PreparedStatement event_part_default_usage_add_index_q;
	protected PreparedStatement event_type_add_index_q;
	protected PreparedStatement event_status_add_index_q;
	protected PreparedStatement provider_event_relation_add_index_q;
	protected PreparedStatement sport_add_index_q;
	protected PreparedStatement provider_add_index_q;
	protected PreparedStatement event_participant_relation_add_index_q;
	protected PreparedStatement event_participant_restriction_add_index_q;
	//location
	protected PreparedStatement location_add_index_q;
	protected PreparedStatement location_type_add_index_q;
	protected PreparedStatement location_relation_add_index_q;
	protected PreparedStatement location_relation_type_add_index_q;
	//betting
	protected PreparedStatement betting_offer_add_index_q;
	protected PreparedStatement betting_offer_status_add_index_q;
	protected PreparedStatement betting_type_add_index_q;
	protected PreparedStatement betting_type_usage_add_index_q;
	protected PreparedStatement outcome_add_index_q;
	protected PreparedStatement outcome_status_add_index_q;
	protected PreparedStatement outcome_type_add_index_q;
	protected PreparedStatement outcome_type_usage_add_index_q;
	protected PreparedStatement outcome_type_betting_type_relation_add_index_q;
	protected PreparedStatement source_add_index_q;
	//participant
	protected PreparedStatement participant_add_index_q;
	protected PreparedStatement participant_usage_add_index_q;
	protected PreparedStatement participant_role_add_index_q;
	protected PreparedStatement participant_type_role_usage_add_index_q;
	protected PreparedStatement participant_type_add_index_q;
	protected PreparedStatement participant_relation_add_index_q;
	protected PreparedStatement participant_relation_type_add_index_q;

	//drop index_qing
	//event
	protected PreparedStatement event_drop_index_q;
	protected PreparedStatement event_part_drop_index_q;
	protected PreparedStatement event_template_drop_index_q;
	protected PreparedStatement event_type_usage_drop_index_q;
	protected PreparedStatement event_part_default_usage_drop_index_q;
	protected PreparedStatement event_type_drop_index_q;
	protected PreparedStatement event_status_drop_index_q;
	protected PreparedStatement provider_event_relation_drop_index_q;
	protected PreparedStatement sport_drop_index_q;
	protected PreparedStatement provider_drop_index_q;
	protected PreparedStatement event_participant_relation_drop_index_q;
	protected PreparedStatement event_participant_restriction_drop_index_q;

	//location
	protected PreparedStatement location_drop_index_q;
	protected PreparedStatement location_type_drop_index_q;
	protected PreparedStatement location_relation_drop_index_q;
	protected PreparedStatement location_relation_type_drop_index_q;
	//betting
	protected PreparedStatement betting_offer_drop_index_q;
	protected PreparedStatement betting_offer_status_drop_index_q;
	protected PreparedStatement betting_type_drop_index_q;
	protected PreparedStatement betting_type_usage_drop_index_q;
	protected PreparedStatement outcome_drop_index_q;
	protected PreparedStatement outcome_status_drop_index_q;
	protected PreparedStatement outcome_type_drop_index_q;
	protected PreparedStatement outcome_type_usage_drop_index_q;
	protected PreparedStatement outcome_type_betting_type_relation_drop_index_q;
	protected PreparedStatement source_drop_index_q;
	//participant
	protected PreparedStatement participant_drop_index_q;
	protected PreparedStatement participant_usage_drop_index_q;
	protected PreparedStatement participant_role_drop_index_q;
	protected PreparedStatement participant_type_role_usage_drop_index_q;
	protected PreparedStatement participant_type_drop_index_q;
	protected PreparedStatement participant_relation_drop_index_q;
	protected PreparedStatement participant_relation_type_drop_index_q;


	//show index_qing
	//event
	protected PreparedStatement event_show_index_q;
	protected PreparedStatement event_part_show_index_q;
	protected PreparedStatement event_template_show_index_q;
	protected PreparedStatement event_type_usage_show_index_q;
	protected PreparedStatement event_part_default_usage_show_index_q;
	protected PreparedStatement event_type_show_index_q;
	protected PreparedStatement event_status_show_index_q;
	protected PreparedStatement provider_event_relation_show_index_q;
	protected PreparedStatement sport_show_index_q;
	protected PreparedStatement provider_show_index_q;
	protected PreparedStatement event_participant_relation_show_index_q;
	protected PreparedStatement event_participant_restriction_show_index_q;

	//location
	protected PreparedStatement location_show_index_q;
	protected PreparedStatement location_type_show_index_q;
	protected PreparedStatement location_relation_show_index_q;
	protected PreparedStatement location_relation_type_show_index_q;
	//betting
	protected PreparedStatement betting_offer_show_index_q;
	protected PreparedStatement betting_offer_status_show_index_q;
	protected PreparedStatement betting_type_show_index_q;
	protected PreparedStatement betting_type_usage_show_index_q;
	protected PreparedStatement outcome_show_index_q;
	protected PreparedStatement outcome_status_show_index_q;
	protected PreparedStatement outcome_type_show_index_q;
	protected PreparedStatement outcome_type_usage_show_index_q;
	protected PreparedStatement outcome_type_betting_type_relation_show_index_q;
	protected PreparedStatement source_show_index_q;
	//participant
	protected PreparedStatement participant_show_index_q;
	protected PreparedStatement participant_usage_show_index_q;
	protected PreparedStatement participant_role_show_index_q;
	protected PreparedStatement participant_type_role_usage_show_index_q;
	protected PreparedStatement participant_type_show_index_q;
	protected PreparedStatement participant_relation_show_index_q;
	protected PreparedStatement participant_relation_type_show_index_q;

	
	
	//invalid date
	protected PreparedStatement invalidDate;

	
	//odds history
	protected PreparedStatement odds_history_show_index_q;
	protected PreparedStatement odds_history_drop_index_q;
	protected PreparedStatement odds_history_add_index_q;
	
	
	public PreparedStatementsForIndexing(Controller controller)
	{
		this.connection = controller.getDatabase2().connection;
		
		//indexing
		//event
		event_add_index_q = getEvent_add_indexStatement();
		event_part_add_index_q = getEventPart_add_indexStatement();
		event_template_add_index_q = getEventTemplate_add_indexStatement();
		event_type_usage_add_index_q = getEventTypeUsage_add_indexStatement();
		event_part_default_usage_add_index_q = getEventPartDefaultUsage_add_indexStatement();
		event_type_add_index_q = getEventType_add_indexStatement();
		event_status_add_index_q = getEventStatus_add_indexStatement();
		provider_event_relation_add_index_q = getProviderEventRelation_add_indexStatement();
		sport_add_index_q = getSport_add_indexStatement();
		provider_add_index_q = getProvider_add_indexStatement();
		event_participant_relation_add_index_q = getEvent_participant_relation_add_indexStatement();
		event_participant_restriction_add_index_q = getEvent_participant_restriction_add_indexStatement();
		
		//location
		location_add_index_q = getLocation_add_indexStatement();
		location_type_add_index_q = getLocationType_add_indexStatement();
		location_relation_add_index_q = getLocationRelation_add_indexStatement();
		location_relation_type_add_index_q = getLocationRelationType_add_indexStatement();
		//betting
		betting_offer_add_index_q = getBettingOffer_add_indexStatement();
		betting_offer_status_add_index_q = getBettingOfferStatus_add_indexStatement();
		betting_type_add_index_q = getBettingType_add_indexStatement();
		betting_type_usage_add_index_q = getBettingTypeUsage_add_indexStatement();
		outcome_add_index_q = getOutcome_add_indexStatement();
		outcome_status_add_index_q = getOutcomeStatus_add_indexStatement();
		outcome_type_add_index_q = getOutcomeType_add_indexStatement();
		outcome_type_usage_add_index_q = getOutComeTypeUsage_add_indexStatement();
		outcome_type_betting_type_relation_add_index_q = getOutcomeTypeBettingTypeRelation_add_indexStatement();
		source_add_index_q = getSource_add_indexStatement();
		
		//deindexng
		//event
		event_drop_index_q = getEvent_drop_indexStatement();
		event_part_drop_index_q = getEventPart_drop_indexStatement();
		event_template_drop_index_q = getEventTemplate_drop_indexStatement();
		event_type_usage_drop_index_q = getEventTypeUsage_drop_indexStatement();
		event_part_default_usage_drop_index_q = getEventPartDefaultUsage_drop_indexStatement();
		event_type_drop_index_q = getEventType_drop_indexStatement();
		event_status_drop_index_q = getEventStatus_drop_indexStatement();
		provider_event_relation_drop_index_q = getProviderEventRelation_drop_indexStatement();
		sport_drop_index_q = getSport_drop_indexStatement();
		provider_drop_index_q = getProvider_drop_indexStatement();
		event_participant_relation_drop_index_q = getEvent_participant_relation_drop_indexStatement();
		event_participant_restriction_drop_index_q = getEvent_participant_restriction_drop_indexStatement();
		//location
		location_drop_index_q = getLocation_drop_indexStatement();
		location_type_drop_index_q = getLocationType_drop_indexStatement();
		location_relation_drop_index_q = getLocationRelation_drop_indexStatement();
		location_relation_type_drop_index_q = getLocationRelationType_drop_indexStatement();
		//betting
		betting_offer_drop_index_q = getBettingOffer_drop_indexStatement();
		betting_offer_status_drop_index_q = getBettingOfferStatus_drop_indexStatement();
		betting_type_drop_index_q = getBettingType_drop_indexStatement();
		betting_type_usage_drop_index_q = getBettingTypeUsage_drop_indexStatement();
		outcome_drop_index_q = getOutcome_drop_indexStatement();
		outcome_status_drop_index_q = getOutcomeStatus_drop_indexStatement();
		outcome_type_drop_index_q = getOutcomeType_drop_indexStatement();
		outcome_type_usage_drop_index_q = getOutComeTypeUsage_drop_indexStatement();
		outcome_type_betting_type_relation_drop_index_q = getOutcomeTypeBettingTypeRelation_drop_indexStatement();
		source_drop_index_q = getSource_drop_indexStatement();

		
		//show indexing
		//event
		event_show_index_q = getEvent_show_indexStatement();
		event_part_show_index_q = getEventPart_show_indexStatement();
		event_template_show_index_q = getEventTemplate_show_indexStatement();
		event_type_usage_show_index_q = getEventTypeUsage_show_indexStatement();
		event_part_default_usage_show_index_q = getEventPartDefaultUsage_show_indexStatement();
		event_type_show_index_q = getEventType_show_indexStatement();
		event_status_show_index_q = getEventStatus_show_indexStatement();
		provider_event_relation_show_index_q = getProviderEventRelation_show_indexStatement();
		sport_show_index_q = getSport_show_indexStatement();
		provider_show_index_q = getProvider_show_indexStatement();
		event_participant_relation_show_index_q = getEvent_participant_relation_show_indexStatement();
		event_participant_restriction_show_index_q = getEvent_participant_restriction_show_indexStatement();

		//location
		location_show_index_q = getLocation_show_indexStatement();
		location_type_show_index_q = getLocationType_show_indexStatement();
		location_relation_show_index_q = getLocationRelation_show_indexStatement();
		location_relation_type_show_index_q = getLocationRelationType_show_indexStatement();
		//betting
		betting_offer_show_index_q = getBettingOffer_show_indexStatement();
		betting_offer_status_show_index_q = getBettingOfferStatus_show_indexStatement();
		betting_type_show_index_q = getBettingType_show_indexStatement();
		betting_type_usage_show_index_q = getBettingTypeUsage_show_indexStatement();
		outcome_show_index_q = getOutcome_show_indexStatement();
		outcome_status_show_index_q = getOutcomeStatus_show_indexStatement();
		outcome_type_show_index_q = getOutcomeType_show_indexStatement();
		outcome_type_usage_show_index_q = getOutComeTypeUsage_show_indexStatement();
		outcome_type_betting_type_relation_show_index_q = getOutcomeTypeBettingTypeRelation_show_indexStatement();
		source_show_index_q = getSource_show_indexStatement();

		
		//participant
		//participant add index
		participant_add_index_q = getParticipant_add_indexStatement();
		participant_usage_add_index_q = getParticipant_usage_add_indexStatement();
		participant_role_add_index_q = getParticipant_role_add_indexStatement();
		participant_type_role_usage_add_index_q = getParticipant_type_role_usage_add_indexStatement();
		participant_type_add_index_q = getParticiapnt_type_add_indexStatement();
		participant_relation_add_index_q = getParticipant__relation_add_indexStatement();
		participant_relation_type_add_index_q = getParticipant_relation_type_add_indexStatement();
		//participant remove index
		participant_drop_index_q = getParticipant_drop_indexStatement();
		participant_usage_drop_index_q = getParticipant_usage_drop_indexStatement();
		participant_role_drop_index_q = getParticipant_role_drop_indexStatement();
		participant_type_role_usage_drop_index_q = getParticipant_type_role_usage_drop_indexStatement();
		participant_type_drop_index_q = getParticiapnt_type_drop_indexStatement();
		participant_relation_drop_index_q = getParticipant__relation_drop_indexStatement();
		participant_relation_type_drop_index_q = getParticipant_relation_type_drop_indexStatement();
		//participant show index
		participant_show_index_q = getParticipant_show_indexStatement();
		participant_usage_show_index_q = getParticipant_usage_show_indexStatement();
		participant_role_show_index_q = getParticipant_role_show_indexStatement();
		participant_type_role_usage_show_index_q = getParticipant_type_role_usage_show_indexStatement();
		participant_type_show_index_q = getParticiapnt_type_show_indexStatement();
		participant_relation_show_index_q = getParticipant__relation_show_indexStatement();
		participant_relation_type_show_index_q = getParticipant_relation_type_show_indexStatement();
		
		//invalid date
		invalidDate = getInvalidDateStatement();
		
		//odds history
		odds_history_add_index_q = getoddshistory_add_indexStatement();
		odds_history_drop_index_q = getoddshistory_drop_indexStatement();
		odds_history_show_index_q = getoddshistory_show_indexStatement();

	}
	
	private PreparedStatement getInvalidDateStatement()
	{
		try
		{
			return connection.prepareStatement(invalid_date);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
		
	}
	
	
	//-----------------------------------------------------------Events add index------------------------------------------//
	private PreparedStatement getEvent_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getEventPart_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventPart_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getEventTemplate_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventTemplate_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventTypeUsage_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventTypeUsage_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventPartDefaultUsage_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventPartDefaultUsage_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventType_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventType_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventStatus_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventStatus_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getProviderEventRelation_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(providerEventRelation_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getSport_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(sport_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getProvider_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(provider_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEvent_participant_relation_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_relation_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEvent_participant_restriction_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_restriction_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	//----------------------------------------------------------------location add index--------------------------------------//
	private PreparedStatement getLocation_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(location_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getLocationType_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationType_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getLocationRelation_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationRelation_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getLocationRelationType_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationRelationType_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	//------------------------------------------------------------Bettings add index-------------------------------//
	private PreparedStatement getBettingOffer_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingOffer_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingOfferStatus_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingOfferStatus_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingType_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingType_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingTypeUsage_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingTypeUsage_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcome_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeStatus_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcomeStatus_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeType_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcomeType_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutComeTypeUsage_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcometypeusage_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeTypeBettingTypeRelation_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcometypebettingtyperelation_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getSource_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(source_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	//drop-------------------------------------------------------
	
	//----------------------------------------------------------------events drop index---------------------------------------//
	private PreparedStatement getEvent_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getEventPart_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventPart_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getEventTemplate_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventTemplate_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventTypeUsage_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventTypeUsage_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventPartDefaultUsage_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventPartDefaultUsage_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventType_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventType_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventStatus_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventStatus_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getProviderEventRelation_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(providerEventRelation_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getSport_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(sport_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getProvider_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(provider_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getEvent_participant_relation_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_relation_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEvent_participant_restriction_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_restriction_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	
	//--------------------------------------------------------location drop index-------------------------------------------//
	private PreparedStatement getLocation_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(location_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getLocationType_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationType_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getLocationRelation_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationRelation_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getLocationRelationType_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationRelationType_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	//---------------------------------------betting drop index----------------------------------------------------------//
	private PreparedStatement getBettingOffer_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingOffer_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingOfferStatus_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingOfferStatus_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingType_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingType_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingTypeUsage_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingTypeUsage_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcome_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeStatus_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcomeStatus_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeType_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcomeType_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutComeTypeUsage_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcometypeusage_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeTypeBettingTypeRelation_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcometypebettingtyperelation_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getSource_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(source_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	//show index
	//------------------------------------------------------event show index---------------------------------------------------//
	private PreparedStatement getEvent_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getEventPart_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventPart_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getEventTemplate_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventTemplate_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventTypeUsage_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventTypeUsage_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventPartDefaultUsage_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventPartDefaultUsage_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventType_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventType_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEventStatus_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(eventStatus_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getProviderEventRelation_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(providerEventRelation_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getSport_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(sport_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	private PreparedStatement getProvider_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(provider_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getEvent_participant_relation_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_relation_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getEvent_participant_restriction_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(event_participant_restriction_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	//------------------------------------------------------------locations show index-------------------------------------//
	private PreparedStatement getLocation_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(location_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	
	private PreparedStatement getLocationType_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationType_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getLocationRelation_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationRelation_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getLocationRelationType_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(locationRelationType_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	//---------------------------------------------------------Betting show index------------------------------------------//
	private PreparedStatement getBettingOffer_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingOffer_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingOfferStatus_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingOfferStatus_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingType_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingType_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getBettingTypeUsage_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(bettingTypeUsage_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcome_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcome_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeStatus_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcomeStatus_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeType_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcomeType_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutComeTypeUsage_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcometypeusage_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	private PreparedStatement getOutcomeTypeBettingTypeRelation_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(outcometypebettingtyperelation_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getSource_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(source_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}


	//---------------------------------------------------------Participant add index-----------------------------------------//
	private PreparedStatement getParticipant_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getParticipant_usage_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_usage_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_role_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_type_role_usage_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticiapnt_type_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_type_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant__relation_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_relation_type_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_type_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	//----------------------------------------------------------------Participant drop index------------------------------------//
	private PreparedStatement getParticipant_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getParticipant_usage_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_usage_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_role_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_type_role_usage_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticiapnt_type_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_type_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant__relation_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_relation_type_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_type_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

	//-----------------------------------------------------------Participant show index ---------------------------------------//
	private PreparedStatement getParticipant_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	private PreparedStatement getParticipant_usage_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_usage_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_role_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_type_role_usage_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_role_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticiapnt_type_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_type_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant__relation_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getParticipant_relation_type_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(participant_relation_type_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	
	
	//odds history table
	private PreparedStatement getoddshistory_add_indexStatement()
	{
		try
		{
			return connection.prepareStatement(odds_history_add_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getoddshistory_drop_indexStatement()
	{
		try
		{
			return connection.prepareStatement(odds_history_drop_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}
	private PreparedStatement getoddshistory_show_indexStatement()
	{
		try
		{
			return connection.prepareStatement(odds_history_show_index);
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			return null;
		}
	}

}
