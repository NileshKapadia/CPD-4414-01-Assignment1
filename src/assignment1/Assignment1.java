/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
/**
 *
 * @author c0654874 
 * @author c0645457
 */
public class Assignment1 {
    static int  custid;
   static String custname;
  static  String productname;
  static  int quantity;
   static  String notes;
  
   public static void seeOrders()
{Scanner in= new Scanner(System.in);
    JSONParser parser = new JSONParser();
 
	try {
 
		Object obj = parser.parse(new FileReader("c:\\test.json"));
 
		JSONObject jsonObject = (JSONObject) obj;
 
		String name = (String) jsonObject.get("orders");
		System.out.println(name);
 
		
 
		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("orders");
		Iterator<String> iterator = msg.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
 
     
 
}
public static void placeOrders()
{
    Scanner in= new Scanner(System.in);
     System.out.println("enter your customer  id");
     try{
    custid=in.nextInt();
    in.nextLine();
     }
     catch(Exception e)
     {
         System.out.println("We got some problem:" +e);
     }
    System.out.println("enter your name");
    
    try{
    custname=in.nextLine();
    }
     catch(Exception e)
     {
         System.out.println("We got some problem:" +e);
     }
    System.out.println("enter product name you wanna purchase");
    
    try
    {
     productname=in.nextLine();
     
    }
      catch(Exception e)
     {
         System.out.println("We got some problem:" +e);
     }
     System.out.println("enter product quantity");
     try{
         
     
      quantity=in.nextInt();
      in.nextLine();
     }
      catch(Exception e)
     {
         System.out.println("We got some problem:" +e);
     }
       System.out.println("enter some notes");
       try{
            notes=in.nextLine();
       }
       catch(Exception e)
     {
         System.out.println("We got some problem:" +e);
     }
        
 
	JSONObject obj = new JSONObject();
	obj.put("notes", notes);
	
 
	JSONArray list = new JSONArray();
	list.add("customerId:" + custid);
	list.add("customerName:" + custname);
	list.add("product name:" + productname);
        list.add("quantity:" + quantity);
	list.add("notes:" + notes);
 
	obj.put("orders", list);
 
	try {
 
		FileWriter file = new FileWriter("c:\\test.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();
 
	} catch (IOException e) {
		e.printStackTrace();
	}
}
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println("1.Enter you orders\n"
                + "2.See your order");
        Scanner in=new Scanner(System.in);
        int choice=in.nextInt();
        switch(choice)
        {
            case 1:
                placeOrders();
            case 2:
                seeOrders();
                
        }
        
        // TODO code application logic here
    }
    
}
