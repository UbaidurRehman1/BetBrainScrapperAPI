package com.ubaid.app.model.retrieve;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementForRetrievingIDs;

public class IDRetrieval extends PreparedStatementForRetrievingIDs
{
	protected Controller controller;
	protected ResultSet resultSet;
	
	public IDRetrieval(Controller controller)
	{
		super(controller);
		this.controller = controller;
		
		setEventIDs();
		setEventPartIDs();
		setEventTemplateIDs();
		setEventTypeUsageIDs();
		setEventPartDefaultUsageIDs();
		setEventTypeIDs();
		setEventStatusIDs();
		setProviderEventRelationIDs();
		setSportIDs();
		setProviderIDs();
		setEventParticipantRelationIDs();
		setEventParticipantRestrictionIDs();
		
		setLocationIDs();
		setLocationTypeIDs();
		setLocationRelationIDs();
		setLocationRelationTypeIDs();
		
		setBettingOfferIDs();
		setBettingOfferStatusIDs();
		setBettingTypeIDs();
		setBettingTypeUsageIDs();
		setOutcomeIDs();
		setOutcomeStatusIDs();
		setOutcomeTypeIDs();
		setOutcomeTypeUsageIDs();
		setOutcomeTypeBettingTypeRelationIDs();
		setSourceIDs();
		
		setParticipantIDs();
		setParticipantUsageIDs();
		setParticipantRoleIDs();
		setParticipantTypeRoleUsageIDs();
		setParticipantTypeIDs();
		setParticipantRelationIDs();
		setParticipantRelationTypeIDs();
	}
	
	public void setEventIDs()
	{
		try
		{
			resultSet = _q_event_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEvents_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	
	public void setEventPartIDs()
	{
		try
		{
			resultSet = _q_event_part_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEventParts_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventTemplateIDs()
	{
		try
		{
			resultSet = _q_event_template_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEventTemplates_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventTypeIDs()
	{
		try
		{
			resultSet = _q_event_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEventTypes_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventPartDefaultUsageIDs()
	{
		try
		{
			resultSet = _q_event_part_default_usage_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEventPartDefaultUsages_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventTypeUsageIDs()
	{
		try
		{
			resultSet = _q_event_type_usage_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEventTypeUsages_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventStatusIDs()
	{
		try
		{
			resultSet = _q_event_status_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEventStatus_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setProviderEventRelationIDs()
	{
		try
		{
			resultSet = _q_provider_event_relation_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setProviders_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setSportIDs()
	{
		try
		{
			resultSet = _q_sport_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setSports_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setProviderIDs()
	{
		try
		{
			resultSet = _q_provider_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setProviders_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventParticipantRelationIDs()
	{
		try
		{
			resultSet = _q_event_participant_relation_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEvent_participant_relation_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setEventParticipantRestrictionIDs()
	{
		try
		{
			resultSet = _q_event_participant_restriction_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setEvent_participant_restriction_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	
	public void setLocationIDs()
	{
		try
		{
			resultSet = _q_location_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setLocations_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setLocationTypeIDs()
	{
		try
		{
			resultSet = _q_location_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setLocationTypes_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setLocationRelationIDs()
	{
		try
		{
			resultSet = _q_location_relation_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setLocationRelations_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setLocationRelationTypeIDs()
	{
		try
		{
			resultSet = _q_location_relation_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setLocationRelationTypes_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setBettingOfferIDs()
	{
		try
		{
			resultSet = _q_betting_offer_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setBettingOffers_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setBettingOfferStatusIDs()
	{
		try
		{
			resultSet = _q_betting_offer_status_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setBettingOfferStatus_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setBettingTypeIDs()
	{
		try
		{
			resultSet = _q_betting_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setBettingTypes_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setBettingTypeUsageIDs()
	{
		try
		{
			resultSet = _q_betting_type_usage_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setBettingTypeUsages_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setOutcomeIDs()
	{
		try
		{
			resultSet = _q_outcome_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setOutcomes_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setOutcomeStatusIDs()
	{
		try
		{
			resultSet = _q_outcome_status_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setOutcomeStatus_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setOutcomeTypeIDs()
	{
		try
		{
			resultSet = _q_outcome_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setOutcomeTypes_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setOutcomeTypeUsageIDs()
	{
		try
		{
			resultSet = _q_outcome_type_usage_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setOutcomeTypeUsages_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setOutcomeTypeBettingTypeRelationIDs()
	{
		try
		{
			resultSet = _q_outcome_type_betting_type_relation_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setOutcomeTypeBettingTypeRelations_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setSourceIDs()
	{
		try
		{
			resultSet = _q_source_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setSources_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantIDs()
	{
		try
		{
			resultSet = _q_participant_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantUsageIDs()
	{
		try
		{
			resultSet = _q_participant_usage_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_usage_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantRoleIDs()
	{
		try
		{
			resultSet = _q_participant_role_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_role_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantTypeRoleUsageIDs()
	{
		try
		{
			resultSet = _q_participant_type_role_usage_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_type_role_usage_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantTypeIDs()
	{
		try
		{
			resultSet = _q_participant_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_type_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantRelationIDs()
	{
		try
		{
			resultSet = _q_participant_relation_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_relation_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}
	public void setParticipantRelationTypeIDs()
	{
		try
		{
			resultSet = _q_participant_relation_type_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setParticipant_relation_type_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}

	public void setOddsHistoryIDs()
	{
		try
		{
			resultSet = _q_odds_history_ids.executeQuery();
			while(resultSet.next())
			{
				controller.setOdds_history_ids(resultSet.getBoolean(1));
			}
			connection.commit();
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
	}

}
