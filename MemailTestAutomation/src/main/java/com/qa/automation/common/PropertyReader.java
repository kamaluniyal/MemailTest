package com.qa.automation.common;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	private Properties prop;

	public PropertyReader(String name) throws IOException{
		try{
			prop = new Properties();		
			prop.load(this.getClass().getClassLoader().getResource(name).openStream());
		}
		catch(Exception e){
			System.out.println("Exception in creating properties file::"+e.getMessage());

		}
	}

	public String getFieldValue(String fieldName){
		try{
			System.out.println("FieldName received ::"+fieldName);
			String value = prop.getProperty(fieldName);

			System.out.println("FieldName's value ::"+value);
			return value ;
		}
		catch(Exception e){
			System.out.println("Exception in retreiving fieldValue for "+fieldName);
			return null;
		}
	}

	public void setFieldValue(String fieldName, String value){
		try{
			System.out.println("FieldName received ::"+fieldName);
			prop.setProperty(fieldName, value);		
			System.out.println(fieldName+" value has been set to::"+value);

		}
		catch(Exception e){
			System.out.println("Exception in setting Value "+value+" for "+fieldName);
		}
	}



}
