package com.ubaid.app.model;

import java.sql.SQLException;
import java.sql.Statement;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.logger.Level;
import com.ubaid.app.model.logger.Queue;
import com.ubaid.app.model.logger.Text;


public class QueueReader implements Runnable
{

	protected Controller controller;
	
	public QueueReader(Controller controller)
	{
		this.controller = controller;
	}
	
	@Override
	public void run()
	{
		Queue queue = controller.getQueue();
		
		while(true)
		{
			
			Text text = queue.getNext();

			System.out.println(text);

			if(text.getLevel() == Level.ERROR)
				setInException(text.toString());
		}
	}
	
	public void setInException(String text)
	{
		try
		{
			Statement statement = controller.getDatabase2().connection.createStatement();
			
			if(statement.execute("INSERT INTO Exception(exception) VALUES('"
					+ text +  "');"))
			{
				System.out.println("Exception inserted");
			}
		}
		catch(SQLException exp)
		{
			System.out.println("\n\n.....................\n\n....................\n\n...................\n\n");
			controller.getQueue().setIndex(exp.getMessage());
		}
	}

}
