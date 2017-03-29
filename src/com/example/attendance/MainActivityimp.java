package com.example.attendance;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityimp extends Activity {
SQLiteDatabase db;
TextView path;
Button impo;



static String TAG = "ExelLog";
static int iddddd = 0;

public final Context context = this;
File directory = null;
File file = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activityimp);
		
		path = (TextView)findViewById(R.id.folderpath);
		impo = (Button)findViewById(R.id.impbtn);
		db= openOrCreateDatabase("Mydb", MODE_PRIVATE, null);

		Intent intent = getIntent();
		final String tbname = intent.getStringExtra("tbname");
		final String fileName = tbname+".xls";
		
		
		
		
		
		
		
		
		
		
		
		
		impo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				

				// TODO Auto-generated method stub
				try{
					// private static void readExcelFile(Context context, String filename) { 
					 
				//	final String fileName = "fuckbitch.xls";
					//File directory = null,file = null;
					
					
					//hear main code
					File sdCard = Environment.getExternalStorageDirectory();	
					 directory = new File(sdCard.getAbsolutePath() + "/AttendanceImport");
						
					//create directory if not exist
					if(!directory.isDirectory()){
						directory.mkdirs();	
						Toast.makeText(context, "path created successfully ="+sdCard.getAbsolutePath() + directory, 100).show();
					}
					
					path.setText(directory.toString());

					}
					catch(Exception e)
					{
						Toast.makeText(context, "dir not create", 100).show();
					}
					//file path
					
					
					try{
				//	 file = new File(directory, fileName);
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					//
						/*
			        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) 
			        { 
			            Log.e(TAG, "Storage not available or read only"); 
			            Toast.makeText(context,"Stroage not available", 100).show();
			            return; 
			        } */
			//final String filename = "testfile.xls";
			        try{
			            // Creating Input Stream 
			        	try{
						 file = new File(directory, fileName);
						 }
			        	catch(Exception e)
			        	{
			        		Toast.makeText(context, "file not found", 10).show();
			        	}

			            //File file = new File(context.getExternalFilesDir(null), filename); 
			            FileInputStream myInput = new FileInputStream(file);
			 
			            // Create a POIFSFileSystem object 
			            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
			 
			            // Create a workbook using the File System 
			            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
			 
			            // Get the first sheet from workbook 
			            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
			 
			            /** We now need something to iterate through the cells.**/
			            Iterator<?> rowIter = mySheet.rowIterator();
			 
			            while(rowIter.hasNext()){
			                HSSFRow myRow = (HSSFRow) rowIter.next();

			                if(myRow.getRowNum()== 0)
			                {
			                	//Toast.makeText(context, "fuck", 100).show();
			                }
			                else
			                {
			               //  myRow = (HSSFRow) rowIter.next();

			                Iterator<?> cellIter = myRow.cellIterator();
			                while(cellIter.hasNext()){
			                    HSSFCell myCell = (HSSFCell) cellIter.next();
			                  //  myCell = (HSSFCell) cellIter.next();
			                    String data = null,data1;
			                    
			                    try{
			                    if(myCell.getCellNum() == 0)
			                    {
			                    	
			                    	
			                     data =  myCell.toString();
			                 //   Log.d(TAG, "Cell Value: " +  myCell.toString());
			                   
			                    //String data1 =  myCell.toString();
			                    
			                     iddddd = Integer.parseInt(data);
			                   // String query = "insert into "+ tbname +" VALUES("+iddd+","+null+")";

			    			  //  db.execSQL(query);
			    			   //display Toast
			    			 //  Toast.makeText(getApplicationContext(), "values inserted successfully.", Toast.LENGTH_LONG).show();

			                    }else
			                    
			                    
			                    if(myCell.getCellNum() == 1)
			                    {
			                   

				                   data1 =  myCell.toString();
		                    	
			                 //   Log.d(TAG, "Cell Value: " +  myCell.toString());
			                    

			                    // iddd = Integer.parseInt(data);
			    			   // String sq = "UPDATE "+tbname+" SET sur_name='" + data1 + "' WHERE id= " + iddd + ";";
			                   // String query = "insert into "+ tbname +" VALUES("+iddddd+",'"+data1+"')";
							    String query = "insert into "+ tbname +" VALUES("+iddddd+",'"+data1+"',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)";

			    			    db.execSQL(query);
			    			   //display Toast
			    			  // Toast.makeText(getApplicationContext(), "values inserted successfully.", Toast.LENGTH_LONG).show();
iddddd= 0;
			                  // Toast.makeText(getApplicationContext(), "values inserted successfully.", Toast.LENGTH_LONG).show();
            			    	}
			                    
			                    				                    	

				    			   Toast.makeText(getApplicationContext(), "Data imported successfully.",10).show();

			                    
			                    	
			                 //   Toast.makeText(context, "cell Value: " + myCell.toString(), Toast.LENGTH_SHORT).show();
			                
			                    
			                    
			                  //  }
			                   ///(Exception e)
			                   // {
			                    //	e.printStackTrace();
			                    //	Toast.makeText(context, "cant insert",100).show();
			                   // }
			                    
			                    
			                    
			                    }
			                
			                    catch(Exception e)
				                {
			                    	e.printStackTrace();
				                	Toast.makeText(context, "cant insert", 10).show();
				                }
			                
			                }
			                }
			            }}
			        catch (Exception e){e.printStackTrace(); }
		            Toast.makeText(context,"cannot import", 10).show();

			        return;
			    } 
				
				catch (Exception e)
				   {
					e.printStackTrace();
					  // Toast.makeText(getApplicationContext(), "cant display" , 300).show();

				   }
			
				
			}
		});
		
		
		
		
		
		
		
		
	}
	public void onResume()
	{
		try{
			
			File sdCard = Environment.getExternalStorageDirectory();	
			 directory = new File(sdCard.getAbsolutePath() + "/AttendanceImport");
				
			//create directory if not exist
			if(!directory.isDirectory()){
				directory.mkdirs();	
				Toast.makeText(context, "path created successfully ="+sdCard.getAbsolutePath() + directory, 100).show();
			}
			
			path.setText(directory.toString());

			}
			catch(Exception e)
			{
				e.printStackTrace();
				Toast.makeText(context, "dir not create", 10).show();
			}

		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activityimp, menu);
		return true;
	}

}
