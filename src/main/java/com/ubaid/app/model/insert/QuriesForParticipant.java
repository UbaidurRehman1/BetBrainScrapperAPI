package com.ubaid.app.model.insert;

//change
public interface QuriesForParticipant extends Quries
{

//	create table Participant
//	(
//1		id bigint,
//2	    version int,
//3	    typeId bigint,
//4	    `name` varchar(255),
//5	    firstName varchar(255),
//6	    lastName varchar(255),
//7	    isMale boolean,
//8	    birthTime timestamp,
//9	    countryId bigint,
//10	    url varchar(255),
//11	    retirementTime timestamp,
//12	    note varchar(255)
//	);

	//1
	String q_participant = "INSERT INTO `Participant`(id, version, typeId, name, firstName, lastName, "
			+ "isMale, birthTime, countryId, url, retirementTime, note) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//	create table ParticipantUsage
//	(
//		id bigint,
//	    version int,
//	    participantId bigint,
//	    sportId bigint
//	);
	
	//2
	String q_participant_usage = "INSERT INTO `ParticipantUsage`(id, version, participantId, sportId) "
			+ "VALUES(?, ?, ?, ?)";
	
//	create table ParticipantRole
//	(
//		id bigint,
//	    version int,
//	    `name` varchar(255),
//	    description varchar(255),
//	    isPrimary boolean
//	);
	
	//3
	String q_participant_role = "INSERT INTO `ParticipantRole`(id, version, name, description, isPrimary) "
			+ "VALUES(?, ?, ?, ?, ?)";
	
	
//	create table ParticipantTypeRoleUsage
//	(
//		id bigint,
//	    version int,
//	    participantTypeId bigint,
//	    participantRoleId bigint,
//	    sportId bigint
//	);
	
	//4
	String q_participant_type_role_usage = "INSERT INTO `ParticipantTypeRoleUsage`(id, version, participantTypeId, "
			+ "participantRoleId, sportId) "
			+ "VALUES(?, ?, ?, ?, ?)";

//	create table ParticipantType
//	(
//1		id bigint,
//2    version int,
//3	    `name` varchar(255),
//4	    description varchar(255),
//5	    isIndividual boolean,
//6	    hasName boolean,
//7	    hasFirstName boolean,
//8	    hasLastName boolean,
//9	    hasIsMale boolean,
//10	    hasBirthTime boolean,
//11	    hasNationalityId boolean,
//12	    hasRetirementTime boolean
//	);

	//5
	String q_participant_type = "INSERT INTO `ParticipantType`(id, version, name, description, isIndividual, "
			+ "hasName, hasFirstName, hasLastName, hasIsMale, hasBirthTime, hasNationalityId, hasRetirementTime) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
//	create table ParticipantRelation
//	(
//1		id bigint,
//2	    version int,
//3	    typeId bigint,
//4	    fromParticipantId bigint,
//5	    toParticipantId bigint,
//6	    startTime timestamp,
//7	    endTime timestamp,
//8	    paramParticipantRoleId bigint
//	);
	
	//6
	String q_participation_relation = "INSERT INTO `ParticipantRelation`(id, version, typeId, fromParticipantId, "
			+ "toParticipantId, startTime, endTime, paramParticipantRoleId) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	
//	create table ParticipantRelationType
//	(
//		id bigint,
//	    version int,
//	    `name` varchar(255),
//	    description varchar(255),
//	    hasParamParticipantRoleId boolean,
//	    paramParticipantRoleIdDescription varchar(255)
//	);

	//7
	String q_participant_relation_type = "INSERT INTO `ParticipantRelationType`(id, version, name, "
			+ "description, hasParamParticipantRoleId, paramParticipantRoleIdDescription) "
			+ "VALUES(?, ?, ?, ?, ?, ?)";
}
