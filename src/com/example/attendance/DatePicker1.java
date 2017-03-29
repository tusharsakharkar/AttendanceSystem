package com.example.attendance;
//package com.example.stud_attendance;



import java.util.ArrayList;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DatePicker1 extends Activity {
ListView ls;
SQLiteDatabase db;
	private TextView Output;
	private Button changeDate;
final Context context = this;
	private int year;
	private int month;
	private int day;
	
	String date;
Button b1,b2,bdisp;
EditText edit1;
protected String str;
static String word = "",word1 = "", worddd ="",num = "",word5="",word6="";
	static final int DATE_PICKER_ID = 1111; 
	private ArrayList<String> dat = new ArrayList<String>();
	private ArrayList<String> tym = new ArrayList<String>();
	private ArrayList<String> tb = new ArrayList<String>();
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_picker1);
		
		
		try{
		
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ls = (ListView)findViewById(R.id.listView123456);

		changeDate = (Button) findViewById(R.id.changeDate);
		//b1 = (Button)findViewById(R.id.Button011);
	//	bdisp = (Button)findViewById(R.id.Button012);
//edit1  = (EditText)findViewById(R.id.editText11);
		// Get current date by calender
		
		/*
				*/
		/*
		ls.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
			ls.scrollBy(0, 1);
			}
			return false;
			}
			});
		
		*/
		 ls.setOnItemClickListener(new OnItemClickListener() {
	       	 public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
	            {
	       		try{
	              
	       		Intent intent1 = getIntent();
				final String tbname =intent1.getStringExtra("tbname");
				
	       		 
	       		 // position parameter gives the index or position of ListView Item which is Clicked
	                TextView tv=(TextView)v.findViewById(R.id.chut1);
	                TextView tv1 = (TextView)v.findViewById(R.id.chut2);
	                TextView tv2 = (TextView)v.findViewById(R.id.chut3);
	                
	                String s =tv.getText().toString();
	                String tarik = s;
	               // Toast.makeText(getApplicationContext(), "Contact Selected: "+s, Toast.LENGTH_LONG).show();
	                
	                
	                
	                String aa = s.substring(s.lastIndexOf('/')+1);
	                
	                System.out.println(aa);
	                String b = s.substring(s.indexOf('/')+1,s.lastIndexOf('/'));
	                    System.out.println(b);
	                            String c = s.substring(0,s.indexOf('/'));
	                                    System.out.println(c);
	                                    String str = aa+b+c;
	                                    String bb = "",cc = "";
	                                    if(b.length() == 1)
	                                    {
	                                        bb  = "0"+b;
	                                    }
	                                    else
	                                    {
	                                        bb = b;
	                                    }
	                                    if(c.length() == 1)
	                                    {
	                                        cc  = "0"+c;
	                                    }
	                                    else
	                                    {
	                                        cc = c;
	                                    }
	                                                                String str1 = aa+bb+cc;

	                                    
	                                    System.out.println(str1);
	                                    int num = Integer.parseInt(str1);
	                                       //  static String aaaaaaa="";
	                                    while(num != 0){
	        			if(num%10 == 0)
	        			{
	        			word5 = word5 +"a";
	        		    }
	        			else
	        			if(num%10 == 1)
	        			{
	        				word5 = word5 +"b";
	        			}
	        	else
	        			if(num%10 == 2 )
	        			{
	        				word5 = word5 +"c";
	        			}
	        			else
	        			if(num%10 == 3)
	        			{
	        				word5 = word5 +"d";
	        			}
	        			else
	        			if(num%10 == 4)
	        			{
	        				word5 = word5 +"e";
	        			}
	        	else
	        			if(num%10 == 5)
	        			{
	        				word5 = word5 +"f";
	        			}
	        	else
	        			if(num%10 == 6)
	        			{
	        				word5 = word5 +"g";
	        			}
	        	else
	        			if(num%10 == 7)
	        			{
	        				word5 = word5 +"h";
	        			}
	        	else
	        			if(num%10 == 8)
	        			{
	        				word5 = word5 +"i";
	        			}
	        			else
	        			if(num %10 == 9)
	        			{
	        				word5 = word5 +"j";
	        			}
	        			
	        			num = num/10;
	            }

	                                    System.out.println(word);
	                                    String yyyy = tv2.getText().toString();
	                                    String diwas = yyyy;
	                                    
	                                    String sta ="";
	                                    
	                                    

	                                    //String ddayy="";
	                                                    if(yyyy.equalsIgnoreCase("Sunday"))
	                                                    {
	                                                    	sta = "1";
	                                                 	   
	                                                    }else
	                                                 	   if(yyyy.equalsIgnoreCase("Monday"))
	                                                        {
	                                                 		  sta = "2";
	                                                     	   
	                                                        }else
	                                                     	   if(yyyy.equalsIgnoreCase("Tuesday"))
	                                                        {
	                                                     		  sta = "3";
	                                                     	   
	                                                        }else
	                                                     	   if(yyyy.equalsIgnoreCase("Wednesday"))
	                                                            {
	                                                     		  sta = "4";
	                                                         	   
	                                                            }else
	                                                         	   if(yyyy.equalsIgnoreCase("Thursday"))
	                                                                {
	                                                         		  sta = "5";
	                                                             	   
	                                                                }else
	                                                             	   if(yyyy.equalsIgnoreCase("Friday"))
	                                                                    {
	                                                             		  sta = "6";
	                                                                 	   
	                                                                    }else
	                                                                 	   if(yyyy.equalsIgnoreCase("Saturday"))
	                                                                        {
	                                                                 		  sta = "7";
	                                                                     	   
	                                                                        }
	                                                                        
	                                                                 System.out.println(sta);       
	                                     
	                                    
	                                    
	                                    
	                                    
	                                    
	                                    
	                                    
	                                    
	                                    
	                                    String s1 = tv1.getText().toString();
	                                    String vel;
	                                    String a22 = s1.substring(0,s1.indexOf(":"));
	                                    String b22 = s1.substring(s1.indexOf(":")+1,5);
	                                     System.out.println(a22);
	                                     System.out.println(b22);
	                                     String oppp = sta+a22+b22;

	                                     String ffff = a22;
	                                     int hoooo = Integer.parseInt(ffff);
	                                     if(hoooo>12)
	                                     {	
	                                      vel = a22+":"+b22+" PM";
	                                     }
	                                     else
	                                     {
	                                          vel = a22+":"+b22+" AM";

	                                     }
	                                     
	                                     
	                                     
	                                    sta ="";
	                                     
	                                     
	                                     int nummmmm = Integer.parseInt(oppp);
	                                       //  static String aaaaaaa="";
	                                    while(nummmmm != 0){
	        			if(nummmmm%10 == 0)
	        			{
	        			word6 = word6 +"a";
	        		    }
	        			else
	        			if(nummmmm%10 == 1)
	        			{
	        				word6 = word6 +"b";
	        			}
	        	else
	        			if(nummmmm%10 == 2 )
	        			{
	        				word6 = word6 +"c";
	        			}
	        			else
	        			if(nummmmm%10 == 3)
	        			{
	        				word6 = word6 +"d";
	        			}
	        			else
	        			if(nummmmm%10 == 4)
	        			{
	        				word6 = word6 +"e";
	        			}
	        	else
	        			if(nummmmm%10 == 5)
	        			{
	        				word6 = word6 +"f";
	        			}
	        	else
	        			if(nummmmm%10 == 6)
	        			{
	        				word6 = word6 +"g";
	        			}
	        	else
	        			if(nummmmm%10 == 7)
	        			{
	        				word6 = word6 +"h";
	        			}
	        	else
	        			if(nummmmm%10 == 8)
	        			{
	        				word6 = word6 +"i";
	        			}
	        			else
	        			if(nummmmm %10 == 9)
	        			{
	        				word6 = word6 +"j";
	        			}
	        			
	        			nummmmm = nummmmm/10;
	            }

	                                     
	                                     
	                                    
	                                    
	                                    
	                                    
	                                    
String dgg = word5+word6;

	             //   Toast.makeText(context, dgg, 100).show();
	                
	                word5 ="";
	                word6="";
	                
	                
	                
	                
	                
	                
	                
	                
	                try{
	                
	                
	                Intent intent = new Intent(context,Attend_Activity.class);
	                intent.putExtra("date",dgg);
	                intent.putExtra("tbname", tbname);
	                intent.putExtra("da", tarik);
	                intent.putExtra("day", diwas);
	                intent.putExtra("tym", vel);
	                startActivity(intent);
	                }
	                catch(Exception e)
	                {
	                	e.printStackTrace();
	                }
	                
	       		}
	                
	                catch(Exception e)
	                {
	                	e.printStackTrace();
	                }
	            }
	       		 
	            
	       	// catch()
		 });
	                
		
		changeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
               
				// On button click show datepicker dialog 
				showDialog(DATE_PICKER_ID);
				fucku();

			}

			private void fucku() {}

		});
		/*
		bdisp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		    	try{
		    		String date = "";
		    		Intent intent = getIntent();
					final String tbname =intent.getStringExtra("tbname");
					ls = (ListView)findViewById(R.id.listView123456);
					
					 Cursor c=db.rawQuery("select * from "+tbname+";", null);
					   String[] ss = c.getColumnNames();
					   int count = ss.length;
					   String num = "";
					   //String s = "";
					   dat.clear();
						tym.clear();
						tb.clear();
						
					   for(int j = 17;j<count;j++){
						   
						 					  StringBuffer s = new StringBuffer(ss[j]);
				   
						   
						   


					       // System.out.println("hello");
					        // TODO code application logic here
					//String a = "";
					char b[] = {'a','b','c','d','e','f','g','h','i','j'};
					        //StringBuffer s = new StringBuffer("dbbaaajb");
					        ///s.reverse();
					     //   System.out.println(s);
					         s.reverse();
					       // num = s;
					        for(int i= 0;i<10;i++)
					        {
					           /// for(int j=0;j<8;j++ )
					                 //   System.out.println(s);
					            if(s.charAt(0)== b[i])
					            {
					                num = num+i;
					            }
					        }
					       //     
					               for(int i= 0;i<10;i++)
					               {
					            if(s.charAt(1) == b[i])
					            {
					num = num +i;            } }
					          //  else
					               
					                       for(int i= 0;i<10;i++)
					                       {
					             if(s.charAt(2) == b[i])
					            {
					                num = num + i;
					            } }

					                               for(int i= 0;i<10;i++)
					                               {
					                       if(s.charAt(3) == b[i])
					            {
					                num = num + i;
					            } }
					                               
					                                       for(int i= 0;i<10;i++)
					                                       {
					            if(s.charAt(4) == b[i])
					            {
					                num = num + i;
					            } }
					                                               for(int i= 0;i<10;i++)
					                                               {
					            if(s.charAt(5) == b[i])
					            {
					                num = num + i;
					            }}
					         
					                                                       for(int i= 0;i<10;i++)
					                                                       {
					        if(s.charAt(6) == b[i])
					            {
					                num = num + i;
					            } }
					                                                       
					                            for(int i= 0;i<10;i++)
					                            {
					        if(s.charAt(7) == b[i])
					            {
					                num = num + i;
					            } }
					                            
					                            int fck = Integer.valueOf(num);
					                 
					                            
					                            
					                            //String s = "19000101";
					                          //  int fck = Integer.valueOf(s);
					                            int month = fck %100;
					                            int day = (fck /100)%100;
					                            System.out.println(month);
					                                    System.out.println(day);
					                                    int year = fck /10000;
					                                            System.out.println(year);
					                                            String aa = String.valueOf(day);
					                                            String bb = String.valueOf(month);
					                                            String cc = String.valueOf(year);
					                                            date  = bb+"/"+aa+"/"+cc;
					                                           // String b = String.valueOf(month);
					                                                    //
					                                           // System.out.println(date);

					                      
				Toast.makeText(getApplicationContext(), date, 100).show();
					 
						//if (mCursor.moveToFirst()) {
							//do {
								dat.add(date);
								tym.add("");
								tb.add("");
								//user_status.add(status);
								//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

					   
								
					  // } while (c.moveToNext());
				
						  // }
						  // 
							//java.append(date+"  "+status+"\n");

						   //status = "";
						   num ="";
						   //s = "";
						   		date = "";

					   }		
								

						DisplayAdapter2 disadpt = new DisplayAdapter2(context ,dat, tym,tb);
						ls.setAdapter(disadpt);
						c.close();
						
					   
					 
					 
					 
					 		
					 
					 
					                            
					                            
					                           					                            
						//   String aaa = s[i];
						 // String status= c.getColumnName(i);
						//java.append(date+"  "+status+"\n");

	//status = "";
	//num ="";
	//s = "";

					
					
		    	}
		    	catch(Exception e)
		    	{
		    		Toast.makeText(getApplicationContext(),"cant show", 100).show();
		    	}
		    	
		    	
		    }
		});
		*/
  }
		 

	protected void onResume() {
    {
    	try{
	    	//try{
	    		//String date = "";
	    		Intent intent = getIntent();
				final String tbname =intent.getStringExtra("tbname");
				ls = (ListView)findViewById(R.id.listView123456);
				
				 Cursor c=db.rawQuery("select * from "+tbname+";", null);
				   String[] ss = c.getColumnNames();
				   int count = ss.length;
				 //  String num = "";
				   //String s = "";
				   dat.clear();
					tym.clear();
					tb.clear();
					
				   for(int j = 17;j<count;j++){				   
				 
				 

					   
	 					  StringBuffer s = new StringBuffer(ss[j]);

	   
	   


    // System.out.println("hello");
     // TODO code application logic here
//String a = "";
char b[] = {'a','b','c','d','e','f','g','h','i','j'};
     //StringBuffer s = new StringBuffer("dbbaaajb");
     ///s.reverse();
  //   System.out.println(s);
      s.reverse();
    // num = s;
     for(int i= 0;i<10;i++)
     {
        /// for(int j=0;j<8;j++ )
              //   System.out.println(s);
         if(s.charAt(0)== b[i])
         {
             num = num+i;
         }
     }
    //     
            for(int i= 0;i<10;i++)
            {
         if(s.charAt(1) == b[i])
         {
num = num +i;            } }
       //  else
            
                    for(int i= 0;i<10;i++)
                    {
          if(s.charAt(2) == b[i])
         {
             num = num + i;
         } }

                            for(int i= 0;i<10;i++)
                            {
                    if(s.charAt(3) == b[i])
         {
             num = num + i;
         } }
                            
                                    for(int i= 0;i<10;i++)
                                    {
         if(s.charAt(4) == b[i])
         {
             num = num + i;
         } }
                                            for(int i= 0;i<10;i++)
                                            {
         if(s.charAt(5) == b[i])
         {
             num = num + i;
         }}
      
                                                    for(int i= 0;i<10;i++)
                                                    {
     if(s.charAt(6) == b[i])
         {
             num = num + i;
         } }
                                                    
                         for(int i= 0;i<10;i++)
                         {
     if(s.charAt(7) == b[i])
         {
             num = num + i;
         } }
                         
                         for(int i= 0;i<10;i++)
                         {
     if(s.charAt(8) == b[i])
         {
             num = num + i;
         } }
              
              for(int i= 0;i<10;i++)
                         {
     if(s.charAt(9) == b[i])
         {
             num = num + i;
         } }
              
              
              for(int i= 0;i<10;i++)
                         {
     if(s.charAt(10) == b[i])
         {
             num = num + i;
         } }
              
              for(int i= 0;i<10;i++)
                         {
     if(s.charAt(11) == b[i])
         {
             num = num + i;
         } }
              
              for(int i= 0;i<10;i++)
                         {
     if(s.charAt(12) == b[i])
         {
             num = num + i;
         } }
     
              String tym1;
                         
                         
                         
                         
                         
                         /*
                         int fck = Integer.valueOf(num);
              
                         
                         
                         //String s = "19000101";
                       //  int fck = Integer.valueOf(s);
                         int month =  (fck /100)%100;
                         int day = fck %100;
                         System.out.println(month);
                                 System.out.println(day);
                                 int year = fck /10000;
                                         System.out.println(year);
                                         String a1 = String.valueOf(day);
                                         String b1 = String.valueOf(month);
                                         String c1 = String.valueOf(year);*/
              String a1 = num.substring(11,13);
              
              
              String b1 = num.substring(9,11);
              String c1 = num.substring(5,9);
                                         String date1  = a1+"/"+b1+"/"+c1;
                         
                                        // String b = String.valueOf(month);
                                                 //
                                        // System.out.println(date);

                                         
                                         
                                         String hourr = num.substring(1,3);
                                         System.out.println(hourr);
                                      //  int mi = fck1%100;
                                        String min = num.substring(3,5);
                                         System.out.println(min);
                                         String hpp = hourr;
                                         int hyy = Integer.parseInt(hpp);
                                         if(hyy>12)
                                         {
                                              tym1  =hourr+":"+min+" PM"; 

                                         }
                                         else
                                         {
                                        	  tym1  =hourr+":"+min+" AM"; 

 
                                         }
                                        //String tym1  =hourr+":"+min; 
                                         
                   String dddddd = num.substring(0, 1);
//Toast.makeText(getApplicationContext(), date1, 100).show();
                   

                   String ddayy="";
                                   if(dddddd.equalsIgnoreCase("1"))
                                   {
                                	   ddayy = "Sunday";
                                	   
                                   }else
                                	   if(dddddd.equalsIgnoreCase("2"))
                                       {
                                    	   ddayy = "Monday";
                                    	   
                                       }else
                                    	   if(dddddd.equalsIgnoreCase("3"))
                                       {
                                    	   ddayy = "Tuesday";
                                    	   
                                       }else
                                    	   if(dddddd.equalsIgnoreCase("4"))
                                           {
                                        	   ddayy = "Wednesday";
                                        	   
                                           }else
                                        	   if(dddddd.equalsIgnoreCase("5"))
                                               {
                                            	   ddayy = "Thursday";
                                            	   
                                               }else
                                            	   if(dddddd.equalsIgnoreCase("6"))
                                                   {
                                                	   ddayy = "Friday";
                                                	   
                                                   }else
                                                	   if(dddddd.equalsIgnoreCase("7"))
                                                       {
                                                    	   ddayy = "Saturday";
                                                    	   
                                                       }
                                                       
                                                System.out.println(ddayy);       
                           
                        	   
	//if (mCursor.moveToFirst()) {
		//do {
			dat.add(date1);
			tym.add(tym1);
			tb.add(ddayy);
			//user_status.add(status);
			//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));


			
// } while (c.moveToNext());

	  // }
	  // 
		//java.append(date+"  "+status+"\n");

	   //status = "";
	   num ="";
	   //s = "";
	   		date1 = "";
	   		tym1 = "";
	   		dddddd = "";
	   		ddayy = "";

}		
			

	DisplayAdapter2 disadpt = new DisplayAdapter2(context ,dat, tym,tb);
	ls.setAdapter(disadpt);
	c.close();
	

				 		
				 
				                            
				                            
				                           					                            
					//   String aaa = s[i];
					 // String status= c.getColumnName(i);
					//java.append(date+"  "+status+"\n");

//status = "";
//num ="";
//s = "";

				
				
	    	
    	}
	    	catch(Exception e)
	    	{e.printStackTrace();
	    		Toast.makeText(getApplicationContext(),"cant show", 10).show();
	    	}
	    	

    	
    	super.onResume();
    }
    }
    	
    

	

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_PICKER_ID:
			
			// open datepicker dialog. 
			// set date picker for current date 
			// add pickerListener listner to date picker
			return new DatePickerDialog(this, pickerListener, year, month,day);
		}
		return null;
		
		
	}

	private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

	

		// when dialog box is closed, below method will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			try{
			
			year  = selectedYear;
			month = selectedMonth;
			day   = selectedDay;

			int month1 = month+1;
		String yyyy,s;
			/*
			 * intent.putExtra("date",dgg);
	                intent.putExtra("tbname", tbname);
	                intent.putExtra("da", s);
	                intent.putExtra("day", s1);
	                intent.putExtra("tym", yyyy);
			 */
            final Calendar cal  = Calendar.getInstance();
            int mHour = cal.get(Calendar.HOUR_OF_DAY);
            int mMinute = cal.get(Calendar.MINUTE);
 
            int a= cal.get(Calendar.DAY_OF_WEEK);
            
            
            String hour1  = String.valueOf(mHour);
            String minute1  = String.valueOf(mMinute);
            String hour,minute;
            if(hour1.length() == 1)
            {
            	hour = "0"+hour1;
            	
            }
            else
            {
            	hour = hour1;
            	
            }

            if(minute1.length() == 1)
            {
            	minute = "0"+minute1;
            	
            }
            else
            {
            	minute = minute1;
            	
            }
            int aaa = cal.get(Calendar.DAY_OF_WEEK);
            String dddddd = String.valueOf(aaa);
            String ffff = hour;
            int hoooo = Integer.parseInt(ffff);
;            //send time code
            if(hoooo>12)
            {	
             yyyy = hour+":"+minute+" PM";
            }
            else
            {
                 yyyy = hour+":"+minute+" AM";

            }
            
            //day code
            String s1 ="";
            
            if(dddddd.equalsIgnoreCase("1"))
            {
         	   s1 = "Sunday";
         	   
            }else
         	   if(dddddd.equalsIgnoreCase("2"))
                {
         		  s1 = "Monday";
             	   
                }else
             	   if(dddddd.equalsIgnoreCase("3"))
                {
             		  s1 = "Tuesday";
             	   
                }else
             	   if(dddddd.equalsIgnoreCase("4"))
                    {
             		  s1 = "Wednesday";
                 	   
                    }else
                 	   if(dddddd.equalsIgnoreCase("5"))
                        {
                 		  s1 = "Thursday";
                     	   
                        }else
                     	   if(dddddd.equalsIgnoreCase("6"))
                            {
                     		  s1 = "Friday";
                         	   
                            }else
                         	   if(dddddd.equalsIgnoreCase("7"))
                                {
                         		  s1 = "Saturday";
                             	   
                                }
                                
            
            
            
//ended code            
            String time = aaa+hour+minute;
            int num1 = Integer.parseInt(time);
            

            
            while(num1 !=0)
			{
			if(num1%10 == 0)
			{
			worddd = worddd +"a";
		    }
			else
			if(num1%10 == 1)
			{
				worddd = worddd +"b";
			}
	else
			if(num1%10 == 2 )
			{
				worddd = worddd +"c";
			}
			else
			if(num1%10 == 3)
			{
				worddd = worddd +"d";
			}
			else
			if(num1%10 == 4)
			{
				worddd = worddd +"e";
			}
	else
			if(num1%10 == 5)
			{
				worddd = worddd +"f";
			}
	else
			if(num1%10 == 6)
			{
				worddd = worddd +"g";
			}
	else
			if(num1%10 == 7)
			{
				worddd = worddd +"h";
			}
	else
			if(num1%10 == 8)
			{
				worddd = worddd +"i";
			}
			else
			if(num1 %10 == 9)
			{
				worddd = worddd +"j";
			}
			
			num1 = num1/10;
			}
		
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
String aa = String.valueOf(year);
			String b = String.valueOf(month1);
			String c = String.valueOf(day);
				
			// Show selected date 
		 // StringBuilder str = new StringBuilder().append(day).append(month+1).append(year);
			String mon ,da;
			if(b.length() == 1)
			{
			mon = "0"+b;
			}
			else
			{
			mon  = b;
			}


			if(c.length() == 1)
			{
			da = "0"+c;
			}
			else
			{
			da  = c;
			}

			
			
			// str = da+mon+aa;
			 str = aa+mon+da;
			  s = da+"/"+mon+"/"+aa;
			//Toast.makeText(context, aa+"-"+mon+"-"+da, 1000).show();
			//Toast.makeText(context, da+"-"+mon+"-"+aa, 1000).show();
Intent intent1 = getIntent();
String tbname = intent1.getStringExtra("tbname");
			//String tbname = edit1.getText().toString();
			int num = Integer.parseInt(str);


//conversion code		
			
		//	int a = num % 10;
			//System.out.println(a);
			try{
			while(num !=0)
			{
			if(num%10 == 0)
			{
			word = word +"a";
		    }
			else
			if(num%10 == 1)
			{
			word = word +"b";
			}
	else
			if(num%10 == 2 )
			{
			word = word +"c";
			}
			else
			if(num%10 == 3)
			{
			word = word +"d";
			}
			else
			if(num%10 == 4)
			{
			word = word +"e";
			}
	else
			if(num%10 == 5)
			{
			word = word +"f";
			}
	else
			if(num%10 == 6)
			{
			word = word +"g";
			}
	else
			if(num%10 == 7)
			{
			word = word +"h";
			}
	else
			if(num%10 == 8)
			{
			word = word +"i";
			}
			else
			if(num %10 == 9)
			{
			word = word +"j";
			}
			
			num = num/10;
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
						 
			//Toast.makeText(getApplicationContext(),word, 1000).show();
			
			
			date = word +worddd;
			
			try{
			  String query = "ALTER TABLE " + tbname + " ADD COLUMN " + date + " varchar2(10);";
				db.execSQL(query);
				Toast.makeText(getApplicationContext(),"Today date is added successfully", 10).show();

			}
			catch(Exception e)
			{
				e.printStackTrace();
				//Toast.makeText(getApplicationContext(),"already hav column to table", 50).show();
			}
			Intent intent = new Intent(context,Attend_Activity.class);
            intent.putExtra("date",date);
            intent.putExtra("tbname", tbname);
            intent.putExtra("da", s);
            intent.putExtra("day", s1);
            intent.putExtra("tym", yyyy);

            startActivity(intent);


			//Intent intent = new Intent(context, Attend_Activity.class);
			//intent.putExtra("date", fuck);
			//intent.putExtra("tbname", tbname);
			//startActivity(intent);
			 word  = "";
			 worddd ="";
			 
			 
			 
			 
			 
			 //gandu();
			 
			 
			 
			 

		   }
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
		};
	    
	  
	   	    

	    
			
		    	    
}
	