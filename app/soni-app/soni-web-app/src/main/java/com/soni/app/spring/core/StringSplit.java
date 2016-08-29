package com.soni.app.spring.core;


public class StringSplit {
public static void main(String[] args) {
	
	countRepeatedCharacters("Haridasonisss", "st");
	
}

public static String countRepeatedCharacters(String original,String removeString)
{
	int start,end=0;
	char []originoalStringArray=original.toCharArray();
	char []removeStringArray=removeString.toCharArray();
	
	boolean []isremoveCharacter=new boolean[128];
	for(start=0;start<removeStringArray.length;start++)
	{
		
		isremoveCharacter[removeStringArray[start]]=true;
	}
	
	
	for(start=0;start<originoalStringArray.length;start++)
	{
		if(!isremoveCharacter[originoalStringArray[start]])
		{
			originoalStringArray[end++]=originoalStringArray[start];
		}
		
	}
	
	
	return new String(originoalStringArray, 0, end);
}
}
