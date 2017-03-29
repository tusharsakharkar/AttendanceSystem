package com.example.attendance;
//package com.example.stud_attendance;

import java.util.concurrent.ExecutionException;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Attend_Activity extends Activity {

	 private RadioGroup radioGroup;
	  private RadioButton SexButton,radio;

	
	//static String word ="";
	 final Context context = this;
	 TextView id ,name,view,datee,dayy,tymm;
	 Button pre,nxt,start,btnDisplay ,show,secondnxt;
	 EditText edit ;
	 SQLiteDatabase db;
	protected Cursor c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attend_);
		id = (TextView)findViewById(R.id.id);
		name = (TextView)findViewById(R.id.name);
		pre = (Button)findViewById(R.id.pre);
		nxt = (Button)findViewById(R.id.nxt);
		radioGroup = (RadioGroup) findViewById(R.id.att);
		secondnxt = (Button)findViewById(R.id.icon);
		datee = (TextView)findViewById(R.id.text0101);
		dayy = (TextView)findViewById(R.id.text0202);
		tymm = (TextView)findViewById(R.id.text0303);
		edit = (EditText)findViewById(R.id.only);
		//view = (TextView)findViewById(R.id.V1);
show = (Button)findViewById(R.id.bu);
		radio = (RadioButton)findViewById(R.id.present);
		radio.setChecked(true);
		
		//btnDisplay = (Button) findViewById(R.id.button111);


		start = (Button)findViewById(R.id.start);
		Intent intent = getIntent();
		
	//final String date =	intent.getStringExtra("date");
	//final String date =	"date";
	
		 final String date =intent.getStringExtra("date");
		 
		 //int num = Integer.parseInt(date1);
 //final String word = "";

		
		//final String date = word;
		
		
		
		
	
		
		
	
	final String tbname = intent.getStringExtra("tbname");

	//final String tbname = 123456";
	//Toast.makeText(context, date, 30).show();
	
	try{
	  db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
	   //create new table if not already exist
	//   String str = "create table if not exists mytable(id varchar2(5), sur_name varchar2(20))";
	//   String str = "create table if not exists "+ tbname +"(id varchar2(5), sur_name varchar2(20), " + date +" varchar2(10))";

	  // db.execSQL(str);
	   String query = "ALTER TABLE " + tbname + " ADD COLUMN " + date + " varchar2(10);";
		db.execSQL(query);
		Toast.makeText(getApplicationContext(),"Today date is added successfully", 10).show();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	//	e.printStackTrace();
		//Toast.makeText(getApplicationContext(),"already hav column to table", 50).show();
	}
	   
	   
	   
	   
	 
	   
	   
//  codee for radio button
	/*
	 // public void addListenerOnButton() {

	radioGroup = (RadioGroup) findViewById(R.id.attend);
	btnDisplay = (Button) findViewById(R.id.btnDisplay);

	btnDisplay.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {

		        // get selected radio button from radioGroup
			int selectedId = radioGroup.getCheckedRadioButtonId();

			// find the radiobutton by returned id
			SexButton = (RadioButton) findViewById(selectedId);

			String ss = SexButton.getText().toString();
			Toast.makeText(getApplicationContext(),
					ss, 3000).show();

		}

	});

  //}

	   
	   
	   */
	   
//ending code of radio button
	
	
	
	
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
		  
		    String val = c.getString(c.getColumnIndex(date));
		    if(val == null)
		    {
			String sq = "UPDATE "+tbname+" SET " + date + " = 'Present' WHERE id = " + id + ";";

		    db.execSQL(sq);

		    //display Toast
		 //  Toast.makeText(getApplicationContext(), "data updated successfully.", 50).show();
		    }
		   // String surname=c.getString(c.getColumnIndex("sur_name"));
		   // String check =c.getString(c.getColumnIndex(date));
		    //display on text view
		    
		  //  view.append(" "+id+"  "+surname+" "+check+"\n");
		    //move next position until end of the data
		   }while(c.moveToNext());
		  
}
catch(Exception e)
{
	e.printStackTrace();
Toast.makeText(getApplicationContext(), "data not updated.", 20).show();
}

	   
	   
	   start.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			try{
			display();}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		private void display() {
			// TODO Auto-generated method stub

			   //use cursor to keep all data
			   //cursor can keep data of any data type

			    c=db.rawQuery("select * from "+tbname+";", null);
			   id.setText("");
			   name.setText("");
			   //move cursor to first position
			   c.moveToFirst();
			   
			   showrecord();
			   //fetch all data one by one
			 /*  do
			   {
			    //we can use c.getString(0) here
			    //or we can get data using column index
			    int idd =c.getInt(0);
			    String id = Integer.toString(idd); 
			  
			    String surname=c.getString(1);
			    //display on text view
			    
			    id.(" "+id+"              "+surname+"\n");
			    //move next position until end of the data
			   }while(c.moveToNext());
			   */
			  
			   			   
		}

		private void showrecord() {
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
			}
			
		}
	});
		// String idd = id.getText().toString();

		nxt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		try{
			check();
			movenxt();

		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(),
						"cannot not update", 10).show();
				
		}
			//Toast.makeText(getApplicationC//ontext(),
				//	"fuck u", 3000).show();
			
			//datainsert();
		//movenxt();


										}
/*
		*/
		private void check() {
			// TODO Auto-generated method stub
			try{
			int selectedId = radioGroup.getCheckedRadioButtonId();

			// find the radiobutton by returned id
			SexButton = (RadioButton) findViewById(selectedId);

			String tv = SexButton.getText().toString();
			//Toast.makeText(getApplicationContext(),
				//	tv, 10).show();
			//addColumn(date);
			String idd = id.getText().toString();
			int iid = Integer.parseInt(idd);
		//	try{
			String sq = "UPDATE "+tbname+" SET " + date + " = '" + tv + "' WHERE id = " + iid + ";";

		    db.execSQL(sq);

		    //display Toast
		   Toast.makeText(getApplicationContext(), "student "+tv, 10).show();
}
catch(Exception e)
{
	e.printStackTrace();
	   Toast.makeText(getApplicationContext(), "data not update.", 10).show();

}

}
			
		/*
		Cursor addColumn(String name){
			    //db=dbhelper.getWritableDatabase();
			    return  db.rawQuery("alter table " + name + " add column " + name + " varchar(10)", null);
			}
*/
		
	
		private void movenxt() {
			// TODO Auto-generated method stub
			try{
			if(!c.isLast())
				c.moveToNext();
			showrecord();
			//Toast.makeText(getApplicationContext(),ss, 3000).show();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		private void showrecord() {
			// TODO Auto-generated method stub
			// int idd =c.getString(c.getColumnIndex("id"));
			try{
				
		
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
	
	pre.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			try{
			if(!c.isFirst())
				c.moveToPrevious();
			showrecord();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		private void showrecord() {
			// TODO Auto-generated method stub
			int idd =c.getInt(0);
		    String iid = Integer.toString(idd); 
		  
		    String surname=c.getString(1);
		    id.setText(iid);
		    name.setText(surname);
	
		}
		
			
		
	});
	
	show.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			try{
			Intent intent = new Intent(context,TodayDisplay.class);
			intent.putExtra("tbname", tbname);
			intent.putExtra("date", date);
			startActivity(intent);
			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			/*
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
*/
		}
		
		
	});
	
	
	
	secondnxt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			fuck();
		}

		private void fuck() {
			// TODO Auto-generated method stub
			try{
				
				String id = edit.getText().toString();

				//String sq = "UPDATE "+tbname+" SET " + date + " = '" + fck + "' WHERE id = " + id + ";";
				String sq = "UPDATE "+tbname+" SET " + date + " = 'Absent' WHERE id = " + id + ";";

			    db.execSQL(sq);

			    //display Toast
			   Toast.makeText(getApplicationContext(), "data updated successfully.", 10).show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		   Toast.makeText(getApplicationContext(), "data not updated successfully.", 10).show();

	}

			
		  //  c=db.rawQuery("select * from "+tbname+";", null);

		  //  c.moveToFirst();
			//  String iid = c.getString(c.getColumnIndex("id")); 
			 /* while(!c.isLast()){
			  if(iid == id)
			  {
				//  String fck = "Absent";
					try{
						//String sq = "UPDATE "+tbname+" SET " + date + " = '" + fck + "' WHERE id = " + id + ";";
						String sq = "UPDATE "+tbname+" SET " + date + " = 'Absent' WHERE id = " + iid + ";";

					    db.execSQL(sq);

					    //display Toast
					   Toast.makeText(getApplicationContext(), "values updated successfully.", 50).show();
			}
			catch(Exception e)
			{
				   Toast.makeText(getApplicationContext(), "values not updated successfully.", 50).show();

			}

			  }
			  else
			  {
				 // String fck = "present";
					try{
						//String sq = "UPDATE "+tbname+" SET " + date + " = '" + fck + "' WHERE id = " + iid + ";";
						String sq = "UPDATE "+tbname+" SET " + date + " = 'Present' WHERE id = " + iid + ";";

					    db.execSQL(sq);

					    //display Toast
					   Toast.makeText(getApplicationContext(), "values updated successfully.", 50).show();
			}
			catch(Exception e)
			{
				   Toast.makeText(getApplicationContext(), "values not updated successfully.", 50).show();

			}

			  
		    
			
		}
			  c.moveToNext();

			   }*/
		}
			  
	});
	
	}
	protected void onResume() {

		// TODO Auto-generated method stub

		   //use cursor to keep all data
		   //cursor can keep data of any data type
		try{
Intent intent = getIntent();
final String tbname = intent.getStringExtra("tbname");

/*
 * 
 *    intent.putExtra("date",dgg);
	                intent.putExtra("tbname", tbname);
	                intent.putExtra("da", s);
	                intent.putExtra("day", s1);
	                intent.putExtra("tym", yyyy);

 */
String dateee = intent.getStringExtra("da");
String day = intent.getStringExtra("day");
String tym  = intent.getStringExtra("tym");


datee.setText(dateee);
dayy.setText(day);
tymm.setText(tym);












		    c=db.rawQuery("select * from "+tbname+";", null);
		   id.setText("");
		   name.setText("");
		   //move cursor to first position
		   c.moveToFirst();
		   
		   //fetch all data one by one
		 /*  do
		   {
		    //we can use c.getString(0) here
		    //or we can get data using column index
		    int idd =c.getInt(0);
		    String id = Integer.toString(idd); 
		  
		    String surname=c.getString(1);
		    //display on text view
		    
		    id.(" "+id+"              "+surname+"\n");
		    //move next position until end of the data
		   }while(c.moveToNext());
		   */
		  
		   			   
	
		// TODO Auto-generated method stub
		  String iid = c.getString(c.getColumnIndex("id")); 
		  
		    String surname=c.getString(c.getColumnIndex("sur_name"));
		    id.setText(iid);
		    name.setText(surname);
		 
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		super.onResume();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attend_, menu);
		return true;
	}

}
