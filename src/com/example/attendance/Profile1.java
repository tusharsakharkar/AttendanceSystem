package com.example.attendance;
//package com.example.stud_attendance;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Profile1 extends Activity {

	
	TextView txt1,txt2 ,txt3,java,txttot,txtatt,txtper,txtsta,txtab;
	SQLiteDatabase db;
	Button bb1;
	protected ListView userlist,testlist,asslist;
	private ArrayList<String> user_date = new ArrayList<String>();
	private ArrayList<String> user_status1 = new ArrayList<String>();
	//private ArrayList<String> user_status2 = new ArrayList<String>();
	private ArrayList<String> test = new ArrayList<String>();
	private ArrayList<String> te = new ArrayList<String>();
	private ArrayList<String> ma = new ArrayList<String>();


	private ArrayList<String> mar = new ArrayList<String>();

	
	
static int countatt = 0,counttot = 0,countab = 0;
	//private ArrayList<String> sub = new ArrayList<String>();
	protected Context context = this;
	


	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile1);
		
		
		
		txt1 = (TextView)findViewById(R.id.fuck11);
		txt3 = (TextView)findViewById(R.id.fuck41);

		txt2 = (TextView)findViewById(R.id.fuck21);
		//bb1 = (Button)findViewById(R.id.fuck31);
		
		txttot = (TextView)findViewById(R.id.txttotal);

		txtatt = (TextView)findViewById(R.id.txtatt);
txtab = (TextView)findViewById(R.id.txtab);
		txtper = (TextView)findViewById(R.id.txtper);

		txtsta = (TextView)findViewById(R.id.txtsta);
		 userlist  = (ListView)findViewById(R.id.list1111000);
		 testlist = (ListView)findViewById(R.id.list000000);
		 asslist = (ListView)findViewById(R.id.list000000111);

		
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		   //create new table if not already exist
	//  String str = "create table if not exists mytable(id varchar2(5), sur_name varchar2(20))";
		 // String str = "create table if not exists "+ tbname +"(id varchar2(5) PRIMARY KEY, sur_name varchar2(20))";

		
		
		userlist.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
			userlist.scrollBy(0, 1);
			}
			return false;
			}
			});
		
		
		
		testlist.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
			testlist.scrollBy(0, 1);
			}
			return false;
			}
			});

		asslist.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
			asslist.scrollBy(0, 1);
			}
			return false;
			}
			});
		
		
		//   db.execSQL(str);
//bb1.setOnClickListener(new OnClickListener() {
	
	//@Override
	//public void onClick(View arg0) {
		
		/*
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		final String tbname =intent.getStringExtra("tbname");
		String name	=	intent.getStringExtra("name");
		final String iid= intent.getStringExtra("id");
		int id = Integer.parseInt(iid);
		
		
		txt1.setText(iid);
		txt2.setText(name);
			txt3.setText(tbname);
			Cursor c=db.rawQuery("select * from "+tbname+" where id =" + id + ";", null);
			   String[] ss = c.getColumnNames();
			   for(int i = 0;i<ss.length;i++)
			   Toast.makeText(context,ss[i], 100).show();
			
			
			String date ="";
			 userlist  = (ListView)findViewById(R.id.list1111000);

		//txt1.setText(id);
		//txt2.setText("name");
		//	txt3.setText(tbname);
		//	String quer="SELECT * FROM "+ tbname +";";
			//java = (TextView)findViewById(R.id.co);
			String status = "";
			try{
				  // Cursor c=db.rawQuery("select * from "+tbname+" where id =" + id + ";", null);
				 //  String[] ss = c.getColumnNames();
				   int count = ss.length;
				   String num = "";
				   //String s = "";

				   for(int j = 17;j<count;j++){
					   //Toast.makeText(getApplicationContext(), s[i] , 300).show();
					 if (c.moveToFirst()) {
							do {
								 String aaa = ss[j];
								 int fck = aaa.length();
								 
								 try{
								 if(fck == 8){
								 
								   status= c.getString(j);
								   if(status == "present")
								   {
									user_status1.add(status);
									user_status2.add("");}
									else
									{										user_status1.add("");

										user_status2.add(status);
										
										
									}
								 }
								 }
								 catch(Exception e)
								 {
									 Toast.makeText(context,"Invalid date", 100).show();
								 }
								 
								} while (c.moveToNext());
					 }
								


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

				                      
			
				 
				// user_date.clear();
				//	user_status.clear();
					//user_lName.clear();
					//if (mCursor.moveToFirst()) {
						//do {
							user_date.add(date);
							//user_status.add(status);
							//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

				   
							
				  // } while (c.moveToNext());
			
					  // }
					  // 
						//java.append(date+"  "+status+"\n");

					   status = "";
					   num ="";
					   //s = "";
					   		

				   }		
							

					DisplayAdapter2 disadpt = new DisplayAdapter2(context ,user_date, user_status1,user_status2);
					userlist.setAdapter(disadpt);
					//mCursor.close();
					
				   
				 
				 
				 
				 		
				 
				 
				                            
				                            
				                           					                            
					//   String aaa = s[i];
					 // String status= c.getColumnName(i);
					//java.append(date+"  "+status+"\n");

//status = "";
//num ="";
//s = "";
												   
				  // Toast.makeText(getApplicationContext(), count , 300).show();
				
				   
				   //}
			}
	
		
				catch (Exception e)
				   {
					   Toast.makeText(getApplicationContext(), "cant display" , 300).show();

				   }			   

		
		

			
			
			
			
			
		
*/}
//});
		
	
		
protected void onResume(){
	

	// TODO Auto-generated method stub
	Intent intent = getIntent();
	final String tbname =intent.getStringExtra("tbname");
	String name	=	intent.getStringExtra("name");
	final String iid= intent.getStringExtra("id");
	int id = Integer.parseInt(iid);
	
	
	txt1.setText(iid);
	txt2.setText(name);
		txt3.setText(tbname);
		Cursor c=db.rawQuery("select * from "+tbname+" where id = " + id + ";", null);
		   String[] ss = c.getColumnNames();
		  // for(int i = 0;i<ss.length;i++)
		  // Toast.makeText(context,ss[i], 100).show();
		
		
		//String date ="";
//c.moveToFirst();
	//txt1.setText(id);
	//txt2.setText("name");
	//	txt3.setText(tbname);
	//	String quer="SELECT * FROM "+ tbname +";";
		//java = (TextView)findViewById(R.id.co);
		String status = "";
		try{
			  // Cursor c=db.rawQuery("select * from "+tbname+" where id =" + id + ";", null);
			 //  String[] ss = c.getColumnNames();
			   int count = ss.length;
			   c.moveToFirst();
			   String num = "";
			   //String s = "";
//txttot.setText(String.valueOf(count));
			   for(int j = 17;j<count;j++){
				   //Toast.makeText(getApplicationContext(), s[i] , 300).show();
				 if (c.moveToFirst()) {
						do {
							 String aaa = ss[j];
							 int fck = aaa.length();
							 							 
							 try{
							// if(fck == 13){
							 
							   status= c.getString(j);
							   	user_status1.add(status);
								///user_status2.add("");
							   	if(status.equalsIgnoreCase("Present"))
								 {
									 countatt++;
								 }else
									   	if(status.equalsIgnoreCase("Absent"))
									   	{
									   		countab++;
									   	}

															 
							 }
							 catch(Exception e)
							 {
								 Toast.makeText(context,"Invalid date", 100).show();
							 }
							 
							} while (c.moveToNext());
				 }
							


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
			           
			                            
			                            String a1 = num.substring(11,13);
			                            
			                            
			                            String b1 = num.substring(9,11);
			                            String c1 = num.substring(5,9);
			                                                       String date1  = a1+"/"+b1+"/"+c1;
			                            
			                            
			                            
			                            
			                            
			                            
			                            
			                            
			                            
			                            
			                            
			                            /*
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
			                                            //date  = bb+"/"+aa+"/"+cc;
			                                           // String b = String.valueOf(month);
			                                                    //
			                                           // System.out.println(date);

			                      */
		
			 
			// user_date.clear();
			//	user_status.clear();
				//user_lName.clear();
				//if (mCursor.moveToFirst()) {
					//do {
						user_date.add(date1);
						//user_status.add(status);
						//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

			   
						
			  // } while (c.moveToNext());
		
				  // }
				  // 
					//java.append(date+"  "+status+"\n");

				   status = "";
				   num ="";
				   //s = "";
				   date1 = "";
				   		
counttot++;








			   }		
						
			   txttot.setText(String.valueOf(counttot));
				txtatt.setText(String.valueOf(countatt));
				txtab.setText(String.valueOf(countab));
				
				
				int per = (countatt*100)/counttot;
				String perc = String.valueOf(per)+" %";
				txtper.setText(perc);
				if(per<75)
				{
					txtsta.setText("Detained");
				}
				else
				{
					txtsta.setText("Not Detained");
				}
				
				countatt = 0;
				counttot = 0;
				countab = 0;
 				DisplayAdapter10 disadpt = new DisplayAdapter10(context ,user_date, user_status1);
				userlist.setAdapter(disadpt);
				c.close();


				
				
				
				Cursor cc=db.rawQuery("select * from "+tbname+" where id = " + id + ";", null);
				   String[] ssss = cc.getColumnNames();
				
				
				
				//try{
			 cc.moveToFirst();
			 for(int i = 2;i<12;i++)
			 {
				// Toast.makeText(context,ssss[i], 100).show();

				 
				 test.add(ssss[i]);

				 if (cc.moveToFirst()) {
						do {
							 //String aaa = ssss[i];
							 
							 try{
							   String strrrrr= cc.getString(i);
							   	mar.add(strrrrr);
							 

															 }
							 
							 catch(Exception e)
							 {
								 Toast.makeText(context,"Invalid date", 100).show();
							 }
							 
							} while (cc.moveToNext());
				 }
							
				
			 }
			 		DisplayProTest pro = new DisplayProTest(context,test, mar);
			 
	 				//DisplayAdapter10 disadpt = new DisplayAdapter10(context ,user_date, user_status1);
					testlist.setAdapter(pro);
					
					
					
					
					

					Cursor ccc=db.rawQuery("select * from "+tbname+" where id = " + id + ";", null);
					   String[] ssssss = ccc.getColumnNames();
					
					
					
					//try{
					 ccc.moveToFirst();
					 for(int i = 12;i<17;i++)
					 {
						// Toast.makeText(context,ssss[i], 100).show();

						 
						 te.add(ssssss[i]);

						 if (ccc.moveToFirst()) {
								do {
									 //String aaa = ssss[i];
									 
									 try{
									   String strrrrr= ccc.getString(i);
									   	ma.add(strrrrr);
									 

																	 }
									 
									 catch(Exception e)
									 {
										 Toast.makeText(context,"Invalid date", 100).show();
									 }
									 
									} while (ccc.moveToNext());
						 }
									
						
					 }
					 		DisplayProAss pro1 = new DisplayProAss(context,te, ma);
					 
			 				//DisplayAdapter10 disadpt = new DisplayAdapter10(context ,user_date, user_status1);
							asslist.setAdapter(pro1);

					                            


			                            
			                            /*
					
					 c.moveToFirst();
					 for(int i = 12;i<17;i++)
					 {
						 
						 if (c.moveToFirst()) {
								do {
									 String aaa = ss[i];
									 
									 try{
										 te.add(ss[i]);
									   status= c.getString(i);
									   	ma.add(status);
									 

																	 }
									 
									 catch(Exception e)
									 {
										 Toast.makeText(context,"Invalid date", 100).show();
									 }
									 
									} while (c.moveToNext());
						 }
									
						 
					 }
					 		DisplayProAss pro1 = new DisplayProAss(context,te, ma);
					 
			 				//DisplayAdapter10 disadpt = new DisplayAdapter10(context ,user_date, user_status1);
							asslist.setAdapter(pro1);
				}
				catch(Exception e)
				{
					Toast.makeText(context, "cannot display test marks", 100).show();
				}
					*/
			                           					                            
				//   String aaa = s[i];
				 // String status= c.getColumnName(i);
				//java.append(date+"  "+status+"\n");

//status = "";
//num ="";
//s = "";
											   
			  // Toast.makeText(getApplicationContext(), count , 300).show();
			
			   
			   //}*/
		}

	
			catch (Exception e)
			   {
				   Toast.makeText(getApplicationContext(), "cant display" , 300).show();

			   }			   

	
	

		
		
		
		
		
	

	
	super.onResume();

}
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile1, menu);
		return true;
	}

}
