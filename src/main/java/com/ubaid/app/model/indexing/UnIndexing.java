package com.ubaid.app.model.indexing;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ubaid.app.controller.Controller;
import com.ubaid.app.model.insert.preparedStatement.PreparedStatementsForIndexing;

public class UnIndexing extends PreparedStatementsForIndexing implements Runnable
{
	protected Controller controller;
	
	public UnIndexing(Controller controller)
	{
		super(controller);
		this.controller = controller;
	}

	@Override
	public void run()
	{			
		try
		{
			ResultSet resultSet = event_show_index_q.executeQuery();
			resultSet.next();
			int numberOfRows = resultSet.getRow();

			if(numberOfRows == 1)
			{
				//events
				event_drop_index_q.execute();
				event_part_drop_index_q.execute();
				event_template_drop_index_q.execute();
				event_type_usage_drop_index_q.execute();
				event_part_default_usage_drop_index_q.execute();
				event_type_drop_index_q.execute();
				event_status_drop_index_q.execute();
				provider_event_relation_drop_index_q.execute();
				sport_drop_index_q.execute();
				provider_drop_index_q.execute();
				event_participant_relation_drop_index_q.execute();
				event_participant_restriction_drop_index_q.execute();
				//location
				location_drop_index_q.execute();
				location_type_drop_index_q.execute();
				location_relation_drop_index_q.execute();
				location_relation_type_drop_index_q.execute();
				//betting
				betting_offer_drop_index_q.execute();
				betting_offer_status_drop_index_q.execute();
				betting_type_drop_index_q.execute();
				betting_type_usage_drop_index_q.execute();
				outcome_drop_index_q.execute();
				outcome_status_drop_index_q.execute();
				outcome_type_drop_index_q.execute();
				outcome_type_usage_drop_index_q.execute();
				outcome_type_betting_type_relation_drop_index_q.execute();
				source_drop_index_q.execute();		
				//participant
				participant_drop_index_q.execute();
				participant_usage_drop_index_q.execute();
				participant_role_drop_index_q.execute();
				participant_type_role_usage_drop_index_q.execute();
				participant_type_drop_index_q.execute();
				participant_relation_drop_index_q.execute();
				participant_relation_type_drop_index_q.execute();
				
				//odds history
				odds_history_drop_index_q.execute();
			}
			else
			{
				controller.getQueue().setIndex("The tables are already un indexed");
			}
			
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		
	}
	
}
