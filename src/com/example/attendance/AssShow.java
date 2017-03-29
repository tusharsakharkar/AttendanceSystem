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

public class AssShow extends Activity {
	SQLiteDatabase db;
	Button benter;
	ListView ls;
	Cursor c;
	private ArrayList<String> userId = new ArrayList<String>();
	private ArrayList<String> user_sur_name = new ArrayList<String>();
	private ArrayList<String> sub = new ArrayList<String>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ass_show);
		try{
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ls = (ListView)findViewById(R.id.list888888);
	

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
//benter = (Button)findViewById(R.id.enter9);
//list = (ListView)findViewById(R.id.list888888);

		
	}
	protected void onResume() {
		//displayData();
		
		// TODO Auto-generated method stub
		try{
			Intent intent = getIntent();
			final String tbname = intent.getStringExtra("tbname");
		     final String test = intent.getStringExtra("test");

			// userList = (ListView)findViewById(R.id.List);

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
			 		e.printStackTrace();
			 		Toast.makeText(getApplicationContext(), "cant display", 30).show();
					// TODO: handle exception
				}
			

	
		super.onResume();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ass_show, menu);
		return true;
	}

}
