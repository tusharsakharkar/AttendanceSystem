package com.example.attendance;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Setting_activity extends Activity {
Button settt,about,dev,setimp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_activity);
		Intent intent = getIntent();
	final	String tbname = intent.getStringExtra("tbname");
	dev = (Button)findViewById(R.id.about111);
		about = (Button)findViewById(R.id.about);
	setimp = (Button)findViewById(R.id.setimp);
		
		
		setimp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 //TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), MainActivityimp.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

			}
		});
		
about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Help.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

			}
		});

		settt = (Button)findViewById(R.id.set11);
		settt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Export.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

			}
		});
		dev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Developer.class);
				intent.putExtra("tbname", tbname);

				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_activity, menu);
		return true;
	}

}
