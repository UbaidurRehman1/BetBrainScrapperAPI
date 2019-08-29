package com.ubaid.app.model.insert.betting;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.betbrain.sepc.connector.sportsmodel.BettingOffer;
import com.betbrain.sepc.connector.sportsmodel.BettingOfferStatus;
import com.betbrain.sepc.connector.sportsmodel.BettingType;
import com.betbrain.sepc.connector.sportsmodel.BettingTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Outcome;
import com.betbrain.sepc.connector.sportsmodel.OutcomeStatus;
import com.betbrain.sepc.connector.sportsmodel.OutcomeType;
import com.betbrain.sepc.connector.sportsmodel.OutcomeTypeBettingTypeRelation;
import com.betbrain.sepc.connector.sportsmodel.OutcomeTypeUsage;
import com.betbrain.sepc.connector.sportsmodel.Source;
import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementsForBetting;


public class InsertInToBetting extends PreparedStatementsForBetting
{

	protected Controller controller;
	
	public InsertInToBetting(Controller controller)
	{
		super(controller);
		this.controller = controller;
	}
	
	
	//betting offer table 1
	public void insertIntoBettingOfferTable(LinkedList<BettingOffer> bettingOffers_)
	{
		try
		{
			int i = 0;
			for(BettingOffer bettingOffer : bettingOffers_)
			{
				
				_q_betting_offer.setLong(1, getLongNumber(bettingOffer.getId()));
				_q_betting_offer.setInt(2, getIntNumber(bettingOffer.getVersion()));
				_q_betting_offer.setLong(3, getLongNumber(bettingOffer.getProviderId()));
				_q_betting_offer.setLong(4, getLongNumber(bettingOffer.getSourceId()));
				_q_betting_offer.setLong(5, getLongNumber(bettingOffer.getOutcomeId()));
				_q_betting_offer.setLong(6, getLongNumber(bettingOffer.getBettingTypeId()));
				_q_betting_offer.setLong(7, getLongNumber(bettingOffer.getStatusId()));
				_q_betting_offer.setBoolean(8, getDecision(bettingOffer.getIsLive()));
				_q_betting_offer.setFloat(9, getFloatNumber(bettingOffer.getOdds()));
				_q_betting_offer.setInt(10, getIntNumber(bettingOffer.getMultiplicity()));
				_q_betting_offer.setFloat(11, getFloatNumber(bettingOffer.getVolume()));
				_q_betting_offer.setLong(12, getLongNumber(bettingOffer.getVolumeCurrencyId()));
				_q_betting_offer.setString(13, bettingOffer.getCouponKey());
				_q_betting_offer.setInt(14, getIntNumber(bettingOffer.getSlotNum()));
				_q_betting_offer.setTimestamp(15, getDate(bettingOffer.getLastChangedTime()));			
				_q_betting_offer.addBatch();

				i++;
				if(i % 1000 == 0 || i == bettingOffers_.size())
				{
					_q_betting_offer.executeBatch();
					controller.getQueue().setText("Betting Offer Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			bettingOffers_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//betting offer status table 2
	public void insertIntoBettingOfferStatusTable(LinkedList<BettingOfferStatus> bettingOfferStatuses_)
	{
		try
		{
			int i = 0;
			for(BettingOfferStatus bettingOfferStatus : bettingOfferStatuses_)
			{
				_q_betting_offer_status.setLong(1, getLongNumber(bettingOfferStatus.getId()));
				_q_betting_offer_status.setInt(2, getIntNumber(bettingOfferStatus.getVersion()));
				_q_betting_offer_status.setString(3, bettingOfferStatus.getName());
				_q_betting_offer_status.setBoolean(4, getDecision(bettingOfferStatus.getIsAvailable()));
				_q_betting_offer_status.setString(5, bettingOfferStatus.getDescription());
				_q_betting_offer_status.addBatch();

				i++;
				if(i % 1000 == 0 || i == bettingOfferStatuses_.size())
				{
					_q_betting_offer_status.executeBatch();
					controller.getQueue().setText("Betting Offer status Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			bettingOfferStatuses_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//betting type table 3
	public void insertIntoBettingTypeTable(LinkedList<BettingType> bettingTypes_)
	{
		try
		{
			int i = 0;
			for(BettingType bettingType : bettingTypes_)
			{
				_q_betting_type.setLong(1, getLongNumber(bettingType.getId()));
				_q_betting_type.setInt(2, getIntNumber(bettingType.getVersion()));
				_q_betting_type.setString(3, bettingType.getName());
				_q_betting_type.setString(4, bettingType.getDescription());
				_q_betting_type.addBatch();

				i++;
				if(i % 1000 == 0 || i == bettingTypes_.size())
				{
					_q_betting_type.executeBatch();
					controller.getQueue().setText("Betting Type Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			bettingTypes_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//betting type usage 4
	public void insertIntoBettingTypeUsageTable(LinkedList<BettingTypeUsage> bettingTypeUsages_)
	{
		try
		{
			int i = 0;
			for(BettingTypeUsage bettingTypeUsage : bettingTypeUsages_)
			{
				_q_betting_type_usage.setLong(1, getLongNumber(bettingTypeUsage.getId()));
				_q_betting_type_usage.setInt(2, getIntNumber(bettingTypeUsage.getVersion()));
				_q_betting_type_usage.setLong(3, getLongNumber(bettingTypeUsage.getBettingTypeId()));
				_q_betting_type_usage.setLong(4, getLongNumber(bettingTypeUsage.getEventTypeId()));
				_q_betting_type_usage.setLong(5, getLongNumber(bettingTypeUsage.getSportId()));
				_q_betting_type_usage.addBatch();

				i++;
				if(i % 1000 == 0 || i == bettingTypeUsages_.size())
				{
					_q_betting_type_usage.executeBatch();
					controller.getQueue().setText("Betting Type Usage Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			bettingTypeUsages_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//outcome table 5
	public void insertIntoOutcomeTable(LinkedList<Outcome> outcomes_)
	{
		try
		{
			int i = 0;
			for(Outcome outcome : outcomes_)
			{
				_q_outcome.setLong(1, getLongNumber(outcome.getId()));
				_q_outcome.setInt(2, getIntNumber(outcome.getVersion()));
				_q_outcome.setLong(3, getLongNumber(outcome.getTypeId()));
				_q_outcome.setBoolean(4, getDecision(outcome.getIsNegation()));
				_q_outcome.setLong(5, getLongNumber(outcome.getStatusId()));
				_q_outcome.setLong(6, getLongNumber(outcome.getEventId()));
				_q_outcome.setLong(7, getLongNumber(outcome.getEventPartId()));
				_q_outcome.setFloat(8, getFloatNumber(outcome.getParamFloat1()));
				_q_outcome.setFloat(9, getFloatNumber(outcome.getParamFloat2()));
				_q_outcome.setFloat(10, getFloatNumber(outcome.getParamFloat3()));
				_q_outcome.setBoolean(11, getDecision(outcome.getParamBoolean1()));
				_q_outcome.setString(12, outcome.getParamString1());
				_q_outcome.setLong(13, getLongNumber(outcome.getParamParticipantId1()));
				_q_outcome.setLong(14, getLongNumber(outcome.getParamParticipantId2()));
				_q_outcome.setLong(15, getLongNumber(outcome.getParamParticipantId3()));
				_q_outcome.setLong(16, getLongNumber(outcome.getParamEventPartId1()));
				_q_outcome.addBatch();

				i++;
				if(i % 1000 == 0 || i == outcomes_.size())
				{
					_q_outcome.executeBatch();
					controller.getQueue().setText("Outcome Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			outcomes_.clear();
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//outcome status 6
	public void insertIntoOutcomeStatusTable(LinkedList<OutcomeStatus> outcomeStatuses_)
	{
		try
		{
			int i = 0;
			for(OutcomeStatus outcomeStatus : outcomeStatuses_)
			{
				_q_outcome_status.setLong(1, getLongNumber(outcomeStatus.getId()));
				_q_outcome_status.setInt(2, getIntNumber(outcomeStatus.getVersion()));
				_q_outcome_status.setString(3, outcomeStatus.getName());
				_q_outcome_status.setString(4, outcomeStatus.getDescription());
				_q_outcome_status.addBatch();

				i++;
				if(i % 1000 == 0 || i == outcomeStatuses_.size())
				{
					_q_outcome_status.executeBatch();
					controller.getQueue().setText("Outcome satatus Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			outcomeStatuses_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//betting offer table 7
	public void insertIntoOutcomTypeTable(LinkedList<OutcomeType> outcomeTypes_)
	{
		try
		{
			int i = 0;
			for(OutcomeType outcomeType : outcomeTypes_)
			{
				_q_outcome_type.setLong(1, getLongNumber(outcomeType.getId()));
				_q_outcome_type.setInt(2, getIntNumber(outcomeType.getVersion()));
				_q_outcome_type.setString(3, outcomeType.getName());
				_q_outcome_type.setString(4, outcomeType.getDescription());
				_q_outcome_type.setBoolean(5, getDecision(outcomeType.getHasParamFloat1()));
				_q_outcome_type.setString(6, outcomeType.getParamFloat1Description());
				_q_outcome_type.setBoolean(7, getDecision(outcomeType.getHasParamFloat2()));
				_q_outcome_type.setString(8, outcomeType.getParamFloat2Description());
				_q_outcome_type.setBoolean(9, getDecision(outcomeType.getHasParamFloat3()));
				_q_outcome_type.setString(10, outcomeType.getParamFloat3Description());
				_q_outcome_type.setBoolean(11, getDecision(outcomeType.getHasParamBoolean1()));
				_q_outcome_type.setString(12, outcomeType.getParamBoolean1Description());
				_q_outcome_type.setBoolean(13, getDecision(outcomeType.getHasParamString1()));
				_q_outcome_type.setString(14, outcomeType.getParamString1Description());
				_q_outcome_type.setString(15, outcomeType.getParamString1PossibleValues());
				_q_outcome_type.setBoolean(16, getDecision(outcomeType.getHasParamParticipantId1()));
				_q_outcome_type.setString(17, outcomeType.getParamParticipantId1Description());
				_q_outcome_type.setBoolean(18, getDecision(outcomeType.getParamParticipant1MustBePrimary()));
				_q_outcome_type.setBoolean(19, getDecision(outcomeType.getParamParticipant1MustBeRoot()));
				_q_outcome_type.setLong(20, getLongNumber(outcomeType.getParamParticipant1MustHaveRoleId()));
				_q_outcome_type.setBoolean(21, getDecision(outcomeType.getHasParamParticipantId2()));
				_q_outcome_type.setString(22, outcomeType.getParamParticipantId2Description());
				_q_outcome_type.setBoolean(23, getDecision(outcomeType.getParamParticipant2MustBePrimary()));
				_q_outcome_type.setBoolean(24, getDecision(outcomeType.getParamParticipant2MustBeRoot()));
				_q_outcome_type.setLong(25, getLongNumber(outcomeType.getParamParticipant2MustHaveRoleId()));
				_q_outcome_type.setBoolean(26, getDecision(outcomeType.getHasParamParticipantId3()));
				_q_outcome_type.setString(27, outcomeType.getParamParticipantId3Description());
				_q_outcome_type.setBoolean(28, getDecision(outcomeType.getParamParticipant3MustBePrimary()));
				_q_outcome_type.setBoolean(29, getDecision(outcomeType.getParamParticipant3MustBeRoot()));
				_q_outcome_type.setLong(30, getLongNumber(outcomeType.getParamParticipant3MustHaveRoleId()));
				_q_outcome_type.setBoolean(31, getDecision(outcomeType.getHasParamEventPartId1()));
				_q_outcome_type.setString(32, outcomeType.getParamEventPartId1Description());
				_q_outcome_type.addBatch();

				i++;
				if(i % 1000 == 0 || i == outcomeTypes_.size())
				{
					_q_outcome_type.executeBatch();
					controller.getQueue().setText("Outcome type Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			outcomeTypes_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//outcome type usage 8
	public void insertIntoOutcomeTypeUsageTable(LinkedList<OutcomeTypeUsage> outcomeTypeUsages_)
	{
		try
		{
			int i = 0;
			for(OutcomeTypeUsage outcomeTypeUsage : outcomeTypeUsages_)
			{
				_q_outcome_type_usage.setLong(1, getLongNumber(outcomeTypeUsage.getId()));
				_q_outcome_type_usage.setInt(2, getIntNumber(outcomeTypeUsage.getVersion()));
				_q_outcome_type_usage.setLong(3, getLongNumber(outcomeTypeUsage.getOutcomeTypeId()));
				_q_outcome_type_usage.setLong(4, getLongNumber(outcomeTypeUsage.getEventTypeId()));
				_q_outcome_type_usage.setLong(5, getLongNumber(outcomeTypeUsage.getEventPartId()));
				_q_outcome_type_usage.setLong(6, getLongNumber(outcomeTypeUsage.getSportId()));
				_q_outcome_type_usage.addBatch();

				i++;
				if(i % 1000 == 0 || i == outcomeTypeUsages_.size())
				{
					_q_outcome_type_usage.executeBatch();
					controller.getQueue().setText("Outcome Type Usage Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			outcomeTypeUsages_.clear();
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	

	//outcometypebettingtyperelation 9
	public void insertIntoOutcomeTypeBettingTypeRelationTable(LinkedList<OutcomeTypeBettingTypeRelation> outcomeTypeBettingTypeRelations_)
	{
		try
		{
			int i = 0;
			for(OutcomeTypeBettingTypeRelation outcomeTypeBettingTypeRelation : outcomeTypeBettingTypeRelations_)
			{
				_q_outcome_type_betting_type_relation.setLong(1, getLongNumber(outcomeTypeBettingTypeRelation.getId()));
				_q_outcome_type_betting_type_relation.setInt(2, getIntNumber(outcomeTypeBettingTypeRelation.getVersion()));
				_q_outcome_type_betting_type_relation.setLong(3, getLongNumber(outcomeTypeBettingTypeRelation.getOutcomeTypeId()));
				_q_outcome_type_betting_type_relation.setLong(4, getLongNumber(outcomeTypeBettingTypeRelation.getBettingTypeId()));
				_q_outcome_type_betting_type_relation.addBatch();

				i++;
				if(i % 1000 == 0 || i == outcomeTypeBettingTypeRelations_.size())
				{
					_q_outcome_type_betting_type_relation.executeBatch();
					controller.getQueue().setText("OutcomeType Betting Type Relation Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			outcomeTypeBettingTypeRelations_.clear();
		}
		catch(SQLException exp)
		{

			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//source 10
	public void insertIntoSourceTable(LinkedList<Source> sources_)
	{
		try
		{
			int i = 0;
			for(Source source : sources_)
			{
				
				_q_source.setLong(1, getLongNumber(source.getId()));
				_q_source.setInt(2, getIntNumber(source.getVersion()));
				_q_source.setLong(3, getLongNumber(source.getCollectorId()));
				_q_source.setLong(4, getLongNumber(source.getProviderId()));
				_q_source.setString(5, source.getSourceKey());
				_q_source.setTimestamp(6, getDate(source.getLastCollectedTime()));
				_q_source.setTimestamp(7, getDate(source.getLastUpdatedTime()));
				_q_source.addBatch();

				i++;
				if(i % 1000 == 0 || i == sources_.size())
				{
					_q_source.executeBatch();
					controller.getQueue().setText("Source Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			sources_.clear();

		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//betting offer table 1
	public void insertIntoBettingOfferTable(BettingOffer bettingOffer)
	{
		try
		{
			_q_betting_offer.setLong(1, getLongNumber(bettingOffer.getId()));
			_q_betting_offer.setInt(2, getIntNumber(bettingOffer.getVersion()));
			_q_betting_offer.setLong(3, getLongNumber(bettingOffer.getProviderId()));
			_q_betting_offer.setLong(4, getLongNumber(bettingOffer.getSourceId()));
			_q_betting_offer.setLong(5, getLongNumber(bettingOffer.getOutcomeId()));
			_q_betting_offer.setLong(6, getLongNumber(bettingOffer.getBettingTypeId()));
			_q_betting_offer.setLong(7, getLongNumber(bettingOffer.getStatusId()));
			_q_betting_offer.setBoolean(8, getDecision(bettingOffer.getIsLive()));
			_q_betting_offer.setFloat(9, getFloatNumber(bettingOffer.getOdds()));
			_q_betting_offer.setInt(10, getIntNumber(bettingOffer.getMultiplicity()));
			_q_betting_offer.setFloat(11, getFloatNumber(bettingOffer.getVolume()));
			_q_betting_offer.setLong(12, getLongNumber(bettingOffer.getVolumeCurrencyId()));
			_q_betting_offer.setString(13, bettingOffer.getCouponKey());
			_q_betting_offer.setInt(14, getIntNumber(bettingOffer.getSlotNum()));
			_q_betting_offer.setTimestamp(15, getDate(bettingOffer.getLastChangedTime()));			
			_q_betting_offer.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Betting Offer Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//betting offer status table 2
	public void insertIntoBettingOfferStatusTable(BettingOfferStatus bettingOfferStatus)
	{
		try
		{
			_q_betting_offer_status.setLong(1, getLongNumber(bettingOfferStatus.getId()));
			_q_betting_offer_status.setInt(2, getIntNumber(bettingOfferStatus.getVersion()));
			_q_betting_offer_status.setString(3, bettingOfferStatus.getName());
			_q_betting_offer_status.setBoolean(4, getDecision(bettingOfferStatus.getIsAvailable()));
			_q_betting_offer_status.setString(5, bettingOfferStatus.getDescription());
			_q_betting_offer_status.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Betting Offer status Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//betting type table 3
	public void insertIntoBettingTypeTable(BettingType bettingType)
	{
		try
		{
			_q_betting_type.setLong(1, getLongNumber(bettingType.getId()));
			_q_betting_type.setInt(2, getIntNumber(bettingType.getVersion()));
			_q_betting_type.setString(3, bettingType.getName());
			_q_betting_type.setString(4, bettingType.getDescription());
			_q_betting_type.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Betting Type Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//betting type usage 4
	public void insertIntoBettingTypeUsageTable(BettingTypeUsage bettingTypeUsage)
	{
		try
		{
			_q_betting_type_usage.setLong(1, getLongNumber(bettingTypeUsage.getId()));
			_q_betting_type_usage.setInt(2, getIntNumber(bettingTypeUsage.getVersion()));
			_q_betting_type_usage.setLong(3, getLongNumber(bettingTypeUsage.getBettingTypeId()));
			_q_betting_type_usage.setLong(4, getLongNumber(bettingTypeUsage.getEventTypeId()));
			_q_betting_type_usage.setLong(5, getLongNumber(bettingTypeUsage.getSportId()));
			_q_betting_type_usage.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Betting Type Usage Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//outcome table 5
	public void insertIntoOutcomeTable(Outcome outcome)
	{
		try
		{
			_q_outcome.setLong(1, getLongNumber(outcome.getId()));
			_q_outcome.setInt(2, getIntNumber(outcome.getVersion()));
			_q_outcome.setLong(3, getLongNumber(outcome.getTypeId()));
			_q_outcome.setBoolean(4, getDecision(outcome.getIsNegation()));
			_q_outcome.setLong(5, getLongNumber(outcome.getStatusId()));
			_q_outcome.setLong(6, getLongNumber(outcome.getEventId()));
			_q_outcome.setLong(7, getLongNumber(outcome.getEventPartId()));
			_q_outcome.setFloat(8, getFloatNumber(outcome.getParamFloat1()));
			_q_outcome.setFloat(9, getFloatNumber(outcome.getParamFloat2()));
			_q_outcome.setFloat(10, getFloatNumber(outcome.getParamFloat3()));
			_q_outcome.setBoolean(11, getDecision(outcome.getParamBoolean1()));
			_q_outcome.setString(12, outcome.getParamString1());
			_q_outcome.setLong(13, getLongNumber(outcome.getParamParticipantId1()));
			_q_outcome.setLong(14, getLongNumber(outcome.getParamParticipantId2()));
			_q_outcome.setLong(15, getLongNumber(outcome.getParamParticipantId3()));
			_q_outcome.setLong(16, getLongNumber(outcome.getParamEventPartId1()));
			_q_outcome.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Outcome Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//outcome status 6
	public void insertIntoOutcomeStatusTable(OutcomeStatus outcomeStatus)
	{
		try
		{
			_q_outcome_status.setLong(1, getLongNumber(outcomeStatus.getId()));
			_q_outcome_status.setInt(2, getIntNumber(outcomeStatus.getVersion()));
			_q_outcome_status.setString(3, outcomeStatus.getName());
			_q_outcome_status.setString(4, outcomeStatus.getDescription());
			_q_outcome_status.executeUpdate();
			controller.getQueue().setText("Outcome satatus Entity inserted Successfully", controller.getQueue().getEntityIndex());
			connection.commit();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//betting offer table 7
	public void insertIntoOutcomTypeTable(OutcomeType outcomeType)
	{
		try
		{
			_q_outcome_type.setLong(1, getLongNumber(outcomeType.getId()));
			_q_outcome_type.setInt(2, getIntNumber(outcomeType.getVersion()));
			_q_outcome_type.setString(3, outcomeType.getName());
			_q_outcome_type.setString(4, outcomeType.getDescription());
			_q_outcome_type.setBoolean(5, getDecision(outcomeType.getHasParamFloat1()));
			_q_outcome_type.setString(6, outcomeType.getParamFloat1Description());
			_q_outcome_type.setBoolean(7, getDecision(outcomeType.getHasParamFloat2()));
			_q_outcome_type.setString(8, outcomeType.getParamFloat2Description());
			_q_outcome_type.setBoolean(9, getDecision(outcomeType.getHasParamFloat3()));
			_q_outcome_type.setString(10, outcomeType.getParamFloat3Description());
			_q_outcome_type.setBoolean(11, getDecision(outcomeType.getHasParamBoolean1()));
			_q_outcome_type.setString(12, outcomeType.getParamBoolean1Description());
			_q_outcome_type.setBoolean(13, getDecision(outcomeType.getHasParamString1()));
			_q_outcome_type.setString(14, outcomeType.getParamString1Description());
			_q_outcome_type.setString(15, outcomeType.getParamString1PossibleValues());
			_q_outcome_type.setBoolean(16, getDecision(outcomeType.getHasParamParticipantId1()));
			_q_outcome_type.setString(17, outcomeType.getParamParticipantId1Description());
			_q_outcome_type.setBoolean(18, getDecision(outcomeType.getParamParticipant1MustBePrimary()));
			_q_outcome_type.setBoolean(19, getDecision(outcomeType.getParamParticipant1MustBeRoot()));
			_q_outcome_type.setLong(20, getLongNumber(outcomeType.getParamParticipant1MustHaveRoleId()));
			_q_outcome_type.setBoolean(21, getDecision(outcomeType.getHasParamParticipantId2()));
			_q_outcome_type.setString(22, outcomeType.getParamParticipantId2Description());
			_q_outcome_type.setBoolean(23, getDecision(outcomeType.getParamParticipant2MustBePrimary()));
			_q_outcome_type.setBoolean(24, getDecision(outcomeType.getParamParticipant2MustBeRoot()));
			_q_outcome_type.setLong(25, getLongNumber(outcomeType.getParamParticipant2MustHaveRoleId()));
			_q_outcome_type.setBoolean(26, getDecision(outcomeType.getHasParamParticipantId3()));
			_q_outcome_type.setString(27, outcomeType.getParamParticipantId3Description());
			_q_outcome_type.setBoolean(28, getDecision(outcomeType.getParamParticipant3MustBePrimary()));
			_q_outcome_type.setBoolean(29, getDecision(outcomeType.getParamParticipant3MustBeRoot()));
			_q_outcome_type.setLong(30, getLongNumber(outcomeType.getParamParticipant3MustHaveRoleId()));
			_q_outcome_type.setBoolean(31, getDecision(outcomeType.getHasParamEventPartId1()));
			_q_outcome_type.setString(32, outcomeType.getParamEventPartId1Description());
			_q_outcome_type.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Outcome type Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//outcome type usage 8
	public void insertIntoOutcomeTypeUsageTable(OutcomeTypeUsage outcomeTypeUsage)
	{
		try
		{
			_q_outcome_type_usage.setLong(1, getLongNumber(outcomeTypeUsage.getId()));
			_q_outcome_type_usage.setInt(2, getIntNumber(outcomeTypeUsage.getVersion()));
			_q_outcome_type_usage.setLong(3, getLongNumber(outcomeTypeUsage.getOutcomeTypeId()));
			_q_outcome_type_usage.setLong(4, getLongNumber(outcomeTypeUsage.getEventTypeId()));
			_q_outcome_type_usage.setLong(5, getLongNumber(outcomeTypeUsage.getEventPartId()));
			_q_outcome_type_usage.setLong(6, getLongNumber(outcomeTypeUsage.getSportId()));
			_q_outcome_type_usage.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Outcome Type Usage Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	

	//outcometypebettingtyperelation 9
	public void insertIntoOutcomeTypeBettingTypeRelationTable(OutcomeTypeBettingTypeRelation outcomeTypeBettingTypeRelation)
	{
		try
		{
			_q_outcome_type_betting_type_relation.setLong(1, getLongNumber(outcomeTypeBettingTypeRelation.getId()));
			_q_outcome_type_betting_type_relation.setInt(2, getIntNumber(outcomeTypeBettingTypeRelation.getVersion()));
			_q_outcome_type_betting_type_relation.setLong(3, getLongNumber(outcomeTypeBettingTypeRelation.getOutcomeTypeId()));
			_q_outcome_type_betting_type_relation.setLong(4, getLongNumber(outcomeTypeBettingTypeRelation.getBettingTypeId()));
			_q_outcome_type_betting_type_relation.executeUpdate();
			connection.commit();
			controller.getQueue().setText("OutcomeType Betting Type Relation Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{

			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	//source 10
	public void insertIntoSourceTable(Source source)
	{
		try
		{
			_q_source.setLong(1, getLongNumber(source.getId()));
			_q_source.setInt(2, getIntNumber(source.getVersion()));
			_q_source.setLong(3, getLongNumber(source.getCollectorId()));
			_q_source.setLong(4, getLongNumber(source.getProviderId()));
			_q_source.setString(5, source.getSourceKey());
			_q_source.setTimestamp(6, getDate(source.getLastCollectedTime()));
			_q_source.setTimestamp(7, getDate(source.getLastUpdatedTime()));
			_q_source.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Source Entity inserted Successfully", controller.getQueue().getEntityIndex());
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
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
		return (number == null ? -1 : number);
	}
	
}
