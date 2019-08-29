package com.ubaid.app.model.insert.participant;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.betbrain.sepc.connector.sportsmodel.Participant;
import com.betbrain.sepc.connector.sportsmodel.ParticipantRelation;
import com.betbrain.sepc.connector.sportsmodel.ParticipantRelationType;
import com.betbrain.sepc.connector.sportsmodel.ParticipantRole;
import com.betbrain.sepc.connector.sportsmodel.ParticipantType;
import com.betbrain.sepc.connector.sportsmodel.ParticipantTypeRoleUsage;
import com.betbrain.sepc.connector.sportsmodel.ParticipantUsage;
import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementsForParticipant;

public class InsertIntoParticipant extends PreparedStatementsForParticipant {

	protected Controller controller;
	
	public InsertIntoParticipant(Controller controller)
	{
		super(controller);
		this.controller = controller;
	}

	
	//Participant Table -1
	public void insertInParticipantTable(LinkedList<Participant> participants_)
	{
		try
		{
			int i = 0;
			for(Participant participant : participants_)
			{
				_q_participant.setLong(1, getLongNumber(participant.getId()));
				_q_participant.setInt(2, getIntNumber(participant.getVersion()));
				_q_participant.setLong(3, getLongNumber(participant.getTypeId()));
				_q_participant.setString(4, participant.getName());
				_q_participant.setString(5, participant.getFirstName());
				_q_participant.setString(6, participant.getLastName());
				_q_participant.setBoolean(7, getDecision(participant.getIsMale()));
				_q_participant.setTimestamp(8, getDate(participant.getBirthTime()));
				_q_participant.setLong(9, getLongNumber(participant.getCountryId()));
				_q_participant.setString(10, participant.getUrl());
				_q_participant.setTimestamp(11, getDate(participant.getRetirementTime()));
				_q_participant.setString(12, participant.getNote());
				_q_participant.addBatch();

				i++;
				if(i % 1000 == 0 || i == participants_.size())
				{
					_q_participant.executeBatch();
					controller.getQueue().setText("Participant Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participants_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//ParticipantUsage Table -2
	public void insertInParticipantUsageTable(LinkedList<ParticipantUsage> participantUsages_)
	{
		try
		{
			int i = 0;
			for(ParticipantUsage participantUsage : participantUsages_)
			{
				_q_participant_usage.setLong(1, getLongNumber(participantUsage.getId()));
				_q_participant_usage.setInt(2, getIntNumber(participantUsage.getVersion()));
				_q_participant_usage.setLong(3, getLongNumber(participantUsage.getParticipantId()));
				_q_participant_usage.setLong(4, getLongNumber(participantUsage.getSportId()));				
				_q_participant_usage.addBatch();

				i++;
				if(i % 1000 == 0 || i == participantUsages_.size())
				{
					_q_participant_usage.executeBatch();
					controller.getQueue().setText("participantUsage Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participantUsages_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Participant Role Table -3
	public void insertInParticipantRoleTable(LinkedList<ParticipantRole> participantRoles_)
	{
		try
		{
			int i = 0;
			for(ParticipantRole participantRole : participantRoles_)
			{
				_q_participant_role.setLong(1, getLongNumber(participantRole.getId()));
				_q_participant_role.setInt(2, getIntNumber(participantRole.getVersion()));
				_q_participant_role.setString(3, participantRole.getName());
				_q_participant_role.setString(4, participantRole.getDescription());
				_q_participant_role.setBoolean(5, getDecision(participantRole.getIsPrimary()));
				_q_participant_role.addBatch();

				i++;
				if(i % 1000 == 0 || i == participantRoles_.size())
				{
					_q_participant_role.executeBatch();
					controller.getQueue().setText("participantRole Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participantRoles_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//ParticipantTypeRoleUsage Table 4
	public void insertInParticipantTypeRoleUsageTable(LinkedList<ParticipantTypeRoleUsage> participantTypeRoleUsages_)
	{
		try
		{
			int i = 0;
			for(ParticipantTypeRoleUsage participantTypeRoleUsage : participantTypeRoleUsages_)
			{
				_q_participant_type_role_usage.setLong(1, getLongNumber(participantTypeRoleUsage.getId()));
				_q_participant_type_role_usage.setInt(2, getIntNumber(participantTypeRoleUsage.getVersion()));
				_q_participant_type_role_usage.setLong(3, getLongNumber(participantTypeRoleUsage.getParticipantTypeId()));
				_q_participant_type_role_usage.setLong(4, getLongNumber(participantTypeRoleUsage.getParticipantRoleId()));
				_q_participant_type_role_usage.setLong(5, getLongNumber(participantTypeRoleUsage.getSportId()));
				_q_participant_type_role_usage.addBatch();

				i++;
				if(i % 1000 == 0 || i == participantTypeRoleUsages_.size())
				{
					_q_participant_type_role_usage.executeBatch();
					controller.getQueue().setText("participantTypeRoleUsage Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participantTypeRoleUsages_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Participant Type Table-5
	public void insertInParticipantTypeTable(LinkedList<ParticipantType> participantTypes_)
	{
		try
		{
			int i = 0;
			for(ParticipantType participantType : participantTypes_)
			{
				_q_participant_type.setLong(1, getLongNumber(participantType.getId()));
				_q_participant_type.setInt(2, getIntNumber(participantType.getVersion()));
				_q_participant_type.setString(3, participantType.getName());
				_q_participant_type.setString(4, participantType.getDescription());
				_q_participant_type.setBoolean(5, getDecision(participantType.getIsIndividual()));
				_q_participant_type.setBoolean(6, getDecision(participantType.getHasName()));
				_q_participant_type.setBoolean(7, getDecision(participantType.getHasFirstName()));
				_q_participant_type.setBoolean(8, getDecision(participantType.getHasLastName()));
				_q_participant_type.setBoolean(9, getDecision(participantType.getHasIsMale()));
				_q_participant_type.setBoolean(10, getDecision(participantType.getHasBirthTime()));
				_q_participant_type.setBoolean(11, getDecision(participantType.getHasCountryId()));
				_q_participant_type.setBoolean(12, getDecision(participantType.getHasRetirementTime()));
				_q_participant_type.addBatch();

				i++;
				if(i % 1000 == 0 || i == participantTypes_.size())
				{
					_q_participant_type.executeBatch();
					controller.getQueue().setText("participantType Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participantTypes_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//Participant Relation Table 6
	public void insertInParticipantRelationTable(LinkedList<ParticipantRelation> participantRelations_)
	{
		try
		{
			int i = 0;
			for(ParticipantRelation participantRelation : participantRelations_)
			{
				_q_participant_relation.setLong(1, getLongNumber(participantRelation.getId()));
				_q_participant_relation.setInt(2, getIntNumber(participantRelation.getVersion()));
				_q_participant_relation.setLong(3, getLongNumber(participantRelation.getTypeId()));
				_q_participant_relation.setLong(4, getLongNumber(participantRelation.getFromParticipantId()));
				_q_participant_relation.setLong(5, getLongNumber(participantRelation.getToParticipantId()));
				_q_participant_relation.setTimestamp(6, getDate(participantRelation.getStartTime()));
				_q_participant_relation.setTimestamp(7, getDate(participantRelation.getEndTime()));
				_q_participant_relation.setLong(8, getLongNumber(participantRelation.getParamParticipantRoleId()));
				

				_q_participant_relation.addBatch();

				i++;
				if(i % 1000 == 0 || i == participantRelations_.size())
				{
					_q_participant_relation.executeBatch();
					controller.getQueue().setText("participantRelation Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participantRelations_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//Participant Relation Type
	public void insertInParticipantRelationTypeTable(LinkedList<ParticipantRelationType> participantRelationTypes_)
	{
		try
		{
			int i = 0;
			for(ParticipantRelationType participantRelationType : participantRelationTypes_)
			{
				_q_participant_relation_type.setLong(1, getLongNumber(participantRelationType.getId()));
				_q_participant_relation_type.setInt(2, getIntNumber(participantRelationType.getVersion()));
				_q_participant_relation_type.setString(3, participantRelationType.getName());
				_q_participant_relation_type.setString(4, participantRelationType.getDescription());
				_q_participant_relation_type.setBoolean(5, getDecision(participantRelationType.getHasParamParticipantRoleId()));
				_q_participant_relation_type.setString(6, participantRelationType.getParamParticipantRoleIdDescription());
				_q_participant_relation_type.addBatch();

				i++;
				if(i % 1000 == 0 || i == participantRelationTypes_.size())
				{
					_q_participant_relation_type.executeBatch();
					controller.getQueue().setText("participantRelationType Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			participantRelationTypes_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//Participant Table -1
	public void insertInParticipantTable(Participant participant)
	{
		try
		{
			_q_participant.setLong(1, getLongNumber(participant.getId()));
			_q_participant.setInt(2, getIntNumber(participant.getVersion()));
			_q_participant.setLong(3, getLongNumber(participant.getTypeId()));
			_q_participant.setString(4, participant.getName());
			_q_participant.setString(5, participant.getFirstName());
			_q_participant.setString(6, participant.getLastName());
			_q_participant.setBoolean(7, getDecision(participant.getIsMale()));
			_q_participant.setTimestamp(8, getDate(participant.getBirthTime()));
			_q_participant.setLong(9, getLongNumber(participant.getCountryId()));
			_q_participant.setString(10, participant.getUrl());
			_q_participant.setTimestamp(11, getDate(participant.getRetirementTime()));
			_q_participant.setString(12, participant.getNote());
			_q_participant.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Participant inserted Successfully", controller.getQueue().getEntityIndex());								
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//ParticipantUsage Table -2
	public void insertInParticipantUsageTable(ParticipantUsage participantUsage)
	{
		try
		{
			_q_participant_usage.setLong(1, getLongNumber(participantUsage.getId()));
			_q_participant_usage.setInt(2, getIntNumber(participantUsage.getVersion()));
			_q_participant_usage.setLong(3, getLongNumber(participantUsage.getParticipantId()));
			_q_participant_usage.setLong(4, getLongNumber(participantUsage.getSportId()));				
			_q_participant_usage.executeUpdate();
			connection.commit();
			controller.getQueue().setText("participantUsage inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Participant Role Table -3
	public void insertInParticipantRoleTable(ParticipantRole participantRole)
	{
		try
		{
			_q_participant_role.setLong(1, getLongNumber(participantRole.getId()));
			_q_participant_role.setInt(2, getIntNumber(participantRole.getVersion()));
			_q_participant_role.setString(3, participantRole.getName());
			_q_participant_role.setString(4, participantRole.getDescription());
			_q_participant_role.setBoolean(5, getDecision(participantRole.getIsPrimary()));
			_q_participant_role.executeUpdate();
			connection.commit();
			controller.getQueue().setText("participantRole inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}
	}

	//ParticipantTypeRoleUsage Table 4
	public void insertInParticipantTypeRoleUsageTable(ParticipantTypeRoleUsage participantTypeRoleUsage)
	{
		try
		{
			_q_participant_type_role_usage.setLong(1, getLongNumber(participantTypeRoleUsage.getId()));
			_q_participant_type_role_usage.setInt(2, getIntNumber(participantTypeRoleUsage.getVersion()));
			_q_participant_type_role_usage.setLong(3, getLongNumber(participantTypeRoleUsage.getParticipantTypeId()));
			_q_participant_type_role_usage.setLong(4, getLongNumber(participantTypeRoleUsage.getParticipantRoleId()));
			_q_participant_type_role_usage.setLong(5, getLongNumber(participantTypeRoleUsage.getSportId()));
			_q_participant_type_role_usage.executeUpdate();
			connection.commit();
			controller.getQueue().setText("participantTypeRoleUsage inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//Participant Type Table-5
	public void insertInParticipantTypeTable(ParticipantType participantType)
	{
		try
		{
			_q_participant_type.setLong(1, getLongNumber(participantType.getId()));
			_q_participant_type.setInt(2, getIntNumber(participantType.getVersion()));
			_q_participant_type.setString(3, participantType.getName());
			_q_participant_type.setString(4, participantType.getDescription());
			_q_participant_type.setBoolean(5, getDecision(participantType.getIsIndividual()));
			_q_participant_type.setBoolean(6, getDecision(participantType.getHasName()));
			_q_participant_type.setBoolean(7, getDecision(participantType.getHasFirstName()));
			_q_participant_type.setBoolean(8, getDecision(participantType.getHasLastName()));
			_q_participant_type.setBoolean(9, getDecision(participantType.getHasIsMale()));
			_q_participant_type.setBoolean(10, getDecision(participantType.getHasBirthTime()));
			_q_participant_type.setBoolean(11, getDecision(participantType.getHasCountryId()));
			_q_participant_type.setBoolean(12, getDecision(participantType.getHasRetirementTime()));
			_q_participant_type.executeUpdate();
			controller.getQueue().setText("participantType inserted Successfully", controller.getQueue().getEntityIndex());
			connection.commit();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//Participant Relation Table 6
	public void insertInParticipantRelationTable(ParticipantRelation participantRelation)
	{
		try
		{
			_q_participant_relation.setLong(1, getLongNumber(participantRelation.getId()));
			_q_participant_relation.setInt(2, getIntNumber(participantRelation.getVersion()));
			_q_participant_relation.setLong(3, getLongNumber(participantRelation.getTypeId()));
			_q_participant_relation.setLong(4, getLongNumber(participantRelation.getFromParticipantId()));
			_q_participant_relation.setLong(5, getLongNumber(participantRelation.getToParticipantId()));
			_q_participant_relation.setTimestamp(6, getDate(participantRelation.getStartTime()));
			_q_participant_relation.setTimestamp(7, getDate(participantRelation.getEndTime()));
			_q_participant_relation.setLong(8, getLongNumber(participantRelation.getParamParticipantRoleId()));
			_q_participant_relation.executeUpdate();
			connection.commit();
			controller.getQueue().setText("participantRelation inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//Participant Relation Type
	public void insertInParticipantRelationTypeTable(ParticipantRelationType participantRelationType)
	{
		try
		{
			_q_participant_relation_type.setLong(1, getLongNumber(participantRelationType.getId()));
			_q_participant_relation_type.setInt(2, getIntNumber(participantRelationType.getVersion()));
			_q_participant_relation_type.setString(3, participantRelationType.getName());
			_q_participant_relation_type.setString(4, participantRelationType.getDescription());
			_q_participant_relation_type.setBoolean(5, getDecision(participantRelationType.getHasParamParticipantRoleId()));
			_q_participant_relation_type.setString(6, participantRelationType.getParamParticipantRoleIdDescription());
			_q_participant_relation_type.executeUpdate();
			connection.commit();
			controller.getQueue().setText("participantRelationType Batch inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());

			
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	
	@Override
	public long getLongNumber(Long number)
	{
		return (number == null ? 0 : number);
	}

	@Override
	public boolean getDecision(Boolean bool)
	{
		return (bool == null ? false : bool);
	}


	@Override
	public Timestamp getDate(java.util.Date date)
	{
		return (date == null) ? null : new Timestamp(date.getTime());
	}


	@Override
	public int getIntNumber(Integer number)
	{
		return (number == null ? -1 : number);
	}


	@Override
	public float getFloatNumber(Float number)
	{
		return 0;
	}
	

}
