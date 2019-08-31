package com.ubaid.app.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.betbrain.sepc.connector.sdql.SEPCConnectorListener;
import com.betbrain.sepc.connector.sportsmodel.Entity;
import com.betbrain.sepc.connector.sportsmodel.EntityChange;
import com.betbrain.sepc.connector.sportsmodel.EntityChangeBatch;
import com.ubaid.app.controller.Controller;

public class ConnecterListener implements SEPCConnectorListener
{
	protected Controller controller;
	protected ExecutorService threadPool = Executors.newFixedThreadPool(1);;
	LinkedList<EntityChange> entityChanges = new LinkedList<>();
	int i = 0;

	public ConnecterListener(Controller controller)
	{
		this.controller = controller;

	}
	
	@Override
	public void notifyInitialDump(List<? extends Entity> entities)
	{
		if(controller.isBulkDataAllowed())
		{
			Insertion insertion = new Insertion(entities, controller, 1);
			threadPool.execute(insertion);
			threadPool.shutdown();		
			controller.setBulkDataAllowed(false);
		}
	}

	@Override
	public void notifyEntityUpdates(EntityChangeBatch entityChangeBatch)
	{
		try
		{
			controller.getEntityChangeBatchs_queue().put(entityChangeBatch);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
} 


