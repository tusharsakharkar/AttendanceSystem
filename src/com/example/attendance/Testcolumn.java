package com.example.attendance;
//package com.example.stud_attendance;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Testcolumn extends Activity {
	Button chutk;
	ListView list1 ;
	SQLiteDatabase db ;
	 final ArrayList<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testcolumn);
		
		
		
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

		
		
		//chutk = (Button)findViewById(R.id.chutk);
		list1 = (ListView)findViewById(R.id.listView1010);
		Intent intent = getIntent();
		final String tbname = intent.getStringExtra("tbname");
		
		/*
		list1.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
			list1.scrollBy(0, 1);
			}
			return false;
			}
			});
			*/
		
		 list1.setOnItemClickListener(new OnItemClickListener() {
	       	 public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
	            {
	                // position parameter gives the index or position of ListView Item which is Clicked
	                TextView tv=(TextView)v.findViewById(R.id.testcell);
	                String test=tv.getText().toString();
	             //   Toast.makeText(getApplicationContext(), "Contact Selected: "+test, Toast.LENGTH_LONG).show();
	                Intent intent = new Intent(getApplicationContext(),Testenter.class);
	                intent.putExtra("tbname",tbname);
	                intent.putExtra("test", test);
	                startActivity(intent);
	            }
	   	});
		
		
		
		/*
		//chutk.setOnClickListener(new OnClickListener() {
			
			@Override
			//public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				try{
					
					 Cursor c=db.rawQuery("select * from "+tbname+";", null);
					   String[] ss = c.getColumnNames();
					   int count = ss.length;
					   String num = "";
					   for (int i = 2; i < 12; ++i) {
						      list.add(ss[i]);
						    }
						    		
					   DisplayTestAdapter disadpt = new DisplayTestAdapter(getApplicationContext() ,list);
						list1.setAdapter(disadpt);
						
					
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "cant show", 100).show();
				}
				
			}
		});
		
		*/
		
	}
	
	protected void onResume() {
		//displayData();
		Intent intent = getIntent();
		final String tbname = intent.getStringExtra("tbname");

		try{
			
			 Cursor c=db.rawQuery("select * from "+tbname+";", null);
			   String[] ss = c.getColumnNames();
			   int count = ss.length;
			   String num = "";
			   list.clear();
			   for (int i = 2; i < 12; ++i) {
				      list.add(ss[i]);
				    }
				    		
			   DisplayTestAdapter disadpt = new DisplayTestAdapter(getApplicationContext() ,list);
				list1.setAdapter(disadpt);
				
			
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "cant show", 100).show();
		}
		
		
		super.onResume();

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.testcolumn, menu);
		return true;
	}

}
