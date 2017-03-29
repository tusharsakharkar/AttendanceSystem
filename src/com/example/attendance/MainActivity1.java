package com.example.attendance;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity1 extends Activity {
	final Context context = this;
	Button benter,btoday,bcheck,btest,bass,bset;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		Intent intent = getIntent();
		final String tbname = intent.getStringExtra("tbname");
		benter = (Button)findViewById(R.id.fckenter);
		btoday = (Button)findViewById(R.id.fcktoday);
		bcheck = (Button)findViewById(R.id.fckchech);
		btest = (Button)findViewById(R.id.testbtn1);
		bass = (Button)findViewById(R.id.assbutton2);
		bset = (Button)findViewById(R.id.setting1);
		bset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, Setting_activity.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

			}
		});
		
		
		bass.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, AssDisplay.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

				
			}
		});
		
		
		btest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, Testcolumn.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

			}
		});

		
		
		benter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,List_activity.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);
				
			}
		});
		btoday.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(context,DatePicker1.class);
				intent.putExtra("tbname", tbname);
				startActivity(intent);
			}
		});
		bcheck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,Seclistdisplay.class);
				intent.putExtra("tbname", tbname);
				startActivity(intent);
			
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
	}

}
