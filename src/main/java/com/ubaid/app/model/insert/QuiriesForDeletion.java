package com.ubaid.app.model.insert;

public interface QuiriesForDeletion
{
	String event_d = "DELETE FROM `Event`";
	String event_part_d = "DELETE FROM `EventPart`";
	String event_template_d = "DELETE FROM `EventTemplate`";
	String event_type_usage_d = "DELETE FROM `EventTypeUsage`";
	String event_part_default_usage_d = "DELETE FROM `EventPartDefaultUsage`";
	String event_type_d = "DELETE FROM `EventType`";
	String event_status_d = "DELETE FROM `EventStatus`";
	String provider_event_relation_d = "DELETE FROM `ProviderEventRelation`";
	String sport_d = "DELETE FROM `Sport`";
	String provider_d = "DELETE FROM `Provider`";
	String event_participant_relation_d = "DELETE FROM `EventParticipantRelation`";
	String event_participant_restriction_d = "DELETE FROM `EventParticipantRestriction`";
	
	String location_d = "DELETE FROM `Location`";
	String location_type_d = "DELETE FROM `LocationType`";
	String location_relation_d = "DELETE FROM `LocationRelation`";
	String location_relation_type_d = "DELETE FROM `LocationRelationType`";
	
	String betting_offer_d = "DELETE FROM `BettingOffer`";
	String betting_offer_status_d = "DELETE FROM `BettingOfferStatus`";
	String betting_type_d = "DELETE FROM `BettingType`";
	String betting_type_usgae_d = "DELETE FROM `BettingTypeUsage`";
	String outcome_d = "DELETE FROM `Outcome`";
	String outcome_status_d = "DELETE FROM `OutcomeStatus`";
	String outcome_type_d = "DELETE FROM `OutcomeType`";
	String outcome_type_usage_d = "DELETE FROM `OutcomeTypeUsage`";
	String outcome_type_betting_type_relation_d = "DELETE FROM `OutcomeTypeBettingTypeRelation`";
	String source_d = "DELETE FROM `Source`";
	
	String participant_d = "DELETE FROM `Participant`";
	String participant_usage_d = "DELETE FROM `ParticipantUsage`";
	String participant_role_d = "DELETE FROM `ParticipantRole`";
	String participant_type_role_usage_d = "DELETE FROM `ParticipantTypeRoleUsage`";
	String participant_type_d = "DELETE FROM `ParticipantType`";
	String participant_relation_d = "DELETE FROM `ParticipantRelation`";
	String participant_relation_type_d = "DELETE FROM `ParticipantRelationType`";
	
	String odds_history_d = "DELETE FROM `OddsHistory`";
	
}
