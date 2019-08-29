package com.ubaid.app.model.insert;

import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.Table;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementForDelete;

public class RefiningList extends PreparedStatementForDelete implements Runnable
{
	
	protected Table table;
	protected Controller controller;
	
	public RefiningList(Table table, Controller controller)
	{
		super(controller);
		this.table = table;
		this.controller = controller;
		
	}
	
	@Override
	public void run()
	{
		try
		{
			switch (table)
			{
			case Event:
				//delete
				if(controller.isEvents_ids())
				{
					_q_event_delete.execute();
					connection.commit();
				}
				break;
			case EventPart:
				if(controller.isEventParts_ids())
				{
					_q_event_part_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case EventTemplate:
				if(controller.isEventTemplates_ids())
				{
					_q_event_template_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case EventTypeUsage:
				if(controller.isEventTypeUsages_ids())
				{
					_q_event_type_usage_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case EventPartDefaultUsage:
				if(controller.isEventPartDefaultUsages_ids())
				{
					_q_event_part_default_usage_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case EVentType:
				if(controller.isEventTypes_ids())
				{
					_q_event_type_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case EventStatus:
				if(controller.isEventStatus_ids())
				{
					_q_event_status_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case ProviderEventRelation:
				if(controller.isProviderEventRelations_ids())
				{
					_q_provider_event_relation_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case Sport:
				if(controller.isSports_ids())
				{
					_q_sport_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case Provider:
				if(controller.isProviders_ids())
				{
					_q_provider_delete.execute();
					connection.commit();
				}
				//delete
				break;	
			case EventParticipantRelation:
				if(controller.isEvent_participant_relation_ids())
				{
					_q_event_participant_relation_delete.execute();
					connection.commit();
				}
				//delete
				break;				
			case EventParticipantRestriction:
				if(controller.isEvent_participant_restriction_ids())
				{
					_q_event_participant_restriction_delete.execute();
					connection.commit();
				}
				//delete
				break;				
			case Location:
				if(controller.isLocations_ids())
				{
					_q_location_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case LocationType:
				if(controller.isLocationTypes_ids())
				{
					_q_location_type_delete.execute();
					connection.commit();
					
				}
				//delete
				break;
			case LocationRelation:
				if(controller.isLocationRelations_ids())
				{
					_q_location_relation_delete.execute();
					connection.commit();
					
				}
				//delete
				break;
			case LocationRelationType:
				if(controller.isLocationRelationTypes_ids())
				{
					_q_location_relation_type_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case BettingOffer:
				if(controller.isBettingOffers_ids())
				{
					_q_betting_offer_delete.execute();
					connection.commit();
				}
				//delete
				break;		
			case BettingOfferStatus:
				if(controller.isBettingOfferStatus_ids())
				{
					_q_betting_offer_status_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case BettingType:
				if(controller.isBettingTypes_ids())
				{
					_q_betting_type_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case BettingTypeUsage:
				if(controller.isBettingTypeUsages_ids())
				{
					_q_betting_type_usage_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case Outcome:
				if(controller.isOutcomes_ids())
				{
					_q_outcome_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case OUtcomeStatus:
				if(controller.isOutcomeStatus_ids())
				{
					_q_outcome_status_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case OutcomeType:
				if(controller.isOutcomeTypes_ids())
				{
					_q_outcome_type_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case OutcomeTypeUsage:
				if(controller.isOutcomeTypeUsages_ids())
				{
					_q_outcome_type_usage_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case OutcomeTypeBettingTypeRelation:
				if(controller.isOutcomeTypeBettingTypeRelations_ids())
				{
					_q_outcome_type_betting_type_relation_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case Source:
				if(controller.isSources_ids())
				{
					_q_source_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case Participant:
				if(controller.isParticipant_ids())
				{
					_q_participant_delete.execute();
					connection.commit();
				}
				//delete participant from the database
				break;
			case ParticipantUsage:
				if(controller.isParticipant_usage_ids())
				{
					_q_participant_usage_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case ParticipantRole:
				if(controller.isParticipant_role_ids())
				{
					_q_participant_role_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case ParticipantTypeRoleUsage:
				if(controller.isParticipant_type_role_usage_ids())
				{
					_q_participant_type_role_usage_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case ParticipantType:
				if(controller.isParticipant_type_ids())
				{
					_q_participant_type_delete.execute();
					connection.commit();
				}
				//delete
				break;
			case ParticipantRelation:
				if(controller.isParticipant_relation_ids())
				{
					_q_participant_relation_delete.execute();
					connection.commit();
					//delete
				}
				break;
			case ParticipantRelationType:
				if(controller.isParticipant_relation_type_ids())
				{
					_q_participant_relation_type_delete.execute();
					connection.commit();
					//delete					
				}
				break;
			case OddsHistory:
				if(controller.isOdds_history_ids())
				{
					_q_odds_history_delete.execute();
					connection.commit();
				}
			default:
				break;
			}
			
		}
		catch(SQLException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(Exception exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}

	}
}

