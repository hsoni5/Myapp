package com.candidate.hr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Hari Soni
 *
 * TODO Discribe the class / interface here
 */
/**
 * @author HSONI
 * TODO Discribe the class /interface here
*/public class Propertylist {

	public static List getProperties(String fileName)
	{
		List propertyList=new ArrayList();
		try{
		Properties properties=new Properties();
		InputStream stream=new FileInputStream(fileName); 
		properties.load(stream);
		String key=null;
		Iterator i=properties.keySet().iterator();
		while (i.hasNext()) {
		
			key=(String)i.next();
			propertyList.add(properties.getProperty(key));
		}
		}
		catch(IOException e)
		{
			
			e.printStackTrace();
		}
		
		return propertyList;
		
	}

	
public static void main(String[] args) {
	getProperties("reason.properties");
}

}
