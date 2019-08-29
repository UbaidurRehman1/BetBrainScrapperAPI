package com.ubaid.app.model.indexing;

public interface IndexQueries
{
	String event_add_index = "ALTER TABLE `Event` add index (id)";
	String eventPart_add_index = "ALTER TABLE `EventPart` add index (id)";
	String eventTemplate_add_index = "ALTER TABLE `EventTemplate` add index (id)";
	String eventTypeUsage_add_index = "ALTER TABLE `EventTypeUsage` add index (id)";
	String eventPartDefaultUsage_add_index = "ALTER TABLE `EventPartDefaultUsage` add index (id)";
	String eventType_add_index = "ALTER TABLE `EventType` add index (id)";
	String eventStatus_add_index = "ALTER TABLE `EventStatus` add index (id)";
	String providerEventRelation_add_index = "ALTER TABLE `ProviderEventRelation` add index (id)";
	String sport_add_index = "ALTER TABLE `Sport` add index (id)";
	String provider_add_index = "ALTER TABLE `Provider` add index (id)";
	String event_participant_relation_add_index = "ALTER TABLE `EventParticipantRelation` add index(id)";
	String event_participant_restriction_add_index = "ALTER TABLE `EventParticipantRestriction` add index(id)";

	String location_add_index = "ALTER TABLE `Location` add index (id)";
	String locationType_add_index = "ALTER TABLE `LocationType` add index (id)";
	String locationRelation_add_index = "ALTER TABLE `LocationRelation` add index (id)";
	String locationRelationType_add_index = "ALTER TABLE `LocationRelationType` add index (id)";

	String bettingOffer_add_index = "ALTER TABLE `BettingOffer` add index (id)";
	String bettingOfferStatus_add_index = "ALTER TABLE `BettingOfferStatus` add index (id)";
	String bettingType_add_index = "ALTER TABLE `BettingType` add index (id)";
	String bettingTypeUsage_add_index = "ALTER TABLE `BettingTypeUsage` add index (id)";
	String outcome_add_index = "ALTER TABLE `Outcome` add index (id)";
	String outcomeStatus_add_index = "ALTER TABLE `OutcomeStatus` add index (id)";
	String outcomeType_add_index = "ALTER TABLE `OutcomeType` add index (id)";
	String outcometypeusage_add_index = "ALTER TABLE `OutcomeTypeUsage` add index (id)";
	String outcometypebettingtyperelation_add_index = "ALTER TABLE `OutcomeTypeBettingTypeRelation` add index (id)";
	String source_add_index = "ALTER TABLE `Source` add index (id)";

	String participant_add_index = "ALTER TABLE `Participant` add index(id)";
	String participant_usage_add_index = "ALTER TABLE `ParticipantUsage` add index(id)";
	String participant_role_add_index = "ALTER TABLE `ParticipantRole` add index(id)";
	String participant_type_role_usage_add_index = "ALTER TABLE `ParticipantTypeRoleUsage` add index(id)";
	String participant_type_add_index = "ALTER TABLE `ParticipantType` add index(id)";
	String participant_relation_add_index = "ALTER TABLE `ParticipantRelation` add index(id)";
	String participant_relation_type_add_index = "ALTER TABLE `ParticipantRelationType` add index(id)";
	
	String odds_history_add_index = "ALTER TABLE `oddshistory` add index(id)";
	
	String event_drop_index = "ALTER TABLE `Event` drop index id";
	String eventPart_drop_index = "ALTER TABLE `EventPart` drop index id";
	String eventTemplate_drop_index = "ALTER TABLE `EventTemplate` drop index id";
	String eventTypeUsage_drop_index = "ALTER TABLE `EventTypeUsage` drop index id";
	String eventPartDefaultUsage_drop_index = "ALTER TABLE `EventPartDefaultUsage` drop index id";
	String eventType_drop_index = "ALTER TABLE `EventType` drop index id";
	String eventStatus_drop_index = "ALTER TABLE `EventStatus` drop index id";
	String providerEventRelation_drop_index = "ALTER TABLE `ProviderEventRelation` drop index id";
	String sport_drop_index = "ALTER TABLE `Sport` drop index id";
	String provider_drop_index = "ALTER TABLE `Provider` drop index id";
	String event_participant_relation_drop_index = "ALTER TABLE `EventParticipantRelation` drop index id ";
	String event_participant_restriction_drop_index = "ALTER TABLE `EventParticipantRestriction` drop index id ";

	
	String location_drop_index = "ALTER TABLE `Location` drop index id";
	String locationType_drop_index = "ALTER TABLE `LocationType` drop index id";
	String locationRelation_drop_index = "ALTER TABLE `LocationRelation` drop index id";
	String locationRelationType_drop_index = "ALTER TABLE `LocationRelationType` drop index id";

	String bettingOffer_drop_index = "ALTER TABLE `BettingOffer` drop index id";
	String bettingOfferStatus_drop_index = "ALTER TABLE `BettingOfferStatus` drop index id";
	String bettingType_drop_index = "ALTER TABLE `BettingType` drop index id";
	String bettingTypeUsage_drop_index = "ALTER TABLE `BettingTypeUsage` drop index id";
	String outcome_drop_index = "ALTER TABLE `Outcome` drop index id";
	String outcomeStatus_drop_index = "ALTER TABLE `OutcomeStatus` drop index id";
	String outcomeType_drop_index = "ALTER TABLE `OutcomeType` drop index id";
	String outcometypeusage_drop_index = "ALTER TABLE `OutcomeTypeUsage` drop index id";
	String outcometypebettingtyperelation_drop_index = "ALTER TABLE `OutcomeTypeBettingTypeRelation` drop index id";
	String source_drop_index = "ALTER TABLE `Source` drop index id";
	
	String participant_drop_index = "ALTER TABLE `Participant` drop index id";
	String participant_usage_drop_index = "ALTER TABLE `ParticipantUsage` drop index id";
	String participant_role_drop_index = "ALTER TABLE `ParticipantRole` drop index id";
	String participant_type_role_usage_drop_index = "ALTER TABLE `ParticipantTypeRoleUsage` drop index id";
	String participant_type_drop_index = "ALTER TABLE `ParticipantType` drop index id";
	String participant_relation_drop_index = "ALTER TABLE `ParticipantRelation` drop index id";
	String participant_relation_type_drop_index = "ALTER TABLE `ParticipantRelationType` drop index id";

	String odds_history_drop_index = "ALTER TABLE `oddshistory` drop index id";


	String event_show_index = "SHOW INDEX FROM `Event`";
	String eventPart_show_index = "SHOW INDEX FROM `EventPart`";
	String eventTemplate_show_index = "SHOW INDEX FROM `EventTemplate`";
	String eventTypeUsage_show_index = "SHOW INDEX FROM `EventTypeUsage` show index id";
	String eventPartDefaultUsage_show_index = "SHOW INDEX FROM `EventPartDefaultUsage` show index id";
	String eventType_show_index = "SHOW INDEX FROM `EventType` show index id";
	String eventStatus_show_index = "SHOW INDEX FROM `EventStatus`";
	String providerEventRelation_show_index = "SHOW INDEX FROM `ProviderEventRelation`";
	String sport_show_index = "SHOW INDEX FROM `Sport`";
	String provider_show_index = "SHOW INDEX FROM `Provider`";
	String event_participant_relation_show_index = "SHOW INDEX FROM `EventParticipantRelation`";
	String event_participant_restriction_show_index = "SHOW INDEX FROM `EventParticipantRestriction`";
	
	String location_show_index = "SHOW INDEX FROM `Location`";
	String locationType_show_index = "SHOW INDEX FROM `LocationType`";
	String locationRelation_show_index = "SHOW INDEX FROM `LocationRelation`";
	String locationRelationType_show_index = "SHOW INDEX FROM `LocationRelationType`";

	String bettingOffer_show_index = "SHOW INDEX FROM `BettingOffer`";
	String bettingOfferStatus_show_index = "SHOW INDEX FROM `BettingOfferStatus`";
	String bettingType_show_index = "SHOW INDEX FROM `BettingType`";
	String bettingTypeUsage_show_index = "SHOW INDEX FROM `BettingTypeUsage`";
	String outcome_show_index = "SHOW INDEX FROM `Outcome`";
	String outcomeStatus_show_index = "SHOW INDEX FROM `OutcomeStatus`";
	String outcomeType_show_index = "SHOW INDEX FROM `OutcomeType`";
	String outcometypeusage_show_index = "SHOW INDEX FROM `OutcomeTypeUsage`";
	String outcometypebettingtyperelation_show_index = "SHOW INDEX FROM `OutcomeTypeBettingTypeRelation`";
	String source_show_index = "SHOW INDEX FROM `Source`";
	
	String participant_show_index = "SHOW INDEX FROM `Participant`";
	String participant_usage_show_index = "SHOW INDEX FROM `ParticipantUsage`";
	String participant_role_show_index = "SHOW INDEX FROM `ParticipantRole`";
	String participant_type_role_usage_show_index = "SHOW INDEX FROM `ParticipantTypeRoleUsage`";
	String participant_type_show_index = "SHOW INDEX FROM `ParticipantType`";
	String participant_relation_show_index = "SHOW INDEX FROM `ParticipantRelation`";
	String participant_relation_type_show_index = "SHOW INDEX FROM `ParticipantRelationType`";

	String odds_history_show_index = "ALTER TABLE `oddshistory` show index(id)";

	
	String invalid_date = "SET SQL_MODE='ALLOW_INVALID_DATES'";
	
}
