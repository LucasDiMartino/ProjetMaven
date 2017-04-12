package lulu;

import java.io.*;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;

import com.opencsv.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World mon gars!" );
        System.out.println("Le max est de "+ max(4,5));
	int monmax = 0;
	try {
    	CSVReader reader = new CSVReader(new FileReader("data.csv"),',');
    	List<String[]> myEntries = reader.readAll();
    	List list;
        for(String[] s : myEntries)
        {
        	list = Arrays.asList(s);
			Vector<String> out = new Vector<String>();
			CollectionUtils.select(list, new org.apache.commons.collections.Predicate() {
				public boolean evaluate(Object number) {
					return Integer.parseInt(number.toString()) < 50;
				}
			}, out);
			
			System.out.println("OUT :" + out);
			String[] out_filtered = out.toArray(new String[0]);
			CSVWriter ecrire = new CSVWriter(new FileWriter("data-filtered.csv"));
			ecrire.writeNext(out_filtered);
			
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
    
    public static int max(int a, int b)
    {
    	return a > b ? a : b;
    	//return a; //le stagiaire est par la
    }
}
