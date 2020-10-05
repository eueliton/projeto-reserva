package com.globoteste.reserva.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateService {
	
	public static Date convertStringToDate(String data) {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date = null;
		try {
			date = (Date) formatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}


}
