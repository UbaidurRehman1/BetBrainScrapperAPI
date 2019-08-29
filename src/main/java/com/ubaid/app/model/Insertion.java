package com.ubaid.app.model;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.betbrain.sepc.connector.sportsmodel.BettingOffer;
import com.betbrain.sepc.connector.sportsmodel.BettingOfferStatus;
import com.betbrain.sepc.connector.sportsmodel.BettingType;
import com.betbrain.sepc.connector.sportsmodel.BettingTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Entity;
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
import com.ubaid.app.model.indexing.UnIndexing;
import com.ubaid.app.model.insert.DoInsertion;
import com.ubaid.app.model.insert.RefiningList;
import com.ubaid.app.model.update.Update;



public class Insertion implements Runnable
{

	Controller controller;
	List<? extends Entity> entities;
	int startIndex;
	ExecutorService threadPool = Executors.newFixedThreadPool(33);
	ExecutorService refiningThread = Executors.newFixedThreadPool(33);
	ExecutorService indexingThread = Executors.newFixedThreadPool(1);
	int i = 0;

	
	public Insertion(List<? extends Entity> entities, Controller controller, int startIndex)
	{
		this.entities = entities;
		this.controller = controller;
		controller.setTotal_entities(entities.size());
		controller.setInsertionThreadPool(threadPool);
		controller.setIndexingThreadPool(indexingThread);
		this.startIndex = startIndex;
	}
	
	
	@Override
	public void run()
	{
		try
		{	
			//loop which sets entities to their respective linked lists
			for(Entity entity : entities)
			{				
				if(entity instanceof Event)
				{
					controller.getEvents_().add((Event) entity);
				}
				else if(entity instanceof EventTypeUsage)
				{
					controller.getEventTypeUsages_().add((EventTypeUsage) entity);
				}
				else if(entity instanceof EventTemplate)
				{
					controller.getEventTemplates_().add((EventTemplate) entity);
				}
				else if(entity instanceof EventPartDefaultUsage)
				{
					controller.getEventPartDefaultUsages_().add((EventPartDefaultUsage) entity);
				}
				else if(entity instanceof EventPart)
				{
					controller.getEventParts_().add((EventPart) entity);
				}
				else if(entity instanceof ProviderEventRelation)
				{
					controller.getProviderEventRelations_().add((ProviderEventRelation) entity);
				}
				else if(entity instanceof EventType)
				{
					controller.getEventTypes_().add((EventType) entity);
				}
				else if(entity instanceof EventStatus)
				{
					controller.getEventStatus_().add((EventStatus) entity);
				}
				else if(entity instanceof Sport)
				{
					controller.getSports_().add((Sport) entity);
				}
				else if(entity instanceof Provider)
				{
					controller.getProviders_().add((Provider) entity);
				}
				else if(entity instanceof EventParticipantRelation)
				{
					controller.getEventParticipantRelations_().add((EventParticipantRelation) entity);
				}
				else if(entity instanceof EventParticipantRestriction)
				{
					controller.getEventParticipantRestrictions_().add((EventParticipantRestriction) entity);
				}
				
				//*************************location*********************conditions
				else if(entity instanceof Location)
				{
					controller.getLocations_().add((Location) entity);
				}
				else if(entity instanceof LocationType)
				{
					controller.getLocationTypes_().add((LocationType) entity);
				}
				else if(entity instanceof LocationRelation)
				{
					controller.getLocationRelations_().add((LocationRelation) entity);
				}
				else if(entity instanceof LocationRelationType)
				{
					controller.getLocationRelationTypes_().add((LocationRelationType) entity);
				}
				
				//**************************betting***************************conditions
				else if(entity instanceof BettingOffer)
				{
					controller.getBettingOffers_().add((BettingOffer) entity);
				}
				else if(entity instanceof BettingOfferStatus)
				{
					controller.getBettingOfferStatus_().add((BettingOfferStatus) entity);
				}
				else if(entity instanceof BettingType)
				{
					controller.getBettingTypes_().add((BettingType) entity);
				}
				else if(entity instanceof BettingTypeUsage)
				{
					controller.getBettingTypeUsages_().add((BettingTypeUsage) entity);
				}
				else if(entity instanceof Outcome)
				{
					controller.getOutcomes_().add((Outcome) entity);
				}
				else if(entity instanceof OutcomeStatus)
				{
					controller.getOutcomeStatus_().add((OutcomeStatus) entity);
				}
				else if(entity instanceof OutcomeType)
				{
					controller.getOutcomeTypes_().add((OutcomeType) entity);
				}
				else if(entity instanceof OutcomeTypeUsage)
				{
					controller.getOutcomeTypeUsages_().add((OutcomeTypeUsage) entity);
				}
				else if(entity instanceof OutcomeTypeBettingTypeRelation)
				{
					controller.getOutcomeTypeBettingTypeRelations_().add((OutcomeTypeBettingTypeRelation) entity);
				}
				else if(entity instanceof Source)
				{
					controller.getSources_().add((Source) entity);
				}
				//------------------------------------------Participant----------------------------------//
				else if(entity instanceof Participant)
				{
					controller.getParticipants_().add((Participant) entity);
				}
				else if(entity instanceof ParticipantUsage)
				{
					controller.getParticipantUsages_().add((ParticipantUsage) entity);
				}
				else if(entity instanceof ParticipantRole)
				{
					controller.getParticipantRoles_().add((ParticipantRole) entity);
				}
				else if(entity instanceof ParticipantTypeRoleUsage)
				{
					controller.getParticipantTypeRoleUsages_().add((ParticipantTypeRoleUsage) entity);
				}
				else if(entity instanceof ParticipantType)
				{
					controller.getParticipantTypes_().add((ParticipantType) entity);
				}
				else if(entity instanceof ParticipantRelation)
				{
					controller.getParticipantRelations_().add((ParticipantRelation) entity);
				}
				else if(entity instanceof ParticipantRelationType)
				{
					controller.getParticipantRelationTypes_().add((ParticipantRelationType) entity);
				}
								
			}
			
			//refining lists
			controller.getQueue().setIndex("Refining Lists");
			
			for (Table table : Table.values())
			{
				 refiningThread.execute(new RefiningList(table, controller));
			}
			
			refiningThread.shutdown();

			
			//this loop break after refining complete
			while(true)
			{
				if(refiningThread.isTerminated())
				{
					controller.getQueue().setIndex("Refining Complete");
					break;					
				}
				else
				{	
					Thread.sleep(2000);
					controller.getQueue().setIndex("Refining");
				}
			}

			
			
			//unindexing
			ExecutorService executorService = Executors.newFixedThreadPool(1);
			executorService.execute(new UnIndexing(controller));
			executorService.shutdown();
			
			while(true)
			{
				if(executorService.isTerminated())
				{
					controller.getQueue().setIndex("Un Indexing Complete");
					break;
				}
				else
				{
					controller.getQueue().setIndex("UnIndexing");
					Thread.sleep(1000);
				}
			}
			
									
			//after complete the insertion in linked list, then inserting in database		
			for (Table table : Table.values())
			{
				 threadPool.execute(new DoInsertion(table, controller));
			}
			threadPool.shutdown();
			
			
			while(true)
			{
				if(threadPool.isTerminated())
				{
					controller.getQueue().setIndex("Insertion is completed");
					break;
				}
				else
				{
					controller.getQueue().setIndex("Insertion is being done");
					Thread.sleep(5000);
				}
			}
			
			//after insertion completed, then execute update 
			//update has a loop which will indeterminately runs
			ExecutorService updatingPool = Executors.newFixedThreadPool(1);
			updatingPool.execute(new Update(controller));
			updatingPool.shutdown();
	
		}
		catch(Exception exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}

	}	
}
