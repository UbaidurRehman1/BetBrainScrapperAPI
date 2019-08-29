package com.ubaid.app.model.insert;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.Table;

public class DoInsertion implements Runnable
{

	protected Table tableName;
	protected Controller controller;
	
	public DoInsertion(Table tableName, Controller controller)
	{
		this.controller = controller;
		this.tableName = tableName;
	}
	
	@Override
	public void run()
	{
		switch (tableName)
		{
		case Event:
			controller.getInsertInToEvent().insertInEventTable(controller.getEvents_());
			break;
		case EventPart:
			controller.getInsertInToEvent().insertInEventPartTable(controller.getEventParts_());
			break;
		case EventTemplate:
			controller.getInsertInToEvent().insertInEventTemplateTable(controller.getEventTemplates_());
			break;
		case EventTypeUsage:
			controller.getInsertInToEvent().insertInEventTypeUsageTable(controller.getEventTypeUsages_());
			break;
		case EventPartDefaultUsage:
			controller.getInsertInToEvent().insertInEventPartDefaultUsageTable(controller.getEventPartDefaultUsages_());
			break;
		case EVentType:
			controller.getInsertInToEvent().insertInEventTypeTable(controller.getEventTypes_());
			break;
		case EventStatus:
			controller.getInsertInToEvent().insertInEventStatusTable(controller.getEventStatus_());
			break;
		case EventParticipantRelation:
			controller.getInsertInToEvent().insertInEventParticipantRelationTable(controller.getEventParticipantRelations_());
			break;
		case EventParticipantRestriction:
			controller.getInsertInToEvent().insertInEventParticipantRestrictionTable(controller.getEventParticipantRestrictions_());
			break;
		case ProviderEventRelation:
			controller.getInsertInToEvent().insertInProviderEventRelationTable(controller.getProviderEventRelations_());
			break;
		case Sport:
			controller.getInsertInToEvent().insertInSportTable(controller.getSports_());
			break;
		case Provider:
			controller.getInsertInToEvent().insertInProviderTable(controller.getProviders_());
			break;
		case Location:
			controller.getInsertInToLocation().insertInLocationTable(controller.getLocations_());
			break;
		case LocationType:
			controller.getInsertInToLocation().insertInLocationTypeTable(controller.getLocationTypes_());
			break;
		case LocationRelation:
			controller.getInsertInToLocation().insertInLocationRelationTable(controller.getLocationRelations_());
			break;
		case LocationRelationType:
			controller.getInsertInToLocation().insertInLocationRelationTypeTable(controller.getLocationRelationTypes_());
			break;
		case BettingOffer:
			controller.getInsertInToBetting().insertIntoBettingOfferTable(controller.getBettingOffers_());
			break;
		case BettingOfferStatus:
			controller.getInsertInToBetting().insertIntoBettingOfferStatusTable(controller.getBettingOfferStatus_());
			break;
		case BettingType:
			controller.getInsertInToBetting().insertIntoBettingTypeTable(controller.getBettingTypes_());
			break;
		case BettingTypeUsage:
			controller.getInsertInToBetting().insertIntoBettingTypeUsageTable(controller.getBettingTypeUsages_());
			break;
		case Outcome:
			controller.getInsertInToBetting().insertIntoOutcomeTable(controller.getOutcomes_());
			break;
		case OUtcomeStatus:
			controller.getInsertInToBetting().insertIntoOutcomeStatusTable(controller.getOutcomeStatus_());
			break;
		case OutcomeType:
			controller.getInsertInToBetting().insertIntoOutcomTypeTable(controller.getOutcomeTypes_());
			break;
		case OutcomeTypeUsage:
			controller.getInsertInToBetting().insertIntoOutcomeTypeUsageTable(controller.getOutcomeTypeUsages_());
			break;
		case OutcomeTypeBettingTypeRelation:
			controller.getInsertInToBetting().insertIntoOutcomeTypeBettingTypeRelationTable(controller.getOutcomeTypeBettingTypeRelations_());
			break;
		case Source:
			controller.getInsertInToBetting().insertIntoSourceTable(controller.getSources_());
			break;
		case Participant:
			controller.getInsertIntoParticipant().insertInParticipantTable(controller.getParticipants_());
			break;
		case ParticipantUsage:
			controller.getInsertIntoParticipant().insertInParticipantUsageTable(controller.getParticipantUsages_());
			break;
		case ParticipantRole:
			controller.getInsertIntoParticipant().insertInParticipantRoleTable(controller.getParticipantRoles_());
			break;
		case ParticipantTypeRoleUsage:
			controller.getInsertIntoParticipant().insertInParticipantTypeRoleUsageTable(controller.getParticipantTypeRoleUsages_());
			break;
		case ParticipantType:
			controller.getInsertIntoParticipant().insertInParticipantTypeTable(controller.getParticipantTypes_());
			break;
		case ParticipantRelationType:
			controller.getInsertIntoParticipant().insertInParticipantRelationTypeTable(controller.getParticipantRelationTypes_());
			break;
		default:
			break;
		}
	}
	
}