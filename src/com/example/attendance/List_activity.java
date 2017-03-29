package com.example.attendance;
//package com.example.stud_attendance;

//package com.example.mydb4;

import java.util.ArrayList;

//import com.hk.sqlitedemo.DbHelper;
//import com.hk.sqlitedemo.DisplayActivity;

//import com.hk.sqlitedemo.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class List_activity extends Activity {
	 public final Context context = this;
	 

	SQLiteDatabase db;
	Button btn;

	private ArrayList<String> userId = new ArrayList<String>();
	private ArrayList<String> user_sur_name = new ArrayList<String>();
	private ArrayList<String> sub = new ArrayList<String>();
	//private ArrayList<String> user_lName = new ArrayList<String>();

	private ListView userList;
	private AlertDialog.Builder build;

	Button btnadd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_activity);
		
		Intent intent = getIntent();
	   	 
        // 2. get message value from intent
      final String tbname = intent.getStringExtra("tbname");
  	//ArrayList<String> sub = tbname;
       
       try{
       db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
	   //create new table if not already exist
	//   String str = "create table if not exists mytable(id varchar2(5), sur_name varchar2(20))";
	  // String str = "create table if not exists "+ tbname +"(id varchar2(5) PRIMARY KEY, sur_name varchar2(20))";

	  // db.execSQL(str);

	  
		userList = (ListView) findViewById(R.id.List);
		
		btnadd = (Button)findViewById(R.id.button10);
		/*
		 userList.setOnTouchListener(new ListView.OnTouchListener() {
	    	  @Override
	    	  public boolean onTouch(View v, MotionEvent event) {
	    	  if (event.getAction() == MotionEvent.ACTION_MOVE)
	    	  {
	    	  userList.scrollBy(0, 1);
	    	  }
	    	  return false;
	    	  }
	    	  });
	    
		*/
		btnadd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Intent intent = new Intent(context ,MainActivity1.class);
				intent.putExtra("message", tbname);
				startActivity(intent);
				*/
				try{
				showdialogue();}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}

			private void showdialogue() {
				// TODO Auto-generated method stub
				
				LayoutInflater layoutInflater = LayoutInflater.from(List_activity.this);
				View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(List_activity.this);
				alertDialogBuilder.setView(promptView);

				final EditText edit1 = (EditText) promptView.findViewById(R.id.editText1);
				final EditText edit2 = (EditText) promptView.findViewById(R.id.editText2);
				
				//String idd = edit1.getText().toString();
				//String sur_name = edit2.getText().toString();

				// setup a dialog window
				alertDialogBuilder.setCancelable(false)
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							private ArrayList<String> fuck;

							public void onClick(DialogInterface dialog, int id) {
						
								String idd =edit1.getText().toString().trim();
							    String sur_name=edit2.getText().toString().trim();
							    edit1.setText("");
							    edit2.setText("");
								   edit1.setSelection(0);

							    if(idd.equals("") || sur_name.equals(""))
							    	{
						            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
						            return;
							    	}
							    else
							    	{

								    int iid = Integer.parseInt(idd);
								    //Intent intent = getIntent();
								   // String tbname = intent.getExtras("me")
							    //insert data into able
							  // String query = "INSERT INTO mytable (id,sur_name) VALUES("+id+", '"+sur_name+"');";
						       // db.execSQL(query);
							  //  String query = "insert into mytable VALUES("+id+",'"+sur_name+"')";
								   try{
							    String query = "insert into "+ tbname +" VALUES("+iid+",'"+sur_name+"',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)";

							    db.execSQL(query);
							   //display Toast
							   Toast.makeText(getApplicationContext(), "Data inserted successfully.", 10).show();
							   displayData();
							    }
								  catch(Exception e)
								   {
									  e.printStackTrace();
									  Toast.makeText(context, "sorrry",10).show();
								   }
								
							}

							
							}

							private void displayData() {
								// TODO Auto-generated method stub
								
									// TODO Auto-generated method stub
									try{
										 userList = (ListView)findViewById(R.id.List);

											//dataBase = mHelper.getWritableDatabase();
											Cursor mCursor = db.rawQuery("SELECT * FROM "
													+ tbname, null);

											userId.clear();
											user_sur_name.clear();
											//user_lName.clear();
											if (mCursor.moveToFirst()) {
												do {
													userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
													user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
													sub.add(tbname);
													//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

												} while (mCursor.moveToNext());
											}
											DisplayAdapter disadpt = new DisplayAdapter(context,userId, user_sur_name);
											userList.setAdapter(disadpt);
											mCursor.close();
										 	}
										 	catch (Exception e) {
										 		e.printStackTrace();
										 		Toast.makeText(context, "cant display", 10).show();
												// TODO: handle exception
											}
										

								}

							
						}
						)
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										dialog.cancel();
									}
								});

				// create an alert dialog
				AlertDialog alert = alertDialogBuilder.create();
				alert.show();
				
			}
		
		
		
		
		});
		
		
		
		userList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, final View v, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				//final EditText edit1 = (EditText) v.findViewById(R.id.editText3);
				///final EditText edit2 = (EditText) v.findViewById(R.id.editText4);
				
				TextView txt1 = (TextView)v.findViewById(R.id.txt_id);
			    TextView txt2 = (TextView)v.findViewById(R.id.txt_sur_name);
			    String no = txt1.getText().toString().trim();
			    String name = txt2.getText().toString().trim();
			//    Toast.makeText(context,"no: "+no+" name :"+name+" ", 3000).show();
			    
				
				LayoutInflater layoutInflater = LayoutInflater.from(List_activity.this);
				View promptView = layoutInflater.inflate(R.layout.update_dialog, null);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(List_activity.this);
				alertDialogBuilder.setView(promptView);

				final EditText edit1 = (EditText) promptView.findViewById(R.id.editText3);
				final EditText edit2 = (EditText) promptView.findViewById(R.id.editText4);
				edit1.setText(no);
			    
			    edit2.setText(name);
				   edit1.setSelection(0);

				
				//String idd = edit1.getText().toString();
				//String sur_name = edit2.getText().toString();

				// setup a dialog window
				alertDialogBuilder.setCancelable(false)
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
						
								String idd =edit1.getText().toString();
							    String sur_name=edit2.getText().toString();
							    
							    if(idd.equals("") || sur_name.equals(""))
							    	{
						            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
						            return;
							    	}
							    else
							    	{

								    int iid = Integer.parseInt(idd);
								   // Intent intent = getIntent();
								   // String tbname = intent.getExtras("me")
							    //insert data into able
							  // String query = "INSERT INTO mytable (id,sur_name) VALUES("+id+", '"+sur_name+"');";
						       // db.execSQL(query);
							  //  String query = "insert into mytable VALUES("+id+",'"+sur_name+"')";
								    try{
							    String query = "UPDATE "+tbname+" SET sur_name='" + sur_name + "' WHERE id= " + iid + ";";

							    db.execSQL(query);
								   displayData();

							   //display Toast
							   Toast.makeText(getApplicationContext(), "data updated successfully.",10).show();
								    }
								    catch(Exception e)
								    {
								    	e.printStackTrace();
										   Toast.makeText(getApplicationContext(), "data cannot updated successfully.",10).show();

								    }
							}

							
							}

							private void displayData() {
								// TODO Auto-generated method stub
								//userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
							//	user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
								userId.clear();
								user_sur_name.clear();
									// TODO Auto-generated method stub
								try{
									 userList = (ListView)findViewById(R.id.List);

										//dataBase = mHelper.getWritableDatabase();
										Cursor mCursor = db.rawQuery("SELECT * FROM "
												+ tbname, null);

										userId.clear();
										user_sur_name.clear();
										//user_lName.clear();
										if (mCursor.moveToFirst()) {
											do {
												userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
												user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
												//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

											} while (mCursor.moveToNext());
										}
										DisplayAdapter disadpt = new DisplayAdapter(context,userId, user_sur_name);
										userList.setAdapter(disadpt);
										mCursor.close();
									 	}
									 	catch (Exception e) {
									 		e.printStackTrace();
									 		Toast.makeText(context, "cant display", 10).show();
											// TODO: handle exception
										}

								}

							
						}
						)
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										dialog.cancel();
									}
								});

				// create an alert dialog
				AlertDialog alert = alertDialogBuilder.create();
				alert.show();
				
			}

							
						}
						);
						/*.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										dialog.cancel();
									}
								});
								

				// create an alert dialog
				AlertDialog alert = alertDialogBuilder.create();
				alert.show();
				
			*/
				
						
				
					
		
		
		
		
		
		
		
		
		
		userList.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {

				build = new AlertDialog.Builder(context);
				build.setTitle("Delete " + user_sur_name.get(arg2));
				build.setMessage("Do you want to delete ?");
				build.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
try{
								Toast.makeText(
										getApplicationContext(),
										user_sur_name.get(arg2)
												+ " is deleted.", 30).show();

//								dataBase.delete(
//									DbHelper.TABLE_NAME,
//										DbHelper.KEY_ID + "="
//												+ userId.get(arg2), null);
								//displayData();
								
								String sql = "DELETE FROM "+tbname+" WHERE id=" + userId.get(arg2) + ";";
							    db.execSQL(sql);
}
catch(Exception e)
{
	e.printStackTrace();
}
							    userId.clear();
							    user_sur_name.clear();
							    
							    try{
									 userList = (ListView)findViewById(R.id.List);

										//dataBase = mHelper.getWritableDatabase();
										Cursor mCursor = db.rawQuery("SELECT * FROM "
												+ tbname, null);

										userId.clear();
										user_sur_name.clear();
										//user_lName.clear();
										if (mCursor.moveToFirst()) {
											do {
												userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
												user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
												//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

											} while (mCursor.moveToNext());
										}
										DisplayAdapter disadpt = new DisplayAdapter(context,userId, user_sur_name);
										userList.setAdapter(disadpt);
										mCursor.close();
									 	}
									 	catch (Exception e) {
									 		e.printStackTrace();
									 		Toast.makeText(context, "cant display", 30).show();
											// TODO: handle exception
										}

							    Toast.makeText(getApplicationContext(), "data Deleted", 10).show();


								dialog.cancel();
							}
						});

				build.setNegativeButton("No",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});
				AlertDialog alert = build.create();
				alert.show();

				return true;
			}
		});	   
		
		/*
		 btn = (Button)findViewById(R.id.button11);
		 btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				displayData();
			}

		private void displayData() {
				// TODO Auto-generated method stub
				try{
					 userList = (ListView)findViewById(R.id.List);

						//dataBase = mHelper.getWritableDatabase();
						Cursor mCursor = db.rawQuery("SELECT * FROM "
								+ tbname, null);

						userId.clear();
						user_sur_name.clear();
						//user_lName.clear();
						if (mCursor.moveToFirst()) {
							do {
								userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
								user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
								//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

							} while (mCursor.moveToNext());
						}
						DisplayAdapter disadpt = new DisplayAdapter(context,userId, user_sur_name);
						userList.setAdapter(disadpt);
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
		//displayData();
		
		// TODO Auto-generated method stub
		try{
			
			Intent intent = getIntent();
			final String tbname = intent.getStringExtra("tbname");

			 userList = (ListView)findViewById(R.id.List);

				//dataBase = mHelper.getWritableDatabase();
				Cursor mCursor = db.rawQuery("SELECT * FROM "
						+ tbname, null);

				userId.clear();
				user_sur_name.clear();
				//user_lName.clear();
				if (mCursor.moveToFirst()) {
					do {
						userId.add(mCursor.getString(mCursor.getColumnIndex("id")));
						user_sur_name.add(mCursor.getString(mCursor.getColumnIndex("sur_name")));
						//user_lName.add(mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME)));

					} while (mCursor.moveToNext());
				}
				DisplayAdapter disadpt = new DisplayAdapter(context,userId, user_sur_name);
				userList.setAdapter(disadpt);
				mCursor.close();
			 	}
			 	catch (Exception e) {
			 		e.printStackTrace();
			 		Toast.makeText(context, "cant display", 3000).show();
					// TODO: handle exception
				}
			

	
		super.onResume();
	}


		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
	}

}
