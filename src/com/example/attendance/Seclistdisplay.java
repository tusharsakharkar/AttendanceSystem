package com.example.attendance;
//package com.example.stud_attendance;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Seclistdisplay extends Activity {

	
	
	 public final Context context = this;
	 

		SQLiteDatabase db;
		Button btn;

		private ArrayList<String> userId = new ArrayList<String>();
		private ArrayList<String> user_sur_name = new ArrayList<String>();
		//private ArrayList<String> sub = new ArrayList<String>();
		//private ArrayList<String> user_lName = new ArrayList<String>();

		 ListView userList1;
		//private AlertDialog.Builder build;

		//Button btnadd;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seclistdisplay);
	//btn = (Button)findViewById(R.id.button1111);
	userList1 = (ListView)findViewById(R.id.list2);
	
		final Intent intent = getIntent();
	   	 
        // 2. get message value from intent
      final String tbname = intent.getStringExtra("tbname");
  	//ArrayList<String> sub = tbname;
       try{
       db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);}
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
	   //create new table if not already exist
 // String str = "create table if not exists mytable(id varchar2(5), sur_name varchar2(20))";
	 // String str = "create table if not exists "+ tbname +"(id varchar2(5) PRIMARY KEY, sur_name varchar2(20))";

	  // db.execSQL(str);
       /*
       userList1.setOnTouchListener(new ListView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{
			userList1.scrollBy(0, 1);
			}
			return false;
			}
			});
		*/
	   
	   
	   userList1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, final View v, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				//final EditText edit1 = (EditText) v.findViewById(R.id.editText3);
				///final EditText edit2 = (EditText) v.findViewById(R.id.editText4);
				try{
				TextView txt1 = (TextView)v.findViewById(R.id.txt_id1);
			    TextView txt2 = (TextView)v.findViewById(R.id.txt_sur_name1);
			    String id = txt1.getText().toString();
			    String name = txt2.getText().toString();
			      final String tbname = intent.getStringExtra("tbname");

			   // Toast.makeText(context,"no: "+id+" name :"+name+" ", 3000).show();
			    Intent intent1 = new Intent(context, Profile1.class);
			    intent1.putExtra("tbname", tbname);
			    intent1.putExtra("id", id);
			    intent1.putExtra("name", name);
			    startActivity(intent1);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			    
			}
	   });

	   
	   
/*	   
btn.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		fucku();
		
	}

	private void fucku() {
		// TODO Auto-generated method stub
	       db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			try{
				//userList1 = (ListView)findViewById(R.id.List);

					//dataBase = mHelper.getWritableDatabase();
					Cursor mCursor = db.rawQuery("SELECT * FROM " + tbname, null);

					userId.clear();
					user_sur_name.clear();
					//user_lName.clear();
					if (mCursor.moveToFirst()) {
						do {
							userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
							user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
							//sub.add(tbname);
							//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

						} while (mCursor.moveToNext());
					}
					DisplayAdapter1 disadpt = new DisplayAdapter1(context,userId, user_sur_name);
					userList1.setAdapter(disadpt);
					mCursor.close();
				 	}
				 	catch (Exception e) {
				 		Toast.makeText(context, "cant display", 3000).show();
						// TODO: handle exception
					}
				

		
	}
});
	*/
	
	
	}
	protected void onResume() {
		super.onResume();
		
		try{
			//userList1 = (ListView)findViewById(R.id.List);
Intent intent = getIntent();
final String tbname = intent.getStringExtra("tbname");
				//dataBase = mHelper.getWritableDatabase();
				Cursor mCursor = db.rawQuery("SELECT * FROM " + tbname, null);

				userId.clear();
				user_sur_name.clear();
				//user_lName.clear();
				if (mCursor.moveToFirst()) {
					do {
						userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
						user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
						//sub.add(tbname);
						//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

					} while (mCursor.moveToNext());
				}
				DisplayAdapter1 disadpt = new DisplayAdapter1(context,userId, user_sur_name);
				userList1.setAdapter(disadpt);
				mCursor.close();
			 	}
			 	catch (Exception e) {
			 		Toast.makeText(context, "cant display", 3000).show();
					// TODO: handle exception
				}
			

	

		
		
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seclistdisplay, menu);
		return true;
	}

}
	
