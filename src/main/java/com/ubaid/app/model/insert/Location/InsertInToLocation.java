package com.ubaid.app.model.insert.Location;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.betbrain.sepc.connector.sportsmodel.Location;
import com.betbrain.sepc.connector.sportsmodel.LocationRelation;
import com.betbrain.sepc.connector.sportsmodel.LocationRelationType;
import com.betbrain.sepc.connector.sportsmodel.LocationType;
import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementsForLocation;

/**
 * this class provide a way to insert 
 * data in locations entities
 * @author ubaid
 *
 */
public class InsertInToLocation extends PreparedStatementsForLocation
{
	
	protected Controller controller;
	
	public InsertInToLocation(Controller controller)
	{
		super(controller);
		this.controller = controller;
	}
	
	
	//Location Table -1
	public void insertInLocationTable(LinkedList<Location> locations_)
	{
		try
		{
			int i = 0;
			for(Location location : locations_)
			{
				_q_location.setLong(1, getLongNumber(location.getId()));
				_q_location.setInt(2, getIntNumber(location.getVersion()));
				_q_location.setLong(3, getLongNumber(location.getTypeId()));
				_q_location.setString(4, location.getName());
				_q_location.setString(5, location.getCode());
				_q_location.setBoolean(6, getDecision(location.getIsHistoric()));
				_q_location.setString(7, location.getUrl());
				_q_location.setString(8, location.getNote());
				_q_location.addBatch();

				i++;
				if(i % 1000 == 0 || i == locations_.size())
				{
					_q_location.executeBatch();
					controller.getQueue().setText("Location Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			locations_.clear();

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
	
	public void insertInLocationTypeTable(LinkedList<LocationType> locationTypes_)
	{
		try
		{
			
			int i = 0;
			for(LocationType locationType: locationTypes_)
			{
				_q_location_type.setLong(1, getLongNumber(locationType.getId()));
				_q_location_type.setInt(2, getIntNumber(locationType.getVersion()));
				_q_location_type.setString(3, locationType.getName());
				_q_location_type.setString(4, locationType.getDescription());
				_q_location_type.setBoolean(5, getDecision( locationType.getHasCode()));
				_q_location_type.setString(6, locationType.getCodeDescription());
				_q_location_type.addBatch();

				i++;
				if(i % 1000 == 0 || i == locationTypes_.size())
				{
					_q_location_type.executeBatch();
					controller.getQueue().setText("Location Type Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			locationTypes_.clear();
			
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
	
	public void insertInLocationRelationTable(LinkedList<LocationRelation> locationRelations_)
	{
		try
		{
			int i = 0;
			for(LocationRelation locationRelation : locationRelations_)
			{
				_q_location_relation.setLong(1, getLongNumber(locationRelation.getId()));
				_q_location_relation.setInt(2, getIntNumber(locationRelation.getVersion()));
				_q_location_relation.setLong(3, getLongNumber(locationRelation.getTypeId()));
				_q_location_relation.setLong(4, getLongNumber(locationRelation.getFromLocationId()));
				_q_location_relation.setLong(5, getLongNumber(locationRelation.getToLocationId()));
				_q_location_relation.addBatch();

				i++;
				if(i % 1000 == 0 || i == locationRelations_.size())
				{
					_q_location_relation.executeBatch();
					controller.getQueue().setText("Location Relation Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			locationRelations_.clear();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	public void insertInLocationRelationTypeTable(LinkedList<LocationRelationType> lrTypes_)
	{
		try
		{

			int i = 0;
			for(LocationRelationType lrType : lrTypes_)
			{
				_q_location_relation_type.setLong(1, getLongNumber(lrType.getId()));
				_q_location_relation_type.setInt(2, getIntNumber(lrType.getVersion()));
				_q_location_relation_type.setString(3, lrType.getName());
				_q_location_relation_type.setString(4, lrType.getDescription());
				_q_location_relation_type.addBatch();

				i++;
				if(i % 1000 == 0 || i == lrTypes_.size())
				{
					_q_location_relation_type.executeBatch();
					controller.getQueue().setText("Location Relation Type Batch inserted Successfully", controller.getQueue().getEntityIndex());
					connection.commit();
				}	
			}
			lrTypes_.clear();

		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}
	
	//test----------------------------------------------------
	//Location Table -1
	public void insertInLocationTable(Location location)
	{
		try
		{
			_q_location.setLong(1, getLongNumber(location.getId()));
			_q_location.setInt(2, getIntNumber(location.getVersion()));
			_q_location.setLong(3, getLongNumber(location.getTypeId()));
			_q_location.setString(4, location.getName());
			_q_location.setString(5, location.getCode());
			_q_location.setBoolean(6, getDecision(location.getIsHistoric()));
			_q_location.setString(7, location.getUrl());
			_q_location.setString(8, location.getNote());
			_q_location.executeUpdate();
			connection.commit();
			controller.getQueue().setText("Location Entity inserted Successfully", controller.getQueue().getEntityIndex());
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
	
	public void insertInLocationTypeTable(LocationType locationType)
	{
		try
		{
			_q_location_type.setLong(1, getLongNumber(locationType.getId()));
			_q_location_type.setInt(2, getIntNumber(locationType.getVersion()));
			_q_location_type.setString(3, locationType.getName());
			_q_location_type.setString(4, locationType.getDescription());
			_q_location_type.setBoolean(5, getDecision( locationType.getHasCode()));
			_q_location_type.setString(6, locationType.getCodeDescription());
			_q_location_type.executeUpdate();
			controller.getQueue().setText("Location Type Entity inserted Successfully", controller.getQueue().getEntityIndex());
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
	
	public void insertInLocationRelationTable(LocationRelation locationRelation)
	{
		try
		{
			_q_location_relation.setLong(1, getLongNumber(locationRelation.getId()));
			_q_location_relation.setInt(2, getIntNumber(locationRelation.getVersion()));
			_q_location_relation.setLong(3, getLongNumber(locationRelation.getTypeId()));
			_q_location_relation.setLong(4, getLongNumber(locationRelation.getFromLocationId()));
			_q_location_relation.setLong(5, getLongNumber(locationRelation.getToLocationId()));
			_q_location_relation.executeUpdate();
			controller.getQueue().setText("Location Relation Entity inserted Successfully", controller.getQueue().getEntityIndex());
			connection.commit();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}
		}
		catch(NullPointerException e)
		{
			controller.getQueue().setText(e, controller.getQueue().getErrorIndex());
		}

	}

	public void insertInLocationRelationTypeTable(LocationRelationType lrType)
	{
		try
		{
			_q_location_relation_type.setLong(1, getLongNumber(lrType.getId()));
			_q_location_relation_type.setInt(2, getIntNumber(lrType.getVersion()));
			_q_location_relation_type.setString(3, lrType.getName());
			_q_location_relation_type.setString(4, lrType.getDescription());
			_q_location_relation_type.executeUpdate();
			controller.getQueue().setText("Location Relation Type Entity inserted Successfully", controller.getQueue().getEntityIndex());
			connection.commit();
		}
		catch(SQLException exp)
		{
			if(exp.getErrorCode() == 1062)
			{
				controller.getQueue().setDuplicationWarning(exp, controller.getQueue().getDuplicationIndex());
			}
			else
			{
				controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
			}
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
