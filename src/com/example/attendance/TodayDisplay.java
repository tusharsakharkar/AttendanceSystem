package com.example.attendance;
//package com.example.stud_attendance;

import java.util.ArrayList;

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

public class TodayDisplay extends Activity {
	Button b1 ,today;
	TextView view;
	SQLiteDatabase db;
	ListView lst ;
	private ArrayList<String> no = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> sta = new ArrayList<String>();

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_today_display);
//	b1 = (Button)findViewById(R.id.butt);
	//view = (TextView)findViewById(R.id.tv1);
		today = (Button)findViewById(R.id.today1);
		
	Intent intent = getIntent();
	final String tbname = intent.getStringExtra("tbname");
	final String date = intent.getStringExtra("date");
	lst = (ListView)findViewById(R.id.view12211221);
/*
	lst.setOnTouchListener(new ListView.OnTouchListener() {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
		lst.scrollBy(0, 1);
		}
		return false;
		}
		});
		*/
	/*
	today.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(getApplicationContext(),Attend_Activity.class);
			startActivity(intent);
		}
	});
	*/
	//lst = (ListView)findViewById(R.id.view12211221);
	try{
		  db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		   //create new table if not already exist
		//   String str = "create table if not exists mytable(id varchar2(5), sur_name varchar2(20))";
		//   String str = "create table if not exists "+ tbname +"(id varchar2(5), sur_name varchar2(20), " + date +" varchar2(10))";

		  // db.execSQL(str);

	}
	catch(Exception e)
	{
		Toast.makeText(getApplicationContext(), "cant open table", 20).show();
	}
	
	
	/*
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub

			   //use cursor to keep all data
			   //cursor can keep data of any data type
try{
			   Cursor c=db.rawQuery("select * from "+tbname+";", null);
			   view.setText("");
			   //move cursor to first position
			   c.moveToFirst();
			   //fetch all data one by one
			   do
			   {
			    //we can use c.getString(0) here
			    //or we can get data using column index
			    //int idd =c.getColumnIndexOrThrow("id");
			    String id = c.getString(c.getColumnIndex("id"));
			  
			    String surname=c.getString(c.getColumnIndex("sur_name"));
			    String check =c.getString(c.getColumnIndex(date));
			    //display on text view
			    
			    view.append(" "+id+"  "+surname+" "+check+"\n");
			    //move next position until end of the data
			   }while(c.moveToNext());
			  
}
catch(Exception e)
{
	   Toast.makeText(getApplicationContext(), "could not display successfully.", 50).show();
}

		}
	});
	*/
	
	}
	
	
	
	
	
	protected void onResume() {
		super.onResume();
		
		
		Intent intent = getIntent();
		final String tbname = intent.getStringExtra("tbname");
		final String date = intent.getStringExtra("date");
				// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		   //use cursor to keep all data
		   //cursor can keep data of any data type
try{
		   Cursor c=db.rawQuery("select * from "+tbname+";", null);
		  // view.setText("");
		   //move cursor to first position
		   c.moveToFirst();
		   //fetch all data one by one
		   do
		   {
		    //we can use c.getString(0) here
		    //or we can get data using column index
		    //int idd =c.getColumnIndexOrThrow("id");
		    String id = c.getString(c.getColumnIndex("id"));
		  
		    String surname=c.getString(c.getColumnIndex("sur_name"));
		    String check =c.getString(c.getColumnIndex(date));
		    //display on text view
		    no.add(id);
		    name.add(check);
		    sta.add(surname);
		    
		    //view.append(" "+id+"  "+surname+" "+check+"\n");
		    //move next position until end of the data
		   }while(c.moveToNext());
		  
		   DisplayAdapter15 disp = new DisplayAdapter15(getApplicationContext(), no, name, sta);
		   lst.setAdapter(disp);
}
catch(Exception e)
{
   Toast.makeText(getApplicationContext(), "data cannot display successfully.", 50).show();
}

	
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.today_display, menu);
		return true;
	}

}
