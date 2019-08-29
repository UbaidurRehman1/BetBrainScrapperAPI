package com.ubaid.app.model.execution;

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

public class Q
{
	
	protected Object object;
	
	public Q(String q)
	{
		object = q;
	}
	
	public Q(Event event)
	{
		object = event;
	}
	
	public Q(EventPart eventPart)
	{
		object = eventPart;
	}
	
	public Q(EventTemplate eventTemplate)
	{
		object = eventTemplate;
	}
	
	public Q(EventTypeUsage eventTypeUsage)
	{
		object = eventTypeUsage;
	}
	
	public Q(EventPartDefaultUsage eventPartDefaultUsage)
	{
		object = eventPartDefaultUsage;
	}
	
	public Q(EventType eventType)
	{
		object = eventType;
	}
	
	public Q(EventStatus eventStatus)
	{
		object = eventStatus;
	}
	
	public Q(ProviderEventRelation providerEventRelation)
	{
		object = providerEventRelation;
	}
	
	public Q(Sport sport)
	{
		object = sport;
	}
	
	public Q(Provider provider)
	{
		object = provider;
	}
	
	public Q(EventParticipantRelation eventParticipantRelation)
	{
		object = eventParticipantRelation;
	}
	
	public Q(EventParticipantRestriction eventParticipantRestriction)
	{
		object = eventParticipantRestriction;
	}
	
	
	
	
	public Q(Location location)
	{
		object = location;
	}
	
	public Q(LocationType locationType)
	{
		object = locationType;
	}
	
	public Q(LocationRelation locationRelation)
	{
		object = locationRelation;
	}
	
	public Q(LocationRelationType locationRelationType)
	{
		object = locationRelationType;
	}
	
	
	
	
	
	public Q(BettingOffer bettingOffer)
	{
		object = bettingOffer;
	}
	
	public Q(BettingOfferStatus bettingOfferStatus)
	{
		object = bettingOfferStatus;
	}
	
	public Q(BettingType bettingType)
	{
		object = bettingType;
	}
	
	public Q(BettingTypeUsage bettingTypeUsage)
	{
		object = bettingTypeUsage;
	}
	
	public Q(Outcome outcome)
	{
		object = outcome;
	}
	
	public Q(OutcomeStatus outcomeStatus)
	{
		object = outcomeStatus;
	}
	
	public Q(OutcomeType outcomeType)
	{
		object = outcomeType;
	}
	
	public Q(OutcomeTypeUsage outcomeTypeUsage)
	{
		object = outcomeTypeUsage;
	}
	
	public Q(OutcomeTypeBettingTypeRelation outcomeTypeBettingTypeRelation)
	{
		object = outcomeTypeBettingTypeRelation;
	}
	
	public Q(Source source)
	{
		object = source;
	}
	
	
	
	public Q(Participant participant)
	{
		object = participant;
	}
	
	public Q(ParticipantUsage participantUsage)
	{
		object = participantUsage;
	}
	
	public Q(ParticipantRole participantRole)
	{
		object = participantRole;
	}
	
	public Q(ParticipantTypeRoleUsage participantTypeRoleUsage)
	{
		object = participantTypeRoleUsage;
	}
	
	public Q(ParticipantType participantType)
	{
		object = participantType;
	}
	
	public Q(ParticipantRelation participantRelation)
	{
		object = participantRelation;
	}
	
	public Q(ParticipantRelationType participantRelationType)
	{
		object = participantRelationType;
	}
	
	public Object get()
	{
		return object;
	}
	
}
