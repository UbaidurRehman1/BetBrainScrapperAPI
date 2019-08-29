package com.ubaid.app.model.insert.event;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.betbrain.sepc.connector.sportsmodel.Event;
import com.betbrain.sepc.connector.sportsmodel.EventPart;
import com.betbrain.sepc.connector.sportsmodel.EventPartDefaultUsage;
import com.betbrain.sepc.connector.sportsmodel.EventParticipantRelation;
import com.betbrain.sepc.connector.sportsmodel.EventParticipantRestriction;
import com.betbrain.sepc.connector.sportsmodel.EventStatus;
import com.betbrain.sepc.connector.sportsmodel.EventTemplate;
import com.betbrain.sepc.connector.sportsmodel.EventType;
import com.betbrain.sepc.connector.sportsmodel.EventTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Provider;
import com.betbrain.sepc.connector.sportsmodel.ProviderEventRelation;
import com.betbrain.sepc.connector.sportsmodel.Sport;
import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementsForEvents;


/**
 * in this class all the tables in event except two 
 * which are related with Participant
 * and extra two which are Sport and Provider
 * @author ubaid
 *
 */
public class InsertInToEvent extends PreparedStatementsForEvents
{	
	
	protected Controller controller;
	
	public InsertInToEvent(Controller controller)
	{
		super(controller);
		this.controller = controller;
	}
	
	
	//Event-1
	public void insertInEventTable(LinkedList<Event> events_)
	{
		
		
		try
		{
			int i = 0;
			for(Event event : events_)
			{
				_q_event.setLong(1, getLongNumber(event.getId()));
				_q_event.setInt(2, getIntNumber(event.getVersion()));
				_q_event.setBoolean(3, getDecision(event.getIsComplete()));
				_q_event.setLong(4, getLongNumber(event.getTypeId()));
				_q_event.setLong(5, getLongNumber(event.getSportId()));
				_q_event.setLong(6, getLongNumber(event.getTemplateId()));
				_q_event.setLong(7, getLongNumber(event.getPromotionId()));
				_q_event.setLong(8, getLongNumber(event.getParentId()));							
				_q_event.setLong(9, getLongNumber(event.getParentPartId()));
				_q_event.setString(10, event.getName());
				_q_event.setTimestamp(11, getDate(event.getStartTime()));
				_q_event.setTimestamp(12, getDate(event.getEndTime()));
				_q_event.setLong(13, getLongNumber(event.getDeleteTimeOffset()));
				_q_event.setLong(14, getLongNumber(event.getVenueId()));
				_q_event.setLong(15, getLongNumber(event.getStatusId()));
				_q_event.setBoolean(16, getDecision(event.getHasLiveStatus()));
				_q_event.setLong(17, getLongNumber(event.getRootPartId()));
				_q_event.setLong(18, getLongNumber(event.getCurrentPartId()));
				_q_event.setString(19, event.getUrl());
				_q_event.setInt(20, getIntNumber(event.getPopularity()));
				_q_event.setString(21, event.getNote());
				_q_event.addBatch();
				i++;
				
				if(i % 1000 == 0 || i == events_.size())
				{
					_q_event.executeBatch();
					controller.getQueue().setText("Event Batch Inserted Successfully ", controller.getQueue().getEntityIndex());
					connection.commit();
				}
				
			}
			
			events_.clear();			
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}
	}
	
	//EventPart-2
	public void insertInEventPartTable(LinkedList<EventPart> eventParts_)
	{
		try
		{

			int i = 0;
			for(EventPart eventPart : eventParts_)
			{
				_q_event_part.setLong(1, getLongNumber(eventPart.getId()));
				_q_event_part.setInt(2, getIntNumber(eventPart.getVersion()));
				_q_event_part.setString(3, eventPart.getName());
				_q_event_part.setString(4, eventPart.getDescription());
				_q_event_part.setLong(5, getLongNumber(eventPart.getParentId()));
				_q_event_part.setInt(6, getIntNumber(eventPart.getOrderNum()));
				_q_event_part.setBoolean(7, getDecision(eventPart.getIsDrawPossible()));
				_q_event_part.addBatch();
				
				i++;
				
				if(i % 1000 == 0 || i == eventParts_.size())
				{
					_q_event_part.executeBatch();
					controller.getQueue().setText("Event Part Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}

			}
			
			eventParts_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//EventTemplate-3
	public void insertInEventTemplateTable(LinkedList<EventTemplate> eventTemplates_)
	{
		try
		{

			int i = 0;
			for(EventTemplate eventTemplate : eventTemplates_)
			{
				_q_event_template.setLong(1, getLongNumber(eventTemplate.getId()));
				_q_event_template.setInt(2, getIntNumber(eventTemplate.getVersion()));
				_q_event_template.setString(3, eventTemplate.getName());
				_q_event_template.setLong(4, getLongNumber(eventTemplate.getEventTypeId()));
				_q_event_template.setLong(5, getLongNumber(eventTemplate.getSportId()));
				_q_event_template.setString(6, eventTemplate.getUrl());
				_q_event_template.setLong(7, getLongNumber(eventTemplate.getVenueId()));
				_q_event_template.setLong(8, getLongNumber(eventTemplate.getRootPartId()));
				_q_event_template.setString(9, eventTemplate.getNote());
				_q_event_template.addBatch();

				i++;
				
				if(i % 1000 == 0 || i == eventTemplates_.size())
				{
					_q_event_template.executeBatch();
					controller.getQueue().setText("Event Template Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}
				
			}
			
			eventTemplates_.clear();
						
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//EventTypeUsage-4
	public void insertInEventTypeUsageTable(LinkedList<EventTypeUsage> eventTypeUsages_)
	{
		try
		{
			
			int i = 0;
			for(EventTypeUsage eventTypeUsage : eventTypeUsages_)
			{
				_q_event_type_usage.setLong(1, getLongNumber(eventTypeUsage.getId()));
				_q_event_type_usage.setInt(2, getIntNumber(eventTypeUsage.getVersion()));
				_q_event_type_usage.setLong(3, getLongNumber(eventTypeUsage.getEventTypeId()));
				_q_event_type_usage.setLong(4, getLongNumber(eventTypeUsage.getSportId()));
				_q_event_type_usage.setLong(5, getLongNumber(eventTypeUsage.getMinPrimaryParticipantTimeBetweenEvents()));
				_q_event_type_usage.setLong(6, getLongNumber(eventTypeUsage.getMinEventDuration()));
				_q_event_type_usage.setLong(7, getLongNumber(eventTypeUsage.getMaxEventDuration()));
				_q_event_type_usage.addBatch();

				i++;
				
				if(i % 1000 == 0 || i == eventTypeUsages_.size())
				{
					_q_event_type_usage.executeBatch();
					controller.getQueue().setText("Event Type Usage Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}
				
			}
			
			eventTypeUsages_.clear();
			
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//EventPartDefaultUsage-5
	public void insertInEventPartDefaultUsageTable(LinkedList<EventPartDefaultUsage> eventPartDefaultUsages_)
	{
		try
		{
			
			int i = 0;
			for(EventPartDefaultUsage eventPartDefaultUsage : eventPartDefaultUsages_)
			{
				_q_event_part_default_usage.setLong(1, getLongNumber(eventPartDefaultUsage.getId()));
				_q_event_part_default_usage.setInt(2, getIntNumber(eventPartDefaultUsage.getVersion()));
				_q_event_part_default_usage.setLong(3, getLongNumber(eventPartDefaultUsage.getParentEventId()));
				_q_event_part_default_usage.setLong(4, getLongNumber(eventPartDefaultUsage.getEventTypeId()));
				_q_event_part_default_usage.setLong(5, getLongNumber(eventPartDefaultUsage.getSportId()));
				_q_event_part_default_usage.setLong(6, getLongNumber(eventPartDefaultUsage.getRootPartId()));
				_q_event_part_default_usage.addBatch();

				i++;
				
				if(i % 1000 == 0 || i == eventPartDefaultUsages_.size())
				{
					_q_event_part_default_usage.executeBatch();
					controller.getQueue().setText("Event Part Default Usage Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}
				
			}

			eventPartDefaultUsages_.clear();
			
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Event Type-6
	public void insertInEventTypeTable(LinkedList<EventType> eventTypes_)
	{
		try
		{
			int i = 0;
			for(EventType eventType : eventTypes_)
			{
				_q_event_type.setLong(1, getLongNumber(eventType.getId()));
				_q_event_type.setInt(2, getIntNumber(eventType.getVersion()));
				_q_event_type.setString(3, eventType.getName());
				_q_event_type.setString(4, eventType.getDescription());
				_q_event_type.addBatch();

				i++;
				
				if(i % 1000 == 0 || i == eventTypes_.size())
				{
					_q_event_type.executeBatch();
					controller.getQueue().setText("Event Types Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			
			eventTypes_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Event Status - 7
	public void insertInEventStatusTable(LinkedList<EventStatus> eventStatuses_)
	{
		try
		{
			
			int i = 0;
			for(EventStatus eventStatus : eventStatuses_)
			{
				_q_event_status.setLong(1, getLongNumber(eventStatus.getId()));
				_q_event_status.setInt(2, getIntNumber(eventStatus.getVersion()));
				_q_event_status.setString(3, eventStatus.getName());
				_q_event_status.setString(4, eventStatus.getDescription());
				_q_event_status.addBatch();

				i++;
				
				if(i % 1000 == 0 || i == eventStatuses_.size())
				{
					_q_event_status.executeBatch();
					controller.getQueue().setText("Event Status Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			eventStatuses_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}
		
	}
	
	//Provider Event Relation 8
	public void insertInProviderEventRelationTable(LinkedList<ProviderEventRelation> pRelations_)
	{
		try
		{
			int i = 0;
			for(ProviderEventRelation pRelation : pRelations_)
			{
				_q_provider_event_relation.setLong(1, getLongNumber(pRelation.getId()));
				_q_provider_event_relation.setInt(2, getIntNumber(pRelation.getVersion()));
				_q_provider_event_relation.setLong(3, getLongNumber(pRelation.getProviderId()));
				_q_provider_event_relation.setLong(4, getLongNumber(pRelation.getEventId()));
				_q_provider_event_relation.setTimestamp(5, getDate(pRelation.getStartTime()));
				_q_provider_event_relation.setTimestamp(6, getDate(pRelation.getEndTime()));
				_q_provider_event_relation.setInt(7, getIntNumber(pRelation.getTimeQualityRank()));
				_q_provider_event_relation.setBoolean(8, getDecision(pRelation.getOffersLiveOdds()));
				_q_provider_event_relation.setBoolean(9, getDecision(pRelation.isOffersLiveTV()));
				_q_provider_event_relation.addBatch();

				i++;
				
				if(i % 1000 == 0 || i == pRelations_.size())
				{
					_q_provider_event_relation.executeBatch();
					controller.getQueue().setText("Provider Event Relation Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			pRelations_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//sport table 9
	public void insertInSportTable(LinkedList<Sport> sports_)
	{
		try
		{
			int i = 0;
			for(Sport sport : sports_)
			{
				_q_sport.setLong(1, getLongNumber(sport.getId()));
				_q_sport.setInt(2, getIntNumber(sport.getVersion()));
				_q_sport.setString(3, sport.getName());
				_q_sport.setString(4, sport.getDescription());
				_q_sport.setLong(5, getLongNumber(sport.getParentId()));
				_q_sport.addBatch();

				i++;
				if(i % 1000 == 0 || i == sports_.size())
				{
					_q_sport.executeBatch();
					controller.getQueue().setText("Sport Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			sports_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//provider 10
	public void insertInProviderTable(LinkedList<Provider> providers_)
	{
		try
		{
			
			int i = 0;
			for(Provider provider : providers_)
			{
				_q_provider.setLong(1, getLongNumber(provider.getId()));
				_q_provider.setInt(2, getIntNumber(provider.getVersion()));
				_q_provider.setString(3, provider.getName());
				_q_provider.setLong(4, getLongNumber(provider.getLocationId()));
				_q_provider.setString(5, provider.getUrl());
				_q_provider.setBoolean(6, getDecision(provider.getIsBookmaker()));
				_q_provider.setBoolean(7, getDecision(provider.getIsBettingExchange()));
				_q_provider.setFloat(8, getFloatNumber(provider.getBettingCommissionVACs()));
				_q_provider.setBoolean(9, getDecision(provider.getIsLiveOddsApproved()));
				_q_provider.setBoolean(10, getDecision(provider.getIsNewsSource()));
				_q_provider.setBoolean(11, getDecision(provider.getIsEnabled()));
				_q_provider.setString(12, provider.getNote());
				_q_provider.addBatch();

				i++;
				if(i % 1000 == 0 || i == providers_.size())
				{
					_q_provider.executeBatch();
					controller.getQueue().setText("Provider Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			
			providers_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//event participant relation 11
	public void insertInEventParticipantRelationTable(LinkedList<EventParticipantRelation> eventParticipantRelations_)
	{
		try
		{
			
			int i = 0;
			for(EventParticipantRelation eventParticipantRelation : eventParticipantRelations_)
			{
				_q_event_participant_relation.setLong(1, getLongNumber(eventParticipantRelation.getId()));
				_q_event_participant_relation.setInt(2, getIntNumber(eventParticipantRelation.getVersion()));
				_q_event_participant_relation.setLong(3, getLongNumber(eventParticipantRelation.getEventId()));
				_q_event_participant_relation.setLong(4, getLongNumber(eventParticipantRelation.getEventPartId()));
				_q_event_participant_relation.setLong(5, getLongNumber(eventParticipantRelation.getParticipantId()));
				_q_event_participant_relation.setLong(6, getLongNumber(eventParticipantRelation.getParticipantRoleId()));
				_q_event_participant_relation.setLong(7, getLongNumber(eventParticipantRelation.getParentParticipantId()));
				
				_q_event_participant_relation.addBatch();

				i++;
				if(i % 1000 == 0 || i == eventParticipantRelations_.size())
				{
					_q_event_participant_relation.executeBatch();
					controller.getQueue().setText("EventParticipantRelation Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			
			eventParticipantRelations_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//provider 12
	public void insertInEventParticipantRestrictionTable(LinkedList<EventParticipantRestriction> eventParticipantRestrictions_)
	{
		try
		{
			
			int i = 0;
			for(EventParticipantRestriction eventParticipantRestriction : eventParticipantRestrictions_)
			{
				_q_event_participant_restriction.setLong(1, getLongNumber(eventParticipantRestriction.getId()));
				_q_event_participant_restriction.setInt(2, getIntNumber(eventParticipantRestriction.getVersion()));
				_q_event_participant_restriction.setLong(3, getLongNumber(eventParticipantRestriction.getEventId()));
				_q_event_participant_restriction.setLong(4, getLongNumber(eventParticipantRestriction.getParticipantTypeId()));
				_q_event_participant_restriction.setBoolean(5, getDecision(eventParticipantRestriction.getParticipantIsMale()));
				_q_event_participant_restriction.setInt(6, getIntNumber(eventParticipantRestriction.getParticipantMinAge()));
				_q_event_participant_restriction.setInt(7, getIntNumber(eventParticipantRestriction.getParticipantMaxAge()));
				_q_event_participant_restriction.setLong(8, getLongNumber(eventParticipantRestriction.getParticipantPartOfLocationId()));
				_q_event_participant_restriction.addBatch();

				i++;
				if(i % 1000 == 0 || i == eventParticipantRestrictions_.size())
				{
					_q_event_participant_restriction.executeBatch();
					controller.getQueue().setText("EventParticipantRestriction Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			
			eventParticipantRestrictions_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	
	
	//test
	//Event-1
	public void insertInEventTable(Event event)
	{
		try
		{
			_q_event.setLong(1, getLongNumber(event.getId()));
			_q_event.setInt(2, getIntNumber(event.getVersion()));
			_q_event.setBoolean(3, getDecision(event.getIsComplete()));
			_q_event.setLong(4, getLongNumber(event.getTypeId()));
			_q_event.setLong(5, getLongNumber(event.getSportId()));
			_q_event.setLong(6, getLongNumber(event.getTemplateId()));
			_q_event.setLong(7, getLongNumber(event.getPromotionId()));
			_q_event.setLong(8, getLongNumber(event.getParentId()));							
			_q_event.setLong(9, getLongNumber(event.getParentPartId()));
			_q_event.setString(10, event.getName());
			_q_event.setTimestamp(11, getDate(event.getStartTime()));
			_q_event.setTimestamp(12, getDate(event.getEndTime()));
			_q_event.setLong(13, getLongNumber(event.getDeleteTimeOffset()));
			_q_event.setLong(14, getLongNumber(event.getVenueId()));
			_q_event.setLong(15, getLongNumber(event.getStatusId()));
			_q_event.setBoolean(16, getDecision(event.getHasLiveStatus()));
			_q_event.setLong(17, getLongNumber(event.getRootPartId()));
			_q_event.setLong(18, getLongNumber(event.getCurrentPartId()));
			_q_event.setString(19, event.getUrl());
			_q_event.setInt(20, getIntNumber(event.getPopularity()));
			_q_event.setString(21, event.getNote());
			_q_event.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Event Entity inserted Successfully", controller.getQueue().getEntityIndex());

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}
	}
	
	//EventPart-2
	public void insertInEventPartTable(EventPart eventPart)
	{
		try
		{
			_q_event_part.setLong(1, getLongNumber(eventPart.getId()));
			_q_event_part.setInt(2, getIntNumber(eventPart.getVersion()));
			_q_event_part.setString(3, eventPart.getName());
			_q_event_part.setString(4, eventPart.getDescription());
			_q_event_part.setLong(5, getLongNumber(eventPart.getParentId()));
			_q_event_part.setInt(6, getIntNumber(eventPart.getOrderNum()));
			_q_event_part.setBoolean(7, getDecision(eventPart.getIsDrawPossible()));
			_q_event_part.executeUpdate();
			connection.commit();	
			controller.getQueue().setText("EventPart Entity inserted Successfully", controller.getQueue().getEntityIndex());

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//EventTemplate-3
	public void insertInEventTemplateTable(EventTemplate eventTemplate)
	{
		try
		{
			_q_event_template.setLong(1, getLongNumber(eventTemplate.getId()));
			_q_event_template.setInt(2, getIntNumber(eventTemplate.getVersion()));
			_q_event_template.setString(3, eventTemplate.getName());
			_q_event_template.setLong(4, getLongNumber(eventTemplate.getEventTypeId()));
			_q_event_template.setLong(5, getLongNumber(eventTemplate.getSportId()));
			_q_event_template.setString(6, eventTemplate.getUrl());
			_q_event_template.setLong(7, getLongNumber(eventTemplate.getVenueId()));
			_q_event_template.setLong(8, getLongNumber(eventTemplate.getRootPartId()));
			_q_event_template.setString(9, eventTemplate.getNote());
			_q_event_template.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Event Template Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//EventTypeUsage-4
	public void insertInEventTypeUsageTable(EventTypeUsage eventTypeUsage)
	{
		try
		{
			_q_event_type_usage.setLong(1, getLongNumber(eventTypeUsage.getId()));
			_q_event_type_usage.setInt(2, getIntNumber(eventTypeUsage.getVersion()));
			_q_event_type_usage.setLong(3, getLongNumber(eventTypeUsage.getEventTypeId()));
			_q_event_type_usage.setLong(4, getLongNumber(eventTypeUsage.getSportId()));
			_q_event_type_usage.setLong(5, getLongNumber(eventTypeUsage.getMinPrimaryParticipantTimeBetweenEvents()));
			_q_event_type_usage.setLong(6, getLongNumber(eventTypeUsage.getMinEventDuration()));
			_q_event_type_usage.setLong(7, getLongNumber(eventTypeUsage.getMaxEventDuration()));
			_q_event_type_usage.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Event Type Usage Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//EventPartDefaultUsage-5
	public void insertInEventPartDefaultUsageTable(EventPartDefaultUsage eventPartDefaultUsage)
	{
		try
		{
			_q_event_part_default_usage.setLong(1, getLongNumber(eventPartDefaultUsage.getId()));
			_q_event_part_default_usage.setInt(2, getIntNumber(eventPartDefaultUsage.getVersion()));
			_q_event_part_default_usage.setLong(3, getLongNumber(eventPartDefaultUsage.getParentEventId()));
			_q_event_part_default_usage.setLong(4, getLongNumber(eventPartDefaultUsage.getEventTypeId()));
			_q_event_part_default_usage.setLong(5, getLongNumber(eventPartDefaultUsage.getSportId()));
			_q_event_part_default_usage.setLong(6, getLongNumber(eventPartDefaultUsage.getRootPartId()));
			_q_event_part_default_usage.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Event Part Default Usage Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Event Type-6
	public void insertInEventTypeTable(EventType eventType)
	{
		try
		{
			_q_event_type.setLong(1, getLongNumber(eventType.getId()));
			_q_event_type.setInt(2, getIntNumber(eventType.getVersion()));
			_q_event_type.setString(3, eventType.getName());
			_q_event_type.setString(4, eventType.getDescription());
			_q_event_type.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Event Types Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Event Status - 7
	public void insertInEventStatusTable(EventStatus eventStatus)
	{
		try
		{
			_q_event_status.setLong(1, getLongNumber(eventStatus.getId()));
			_q_event_status.setInt(2, getIntNumber(eventStatus.getVersion()));
			_q_event_status.setString(3, eventStatus.getName());
			_q_event_status.setString(4, eventStatus.getDescription());
			_q_event_status.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Event Status Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}
		
	}
	
	//Provider Event Relation 8
	public void insertInProviderEventRelationTable(ProviderEventRelation pRelation)
	{
		try
		{
				_q_provider_event_relation.setLong(1, getLongNumber(pRelation.getId()));
				_q_provider_event_relation.setInt(2, getIntNumber(pRelation.getVersion()));
				_q_provider_event_relation.setLong(3, getLongNumber(pRelation.getProviderId()));
				_q_provider_event_relation.setLong(4, getLongNumber(pRelation.getEventId()));
				_q_provider_event_relation.setTimestamp(5, getDate(pRelation.getStartTime()));
				_q_provider_event_relation.setTimestamp(6, getDate(pRelation.getEndTime()));
				_q_provider_event_relation.setInt(7, getIntNumber(pRelation.getTimeQualityRank()));
				_q_provider_event_relation.setBoolean(8, getDecision(pRelation.getOffersLiveOdds()));
				_q_provider_event_relation.setBoolean(9, getDecision(pRelation.isOffersLiveTV()));
				_q_provider_event_relation.executeUpdate();
				connection.commit();
				controller.getQueue().setText("Provider Event Relation Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//sport table 9
	public void insertInSportTable(Sport sport)
	{
		try
		{
			_q_sport.setLong(1, getLongNumber(sport.getId()));
			_q_sport.setInt(2, getIntNumber(sport.getVersion()));
			_q_sport.setString(3, sport.getName());
			_q_sport.setString(4, sport.getDescription());
			_q_sport.setLong(5, getLongNumber(sport.getParentId()));
			_q_sport.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Sport Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//provider 10
	public void insertInProviderTable(Provider provider)
	{
		try
		{
			_q_provider.setLong(1, getLongNumber(provider.getId()));
			_q_provider.setInt(2, getIntNumber(provider.getVersion()));
			_q_provider.setString(3, provider.getName());
			_q_provider.setLong(4, getLongNumber(provider.getLocationId()));
			_q_provider.setString(5, provider.getUrl());
			_q_provider.setBoolean(6, getDecision(provider.getIsBookmaker()));
			_q_provider.setBoolean(7, getDecision(provider.getIsBettingExchange()));
			_q_provider.setFloat(8, getFloatNumber(provider.getBettingCommissionVACs()));
			_q_provider.setBoolean(9, getDecision(provider.getIsLiveOddsApproved()));
			_q_provider.setBoolean(10, getDecision(provider.getIsNewsSource()));
			_q_provider.setBoolean(11, getDecision(provider.getIsEnabled()));
			_q_provider.setString(12, provider.getNote());
			_q_provider.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Provider Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//event participant relation 11
	public void insertInEventParticipantRelationTable(EventParticipantRelation eventParticipantRelation)
	{
		try
		{
				_q_event_participant_relation.setLong(1, getLongNumber(eventParticipantRelation.getId()));
				_q_event_participant_relation.setInt(2, getIntNumber(eventParticipantRelation.getVersion()));
				_q_event_participant_relation.setLong(3, getLongNumber(eventParticipantRelation.getEventId()));
				_q_event_participant_relation.setLong(4, getLongNumber(eventParticipantRelation.getEventPartId()));
				_q_event_participant_relation.setLong(5, getLongNumber(eventParticipantRelation.getParticipantId()));
				_q_event_participant_relation.setLong(6, getLongNumber(eventParticipantRelation.getParticipantRoleId()));
				_q_event_participant_relation.setLong(7, getLongNumber(eventParticipantRelation.getParentParticipantId()));
				_q_event_participant_relation.executeUpdate();
				connection.commit();
				controller.getQueue().setText("EventParticipantRelation Batch inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}

		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//provider 12
	public void insertInEventParticipantRestrictionTable(EventParticipantRestriction eventParticipantRestriction)
	{
		try
		{
				_q_event_participant_restriction.setLong(1, getLongNumber(eventParticipantRestriction.getId()));
				_q_event_participant_restriction.setInt(2, getIntNumber(eventParticipantRestriction.getVersion()));
				_q_event_participant_restriction.setLong(3, getLongNumber(eventParticipantRestriction.getEventId()));
				_q_event_participant_restriction.setLong(4, getLongNumber(eventParticipantRestriction.getParticipantTypeId()));
				_q_event_participant_restriction.setBoolean(5, getDecision(eventParticipantRestriction.getParticipantIsMale()));
				_q_event_participant_restriction.setInt(6, getIntNumber(eventParticipantRestriction.getParticipantMinAge()));
				_q_event_participant_restriction.setInt(7, getIntNumber(eventParticipantRestriction.getParticipantMaxAge()));
				_q_event_participant_restriction.setLong(8, getLongNumber(eventParticipantRestriction.getParticipantPartOfLocationId()));
				_q_event_participant_restriction.executeUpdate();
				connection.commit();
				controller.getQueue().setText("EventParticipantRestriction Batch inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}
	}




	@Override
	public long getLongNumber(Long number)
	{
		return (number == null ? 0 : number);
	}

	@Override
	public boolean getDecision(Boolean bool)
	{
		return (bool == null ? false : bool);
	}


	@Override
	public Timestamp getDate(java.util.Date date)
	{
		return (date == null) ? null : new Timestamp(date.getTime());
	}


	@Override
	public int getIntNumber(Integer number)
	{
		return (number == null ? -1 : number); 
	}


	@Override
	public float getFloatNumber(Float number)
	{
		return (number == null ? -1 : number);
	}
}
