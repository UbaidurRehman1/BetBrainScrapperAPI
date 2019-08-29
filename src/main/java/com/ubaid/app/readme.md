First create the LinkedLists of all instances
and then we execute in single thread, all of insertion commands

int i = 0;
for(Event event : events)
{

		_q_event.addBatch();
		i++;
		
		if(i % 1000 == 0 || i == eventParts_.size())
		{
			_q_event_part.executeBatch();
			controller.getQueue().setText("Event Part Batch inserted Successfully", 					controller.getQueue().getEntityIndex());
			connection.commit()
		}
	
}


//I want a thing which is in my mind:
//when we start our application, then 
//we first make sure no duplication (uniqueness)
//so, in the loop, first we check the id from the (ids of the table)
//or
//we can do, first delete this thing and then insert in....
//but this is not a good practice, 
//or
//first delete the batch 

//but the simple thing is that: make a collections of ids (long)
//check the id, if it is present, then do not do 
//if not then insert it:


step-1
create a arraylist containing all the ids of all tables


step-2
and refine the linked list by comparing