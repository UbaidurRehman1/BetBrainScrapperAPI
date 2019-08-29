package com.ubaid.app.model.update;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.betbrain.sepc.connector.sportsmodel.BettingOffer;
import com.betbrain.sepc.connector.sportsmodel.BettingOfferStatus;
import com.betbrain.sepc.connector.sportsmodel.BettingType;
import com.betbrain.sepc.connector.sportsmodel.BettingTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.EntityChange;
import com.betbrain.sepc.connector.sportsmodel.EntityChangeBatch;
import com.betbrain.sepc.connector.sportsmodel.EntityCreate;
import com.betbrain.sepc.connector.sportsmodel.EntityDelete;
import com.betbrain.sepc.connector.sportsmodel.EntityUpdate;
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
import com.ubaid.app.model.execution.Q;
import com.ubaid.app.model.indexing.DoIndexing;

public class Update implements Runnable
{

	protected Controller controller;
	protected boolean insertion_flag = false;
	protected int i = 0;
	
	public Update(Controller controller)
	{
		this.controller = controller;
	}

	
	private String quiryBuilder(String tableName, List<String> names, List<Object> objects, long id)
	{
		String q = "UPDATE " + tableName + " SET ";
		for(int i = 0; i < names.size(); i++)
		{
			if(objects.get(i) == null || objects.get(i).toString().trim() == "true" || objects.get(i).toString().trim() == "false")
			{
				q +=  names.get(i) + " = " + objects.get(i) +  ", "; 					
			}
			else
			{
				q +=  names.get(i) + " = '" + objects.get(i) +  "', "; 	

			}
		}
		q = q.substring(0, q.length() - 2);
		q += " WHERE id = " + id + ";";
		return q;
	}
	
	private String quiryBuilder(EntityChange entityChange)
	{
		EntityDelete entityDelete = (EntityDelete) entityChange;
		String className = entityDelete.getEntityClass().getSimpleName();
		long id = entityDelete.getEntityId();
		return String.format("DELETE FROM %s WHERE id = %o;", className, id);
	}
	
	private String quiryBuilderForOddsHistory(String tableName, List<String> names, List<Object> objects, long id)
	{
		Object odds = null;
		Object timeChanged = null;
		
		for(int i = 0; i < names.size(); i++)
		{
			if(names.get(i).toLowerCase().equals("odds"))
			{
				odds = objects.get(i);
			}
			else if(names.get(i).toLowerCase().equals("lastchangedtime"))
			{
				timeChanged = objects.get(i);
			}
		}

		if(odds == null)
			return null;
		
		long eventId = controller.getInsertIntoOddsHistory().getEventIDOnBettingTypeID(id);
		long eventTypeId = controller.getInsertIntoOddsHistory().getEventTypeIDOnEventID(eventId);
		String bettingTypeName = controller.getInsertIntoOddsHistory().getBettingTypeNameOnBettingOfferID(id);
		float thresHold = controller.getInsertIntoOddsHistory().getThresHoldOnBettingOfferID(id);
		String sportName = controller.getInsertIntoOddsHistory().getSportNameOnEventID(eventId);
		
		String q = "INSERT INTO " + tableName + "(bettingOfferId, odds, timeChanged, eventTypeId,"
				+ " eventId, bettingTypeName, threshold, sportName)"
				+ " VALUES(" + id + ", " + odds  + ", '" + timeChanged + "', " + eventTypeId + ", "
				+ eventId + ", '" + bettingTypeName + "', " + thresHold + ", '" + sportName +  "');";
		return q;
	}

	
	
	private void runUpdateEntity() throws InterruptedException
	{
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(new DoIndexing(controller));
		executorService.shutdown();
		
		while(true)
		{
			if(executorService.isTerminated())
			{
				controller.setUpdateEntity(true);
				ExecutorService executorService2 = Executors.newFixedThreadPool(1);
				executorService2.execute(controller.getUpdateEntity());
				executorService2.shutdown();	
				controller.getQueue().setIndex("Indexing Complete");
				break;
			}
			else
			{
				controller.getQueue().setIndex("Indexing");
				Thread.sleep(1000);
			}
		}		
	}
	
	@Override
	public void run()
	{
		try
		{
			//this method execute the UpdateEntityClass
			//update entity means, delete and update
			runUpdateEntity();
			
			//runing for unlimited
			for(;;)
			{
				EntityChangeBatch entityChangeBatch = controller.getEntityChangeBatchs_queue().take();
				
				for(EntityChange change : entityChangeBatch.getEntityChanges())
				{
					try
					{
						if(change.getEntityClass().equals(Event.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Event", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Event event = (Event) create.getEntity();
								controller.getUpdateQueries().put(new Q(event));										
							}
						}
						else if(change.getEntityClass().equals(EventPart.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventPart", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventPart eventPart = (EventPart) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventPart));										
							}
						}
						else if(change.getEntityClass().equals(EventTemplate.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventTemplate", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventTemplate eventTemplate = (EventTemplate) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventTemplate));										
							}
						}
						else if(change.getEntityClass().equals(EventTypeUsage.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventTypeUsage", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventTypeUsage eventTypeUsage = (EventTypeUsage) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventTypeUsage));										
							}
						}
						else if(change.getEntityClass().equals(EventPartDefaultUsage.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventPartDefaultUsage", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventPartDefaultUsage eventPartDefaultUsage = (EventPartDefaultUsage) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventPartDefaultUsage));										
							}
						}
						else if(change.getEntityClass().equals(EventType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventType eventType = (EventType) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventType));										
							}
						}
						else if(change.getEntityClass().equals(EventStatus.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventStatus", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventStatus eventStatus = (EventStatus) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventStatus));										
							}
						}
						else if(change.getEntityClass().equals(ProviderEventRelation.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ProviderEventRelation", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ProviderEventRelation providerEventRelation = (ProviderEventRelation) create.getEntity();
								controller.getUpdateQueries().put(new Q(providerEventRelation));										
							}
						}
						else if(change.getEntityClass().equals(Sport.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Sport", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Sport sport = (Sport) create.getEntity();
								controller.getUpdateQueries().put(new Q(sport));																	
							}
						}
						else if(change.getEntityClass().equals(Provider.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Provider", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Provider provider = (Provider) create.getEntity();
								controller.getUpdateQueries().put(new Q(provider));										
							}
						}
						else if(change.getEntityClass().equals(EventParticipantRelation.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventParticipantRelation", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventParticipantRelation eventParticipantRelation = (EventParticipantRelation) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventParticipantRelation));										
							}
						}
						else if(change.getEntityClass().equals(EventParticipantRestriction.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("EventParticipantRestriction", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								EventParticipantRestriction eventParticipantRestriction = (EventParticipantRestriction) create.getEntity();
								controller.getUpdateQueries().put(new Q(eventParticipantRestriction));										
							}
						}
						else if(change.getEntityClass().equals(Location.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Location", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));		
		
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Location location = (Location) create.getEntity();
								controller.getUpdateQueries().put(new Q(location));										
							}
						}
						else if(change.getEntityClass().equals(LocationType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("LocationType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								LocationType locationType = (LocationType) create.getEntity();
								controller.getUpdateQueries().put(new Q(locationType));										
							}
						}
						else if(change.getEntityClass().equals(LocationRelation.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("LocationReation", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								LocationRelation locationRelation = (LocationRelation) create.getEntity();
								controller.getUpdateQueries().put(new Q(locationRelation));										
							}
						}
						else if(change.getEntityClass().equals(LocationRelationType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("LocationRelationType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								LocationRelationType locationRelationType = (LocationRelationType) create.getEntity();
								controller.getUpdateQueries().put(new Q(locationRelationType));										
							}
						}
						else if(change.getEntityClass().equals(BettingOffer.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("BettingOffer", list_name, list_value, entityUpdate.getEntityId());
								String q_1 = quiryBuilderForOddsHistory("oddshistory", list_name, list_value, entityUpdate.getEntityId());

								controller.getUpdateQueries().put(new Q(q));			
								controller.getUpdateQueries().put(new Q(q_1));
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								BettingOffer bettingOffer = (BettingOffer) create.getEntity();
								controller.getUpdateQueries().put(new Q(bettingOffer));										
							}
						}
						else if(change.getEntityClass().equals(BettingOfferStatus.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("BettingOfferStatus", list_name, list_value, entityUpdate.getEntityId());								
								controller.getUpdateQueries().put(new Q(q));	
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								BettingOfferStatus bettingOfferStatus = (BettingOfferStatus) create.getEntity();
								controller.getUpdateQueries().put(new Q(bettingOfferStatus));										
							}
						}
						else if(change.getEntityClass().equals(BettingType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("BettingType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								BettingType bettingType = (BettingType) create.getEntity();
								controller.getUpdateQueries().put(new Q(bettingType));										
							}
						}
						else if(change.getEntityClass().equals(BettingTypeUsage.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("BettingTypeUsage", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								BettingTypeUsage bettingTypeUsage = (BettingTypeUsage) create.getEntity();
								controller.getUpdateQueries().put(new Q(bettingTypeUsage));										
							}
						}
						else if(change.getEntityClass().equals(Outcome.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Outcome", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Outcome outcome = (Outcome) create.getEntity();
								controller.getUpdateQueries().put(new Q(outcome));										
							}
						}
						else if(change.getEntityClass().equals(OutcomeStatus.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("OutcomeStatus", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								OutcomeStatus outcomeStatus = (OutcomeStatus) create.getEntity();
								controller.getUpdateQueries().put(new Q(outcomeStatus));										
							}
						}
						else if(change.getEntityClass().equals(OutcomeType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("OutcomeType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								OutcomeType outcomeType = (OutcomeType) create.getEntity();
								controller.getUpdateQueries().put(new Q(outcomeType));										
							}
						}
						else if(change.getEntityClass().equals(OutcomeTypeUsage.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("OutcomeTypeUsage", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								OutcomeTypeUsage outcomeTypeUsage = (OutcomeTypeUsage) create.getEntity();
								controller.getUpdateQueries().put(new Q(outcomeTypeUsage));										
							}
						}
						else if(change.getEntityClass().equals(OutcomeTypeBettingTypeRelation.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("OutcomeTypeBettingTypeRelation", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								OutcomeTypeBettingTypeRelation outcomeTypeBettingTypeRelation = (OutcomeTypeBettingTypeRelation) create.getEntity();
								controller.getUpdateQueries().put(new Q(outcomeTypeBettingTypeRelation));										
							}
						}
						else if(change.getEntityClass().equals(Source.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Source", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Source source = (Source) create.getEntity();
								controller.getUpdateQueries().put(new Q(source));										
							}
						}
						else if(change.getEntityClass().equals(Participant.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("Participant", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								Participant entity = (Participant) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}
						else if(change.getEntityClass().equals(ParticipantUsage.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ParticipantUsage", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ParticipantUsage entity = (ParticipantUsage) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}
						else if(change.getEntityClass().equals(ParticipantRole.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ParticipantRole", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ParticipantRole entity = (ParticipantRole) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}
						else if(change.getEntityClass().equals(ParticipantTypeRoleUsage.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ParticipantTypeRoleUsage", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ParticipantTypeRoleUsage entity = (ParticipantTypeRoleUsage) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}
						else if(change.getEntityClass().equals(ParticipantType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ParticipantType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ParticipantType entity = (ParticipantType) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}
						else if(change.getEntityClass().equals(ParticipantRelation.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ParticipantRelation", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ParticipantRelation entity = (ParticipantRelation) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}
						else if(change.getEntityClass().equals(ParticipantRelationType.class))
						{
							if(change.getClass().equals(EntityUpdate.class))
							{
								EntityUpdate entityUpdate = (EntityUpdate) change;			
								List<String> list_name = entityUpdate.getPropertyNames();
								List<Object> list_value = entityUpdate.getPropertyValues();
								String q = quiryBuilder("ParticipantRelationType", list_name, list_value, entityUpdate.getEntityId());
								controller.getUpdateQueries().put(new Q(q));										
							}
							else if(change.getClass().equals(EntityDelete.class))
							{
								controller.getUpdateQueries().put(new Q(quiryBuilder(change)));
							}
							else if(change.getClass().equals(EntityCreate.class))
							{
								EntityCreate create = (EntityCreate) change;
								ParticipantRelationType entity = (ParticipantRelationType) create.getEntity();
								controller.getUpdateQueries().put(new Q(entity));										
							}
						}				
					}
					catch(Exception exp)
					{
						controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
					}
				}//ending of interal for loop
				
			}//ending of indeterminate loop
			
		}//ending try
		catch(InterruptedException exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(Exception exp)
		{
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		
	}//ending run method	
}
