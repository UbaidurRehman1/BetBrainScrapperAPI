package com.ubaid.app.model.indexing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementsForIndexing;

public class DoIndexing extends PreparedStatementsForIndexing implements Runnable
{

	protected Controller controller;
	
	public DoIndexing(Controller controller)
	{
		super(controller);
		this.controller = controller;
	}

	@Override
	public void run()
	{
		try
		{
			
			ExecutorService unindexPool = Executors.newFixedThreadPool(1);
			unindexPool.execute(new UnIndexing(controller));
			unindexPool.shutdown();
			
			while(true)
			{
				if(unindexPool.isTerminated())
				{
					
					ResultSet resultSet = event_show_index_q.executeQuery();
					resultSet.next();
					int numberOfRows = resultSet.getRow();
					
					if(numberOfRows == 0)
					{
						//first set sql invalid dates
						invalidDate.execute();
						
						//events
						event_add_index_q.execute();
						event_part_add_index_q.execute();
						event_template_add_index_q.execute();
						event_type_usage_add_index_q.execute();
						event_part_default_usage_add_index_q.execute();
						event_type_add_index_q.execute();
						event_status_add_index_q.execute();
						provider_event_relation_add_index_q.execute();
						sport_add_index_q.execute();
						provider_add_index_q.execute();
						event_participant_relation_add_index_q.execute();
						event_participant_restriction_add_index_q.execute();
						//location
						location_add_index_q.execute();
						location_type_add_index_q.execute();
						location_relation_add_index_q.execute();
						location_relation_type_add_index_q.execute();
						//betting
						betting_offer_add_index_q.execute();
						betting_offer_status_add_index_q.execute();
						betting_type_add_index_q.execute();
						betting_type_usage_add_index_q.execute();
						outcome_add_index_q.execute();
						outcome_status_add_index_q.execute();
						outcome_type_add_index_q.execute();
						outcome_type_usage_add_index_q.execute();
						outcome_type_betting_type_relation_add_index_q.execute();
						source_add_index_q.execute();
						//participant
						participant_add_index_q.execute();
						participant_usage_add_index_q.execute();
						participant_role_add_index_q.execute();
						participant_type_role_usage_add_index_q.execute();
						participant_relation_add_index_q.execute();
						participant_relation_type_add_index_q.execute();
						//odds history
						odds_history_add_index_q.execute();
					}
					else
					{
						controller.getQueue().setIndex("The tables are already indexed");
					}
					break;
				}
				else
				{
					Thread.sleep(1000);
				}
			}
			


		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException exp)
		{
			exp.printStackTrace();
		}
	}
	
}
