drop database if exists sport_db_consize;
create database sport_db_consize;
use sport_db_consize;
SET SQL_SAFE_UPDATES = 0;
SET UNIQUE_CHECKS=0;
SET FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE=@@SQL_MODE,
SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
SET SQL_MODE='ALLOW_INVALID_DATES';
#set sql_mode = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

#---------------------------------------------------------Events--------------------------------------------------------------------------#

create table `Event`
(
	id bigint ,
    version int,
    isComplete boolean,
    typeId bigint,
    sportId bigint,
    templateId bigint,
    promotionId bigint,
    parentId bigint,
    parentPartId bigint,
    `name` varchar(255),
    startTime timestamp,
    endTime timestamp,
    deleteTimeOffset bigint,
    venueId bigint,
    statusId bigint,
    hasLiveStatus boolean,
    rootPartId bigint,
    currentPartId bigint,
    url varchar(255),
    popularity int,
    note varchar(255)
);


create table EventPart
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255),
    parentId bigint,
    orderNum int,
    isDrawPossible boolean
);

create table EventTemplate
(
	id bigint ,
    version int,
    `name` varchar(255),
    eventTypeId bigint,
    sportId bigint,
    url varchar(255),
    venueId bigint,
    rootPartId bigint,
    note varchar(255)
);

create table EventTypeUsage
(
	id bigint ,
    version int,
    eventTypeId bigint,
    sportId bigint,
    minPrimaryParticipantBetweenEvents bigint,
    minEventDuration bigint,
    maxEventDuration bigint
);

create table EventPartDefaultUsage
(
	id bigint ,
    version int,
    parentEventId bigint,
    eventTypeId bigint,
    sportId bigint,
    rootPartId bigint
);

create table EventType
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255)
);

create table EventStatus
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255)
);

create table ProviderEventRelation
(
	id bigint ,
    version int,
    providerId bigint,
    eventId bigint,
    startTime timestamp,
    endTime timestamp,
    timeQualityRank int,
    offersLiveOdds boolean,
    offersLiveTV boolean
);

create table EventParticipantRelation
(
	id bigint,
    version int,
    eventId bigint,
    eventPartId bigint,
    participantId bigint,
    participantRoleId bigint,
    parentParticipantId bigint
);

create table EventParticipantRestriction
(
	id bigint,
    version int,
    eventId bigint,
    participantTypeId bigint,
    participantIsMale boolean,
    participantMinAge int,
    participantMaxAge int,
    participantPartOfLocation bigint
);



create table Sport
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255),
    parentId bigint
);


create table Provider
(
	id bigint ,
    version int,
    `name` varchar(255),
    locationId bigint,
    url varchar(255),
    isBookmaker boolean,
    isBettingExchange boolean,
    bettingCommisionVACs float,
    isLiveOddsApproved boolean,
    isNewsSource boolean,
    isEnabled boolean,
    note varchar(255)
);

#----------------------------------------------------------location--------------------------------------------------------------------
create table Location
(
	id bigint ,
    version int,
    typeId bigint,
    `name` varchar(255),
    `code` varchar(255),
    isHistoric boolean,
    url varchar(255),
    note varchar(255)
);

create table LocationType
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255),
    hasCode boolean,
    codeDescription varchar(255)
);


create table  LocationRelation
(
	id bigint ,
    version int,
    typeId bigint,
    fromLocationId bigint,
    toLocationId bigint
);


create table LocationRelationType
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255)
);


#----------------------------------------------------------------Bettings-------------------------------------------------------#

create table BettingOffer
(
	id bigint ,
    version int,
    providerId bigint,
    sourceId bigint,
    outcomeId bigint,
    bettingTypeId bigint,
    statusId bigint,
    isLive boolean,
    odds float,
    multiplicity int,
    volume float,
    volumeCurrencyId bigint,
    couponKey varchar(255),
    slotNum int,
    lastChangedTime timestamp
);

create table BettingOfferStatus
(
	id bigint ,
    version int,
    `name` varchar(255),
    isAvailable boolean,
    description varchar(255)
);

create table BettingType
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255)
);

create table BettingTypeUsage
(	
	id bigint ,
    version int,
    bettingTypeId bigint,
    eventTypeId bigint,
    sportId bigint
);

create table Outcome
(
	id bigint ,
    version int,
    typeId bigint,
    isNegation boolean,
    statusId bigint,
    eventId bigint,
    eventPartId bigint,
    paramFloat1 float,
    paramFloat2 float,
    paramFloat3 float,
    paramBoolean1 boolean,
    paramString1 varchar(255),
    paramParticipant1 bigint,
    paramParticipant2 bigint,
    paramParticipant3 bigint,
    paramEventPartId1 bigint
);

create table OutcomeStatus
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255)
);

create table OutcomeType
(
	id bigint ,
    version int,
    `name` varchar(255),
    description varchar(255),
    hasParamFloat1 boolean,
    paramFloat1Description varchar(255),
    hasParamFloat2 boolean,
    paramFloat2Description varchar(255),
    hasParamFloat3 boolean,
    paramFloat3Description varchar(255),
    hasParamBoolean1 boolean,
    paramBoolean1Description varchar(255),
    hasParamString1 boolean,
    paramString1Description varchar(255),
    paramString1PossibleValues varchar(255),
    hasParamParticipantId1 boolean,
    paramParticipantId1Description varchar(255),
    paramParticipant1MustBePrimary boolean,
    paramParticipant1MustBeRoot boolean,
    paramParticipant1MustHaveRoleId bigint,
    hasParamParticipantId2 boolean,
    paramParticipantId2Description varchar(255),
    paramParticipant2MustBePrimary boolean,
    paramParticipant2MustBeRoot boolean,
    paramParticipant2MustHaveRoleId bigint,
    hasParamParticipantId3 boolean,
    paramParticipantId3Description varchar(255),
    paramParticipant3MustBePrimary boolean,
    paramParticipant3MustBeRoot boolean,
    paramParticipant3MustHaveRoleId bigint,
    hasParamEventPartId1 boolean,
    paramEventPartId1Description varchar(255)
);

create table OutcomeTypeUsage
(
	id bigint ,
    version int,
    outcomeTypeId bigint,
    eventTypeId bigint,
    eventPartId bigint,
    sportId bigint
);

create table OutcomeTypeBettingTypeRelation
(
	id bigint ,
    version int,
    outcomeTypeId bigint,
    bettingTypeId bigint
);

create table `Source`
(
	id bigint ,
    version int,
    collectorId bigint,
    providerId bigint,
    sourceKey varchar(255),
    lastCollectedTime timestamp,
    lastUpdatedTime timestamp
);

#----------------------------------------------------Participant-------------------------------------------------------------------#
create table Participant
(
	id bigint,
    version int,
    typeId bigint,
    `name` varchar(255),
    firstName varchar(255),
    lastName varchar(255),
    isMale boolean,
    birthTime timestamp,
    countryId bigint,
    url varchar(255),
    retirementTime timestamp,
    note varchar(255)
);

create table ParticipantUsage
(
	id bigint,
    version int,
    participantId bigint,
    sportId bigint
);

create table ParticipantRole
(
	id bigint,
    version int,
    `name` varchar(255),
    description varchar(255),
    isPrimary boolean
);

create table ParticipantTypeRoleUsage
(
	id bigint,
    version int,
    participantTypeId bigint,
    participantRoleId bigint,
    sportId bigint
);

create table ParticipantType
(
	id bigint,
    version int,
    `name` varchar(255),
    description varchar(255),
    isIndividual boolean,
    hasName boolean,
    hasFirstName boolean,
    hasLastName boolean,
    hasIsMale boolean,
    hasBirthTime boolean,
    hasNationalityId boolean,
    hasRetirementTime boolean
);

create table ParticipantRelation
(
	id bigint,
    version int,
    typeId bigint,
    fromParticipantId bigint,
    toParticipantId bigint,
    startTime timestamp,
    endTime timestamp,
    paramParticipantRoleId bigint
);

create table ParticipantRelationType
(
	id bigint,
    version int,
    `name` varchar(255),
    description varchar(255),
    hasParamParticipantRoleId boolean,
    paramParticipantRoleIdDescription varchar(255)
);


create table Exception
(
	id bigint primary key auto_increment,
    exception text
);

create table oddshistory
(
	bettingOfferId bigint,
    odds float,
    timeChanged timestamp,
    eventTypeId bigint,
    eventId bigint,
    bettingTypeName varchar(255),
    threshold float,
    sportName varchar(255)
);

#-------------------------------------------------------------New Tracker Table----------------------------------------#
create table trackedMatch
(
	id bigint key,
    providerId bigint,
    userId bigint default -1,
	homeTeam varchar(255),
    awayTeam varchar(255),
    leagueName varchar(255),
    sportName varchar(255)
);

#drop table trackedMatch;

#------------------------------------------------------------Track History---------------------------------------------#
#drop table trackHistory;
#-----------------------------------------------------------registeredOutcome------------------------------------------#
create table registeredOutcome
(
	id bigint,
    providerId bigint,
    userId bigint default -1,
    odds float, 
    threshold float, 
    leagueName varchar(255),
    matchName varchar(255),
    participant varchar(255),
    hometeamName varchar(255),
    awayteamName varchar(255),
    registeredTime timestamp,
    lastUpdatedTime timestamp,
    bettingType varchar(255)
);

#drop table registeredOutcome;

#-----------------------------------------------------Removed Outcomes---------------------------------------------------#
create table removedOutcomes (
	id bigint key,
	userId bigint,
	odds float,
	threshold float,
	leagueName varchar(255),
	homeTeam varchar(255),
	awayTeam varchar(255),
	participant varchar(255),
	removedTime timestamp,
	bettingTypeId bigint,
	sportName varchar(255)
);

#drop table removedOutcomes;
#-----------------------------------------------------25 January 2019 12:18AM--------------------------------------------#


#drop table registeredOutcome;

#--------------------------------------------------------------index---------------------------------------------------#
/*
create index epr_1 on EventParticipantRelation (participantId);
create index epr_2 on EventParticipantRelation (eventId);
create index epr_3 on EventParticipantRelation (participantRoleId);
create index os_1 on oddshistory (BettingOfferId);
create index bo_1 on BettingOffer (outcomeId);
create index o_1 on Outcome(eventId);
create index o_2 on Outcome(eventPartId);
*/

#----------------------------------------------------------function-----------------------------------------------------#



DELIMITER $$
CREATE FUNCTION removeSpecialCharacter(t varchar(255)) returns varchar(255)
	DETERMINISTIC
BEGIN
	set t = replace(t, '\'', '');
    set t = replace(t, '"', '');
    set t = replace(t, ':', '');
    set t = replace(t, ';', '');
    set t = replace(t, '-', '');
    return (t);
END
$$

delimiter ;

#drop function removeSpecialCharacter;

#select removeSpecialCharacter('a:;bc\'\"');


/*
use sport_db_consize;
select count(*), id from `event` group by id;
select * from locationrelationtype;
select count(*) from eventPart group by id;
select * from eventpartdefaultusage;
select * from eventstatus;
select * from eventtemplate;
select * from eventtype;
select * from eventtypeusage;
select * from location;
select * from locationrelation;
select * from locationrelationtype;
select * from locationtype;
select * from provider;
select * from providereventrelation;
select count(*) from sport group by id;
select * from `event`;
select * from bettingoffer;
select * from bettingofferstatus;
select * from bettingtype;
select * from bettingtypeusage;
select count(*), id  from outcome group by id;
select * from outcome;
select * from outcometype;
select * from outcometypeusage;
select * from outcometypebettingtyperelation;
select * from `source`;
select id from `event`;

select * from participant;
select * from participantUsage;
select * from participantrole;
select * from participanttyperoleusage;
select * from participantType;
select * from participantrelation;
select * from participantrelationtype;
select * from eventparticipantrelation;
select * from eventparticipantrestriction;


alter table outcome add index (id);
alter table outcome drop index id_2;

alter table event drop index id;

alter table provider add index (id);
alter table provider drop index id;

show index from provider;
*/
