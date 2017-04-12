package example;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.apache.commons.lang.WordUtils;


public class Hello {

    public static int max(int a, int b)
    {
    	return a > b ? a : b;
    }

    public static void main(String[] args) {
        String  message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
                                + " : " + WordUtils.capitalizeFully(message));
	
	try {
    	CSVReader reader = new CSVReader(new FileReader("data.csv"),',');
    	List<String[]> myEntries = reader.readAll();
	int monmax = 0;        
	for(String[] s : myEntries)
        {
		for(String nb : s)
		{
			System.out.println("Nombre lu : "+ nb);
                	monmax = max(monmax, Integer.parseInt(nb));

		}
        }
        System.out.println("Mon max : " + monmax);
	
	}
	catch(Exception e)
	{
		System.out.println("Erreu" + e.getMessage());
	}
    }
}
        
