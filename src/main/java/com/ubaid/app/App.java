package com.ubaid.app;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.logger.Queue;

/**
 * main class
 * load fxml file, css file, and start an application
 * @author ubaid
 *
 */
public class App
{
	//constructor
	public App()
	{
		//this is Queue class, having blocking queue
		//storing information about (info, exception, warnings)
		Queue queue = new Queue();
		
		try
		{	
			//controller
			new Controller(queue);
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			queue.setText(exp, queue.getErrorIndex());
		}
	}
}


