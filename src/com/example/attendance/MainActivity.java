package com.example.attendance;
import java.io.File;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends Activity {
	Button bedit,bdelete,bsetting,b1,bdel;
	SQLiteDatabase db;
	//TextView t1,t2;\
	ListView userList;
	String tbname;
	Context context = this;
	private ArrayList<String> fuck = new ArrayList<String>();
	File directory = null;
	File file = null;

	private AlertDialog.Builder build;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		 userList = (ListView)findViewById(R.id.fcklist1);
//bedit = (Button)findViewById(R.id.fckedit1);
//bdelete = (Button)findViewById(R.id.fckdelete2);
//bsetting = (Button)findViewById(R.id.fcksetting3);
		 
		 try{
		 
        db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
 	   //create new table if not already exist
 	//   String str = "create table if not exists mytable(id varchar2(5), sur_name varchar2(20))";
 	  // String str = "create table if not exists "+ tbname +"(id varchar2(5), sur_name varchar2(20))";

 	   //db.execSQL(str);

        b1 = (Button)findViewById(R.id.chutbutton1);
      final Context  context = this;
       // bdel = (Button)findViewById(R.id.mainbutton);
        
      /*
      userList.setOnTouchListener(new ListView.OnTouchListener() {
    	  public boolean onTouch(View v, MotionEvent event) {
    	  if (event.getAction() == MotionEvent.ACTION_MOVE)
    	  {
    		  userList.scrollBy(0, 1);
    	  }
    	  return false;
    	  }
    	  });
    	  */
    	 //
      try{
      File sdCard = Environment.getExternalStorageDirectory();	
		 directory = new File(sdCard.getAbsolutePath() + "/AttendanceImport");
			
		//create directory if not exist
		if(!directory.isDirectory()){
			directory.mkdirs();	
			Toast.makeText(context, "path created successfully ="+sdCard.getAbsolutePath() + directory, 10).show();
		}
		
	//	path.setText(sdCard.getAbsolutePath() + directory.toString());
      }
		
		catch(Exception e)
		{
			Toast.makeText(context, "dir not create", 10).show();
		}

        b1.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View arg0) {
    			// TODO Auto-generated method stub
    		//	Intent intent = new Intent(context,MainActivity1.class );
    		//	startActivity(intent);
    			try{
    			fuck();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    				Toast.makeText(context, "cannot create class", 10).show();
    			}
    		}

			private void fuck() {
				// TODO Auto-generated method stub
		//
				// TODO Auto-generated method stub
				
				LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
				View promptView = layoutInflater.inflate(R.layout.input_dialog0, null);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
				alertDialogBuilder.setView(promptView);

				final EditText edit1 = (EditText) promptView.findViewById(R.id.editfuck);
				//final EditText edit2 = (EditText) promptView.findViewById(R.id.editText2);
				
				//String idd = edit1.getText().toString();
				//String sur_name = edit2.getText().toString();

				// setup a dialog window
				alertDialogBuilder.setCancelable(false)
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog, int id) {
								try{
								fuck.clear();
						
								 tbname =edit1.getText().toString().trim();
							    //String sur_name=edit2.getText().toString();
							    edit1.setText("");
							    //edit2.setText("");
								   edit1.setSelection(0);

							    if(tbname.equals(""))
							    	{
						            Toast.makeText(getApplicationContext(),"Please fill all fields",100).show();
						            return;
							    	}
							    else
							    	{

								   // int iid = Integer.parseInt(idd);
								   // Intent intent = getIntent();
								   // String tbname = intent.getExtras("me")
							    //insert data into able
							  // String query = "INSERT INTO mytable (id,sur_name) VALUES("+id+", '"+sur_name+"');";
						       // db.execSQL(query);
							  //  String query = "insert into mytable VALUES("+id+",'"+sur_name+"')";
							    //String query = "insert into "+ tbname +" VALUES("+iid+",'"+sur_name+"')";
							    

							    	 String str = "create table if not exists "+ tbname +"(id Integer(5) not null primary key , sur_name varchar2(20),Test_1 Integer(5),Test_2 Integer(5),Test_3 Integer(5),Test_4 Integer(5),Test_5 Integer(5),Test_6 Integer(5),Test_7 Integer(5),Test_8 Integer(5),Test_9 Integer(5),Test_10 Integer(5),Assignment_1 Integer(5),Assignment_2 Integer(5),Assignment_3 Integer(5),Assignment_4 Integer(5),Assignment_5 Integer(5))";

							   	   //db.execSQL(str);

							    	
							    	
							    db.execSQL(str);
							   //display Toast
							 //  Toast.makeText(getApplicationContext(), "table created successfully successfully.",100).show();
							  // displayData();
								
							}
								}
								catch(Exception e)
								{
									e.printStackTrace();
									   Toast.makeText(getApplicationContext(),"Plz Enter Valid subject name in one word" ,10).show();

								}
								   displayData();

							
							
						
			}
							private void displayData() {
								// TODO Auto-generated method stub
								
									// TODO Auto-generated method stub
									try{
										 userList = (ListView)findViewById(R.id.fcklist1);

											//dataBase = mHelper.getWritableDatabase();
										 Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

										 c.moveToFirst();

										 if (c.moveToFirst()) {
										        while ( !c.isAfterLast() ) {
										        	String and = c.getString(0);
										        	if(and.equalsIgnoreCase("android_metadata"))
										        	{
										        		//chudk;
										        	}
										        	else
										        	{
										            fuck.add(and);
										        	}										            c.moveToNext();
										        }
										    }											//userId.clear();
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
										 Maindisplay maindisplay = new Maindisplay(context, fuck);
											userList.setAdapter(maindisplay);
											c.close();
										 	}
										 	catch (Exception e) {
										 		Toast.makeText(context, "cant display", 50).show();
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
       	 public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
       		 try{
                // position parameter gives the index or position of ListView Item which is Clicked
                TextView tv=(TextView)v.findViewById(R.id.maintxt1);
                String tbname=tv.getText().toString();
             //   Toast.makeText(getApplicationContext(), "Contact Selected: "+tbname, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,MainActivity1.class);
                intent.putExtra("tbname",tbname);
                startActivity(intent);
       		 }
       		 catch(Exception e)
       		 {
        	e.printStackTrace();
       		 }
       		 
            }
   	});
        
        
        
		userList.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {

				build = new AlertDialog.Builder(context);
				build.setTitle("Delete " +fuck.get(arg2) );
				build.setMessage("Do you want to delete ?");
				build.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
try{
								Toast.makeText(
										getApplicationContext(),
										fuck.get(arg2)
												+ " is deleted.", 20).show();

//								dataBase.delete(
//									DbHelper.TABLE_NAME,
//										DbHelper.KEY_ID + "="
//												+ userId.get(arg2), null);
								//displayData();
								String sql = "drop table "+fuck.get(arg2)+";";
							    db.execSQL(sql);
	
								fuck.clear();
}
catch(Exception e)
{
	e.printStackTrace();
}

								try{
									 //userList = (ListView)findViewById(R.id.fcklist1);

										//dataBase = mHelper.getWritableDatabase();
									 Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

									 c.moveToFirst();

									 if (c.moveToFirst()) {
									        while ( !c.isAfterLast() ) {
									        	String and = c.getString(0);
									        	if(and.equalsIgnoreCase("android_metadata"))
									        	{
									        		//chudk;
									        	}
									        	else
									        	{
									            fuck.add(and);
									        	}									            c.moveToNext();
									        }
									    }											//userId.clear();
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
										Maindisplay disadpt = new Maindisplay(context, fuck);
										userList.setAdapter(disadpt);
										c.close();
									 	}
									 	catch (Exception e) {
									 		Toast.makeText(context, "cant display", 50).show();
											// TODO: handle exception
										}

								
														 //   Toast.makeText(getApplicationContext(), "table Deleted", Toast.LENGTH_LONG).show();

							
							
							    									


								
									// TODO Auto-generated method stub
									
										// TODO Auto-generated method stub
																					

									

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
			};
			
			
		});
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }
    
  
    
        
    protected void onResume() {
		//displayData();

		// TODO Auto-generated method stub

			// TODO Auto-generated method stub
			try{
				fuck.clear();

				 userList = (ListView)findViewById(R.id.fcklist1);

					//dataBase = mHelper.getWritableDatabase();
				 Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

				 c.moveToFirst();

				 if (c.moveToFirst()) {
				        while ( !c.isAfterLast() ) {
				        	String and = c.getString(0);
				        	if(and.equalsIgnoreCase("android_metadata"))
				        	{
				        		//chudk;
				        	}
				        	else
				        	{
				            fuck.add(and);
				        	}
				            c.moveToNext();
				        }
				    }											//userId.clear();
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
					Maindisplay disadpt = new Maindisplay(context, fuck);
					userList.setAdapter(disadpt);
					c.close();
				 	}
				 	catch (Exception e) {
				 		e.printStackTrace();
				 		Toast.makeText(context, "cant display",50).show();
						// TODO: handle exception
					}
				

			super.onResume();

		
		
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
