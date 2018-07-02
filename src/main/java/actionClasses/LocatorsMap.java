/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author neerajsah
 */
public class LocatorsMap 
{
    HashMap<String,String> nameToType;
    HashMap<String,String> nameToValue;
    
    public LocatorsMap() throws IOException
    {
      String filePath="C:\\Users\\neerajsah\\Documents\\NetBeansProjects\\TatocwithLocatorFile\\src\\main\\java\\locator.locators.txt";
      
      nameToType=new HashMap<>();
      nameToValue=new HashMap<>();
      
      String line;
      BufferedReader br=new BufferedReader(new FileReader(filePath));
      while((line=br.readLine())!=null)
      {
         String[] parts = line.split(":",3);
         if (parts.length >= 2)
	        {
	            String name = parts[0];
	            String type = parts[1];
	            String value = parts[2];
	            nameToType.put(name, type);
	            nameToValue.put(name, value);
	        } else {
	            System.out.println("ignoring line: " + line);
	        }
	    }
	    br.close();
      
    }
    
    public String getLocatorType(String LocatorName) {
		return nameToType.get(LocatorName);
		
	}
	
	public String getLocatorValue(String LocatorName) {
		return nameToValue.get(LocatorName);
	}
}
