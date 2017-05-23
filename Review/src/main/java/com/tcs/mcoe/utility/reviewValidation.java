package com.tcs.mcoe.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class reviewValidation {
	static Pattern productIdpattern=Pattern.compile("^p[0-9]$");
	//static Pattern numberOfStarspattern=Pattern.compile("^[0-5]");
	
	public static boolean isValidproductId(String id) {
	
	if(id == null)
		return false;
		Matcher match=productIdpattern.matcher(id);
		if(!match.matches())
			return false;
		else
			return true;
	}
	public static boolean isValidStars(Double stars) {
	//	Matcher match=numberOfStarspattern.matcher(stars);
		if(stars>5 || stars<0)
			return false;
		else
			return true;
	}
	}