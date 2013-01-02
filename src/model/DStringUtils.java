package model;

import java.util.ArrayList;
import java.util.List;


public class DStringUtils {

	public List<String>  getContentBetweenTags(String content, String tagFrom, String tagTo){
		
		List <String> lst = new ArrayList<String>();
		
		while(content.contains(tagFrom)){;
			lst.add(content.substring(content.indexOf(tagFrom)+4, content.indexOf(tagTo)));
			content = content.substring(content.indexOf(tagTo)+4);
		}
		return lst;
		
	}      
	    	
}
