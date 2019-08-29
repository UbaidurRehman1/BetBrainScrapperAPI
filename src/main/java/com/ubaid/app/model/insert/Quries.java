package com.ubaid.app.model.insert;


import java.sql.Timestamp;

public interface Quries
{
	
	
	abstract long getLongNumber(Long number);
	abstract boolean getDecision(Boolean bool);
	abstract Timestamp getDate(java.util.Date date);
	abstract float getFloatNumber(Float number);
	abstract int getIntNumber(Integer number);
	
	/*
	1id long,
	2version int,
	3isComplete boolean,
	4typeId long,
	5sportId long,
	6templateId long,
	7promotionId long,
	8parentId long,
	9parentPartId long,
	10`name` varchar(255),
	11startTime timestamp,
	12endTime timestamp,
	13deleteTimeOffset long,
	14venueId long,
	15statusId long,
	16hasLiveStatus boolean,
	17rootPartId long,
	18currentPartId long,
	19url varchar(255),
	20popularity int,
	21note varchar(255)
	*/
	String q_event = "INSERT INTO `Event`(id, version, isComplete, "
			+ "typeId, sportId, templateId, promotionId, parentId, parentPartId, name, "
			+ "startTime, endTime, deleteTimeOffset, venueId, statusId, hasLiveStatus, "
			+ "rootPartId, currentPartId, url, popularity, note) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/*
	id long,
    version int,
    `name` varchar(255),
    description varchar(255),
    parentId long,
    orderNum int,
    isDrawPossible boolean
	*/
	String q_event_part = "INSERT INTO `EventPart`(id, version, name, description, parentId, orderNum, "
			+ "isDrawPossible) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	/*
	1id long,
    2version int,
    3`name` varchar(255),
    4eventTypeId long,
    5sportId long,
    6url varchar(255),
    7venueId long,
    8rootPartId long,
    9note varchar(255)
	*/
	String q_event_template = "INSERT INTO `EventTemplate`(id, "
			+ "version, name, eventTypeId, sportId, url, venueId, rootPartId, "
			+ "note) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	/*
	1id long,
    2version int,
    3eventTypeId long,
    4sportId long,
    5minPrimaryParticipantBetweenEvents long,
    6minEventDuration long,
    7maxEventDuration long
	*/
	String q_event_type_usage = "INSERT INTO `EventTypeUsage`(id, "
			+ "version, eventTypeId, sportId, minPrimaryParticipantBetweenEvents, "
			+ "minEventDuration, maxEventDuration) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	/*
	1id long,
    2version int,
    3parentEventId long,
    4eventTypeId long,
    5sportId long,
    6rootPartId long
	*/
	String q_event_part_default_usage = "INSERT INTO `EventPartDefaultUsage`(id, "
			+ "version, parentEventId, eventTypeId, sportId, rootPartId) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";
	
	/*
	 * 	id long,
    	version int,
    	`name` varchar(255),
    	description varchar(255)
	 */
	String q_event_type = "INSERT INTO `EventType`(id, version, name, description) "
			+ "VALUES(?, ?, ?, ?)";
	
	/*
	 *	id long,
    	varsion int,
    	`name` varchar(255),
    	description varchar(255)
	 */
	String q_event_status = "INSERT INTO `EventStatus`(id, version, name, description) "
			+ "VALUES(?, ?, ?, ?)";
	
	
	/**
	1id long,
    2version int,
    3providerId long,
    4eventId long,
    5startTime varchar,
    6endTime varchar,
    7timeQualityRank int,
    8offersLiveOdds boolean,
    9offersLiveTV boolean
	 */
	
	String q_provider_event_relation = "INSERT INTO `ProviderEventRelation`(id, version, "
			+ "providerId, eventId, startTime, endTime, timeQualityRank, offersLiveOdds, offersLiveTV) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	/**
	1id long,
    2version int,
    3`name` varchar(255),
    4description varchar(255),
    5parentId long
	 */
	String q_sport = "INSERT INTO `Sport`(id, version, name, description, parentId) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	/*
	1id long,
    2version int,
    3`name` varchar(255),
    4locationId long,
    5url varchar(255),
    6isBookmaker boolean,
    7isBettingExchange boolean,
    8bettingCommisionVACs float,
    9isLiveOddsApproved boolean,
    10isNewsSource boolean,
    11isEnabled boolean,
    12note varchar(255)
	*/
	String q_provider = "INSERT INTO `Provider`(id, version, name, locationId, url, "
			+ "isBookmaker, isBettingExchange, bettingCommisionVACs, isLIveOddsApproved, "
			+ "isNewsSource, isEnabled, note) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	//two new quiries
//	create table EventParticipantRelation
//	(
//1		id bigint,
//2	    version int,
//3	    eventId bigint,
//4	    eventPartId bigint,
//5	    participantId bigint,
//6	    participantRoleId bigint,
//7	    parentParticipantId bigint
//	);

	String q_event_participant_relation = "INSERT INTO `EventParticipantRelation`(id, version, "
			+ "eventId, eventPartId, participantId, participantRoleId, parentParticipantId) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";

	
//	create table EventParticipantRestriction
//	(
//1		id bigint,
//2	    version int,
//3	    eventId bigint,
//4	    participantTypeId bigint,
//5	    participantIsMale boolean,
//6	    participantMinAge int,
//7	    participantMaxAge int,
//8	    participantPartOfLocation bigint
//	);

	String q_event_participant_restriction = "INSERT INTO `EventParticipantRestriction`(id, version, eventId, "
			+ "participantTypeId, participantIsMale, participantMinAge, participantMaxAge, participantPartOfLocation) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	/******************************************************************************************************************
	 													Location Entities
	 ******************************************************************************************************************/
	/*
	1id long,
    2version int,
    3typeId long,
    4`name` varchar(255),
    5`code` varchar(255),
    6isHistoric boolean,
    7url varchar(255),
    8note varchar(255)
	*/
	String q_location = "INSERT INTO `Location`(id, version, typeId, name, code, "
			+ "isHistoric, url, note) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	/*
	1id long,
    2version int,
    3name varchar(255),
    4description varchar(255),
    5hasCode boolean,
    6codeDescription varchar(255)
	 */
	String q_location_type = "INSERT INTO `LocationType`(id, version, name, description, "
			+ "hasCode, codeDescription) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";
	
	
	/*
	id long,
    version int,
    typeId long,
    fromLocationId long,
    toLocationId long
	*/
	
	String q_location_relation = "INSERT INTO `LocationRelation`(id, version, typeId, "
			+ "fromLocationId, toLocationId) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	/*
	id long,
    version int,
    `name` varchar(255),
    description varchar(255)
	*/
	
	String q_location_relation_type = "INSERT INTO `LocationRelationType`(id, version, name, description) "
			+ "VALUES(?, ?, ?, ?)";
	
	/*-------------------------------------------Bettings---------------------------------------------*/
	//table name: BettingOffer-1
	
	/*
	1id bigint primary key,
    2version int,
    3providerId bigint,
    4sourceId bigint,
    5outcomeId bigint,
    6bettingTypeId bigint,
    7statusId bigint,
    8isLive boolean,
    9odds float,
    10multiplicity int,
    11volume float,
    12volumeCurrencyId bigint,
    13couponKey varchar(255),
    14slotNum int,
    15lastChangedTime timestamp
	*/
	
	String q_betting_offer = "INSERT INTO `BettingOffer`(id, version, providerId, sourceId, "
			+ "outcomeId, bettingTypeId, statusId, isLive, odds, multiplicity, volume, volumeCurrencyId, "
			+ "couponKey, slotNum, lastChangedTime) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	//table Name: BettingOfferStatus-2
	/*
	id bigint primary key,
    version int,
    `name` varchar(255),
    isAvailable boolean,
    description varchar(255)
    */
	String q_betting_offer_status = "INSERT INTO `BettingOfferStatus`(id, version, name, "
			+ "isAvailable, description) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	
	//table Name: BettingType-3
	/*
	id bigint primary key,
    version int,
    `name` varchar(255),
    description varchar(255)
	*/
	String q_betting_type = "INSERT INTO `BettingType`(id, version, name, description) "
			+ "VALUES(?, ?, ?, ?)";
	
	//table Name: BettingTypeUsage-4
	/*
	id bigint primary key,
    version int,
    bettingTypeId bigint,
    eventTypeId bigint,
    sportId bigint
    */
	
	String q_betting_type_usage = "INSERT INTO `BettingTypeUsage`(id, version, bettingTypeId, "
			+ "eventTypeId, sportId) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	//table Name: OutCome-5
	/*
	1id bigint primary key,
    2version int,
    3typeId bigint,
    4isNegation boolean,
    5statusId bigint,
    6eventId bigint,
    7eventPartId bigint,
    8paramFloat1 float,
    9paramFloat2 float,
    10paramFloat3 float,
    11paramBoolean1 boolean,
    12paramString1 varchar(255),
    13paramParticipant1 bigint,
    14paramParticipant2 bigint,
    15paramParticipant3 bigint,
    16paramEventPartId1 bigint
	*/
	
	String q_outcome = "INSERT INTO `Outcome`(id, version, typeId, isNegation, statusId, eventId, eventPartId, "
			+ "paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramString1, "
			+ "paramParticipant1, paramParticipant2, paramParticipant3, paramEventPartId1) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	//table Name: OutcomeStatus-6
	/*
	id bigint primary key,
    version int,
    `name` varchar(255),
    description varchar(255)
    */
	
	String q_outcome_status = "INSERT INTO `OutcomeStatus`(id, version, name, description) "
			+ "VALUES(?, ?, ?, ?)";

	//table Name: OutcomeType-7
	/*
	1id bigint primary key,
    2version int,
    3`name` varchar(255),
    4description varchar(255),
    5hasParamFloat1 boolean,
    6paramFloat1Description varchar(255),
    7hasParamFloat2 boolean,
    8paramFloat2Description varchar(255),
    9hasParamFloat3 boolean,
    10paramFloat3Description varchar(255),
    11hasParamBoolean1 boolean,
    12paramBoolean1Description varchar(255),
    13hasParamString1 boolean,
    14paramString1Description varchar(255),
    15paramString1PossibleValues varchar(255),
    16hasParamParticipantId1 boolean,
    17paramParticipantId1Description varchar(255),
    18paramParticipant1MustBePrimary boolean,
    19paramParticipant1MustBeRoot boolean,
    20paramParticipant1MustHaveRoleId bigint,
    21hasParamParticipantId2 boolean,
    22paramParticipantId2Description varchar(255),
    23paramParticipant2MustBePrimary boolean,
    24paramParticipant2MustBeRoot boolean,
    25paramParticipant2MustHaveRoleId bigint,
    26hasParamParticipantId3 boolean,
    27paramParticipantId3Description varchar(255),
    28paramParticipant3MustBePrimary boolean,
    29paramParticipant3MustBeRoot boolean,
    30paramParticipant3MustHaveRoleId bigint,
    31hasParamEventPartId1 boolean,
    32paramEventPartId1Description varchar(255),

	 */
	String q_outcome_type = "INSERT INTO `OutcomeType`(id, version, name, description, "
			+ "hasParamFloat1, paramFloat1Description, hasParamFloat2, paramFloat2Description, hasParamFloat3, "
			+ "paramFloat3Description, hasParamBoolean1, paramBoolean1Description, hasParamString1, "
			+ "paramString1Description, paramString1PossibleValues, hasParamParticipantId1, paramParticipantId1Description, "
			+ "paramParticipant1MustBePrimary, paramParticipant1MustBeRoot, paramParticipant1MustHaveRoleId, "
			+ "hasParamParticipantId2, paramParticipantId2Description, paramParticipant2MustBePrimary, "
			+ "paramParticipant2MustBeRoot, paramParticipant2MustHaveRoleId, hasParamParticipantId3, "
			+ "paramParticipantId3Description, paramParticipant3MustBePrimary, paramParticipant3MustBeRoot, "
			+ "paramParticipant3MustHaveRoleId, hasParamEventPartId1, paramEventPartId1Description"
			+ ")"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	//table name: OutcomeTypeUsage 8
	/*
	id bigint primary key,
    version int,
    outcomeTypeId bigint,
    eventTypeId bigint,
    eventPartId bigint,
    sportId bigint
	*/
	String q_outcome_type_usage = "INSERT INTO `OutcomeTypeUsage`(id, version, outcomeTypeId, "
			+ "eventTypeId, eventPartId, sportId) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";
	
	//table name: OutcomeTypeBettingTypeRelation 9
	/*
	id bigint primary key,
    version int,
    outcomeTypeId bigint,
    bettingTypeId bigint
	*/
	String q_outcome_type_betting_type_relation = "INSERT INTO `OutcomeTypeBettingTypeRelation`(id, version, "
			+ "outcomeTypeId, bettingTypeId) "
			+ "VALUES(?, ?, ?, ?)";
	
	//table name: Source 10
	/*
	id bigint primary key,
    version int,
    collectorId bigint,
    providerId bigint,
    sourceKey String,
    lastCollectedTime timestamp,
    lastUpdatedTime timestamp
	*/
	
	String q_source = "INSERT INTO `Source`(id, version, collectorId, providerId, sourceKey, "
			+ "lastCollectedTime, lastUpdatedTime) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
}

