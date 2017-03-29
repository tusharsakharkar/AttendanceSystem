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
import android.widget.TextView;
import android.widget.Toast;

public class AssEnter extends Activity {
	SQLiteDatabase db;
	Button bshow,bnext,bback;
	TextView id,name;
	EditText ass;
	Cursor c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ass_enter);
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		Intent intent	= getIntent();
		final String tbname = intent.getStringExtra("tbname");
		final String test = intent.getStringExtra("test");
		

		bshow = (Button)findViewById(R.id.a22222);
		id = (TextView)findViewById(R.id.a33333);
		name  = (TextView)findViewById(R.id.a44444);
		ass = (EditText)findViewById(R.id.a55555);
		bback = (Button)findViewById(R.id.a66666);
		bnext = (Button)findViewById(R.id.a77777);
		
		
		
		 c=db.rawQuery("select * from "+tbname+";", null);

			c.moveToFirst();

			bnext.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					

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

					// TODO Auto-generated method stub
					try{
					String iid = c.getString(c.getColumnIndex("id")); 
					  
				    String surname=c.getString(c.getColumnIndex("sur_name"));
				    id.setText(iid);
				    name.setText(surname);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						Toast.makeText(getApplicationContext(), "sorry, No Data",100).show();
					}
				
				
				}

				private void movenxt() {
					// TODO Auto-generated method stub

					// TODO Auto-generated method stub
					try{
					if(!c.isLast())
						c.moveToNext();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
				
				}

				private void fuck() {
					// TODO Auto-generated method stub
					

					try{
					// TODO Auto-generated method stub
					String mark = ass.getText().toString();
					if(mark == null)
					{
						Toast.makeText(getApplicationContext(),"please enter the marks first", 10).show();
					}
					else
					{
					// TODO Auto-generated method stub
					
					//int selectedId = radioGroup.getCheckedRadioButtonId();

					// find the radiobutton by returned id
					//SexButton = (RadioButton) findViewById(selectedId);

					//String tv = SexButton.getText().toString();
				//	c.moveToFirst();
					String idd = c.getString(c.getColumnIndex("id"));
					String name1 = c.getString(c.getColumnIndex("sur_name"));
					id.setText(idd);
					name.setText(name1);

					
					
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
	id.setText("");
	name.setText("");
	ass.setText("");
				    //display Toast
				   Toast.makeText(getApplicationContext(), "marks updated successfully.", 10).show();
					}
					}
						   
		
		catch(Exception e)
		{
			e.printStackTrace();
			   Toast.makeText(getApplicationContext(), "marks not updated successfully.", 10).show();

		}


				
					
				}
			});
			bback.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub

					// TODO Auto-generated method stub
					try{
					if(!c.isFirst())
						c.moveToPrevious();
					String iid = c.getString(c.getColumnIndex("id")); 
					  
				    String surname=c.getString(c.getColumnIndex("sur_name"));
				    id.setText(iid);
				    name.setText(surname);
				
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
				
				}
			});
	bshow.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub

					// TODO Auto-generated method stub
						
				
					Intent intent = getIntent();
					final String tbname  = intent.getStringExtra("tbname");
					String test = intent.getStringExtra("test");
					Intent intent1 = new Intent(getApplicationContext(),AssShow.class);
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
id.setText("");
name.setText("");
				        	String id1 = c.getString(c.getColumnIndex("id"));
				        	int iddd = Integer.parseInt(id1);

				        	String name1 = c.getString(c.getColumnIndex("sur_name"));
				        	//String test1 = c.getString(c.getColumnIndex(test));
				        	
				        					        	
				        	id.setText(id1);
				        	name.setText(name1);
				        	
				        	
				        	
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
				 		e.printStackTrace();
				 		Toast.makeText(getApplicationContext(), "cant display", 3000).show();
						// TODO: handle exception
					}
				

			super.onResume();

		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ass_enter, menu);
		return true;
	}

}
