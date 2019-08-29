package com.ubaid.app.model.insert;

public interface QuiriesForOdds
{
	String q_event_id_on_betting_id = "SELECT eventId "
			+ "FROM Outcome WHERE id = "
			+ "(SELECT outcomeId FROM BettingOffer WHERE BettingOffer.id = ? limit 1)";
	String q_event_type_on_event_id = "SELECT typeId from Event where id = ?";
	String q_betting_type_name_on_betting_id = "SELECT name FROM BettingType WHERE "
			+ "id = (SELECT bettingTypeId FROM BettingOffer where BettingOffer.id = ? limit 1)";
	String q_thres_hold_on_betting_id = "SELECT paramFloat1 FROM Outcome WHERE id = "
			+ "(SELECT outcomeId FROM BettingOffer where id = ? limit 1)";
	String q_sport_name_on_event_id = "SELECT name FROM Sport WHERE id = "
			+ "(SELECT sportId FROM Event WHERE id = ? limit 1)";
}
