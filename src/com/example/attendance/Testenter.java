package com.example.attendance;
//package com.example.stud_attendance;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Testenter extends Activity {
	SQLiteDatabase db;
	TextView mc1,mc2;
	EditText mc3;
	Button mc4,mc5,mc7;
	Cursor c;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testenter);
		
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

		Intent intent = getIntent();
		mc1 = (TextView)findViewById(R.id.mc1);

		mc2 = (TextView)findViewById(R.id.mc2);
		

		mc3 = (EditText)findViewById(R.id.mc3);
		

		mc4 = (Button)findViewById(R.id.mc4);
		

		mc5 = (Button)findViewById(R.id.mc5);
		mc7 = (Button)findViewById(R.id.mc7);
		final String tbname  = intent.getStringExtra("tbname");
		final String test = intent.getStringExtra("test");
		
		
		 c=db.rawQuery("select * from "+tbname+";", null);

		c.moveToFirst();

		mc5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			   // c=db.rawQuery("select * from "+tbname+";", null);
//try{
				fuck();
				movenxt();
				show();
//}
//catch(Exception e)
//{
	//Toast.makeText(getApplicationContext(),"Sorry, no data", 100).show();
//}
			}

			private void show() {
				// TODO Auto-generated method stub
				try{
				String iid = c.getString(c.getColumnIndex("id")); 
				  
			    String surname=c.getString(c.getColumnIndex("sur_name"));
			    mc1.setText(iid);
			    mc2.setText(surname);
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "sorry, No Data",100).show();
				}
			
			}

			private void movenxt() {
				// TODO Auto-generated method stub
				if(!c.isLast())
					c.moveToNext();
			
			}

			private void fuck() {
				try{
				// TODO Auto-generated method stub
				String mark = mc3.getText().toString();
				if(mark == null)
				{
					Toast.makeText(getApplicationContext(),"please enter d marks first", 100).show();
				}
				else
				{
				// TODO Auto-generated method stub
				
				//int selectedId = radioGroup.getCheckedRadioButtonId();

				// find the radiobutton by returned id
				//SexButton = (RadioButton) findViewById(selectedId);

				//String tv = SexButton.getText().toString();
				//c.moveToFirst();
				String idd = c.getString(c.getColumnIndex("id"));
				String name = c.getString(c.getColumnIndex("sur_name"));
				mc1.setText(idd);
				mc2.setText(name);

				
				
			//	String mark = mc3.getText().toString();
				int marks = Integer.parseInt(mark);
				//Toast.makeText(getApplicationContext(),
					//	tv, 100).show();
				//addColumn(date);
				//String idd = mc1.getText().toString();
				int iid = Integer.parseInt(idd);
				//try{
				String sq = "UPDATE "+tbname+" SET " + test + " = " + marks + " WHERE id = " + iid + ";";

			    db.execSQL(sq);
mc1.setText("");
mc2.setText("");
mc3.setText("");
			    //display Toast
			   Toast.makeText(getApplicationContext(), "data updated successfully.", 50).show();
				}
				}
					   
	
	catch(Exception e)
	{
		e.printStackTrace();
		   Toast.makeText(getApplicationContext(), "data not updated successfully.", 50).show();

	}


			}
		
		});
		
		mc4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!c.isFirst())
					c.moveToPrevious();
				String iid = c.getString(c.getColumnIndex("id")); 
				  
			    String surname=c.getString(c.getColumnIndex("sur_name"));
			    mc1.setText(iid);
			    mc2.setText(surname);
			
			
			
			}
		});
		mc7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
				final String tbname  = intent.getStringExtra("tbname");
				String test = intent.getStringExtra("test");
				Intent intent1 = new Intent(getApplicationContext(),Showmark.class);
				intent1.putExtra("tbname", tbname);

				intent1.putExtra("test", test);
				startActivity(intent1);
			
			}
		});
		
	}
	
	
	
	protected void onResume() {
		//displayData();

		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			try{
				// userList = (ListView)findViewById(R.id.fcklist1);

					//dataBase = mHelper.getWritableDatabase();
				
				Intent intent = getIntent();
				final String tbname  = intent.getStringExtra("tbname");
				String test = intent.getStringExtra("test");
				
			
				 Cursor c = db.rawQuery("SELECT * from "+tbname+";", null);

				 c.moveToFirst();
mc1.setText("");
mc2.setText("");
				        	String id = c.getString(c.getColumnIndex("id"));
				        	int iddd = Integer.parseInt(id);

				        	String name = c.getString(c.getColumnIndex("sur_name"));
				        	//String test1 = c.getString(c.getColumnIndex(test));
				        	
				        					        	
				        	mc1.setText(id);
				        	mc2.setText(name);
				        	
				        	
				        	
				           // c.moveToNext();
				        
				    										//userId.clear();
					//user_sur_name.clear();
					//user_lName.clear();
					/*if (mCursor.moveToFirst()) {
						do {
							userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
							user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
							sub.add(tbname);
							//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

						} while (mCursor.moveToNext());
					}
					*/
				 	}
				 	catch (Exception e) {
				 		Toast.makeText(getApplicationContext(), "cant display", 3000).show();
						// TODO: handle exception
					}
				

			super.onResume();

		
		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.testenter, menu);
		return true;
	}

}
