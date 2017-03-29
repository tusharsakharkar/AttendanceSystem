package com.example.attendance;
///package com.example.stud_attendance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Export extends Activity {
ListView lst ;
Button xport,sndmail  ;
EditText edit ;
TextView patth;
String pa = "";
//final String fileName = "";
File file = null;
final String fileName = "fuckbitch.xls";
File directory = null;



SQLiteDatabase db;
private ArrayList<String> user = new ArrayList<String>();
ArrayList<String> selectedItems = new ArrayList<String>();
final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_export);
		Intent intent = getIntent();
	final String tbname = intent.getStringExtra("tbname");
		//lst = (ListView)findViewById(R.id.setlist11);
	//	lst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
xport = (Button)findViewById(R.id.buttonxport);
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
		edit = (EditText)findViewById(R.id.editmail);
		sndmail  = (Button)findViewById(R.id.sendmail);
		final String fileName = tbname+".xls";

		
patth = (TextView)findViewById(R.id.path1);
	//	btn = (Button)findViewById(R.id.settingg1);
		Toast.makeText(getApplicationContext(), tbname, 10).show();
	//btn.setOnClickListener(new OnClickListener() {});
	
	xport.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			
			
			
			
			
			
			

			Cursor cursor = db.rawQuery("SELECT * FROM "
					+ tbname, null);
			WritableWorkbook workbook;
			String[] ss = cursor.getColumnNames();
			int len  = ss.length;
		  //  HSSFWorkbook hwb = new HSSFWorkbook();

			WorkbookSettings wbSettings = null;
		//	private void exportToExcel(Cursor cursor) {		
						//file = null;
				//Saving file in external storage
				try{
				File sdCard = Environment.getExternalStorageDirectory();	
				 directory = new File(sdCard.getAbsolutePath() + "/AttendanceXport");
				 String path = String.valueOf(directory);
					patth.setText(path);
						
				//create directory if not exist
				if(!directory.isDirectory()){
					directory.mkdirs();	
					//Toast.makeText(context, "path created successfully ="+sdCard.getAbsolutePath() + directory, 100).show();
				 path = String.valueOf(directory);
				patth.setText(path);
				}
				}
				catch(Exception e)
				{
					Toast.makeText(context, "folder not create", 10).show();
				}
				//file path
				
				
				
				try{
				 file = new File(directory, fileName);
				 pa = file.getAbsolutePath().toString();

				 wbSettings = new WorkbookSettings();
				wbSettings.setLocale(new Locale("en", "EN"));		
				//WritableWorkbook workbook;
				//Toast.makeText(context, "w created successfully", 100).show();

				}
				catch(Exception e)
				{
					e.printStackTrace();
					//Toast.makeText(context, "workbook not create", 100).show();
				}
				
				
				String date1;
				String num  = "";
					
				try {
					workbook = Workbook.createWorkbook(file, wbSettings);			
					//Excel sheet name. 0 represents first sheet
					WritableSheet sheet = workbook.createSheet(tbname, 0);
					cursor.moveToFirst();
					
					try {
						
						for(int k=0;k<len;k++){
							
							
							
							
							

							  StringBuffer s = new StringBuffer(ss[k]);
							  int strlen = s.length();
							  if(strlen == 13)
							  {
					   
							   
							   


						       // System.out.println("hello");
						        // TODO code application logic here
						//String a = "";
						char b[] = {'a','b','c','d','e','f','g','h','i','j'};
						        //StringBuffer s = new StringBuffer("dbbaaajb");
						        ///s.reverse();
						     //   System.out.println(s);
						         s.reverse();
						       // num = s;
						        for(int i= 0;i<10;i++)
						        {
						           /// for(int j=0;j<8;j++ )
						                 //   System.out.println(s);
						            if(s.charAt(0)== b[i])
						            {
						                num = num+i;
						            }
						        }
						       //     
						               for(int i= 0;i<10;i++)
						               {
						            if(s.charAt(1) == b[i])
						            {
						num = num +i;            } }
						          //  else
						               
						                       for(int i= 0;i<10;i++)
						                       {
						             if(s.charAt(2) == b[i])
						            {
						                num = num + i;
						            } }

						                               for(int i= 0;i<10;i++)
						                               {
						                       if(s.charAt(3) == b[i])
						            {
						                num = num + i;
						            } }
						                               
						                                       for(int i= 0;i<10;i++)
						                                       {
						            if(s.charAt(4) == b[i])
						            {
						                num = num + i;
						            } }
						                                               for(int i= 0;i<10;i++)
						                                               {
						            if(s.charAt(5) == b[i])
						            {
						                num = num + i;
						            }}
						         
						                                                       for(int i= 0;i<10;i++)
						                                                       {
						        if(s.charAt(6) == b[i])
						            {
						                num = num + i;
						            } }
						                                                       
						                            for(int i= 0;i<10;i++)
						                            {
						        if(s.charAt(7) == b[i])
						            {
						                num = num + i;
						            } }
						                            for(int i= 0;i<10;i++)
						                            {
						        if(s.charAt(8) == b[i])
						            {
						                num = num + i;
						            } }
						                 
						                 for(int i= 0;i<10;i++)
						                            {
						        if(s.charAt(9) == b[i])
						            {
						                num = num + i;
						            } }
						                 
						                 
						                 for(int i= 0;i<10;i++)
						                            {
						        if(s.charAt(10) == b[i])
						            {
						                num = num + i;
						            } }
						                 
						                 for(int i= 0;i<10;i++)
						                            {
						        if(s.charAt(11) == b[i])
						            {
						                num = num + i;
						            } }
						                 
						                 for(int i= 0;i<10;i++)
						                            {
						        if(s.charAt(12) == b[i])
						            {
						                num = num + i;
						            } }
						           
						                            
						                            String a1 = num.substring(11,13);
						                            
						                            
						                            String b1 = num.substring(9,11);
						                            String c1 = num.substring(5,9);
						                                                        date1  = a1+"/"+b1+"/"+c1;
						                            num = "";
						                            
						                            
							  }
							  else
							  {
								  date1 = ss[k];
								  num = "";
							  }
							
							
							
							
							
							
							
							
							
							
							
							
							
						sheet.addCell(new Label(k, 0, date1)); // column and row
						//sheet.addCell(new Label(i, 0, ss[i+1]));	
						//cursor.moveToFirst();
						if (cursor.moveToFirst()) {
							do {
								String title = cursor.getString(cursor.getColumnIndex(ss[k]));
								//String desc = cursor.getString(cursor.getColumnIndex(ss[i+1]));

								int q = cursor.getPosition() + 1;						
								sheet.addCell(new Label(k, q, title));
							//	sheet.addCell(new Label(1, q, desc));						
							} while (cursor.moveToNext());
						}
						}
						//closing cursor
						cursor.close();
						workbook.write();		
						Toast.makeText(context, "data Xported successfully", 10).show();

					} catch (RowsExceededException e) {
						e.printStackTrace();
						//Toast.makeText(context, "cant row", 100).show();
					} catch (WriteException e) {
						e.printStackTrace();
						//Toast.makeText(context, "cant write work book", 100).show();

					}			
					//workbook.write();		
					try {
						workbook.close();
					} catch (WriteException e) {
						e.printStackTrace();
						//Toast.makeText(context, "cant write ", 100).show();

					}
				} catch (IOException e) {
					e.printStackTrace();
					//Toast.makeText(context, "I O ", 100).show();

				}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	});
	
	
sndmail.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//String pa = file.getAbsolutePath().toString();

		//try{
			
			 file = new File(directory, fileName);

		    Toast.makeText(context,file.getAbsolutePath().toString() , 10).show();
/*
			   String to=edit.getText().toString().trim();

		    Intent email = new Intent(Intent.ACTION_SEND);  
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});  
           // email.putExtra(Intent.EXTRA_SUBJECT, subject);  
            email.putExtra(Intent.EXTRA_TEXT, "ja na be chutiye");  
		       email.putExtra(Intent.EXTRA_STREAM, Uri.parse(file.getAbsolutePath()));

            //need this to prompts email client only  
            email.setType("message/rfc822");  
 
            startActivity(Intent.createChooser(email, "Sending mail"));  
 Toast.makeText(context, "send successfully", 100).show();
			*/
			
		
		   
		   String to=edit.getText().toString().trim();
		 //  String subj=txtsubj.getText().toString().trim();
		  // String msg=txttextmsg.getText().toString().trim();
		   
		   if(to.length() < 1)
		   {
		    Toast.makeText(getApplicationContext(), "Please Enter Recipent Email",10).show();
		   }
		   //else if (subj.length() < 1) {
		    //Toast.makeText(getApplicationContext(), "Please Enter Subject", Toast.LENGTH_LONG).show();
		   //}
		   //else if (msg.length() < 1) {
		    //Toast.makeText(getApplicationContext(), "Please Enter Message", Toast.LENGTH_LONG).show();
		   //}
		   else {
		  //  Toast.makeText(context, file.getAbsolutePath().toString(), 100).show();
		    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
		    emailIntent.setType("message/rfc822");
		       emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{to}); 
		      // emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subj); 
		      emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Excel file"); 
		       emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(file.getAbsolutePath()));
		       try{
		       startActivity(Intent.createChooser(emailIntent, "Send mail..."));
		       Toast.makeText(context, "Email Send successfully", 10).show();
		   } 
		  
		 
		
		
		
		
		catch(Exception e)
		{
		       Toast.makeText(context, "cant Email Send", 10).show();
	
		}
		
		
		
	
		   }
	
	
	
	}
});
			
		
	
	}
	
	protected void onResume() {
		//displayData();
				
super.onResume();	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.export, menu);
		return true;
	}

}
