package com.ubaid.app.model.insert;



public interface QuriesForIDsRetrieve
{

	String q_event_ids = "SELECT (count(id) > 0) FROM `Event`";
	String q_event_part_ids = "SELECT (count(id) > 0) FROM `EventPart`";
	String q_event_template_ids = "SELECT (count(id) > 0) FROM `EventTemplate`";
	String q_event_type_usage = "SELECT (count(id) > 0) FROM `EventTypeUsage`";
	String q_event_part_default_usage_ids = "SELECT (count(id) > 0) FROM `EventPartDefaultUsage`";
	String q_event_type_ids = "SELECT (count(id) > 0) FROM `EventType`";
	String q_event_status_ids = "SELECT (count(id) > 0) FROM `EventStatus`";
	String q_provider_event_relation_ids = "SELECT (count(id) > 0) FROM `ProviderEventRelation`";
	String q_sports_ids = "SELECT (count(id) > 0) FROM `Sport`";
	String q_provider_ids = "SELECT (count(id) > 0) FROM `Provider`";
	String q_event_participant_relation_ids = "SELECT (count(id) > 0) FROM `EventParticipantRelation`";
	String q_event_participant_restriction_ids = "SELECT (count(id) > 0) FROM `EventParticipantRestriction`";
	
	String q_location_ids = "SELECT (count(id) > 0) FROM `Location`";
	String q_location_type_ids = "SELECT (count(id) > 0) FROM `LocationType`";
	String q_location_relation_ids = "SELECT (count(id) > 0) FROM `LocationRelation`";
	String q_location_relation_type_ids = "SELECT (count(id) > 0) FROM `LocationRelationType`";
	
	
	String q_betting_offer_ids = "SELECT (count(id) > 0) FROM `BettingOffer`";
	String q_betting_offer_status_ids = "SELECT (count(id) > 0) FROM `BettingOfferStatus`";
	String q_betting_type_ids = "SELECT (count(id) > 0) FROM `BettingType`";
	String q_betting_type_usage_ids = "SELECT (count(id) > 0) FROM `BettingTypeUsage`";
	String q_outcome_ids = "SELECT (count(id) > 0) FROM `Outcome`";
	String q_outcome_status_ids = "SELECT (count(id) > 0) FROM `OutcomeStatus`";
	String q_outcome_type_ids = "SELECT (count(id) > 0) FROM `OutcomeType`";
	String q_outcome_type_usage = "SELECT (count(id) > 0) FROM `OutcomeTypeUsage`";
	String q_outcome_type_betting_type_relation = "SELECT (count(id) > 0) FROM `OutcomeTypeBettingTypeRelation`";
	String q_source_ids = "SELECT (count(id) > 0) FROM `Source`";
	
	String q_participant_ids = "SELECT (count(id) > 0) FROM `Participant`";
	String q_participant_usage_ids = "SELECT (count(id) > 0) FROM `ParticipantUsage`";
	String q_participant_role_ids = "SELECT (count(id) > 0) FROM `ParticipantRole`";
	String q_participant_type_role_usage_ids = "SELECT (count(id) > 0) FROM `ParticipantTypeRoleUsage`";
	String q_participant_type_ids = "SELECT (count(id) > 0) FROM `ParticipantType`";
	String q_participant_relation_ids = "SELECT (count(id) > 0) FROM `ParticipantRelation`";
	String q_participant_relation_type_ids = "SELECT (count(id) > 0) FROM `ParticipantRelationType`";
	
	String q_odds_history_ids = "SELECT (count(*) > 0) FROM `OddsHistory`";
}
