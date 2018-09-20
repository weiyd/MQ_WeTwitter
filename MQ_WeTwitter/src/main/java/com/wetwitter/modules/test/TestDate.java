package com.wetwitter.modules.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate 
{
	public static void main(String[] args) throws ParseException 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d,yyyy K:m:s a",Locale.ENGLISH);
		Date date = sdf.parse("Jul 26,2018 06:33:06 PM");
		System.out.println("date==" + date);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = sd.format(date);
		System.out.println("currDate==" + currDate);
	}

}
