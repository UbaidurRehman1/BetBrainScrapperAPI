package com.ubaid.app.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ubaid.app.model.Connector;
import com.ubaid.app.model.QueueReader;
import com.ubaid.app.model.insert.Location.InsertInToLocation;
import com.ubaid.app.model.insert.betting.InsertInToBetting;
import com.ubaid.app.model.insert.event.InsertInToEvent;
import com.ubaid.app.model.insert.oddshistory.InsertIntoOddsHistory;
import com.ubaid.app.model.insert.participant.InsertIntoParticipant;
import com.ubaid.app.model.retrieve.IDRetrieval;
import com.ubaid.app.model.update.UpdateEntity;

/**
 * this class initiate three main classes
 * which are InsertInToBettig, Event and Location
 * @author ubaid
 *
 */
public class Initiater implements Runnable
{
	protected Controller controller;
		
	public Initiater(Controller controller)
	{
		this.controller = controller;
	}
	
	@Override
	public void run()
	{		
		try
		{
			ExecutorService reader = Executors.newFixedThreadPool(1);
			reader.execute(new QueueReader(controller));
			reader.shutdown();
			
			
			//instantiating and setting in controller
			controller.setInsertInToBetting(new InsertInToBetting(controller));
			controller.setInsertInToEvent(new InsertInToEvent(controller));
			controller.setInsertInToLocation(new InsertInToLocation(controller));
			controller.setInsertIntoParticipant(new InsertIntoParticipant(controller));
			controller.setInsertIntoOddsHistory(new InsertIntoOddsHistory(controller));
			
			
			//retriving ids and then storing in the lists
			controller.setIdRetrieval(new IDRetrieval(controller));
			
			//storing instance
			controller.setUpdateEntity(new UpdateEntity(controller));
						
			//connector
			ExecutorService threadPool = Executors.newFixedThreadPool(1);				
			Connector connector = new Connector(controller);
			threadPool.execute(connector);
			threadPool.shutdownNow();
		
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			controller.getQueue().setText(exp, controller.getQueue().getErrorIndex());
		}	
	}	
}
