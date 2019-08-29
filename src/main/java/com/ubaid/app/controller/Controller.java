package com.ubaid.app.controller;


import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.betbrain.sepc.connector.sportsmodel.BettingOffer;
import com.betbrain.sepc.connector.sportsmodel.BettingOfferStatus;
import com.betbrain.sepc.connector.sportsmodel.BettingType;
import com.betbrain.sepc.connector.sportsmodel.BettingTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.EntityChangeBatch;
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
import com.ubaid.app.model.database.Database2;
import com.ubaid.app.model.execution.Q;
import com.ubaid.app.model.insert.Location.InsertInToLocation;
import com.ubaid.app.model.insert.betting.InsertInToBetting;
import com.ubaid.app.model.insert.event.InsertInToEvent;
import com.ubaid.app.model.insert.oddshistory.InsertIntoOddsHistory;
import com.ubaid.app.model.insert.participant.InsertIntoParticipant;
import com.ubaid.app.model.logger.Queue;
import com.ubaid.app.model.retrieve.IDRetrieval;
import com.ubaid.app.model.update.UpdateEntity;



/**
 * controller class
 * responsible for 
 * interaction between model
 * and view
 * @author ubaid
 *
 */
public class Controller
{
	private ExecutorService threadPool = Executors.newFixedThreadPool(1);

	private InsertInToEvent insertInToEvent;
	private InsertInToLocation insertInToLocation;
	private InsertInToBetting insertInToBetting;
	private InsertIntoParticipant insertIntoParticipant;
	private InsertIntoOddsHistory insertIntoOddsHistory;
	
	private IDRetrieval idRetrieval;
	
	private Queue queue;
	private Database2 database2;

	
	private int total_entities;
	private boolean timeIsRunning = true;
	
	private LinkedList<Event> events_ = new LinkedList<>();
	private LinkedList<EventPart> eventParts_ = new LinkedList<>();
	private LinkedList<EventTemplate> eventTemplates_ = new LinkedList<>();
	private LinkedList<EventTypeUsage> eventTypeUsages_ = new LinkedList<>();
	private LinkedList<EventPartDefaultUsage> eventPartDefaultUsages_ = new LinkedList<>();
	private LinkedList<EventType> eventTypes_ = new LinkedList<>();
	private LinkedList<EventStatus> eventStatus_ = new LinkedList<>();
	private LinkedList<ProviderEventRelation> providerEventRelations_ = new LinkedList<>();
	private LinkedList<Sport> sports_ = new LinkedList<>();
	private LinkedList<Provider> providers_ = new LinkedList<>();
	private LinkedList<EventParticipantRelation> eventParticipantRelations_ = new LinkedList<>();
	private LinkedList<EventParticipantRestriction> eventParticipantRestrictions_ = new LinkedList<>();
	
	
	private LinkedList<Location> locations_ = new LinkedList<>();
	private LinkedList<LocationType> locationTypes_ = new LinkedList<>();
	private LinkedList<LocationRelation> locationRelations_ = new LinkedList<>();
	private LinkedList<LocationRelationType> locationRelationTypes_ = new LinkedList<>();
	
	private LinkedList<BettingOffer> bettingOffers_ = new LinkedList<>();
	private LinkedList<BettingOfferStatus> bettingOfferStatus_ = new LinkedList<>();
	private LinkedList<BettingType> bettingTypes_ = new LinkedList<>();
	private LinkedList<BettingTypeUsage> bettingTypeUsages_ = new LinkedList<>();
	private LinkedList<Outcome> outcomes_ = new LinkedList<>();
	private LinkedList<OutcomeStatus> outcomeStatus_ = new LinkedList<>();
	private LinkedList<OutcomeType> outcomeTypes_ = new LinkedList<>();
	private LinkedList<OutcomeTypeUsage> outcomeTypeUsages_ = new LinkedList<>();
	private LinkedList<OutcomeTypeBettingTypeRelation> outcomeTypeBettingTypeRelations_ = new LinkedList<>();
	private LinkedList<Source> sources_ = new LinkedList<>();

	
	private LinkedList<Participant> participants_ = new LinkedList<>();
	private LinkedList<ParticipantUsage> participantUsages_ = new LinkedList<>();
	private LinkedList<ParticipantRole> participantRoles_ = new LinkedList<>();
	private LinkedList<ParticipantTypeRoleUsage> participantTypeRoleUsages_ = new LinkedList<>();
	private LinkedList<ParticipantType> participantTypes_ = new LinkedList<>();
	private LinkedList<ParticipantRelation> participantRelations_ = new LinkedList<>();
	private LinkedList<ParticipantRelationType> participantRelationTypes_ = new LinkedList<>();

	private boolean events_ids = false;
	private boolean eventParts_ids = false;
	private boolean eventTemplates_ids = false;
	private boolean eventTypeUsages_ids = false;
	private boolean eventPartDefaultUsages_ids = false;
	private boolean eventTypes_ids = false;
	private boolean eventStatus_ids = false;
	private boolean providerEventRelations_ids = false;
	private boolean sports_ids = false;
	private boolean providers_ids = false;
	private boolean event_participant_relation_ids = false;
	private boolean event_participant_restriction_ids = false;
	
	private boolean locations_ids = false;
	private boolean locationTypes_ids = false;
	private boolean locationRelations_ids = false;
	private boolean locationRelationTypes_ids = false;
	
	private boolean bettingOffers_ids = false;
	private boolean bettingOfferStatus_ids = false;
	private boolean bettingTypes_ids = false;
	private boolean bettingTypeUsages_ids = false;
	private boolean outcomes_ids = false;
	private boolean outcomeStatus_ids = false;
	private boolean outcomeTypes_ids = false;
	private boolean outcomeTypeUsages_ids = false;
	private boolean outcomeTypeBettingTypeRelations_ids = false;
	private boolean sources_ids = false;
		
	private boolean participant_ids = false;
	private boolean participant_usage_ids = false;
	private boolean participant_role_ids = false;
	private boolean participant_type_role_usage_ids = false;
	private boolean participant_type_ids = false;
	private boolean participant_relation_ids = false;
	private boolean participant_relation_type_ids = false;

	private boolean odds_history_ids = false;
	
	private LinkedBlockingQueue<Q> updateQueries = new LinkedBlockingQueue<>();
	private LinkedBlockingQueue<EntityChangeBatch> entityChangeBatchs_queue = new LinkedBlockingQueue<>();
	
	private ExecutorService insertionThreadPool;
	private ExecutorService indexingThreadPool;


	private boolean isUpdateEntity = true;
	private UpdateEntity updateEntity;
	
	private boolean BulkDataAllowed = true;
	
	
	
	//constructor
	public Controller(Queue queue)
	{
		//assigning queue
		this.queue = queue;
		
		
		//initiate the logViewer
		//and setting in app


		
		
		//creating database
		database2 = new Database2(this);
			
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//initiating initiater class which do subprocesses
		Initiater initiater = new Initiater(this);
		threadPool.execute(initiater);
//		threadPool.execute(new QueueReader(queue, this));
		threadPool.shutdown();	
	}

	public InsertInToEvent getInsertInToEvent()
	{
		return insertInToEvent;
	}

	public void setInsertInToEvent(InsertInToEvent insertInToEvent)
	{
		this.insertInToEvent = insertInToEvent;
	}

	public InsertInToLocation getInsertInToLocation()
	{
		return insertInToLocation;
	}

	public void setInsertInToLocation(InsertInToLocation insertInToLocation)
	{
		this.insertInToLocation = insertInToLocation;
	}


	
	
	public Queue getQueue()
	{
		return queue;
	}

	public Database2 getDatabase()
	{
		return database2;
	}

	public InsertInToBetting getInsertInToBetting()
	{
		return insertInToBetting;
	}

	public void setInsertInToBetting(InsertInToBetting insertInToBetting) {
		this.insertInToBetting = insertInToBetting;
	}


	public int getTotal_entities() {
		return total_entities;
	}


	public void setTotal_entities(int total_entities) {
		this.total_entities = total_entities;
	}


	public boolean isTimeIsRunning() {
		return timeIsRunning;
	}


	public void setTimeIsRunning(boolean timeIsRunning) {
		this.timeIsRunning = timeIsRunning;
	}
	
	
	public ExecutorService getThreadPool() {
		return threadPool;
	}


	public Database2 getDatabase2() {
		return database2;
	}


	public LinkedList<Event> getEvents_() {
		return events_;
	}


	public LinkedList<EventPart> getEventParts_() {
		return eventParts_;
	}


	public LinkedList<EventTemplate> getEventTemplates_() {
		return eventTemplates_;
	}


	public LinkedList<EventTypeUsage> getEventTypeUsages_() {
		return eventTypeUsages_;
	}


	public LinkedList<EventPartDefaultUsage> getEventPartDefaultUsages_() {
		return eventPartDefaultUsages_;
	}


	public LinkedList<EventType> getEventTypes_() {
		return eventTypes_;
	}


	public LinkedList<EventStatus> getEventStatus_() {
		return eventStatus_;
	}


	public LinkedList<ProviderEventRelation> getProviderEventRelations_() {
		return providerEventRelations_;
	}


	public LinkedList<Sport> getSports_() {
		return sports_;
	}


	public LinkedList<Provider> getProviders_() {
		return providers_;
	}


	public LinkedList<Location> getLocations_() {
		return locations_;
	}


	public LinkedList<LocationType> getLocationTypes_() {
		return locationTypes_;
	}


	public LinkedList<LocationRelation> getLocationRelations_() {
		return locationRelations_;
	}


	public LinkedList<LocationRelationType> getLocationRelationTypes_() {
		return locationRelationTypes_;
	}


	public LinkedList<BettingOffer> getBettingOffers_() {
		return bettingOffers_;
	}


	public LinkedList<BettingOfferStatus> getBettingOfferStatus_() {
		return bettingOfferStatus_;
	}


	public LinkedList<BettingType> getBettingTypes_() {
		return bettingTypes_;
	}


	public LinkedList<BettingTypeUsage> getBettingTypeUsages_() {
		return bettingTypeUsages_;
	}


	public LinkedList<Outcome> getOutcomes_() {
		return outcomes_;
	}


	public LinkedList<OutcomeStatus> getOutcomeStatus_() {
		return outcomeStatus_;
	}


	public LinkedList<OutcomeType> getOutcomeTypes_() {
		return outcomeTypes_;
	}


	public LinkedList<OutcomeTypeUsage> getOutcomeTypeUsages_() {
		return outcomeTypeUsages_;
	}


	public LinkedList<OutcomeTypeBettingTypeRelation> getOutcomeTypeBettingTypeRelations_() {
		return outcomeTypeBettingTypeRelations_;
	}


	public LinkedList<Source> getSources_() {
		return sources_;
	}

	public IDRetrieval getIdRetrieval() {
		return idRetrieval;
	}

	public void setIdRetrieval(IDRetrieval idRetrieval) {
		this.idRetrieval = idRetrieval;
	}

	public LinkedBlockingQueue<Q> getUpdateQueries() {
		return updateQueries;
	}

	public ExecutorService getInsertionThreadPool() {
		return insertionThreadPool;
	}

	public void setInsertionThreadPool(ExecutorService insertionThreadPool) {
		this.insertionThreadPool = insertionThreadPool;
	}

	public ExecutorService getIndexingThreadPool() {
		return indexingThreadPool;
	}

	public void setIndexingThreadPool(ExecutorService indexingThreadPool) {
		this.indexingThreadPool = indexingThreadPool;
	}

	public LinkedBlockingQueue<EntityChangeBatch> getEntityChangeBatchs_queue() {
		return entityChangeBatchs_queue;
	}

	public boolean isUpdateEntity() {
		return isUpdateEntity;
	}

	public void setUpdateEntity(boolean isUpdateEntity) {
		this.isUpdateEntity = isUpdateEntity;
	}

	public void setUpdateEntity(UpdateEntity updateEntity)
	{
		this.updateEntity = updateEntity;
	}
	
	public UpdateEntity getUpdateEntity() {
		return updateEntity;
	}

	public LinkedList<EventParticipantRelation> getEventParticipantRelations_() {
		return eventParticipantRelations_;
	}

	public LinkedList<EventParticipantRestriction> getEventParticipantRestrictions_() {
		return eventParticipantRestrictions_;
	}

	public LinkedList<Participant> getParticipants_() {
		return participants_;
	}

	public LinkedList<ParticipantUsage> getParticipantUsages_() {
		return participantUsages_;
	}

	public LinkedList<ParticipantRole> getParticipantRoles_() {
		return participantRoles_;
	}

	public LinkedList<ParticipantTypeRoleUsage> getParticipantTypeRoleUsages_() {
		return participantTypeRoleUsages_;
	}

	public LinkedList<ParticipantType> getParticipantTypes_() {
		return participantTypes_;
	}

	public LinkedList<ParticipantRelation> getParticipantRelations_() {
		return participantRelations_;
	}

	public LinkedList<ParticipantRelationType> getParticipantRelationTypes_() {
		return participantRelationTypes_;
	}

	public boolean isEvents_ids() {
		return events_ids;
	}

	public void setEvents_ids(boolean events_ids) {
		this.events_ids = events_ids;
	}

	public boolean isEventParts_ids() {
		return eventParts_ids;
	}

	public void setEventParts_ids(boolean eventParts_ids) {
		this.eventParts_ids = eventParts_ids;
	}

	public boolean isEventTemplates_ids() {
		return eventTemplates_ids;
	}

	public void setEventTemplates_ids(boolean eventTemplates_ids) {
		this.eventTemplates_ids = eventTemplates_ids;
	}

	public boolean isEventTypeUsages_ids() {
		return eventTypeUsages_ids;
	}

	public void setEventTypeUsages_ids(boolean eventTypeUsages_ids) {
		this.eventTypeUsages_ids = eventTypeUsages_ids;
	}

	public boolean isEventPartDefaultUsages_ids() {
		return eventPartDefaultUsages_ids;
	}

	public void setEventPartDefaultUsages_ids(boolean eventPartDefaultUsages_ids) {
		this.eventPartDefaultUsages_ids = eventPartDefaultUsages_ids;
	}

	public boolean isEventTypes_ids() {
		return eventTypes_ids;
	}

	public void setEventTypes_ids(boolean eventTypes_ids) {
		this.eventTypes_ids = eventTypes_ids;
	}

	public boolean isEventStatus_ids() {
		return eventStatus_ids;
	}

	public void setEventStatus_ids(boolean eventStatus_ids) {
		this.eventStatus_ids = eventStatus_ids;
	}

	public boolean isProviderEventRelations_ids() {
		return providerEventRelations_ids;
	}

	public void setProviderEventRelations_ids(boolean providerEventRelations_ids) {
		this.providerEventRelations_ids = providerEventRelations_ids;
	}

	public boolean isSports_ids() {
		return sports_ids;
	}

	public void setSports_ids(boolean sports_ids) {
		this.sports_ids = sports_ids;
	}

	public boolean isProviders_ids() {
		return providers_ids;
	}

	public void setProviders_ids(boolean providers_ids) {
		this.providers_ids = providers_ids;
	}

	public boolean isEvent_participant_relation_ids() {
		return event_participant_relation_ids;
	}

	public void setEvent_participant_relation_ids(boolean event_participant_relation_ids) {
		this.event_participant_relation_ids = event_participant_relation_ids;
	}

	public boolean isEvent_participant_restriction_ids() {
		return event_participant_restriction_ids;
	}

	public void setEvent_participant_restriction_ids(boolean event_participant_restriction_ids) {
		this.event_participant_restriction_ids = event_participant_restriction_ids;
	}

	public boolean isLocations_ids() {
		return locations_ids;
	}

	public void setLocations_ids(boolean locations_ids) {
		this.locations_ids = locations_ids;
	}

	public boolean isLocationTypes_ids() {
		return locationTypes_ids;
	}

	public void setLocationTypes_ids(boolean locationTypes_ids) {
		this.locationTypes_ids = locationTypes_ids;
	}

	public boolean isLocationRelations_ids() {
		return locationRelations_ids;
	}

	public void setLocationRelations_ids(boolean locationRelations_ids) {
		this.locationRelations_ids = locationRelations_ids;
	}

	public boolean isLocationRelationTypes_ids() {
		return locationRelationTypes_ids;
	}

	public void setLocationRelationTypes_ids(boolean locationRelationTypes_ids) {
		this.locationRelationTypes_ids = locationRelationTypes_ids;
	}

	public boolean isBettingOffers_ids() {
		return bettingOffers_ids;
	}

	public void setBettingOffers_ids(boolean bettingOffers_ids) {
		this.bettingOffers_ids = bettingOffers_ids;
	}

	public boolean isBettingOfferStatus_ids() {
		return bettingOfferStatus_ids;
	}

	public void setBettingOfferStatus_ids(boolean bettingOfferStatus_ids) {
		this.bettingOfferStatus_ids = bettingOfferStatus_ids;
	}

	public boolean isBettingTypes_ids() {
		return bettingTypes_ids;
	}

	public void setBettingTypes_ids(boolean bettingTypes_ids) {
		this.bettingTypes_ids = bettingTypes_ids;
	}

	public boolean isBettingTypeUsages_ids() {
		return bettingTypeUsages_ids;
	}

	public void setBettingTypeUsages_ids(boolean bettingTypeUsages_ids) {
		this.bettingTypeUsages_ids = bettingTypeUsages_ids;
	}

	public boolean isOutcomes_ids() {
		return outcomes_ids;
	}

	public void setOutcomes_ids(boolean outcomes_ids) {
		this.outcomes_ids = outcomes_ids;
	}

	public boolean isOutcomeStatus_ids() {
		return outcomeStatus_ids;
	}

	public void setOutcomeStatus_ids(boolean outcomeStatus_ids) {
		this.outcomeStatus_ids = outcomeStatus_ids;
	}

	public boolean isOutcomeTypes_ids() {
		return outcomeTypes_ids;
	}

	public void setOutcomeTypes_ids(boolean outcomeTypes_ids) {
		this.outcomeTypes_ids = outcomeTypes_ids;
	}

	public boolean isOutcomeTypeUsages_ids() {
		return outcomeTypeUsages_ids;
	}

	public void setOutcomeTypeUsages_ids(boolean outcomeTypeUsages_ids) {
		this.outcomeTypeUsages_ids = outcomeTypeUsages_ids;
	}

	public boolean isOutcomeTypeBettingTypeRelations_ids() {
		return outcomeTypeBettingTypeRelations_ids;
	}

	public void setOutcomeTypeBettingTypeRelations_ids(boolean outcomeTypeBettingTypeRelations_ids) {
		this.outcomeTypeBettingTypeRelations_ids = outcomeTypeBettingTypeRelations_ids;
	}

	public boolean isSources_ids() {
		return sources_ids;
	}

	public void setSources_ids(boolean sources_ids) {
		this.sources_ids = sources_ids;
	}

	public boolean isParticipant_ids() {
		return participant_ids;
	}

	public void setParticipant_ids(boolean participant_ids) {
		this.participant_ids = participant_ids;
	}

	public boolean isParticipant_usage_ids() {
		return participant_usage_ids;
	}

	public void setParticipant_usage_ids(boolean participant_usage_ids) {
		this.participant_usage_ids = participant_usage_ids;
	}

	public boolean isParticipant_role_ids() {
		return participant_role_ids;
	}

	public void setParticipant_role_ids(boolean participant_role_ids) {
		this.participant_role_ids = participant_role_ids;
	}

	public boolean isParticipant_type_role_usage_ids() {
		return participant_type_role_usage_ids;
	}

	public void setParticipant_type_role_usage_ids(boolean participant_type_role_usage_ids) {
		this.participant_type_role_usage_ids = participant_type_role_usage_ids;
	}

	public boolean isParticipant_type_ids() {
		return participant_type_ids;
	}

	public void setParticipant_type_ids(boolean participant_type_ids) {
		this.participant_type_ids = participant_type_ids;
	}

	public boolean isParticipant_relation_ids() {
		return participant_relation_ids;
	}

	public void setParticipant_relation_ids(boolean participant_relation_ids) {
		this.participant_relation_ids = participant_relation_ids;
	}

	public boolean isParticipant_relation_type_ids() {
		return participant_relation_type_ids;
	}

	public void setParticipant_relation_type_ids(boolean participant_relation_type_ids) {
		this.participant_relation_type_ids = participant_relation_type_ids;
	}

	public InsertIntoParticipant getInsertIntoParticipant() {
		return insertIntoParticipant;
	}

	public void setInsertIntoParticipant(InsertIntoParticipant insertIntoParticipant) {
		this.insertIntoParticipant = insertIntoParticipant;
	}

	public boolean isBulkDataAllowed() {
		return BulkDataAllowed;
	}

	public void setBulkDataAllowed(boolean bulkDataAllowed) {
		BulkDataAllowed = bulkDataAllowed;
	}

	public boolean isOdds_history_ids() {
		return odds_history_ids;
	}

	public void setOdds_history_ids(boolean odds_history_ids) {
		this.odds_history_ids = odds_history_ids;
	}

	public InsertIntoOddsHistory getInsertIntoOddsHistory() {
		return insertIntoOddsHistory;
	}

	public void setInsertIntoOddsHistory(InsertIntoOddsHistory insertIntoOddsHistory) {
		this.insertIntoOddsHistory = insertIntoOddsHistory;
	}

}
