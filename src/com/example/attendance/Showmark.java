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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Showmark extends Activity {
	Button b1;
	ListView ls;
	SQLiteDatabase db;
	Cursor c;
	private ArrayList<String> userId = new ArrayList<String>();
	private ArrayList<String> user_sur_name = new ArrayList<String>();
	private ArrayList<String> sub = new ArrayList<String>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showmark);
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		ls = (ListView)findViewById(R.id.list5656);

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
		
		
		
		b1 = (Button)findViewById(R.id.button9999);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent3 = new Intent(getApplicationContext(),Testenter.class);
				startActivity(intent3);
				
				
			}
		});
	}
	
	
	
	protected void onResume() {
		//displayData();
		Intent intent = getIntent();
		final String tbname = intent.getStringExtra("tbname");
	final String test = intent.getStringExtra("test");

		// TODO Auto-generated method stub
		try{
			// userList = (ListView)findViewById(R.id.List);
			ls = (ListView)findViewById(R.id.list5656);

				//dataBase = mHelper.getWritableDatabase();
				Cursor mCursor = db.rawQuery("SELECT * FROM "
						+ tbname, null);

				userId.clear();
				user_sur_name.clear();
				sub.clear();
				//user_lName.clear();
				if (mCursor.moveToFirst()) {
					do {
						userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
						user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
						sub.add(mCursor.getString(mCursor.getColumnIndex(test)));

					} while (mCursor.moveToNext());
				}
				Markclass disadpt = new Markclass(getApplicationContext(),userId, user_sur_name,sub);
				ls.setAdapter(disadpt);
				mCursor.close();
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
		getMenuInflater().inflate(R.menu.showmark, menu);
		return true;
	}

}
