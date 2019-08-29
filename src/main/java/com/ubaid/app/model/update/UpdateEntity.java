package com.ubaid.app.model.update;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.betbrain.sepc.connector.sportsmodel.BettingOffer;
import com.betbrain.sepc.connector.sportsmodel.BettingOfferStatus;
import com.betbrain.sepc.connector.sportsmodel.BettingType;
import com.betbrain.sepc.connector.sportsmodel.BettingTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Event;
import com.betbrain.sepc.connector.sportsmodel.EventPart;
import com.betbrain.sepc.connector.sportsmodel.EventPartDefaultUsage;
import com.betbrain.sepc.connector.sportsmodel.EventParticipantRelation;
import com.betbrain.sepc.connector.sportsmodel.EventParticipantRestriction;
import com.betbrain.sepc.connector.sportsmodel.EventStatus;
import com.betbrain.sepc.connector.sportsmodel.EventTemplate;
import com.betbrain.sepc.connector.sportsmodel.EventType;
import com.betbrain.sepc.connector.sportsmodel.EventTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Location;
import com.betbrain.sepc.connector.sportsmodel.LocationRelation;
import com.betbrain.sepc.connector.sportsmodel.LocationRelationType;
import com.betbrain.sepc.connector.sportsmodel.LocationType;
import com.betbrain.sepc.connector.sportsmodel.Outcome;
import com.betbrain.sepc.connector.sportsmodel.OutcomeStatus;
import com.betbrain.sepc.connector.sportsmodel.OutcomeType;
import com.betbrain.sepc.connector.sportsmodel.OutcomeTypeBettingTypeRelation;
import com.betbrain.sepc.connector.sportsmodel.OutcomeTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Participant;
import com.betbrain.sepc.connector.sportsmodel.ParticipantRelation;
import com.betbrain.sepc.connector.sportsmodel.ParticipantRelationType;
import com.betbrain.sepc.connector.sportsmodel.ParticipantRole;
import com.betbrain.sepc.connector.sportsmodel.ParticipantType;
import com.betbrain.sepc.connector.sportsmodel.ParticipantTypeRoleUsage;
import com.betbrain.sepc.connector.sportsmodel.ParticipantUsage;
import com.betbrain.sepc.connector.sportsmodel.Provider;
import com.betbrain.sepc.connector.sportsmodel.ProviderEventRelation;
import com.betbrain.sepc.connector.sportsmodel.Source;
import com.betbrain.sepc.connector.sportsmodel.Sport;
import com.ubaid.app.controller.Controller;

/**
 * this class execute the 
 * statement from the queue (UpdateQueriesQueue)
 * @author ubaid
 *
 */
public class UpdateEntity implements Runnable
{
	protected Controller controller;
	protected Connection connection;
	
	public UpdateEntity(Controller controller)
	{
		this.controller = controller;
		this.connection = controller.getDatabase2().connection;
	}

	@Override
	public void run()
	{
		Statement statement = null;
		try
		{
			statement = connection.createStatement();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}

		while(controller.isUpdateEntity())
		{
			Object q = null;
			
			try
			{
				q = controller.getUpdateQueries().take().get();

					
				if(q instanceof String)
				{
					if(q != null)
					{
						statement.executeUpdate((String) q);	
					}					
				}
				else if(q instanceof Outcome)
					controller.getInsertInToBetting().insertIntoOutcomeTable((Outcome) q);
				else if(q instanceof EventTemplate)
					controller.getInsertInToEvent().insertInEventTemplateTable((EventTemplate) q);
				else if(q instanceof Event)
					controller.getInsertInToEvent().insertInEventTable((Event) q);
				else if(q instanceof EventPart)
					controller.getInsertInToEvent().insertInEventPartTable((EventPart) q);
				else if(q instanceof EventTypeUsage)
					controller.getInsertInToEvent().insertInEventTypeUsageTable((EventTypeUsage) q);
				else if(q instanceof EventPartDefaultUsage)
					controller.getInsertInToEvent().insertInEventPartDefaultUsageTable((EventPartDefaultUsage) q);
				else if(q instanceof EventType)
					controller.getInsertInToEvent().insertInEventTypeTable((EventType) q);
				else if(q instanceof EventStatus)
					controller.getInsertInToEvent().insertInEventStatusTable((EventStatus) q);
				else if(q instanceof ProviderEventRelation)
					controller.getInsertInToEvent().insertInProviderEventRelationTable((ProviderEventRelation) q);
				else if(q instanceof Sport)
					controller.getInsertInToEvent().insertInSportTable((Sport) q);
				else if(q instanceof Provider)
					controller.getInsertInToEvent().insertInProviderTable((Provider) q);
				else if(q instanceof EventParticipantRelation)
					controller.getInsertInToEvent().insertInEventParticipantRelationTable((EventParticipantRelation) q);
				else if(q instanceof EventParticipantRestriction)
					controller.getInsertInToEvent().insertInEventParticipantRestrictionTable((EventParticipantRestriction) q);
				
				else if(q instanceof Location)
					controller.getInsertInToLocation().insertInLocationTable((Location) q);
				else if(q instanceof LocationType)
					controller.getInsertInToLocation().insertInLocationTypeTable((LocationType) q);
				else if(q instanceof LocationRelation)
					controller.getInsertInToLocation().insertInLocationRelationTable((LocationRelation) q);
				else if(q instanceof LocationRelationType)
					controller.getInsertInToLocation().insertInLocationRelationTypeTable((LocationRelationType) q);
				
				else if(q instanceof BettingOffer)
					controller.getInsertInToBetting().insertIntoBettingOfferTable((BettingOffer) q);
				else if(q instanceof BettingOfferStatus)
					controller.getInsertInToBetting().insertIntoBettingOfferStatusTable((BettingOfferStatus) q);
				else if(q instanceof BettingType)
					controller.getInsertInToBetting().insertIntoBettingTypeTable((BettingType) q);
				else if(q instanceof BettingTypeUsage)
					controller.getInsertInToBetting().insertIntoBettingTypeUsageTable((BettingTypeUsage) q);
				else if(q instanceof OutcomeStatus)
					controller.getInsertInToBetting().insertIntoOutcomeStatusTable((OutcomeStatus) q);
				else if(q instanceof OutcomeType)
					controller.getInsertInToBetting().insertIntoOutcomTypeTable((OutcomeType) q);
				else if(q instanceof OutcomeTypeUsage)
					controller.getInsertInToBetting().insertIntoOutcomeTypeUsageTable((OutcomeTypeUsage) q);
				else if(q instanceof OutcomeTypeBettingTypeRelation)
					controller.getInsertInToBetting().insertIntoOutcomeTypeBettingTypeRelationTable((OutcomeTypeBettingTypeRelation) q);
				else if(q instanceof Source)
					controller.getInsertInToBetting().insertIntoSourceTable((Source) q);

				else if(q instanceof Participant)
					controller.getInsertIntoParticipant().insertInParticipantTable((Participant) q);
				else if(q instanceof ParticipantUsage)
					controller.getInsertIntoParticipant().insertInParticipantUsageTable((ParticipantUsage) q);
				else if(q instanceof ParticipantRole)
					controller.getInsertIntoParticipant().insertInParticipantRoleTable((ParticipantRole) q);
				else if(q instanceof ParticipantTypeRoleUsage)
					controller.getInsertIntoParticipant().insertInParticipantTypeRoleUsageTable((ParticipantTypeRoleUsage) q);
				else if(q instanceof ParticipantType)
					controller.getInsertIntoParticipant().insertInParticipantTypeTable((ParticipantType) q);
				else if(q instanceof ParticipantRelation)
					controller.getInsertIntoParticipant().insertInParticipantRelationTable((ParticipantRelation) q);
				else if(q instanceof ParticipantRelationType)
					controller.getInsertIntoParticipant().insertInParticipantRelationTypeTable((ParticipantRelationType) q);
	
				controller.getQueue().setIndex("Entity Updated: Remainng: " + controller.getUpdateQueries().size());
			}
			catch (SQLException e)
			{
				controller.getQueue().setText(e.toString(), controller.getQueue().getEntityIndex());
			}
			catch (InterruptedException e)
			{
				controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
			}
			
		}
		
	}
	
	
}
