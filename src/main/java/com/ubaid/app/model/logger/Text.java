package com.ubaid.app.model.logger;

public class Text
{
	
	private String message;
	private Level level;
	private int index;
	
	public Text(String message, Level level, int index)
	{
		this.level = level;
		this.message = message;
		this.index = index;
	}

	public String getMessage()
	{
		return message;
	}

	public Level getLevel()
	{
		return level;
	}
	
	public long getIndex()
	{
		return index;
	}
	
	@Override
	public String toString()
	{
		String string = null;
		
		switch (level)
		{
			case ERROR:
				string = String.format("%s%d", "Error:- ", getIndex());
				break;
			case WARN:
				string = String.format("%s%d", "Duplication:- ", getIndex());
				break;
			case INFO:
				string = String.format("%s%d", "ID:- ", getIndex());
				break;
			case DEBUG:
				break;
			default:
				break;
		}
		
		return string + ":::" + getMessage();
	}
}
