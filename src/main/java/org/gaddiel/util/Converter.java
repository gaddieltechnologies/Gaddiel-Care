package org.gaddiel.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


// TODO: Auto-generated Javadoc
/**
 * The Class Converter.
 */

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.gaddiel.model.Userprivilege;


public class Converter {
	
	/**
	 * String array to string.
	 *
	 * @param args the args
	 * @return the string buffer
	 */
	public static StringBuffer StringArrayToString(String[] args)
	{
		
		StringBuffer str =new StringBuffer();
		   if(args!=null && args.length!=0 )
		     {
		    
			     int len=args.length-1;
			     String temp="";
			     for(int i=0; i<args.length; i++)
			     {
					   temp = args[i];
					    
					   if(len!=(i))
					   {
					    str.append("'"+temp+"'"+",");
					   
					   }
					   else
					   {
					    str.append("'"+temp+"'");
					   
					   }
			   
			  }
		     }
		return str;
		
	}
	
	/**
	 * Stringto datefor db.
	 *
	 * @param date the date
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date StringtoDateforDB(String date) throws ParseException
	  {
	   
	   String inputstrdate=date==null?"":date;
	   DateFormat inputdate=new SimpleDateFormat("dd-MM-yyyy");
	   Date indate=inputdate.parse(inputstrdate);
	   DateFormat outputdate=new SimpleDateFormat("yyyy-MM-dd");
	   String outstrdate=outputdate.format(indate);
	   return outputdate.parse(outstrdate);
	   
	  }
	 
 	/**
 	 * Format date.
 	 *
 	 * @param date the date
 	 * @return the string
 	 * @throws ParseException the parse exception
 	 */
 	public static String FormatDate(String date) throws ParseException
	  {
	   
	   String inputstrdate=date==null?"":date;
	   DateFormat inputdate=new SimpleDateFormat("yyyy-MM-dd");
	   Date indate=inputdate.parse(inputstrdate);
	   DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy");
	   String outstrdate=outputdate.format(indate);
	   return outstrdate;
	   
	  }
	 public static String FormatTimestamp(String date) throws ParseException
	  {
	   
	   String inputstrdate=date==null?"":date;
	   DateFormat inputdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   Date indate=inputdate.parse(inputstrdate);
	   DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	   String outstrdate=outputdate.format(indate);
	   return outstrdate;
	   
	  }
	 public static void roleprivilleges(HttpSession session,Userprivilege userprivilege)
	 {
		 session.removeAttribute("DELETE");
		 session.removeAttribute("INSERT");
		 session.removeAttribute("UPDATE");
		 session.removeAttribute("READ");
		 session.removeAttribute("REPORT");
		 System.out.println(" DELETE----for -->"+userprivilege.getDeleteflag()+"\t"+"INSERT--->"+userprivilege.getInsertflag()+"\t"+
		                    " UPDATE----->"+userprivilege.getUpdateflag()+"\t"+" REport --->"+userprivilege.getReportflag());
		 session.setAttribute("DELETE", userprivilege.getDeleteflag());
		 session.setAttribute("INSERT", userprivilege.getInsertflag());
		 session.setAttribute("UPDATE", userprivilege.getUpdateflag());
		 session.setAttribute("READ", userprivilege.getReadflag());
		 session.setAttribute("REPORT", userprivilege.getReportflag());
		 
	 }

}
