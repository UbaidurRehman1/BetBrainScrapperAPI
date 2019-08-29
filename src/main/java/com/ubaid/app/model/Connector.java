package com.ubaid.app.model;

import com.betbrain.sepc.connector.sdql.SEPCConnector;
import com.betbrain.sepc.connector.sdql.SEPCPushConnector;
import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.Location.InsertInToLocation;
import com.ubaid.app.model.insert.event.InsertInToEvent;

public class Connector implements Runnable
{
	protected Controller controller;
	
	public Connector(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public void run()
	{
		
		controller.setInsertInToEvent(new InsertInToEvent(controller));
		controller.setInsertInToLocation(new InsertInToLocation(controller));
		
		SEPCConnector sepcPullConnector = new SEPCPushConnector("sept.oddsmatrix.com", 7000);		
		sepcPullConnector.addConnectorListener(new ConnecterListener(controller));
		sepcPullConnector.start("Linas");	
	}
	
	
}
