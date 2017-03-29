package com.example.attendance;
//package com.example.stud_attendance;


import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//import com.example.stud_attendance.DisplayAdapter.Holder;

public class DisplayProTest extends BaseAdapter {

private Context mContext;
private ArrayList<String> id;
private ArrayList<String> sur_name;
// private ArrayList<String> sub;
// private ArrayList<String> /*lastName*/;


public DisplayProTest(Context c, ArrayList<String> id,ArrayList<String> sur_name) {
    this.mContext = c;

    this.id = id;
    this.sur_name = sur_name;
   // this.sub = sub;
    //this.lastName = lname;
}

public int getCount() {
    // TODO Auto-generated method stub
    return id.size();
}

public Object getItem(int position) {
    // TODO Auto-generated method stub
    return null;
}

public long getItemId(int position) {
    // TODO Auto-generated method stub
    return 0;
}

public View getView(int pos, View child, ViewGroup parent) {
    Holder mHolder;
    LayoutInflater layoutInflater;
    if (child == null) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        child = layoutInflater.inflate(R.layout.protest, null);
        mHolder = new Holder();
        mHolder.txt_id = (TextView) child.findViewById(R.id.txt_id111);
        mHolder.txt_fName = (TextView) child.findViewById(R.id.txt_sur_name122);
        //mHolder.sub1 = (TextView) child.findViewById(R.id.txt_lName);
        
        child.setTag(mHolder);
    } else {
        mHolder = (Holder) child.getTag();
    }
    
   

    
    mHolder.txt_id.setText(id.get(pos));
    mHolder.txt_fName.setText(sur_name.get(pos));
  //  mHolder.sub1.setText(sub.get(pos));
    /*
    String ma = sur_name.get(pos);
    int mar = Integer.parseInt(ma);
    if(mar<7)
    {
    	//mHolder.txt_fName.setVisibility(View.INVISIBLE);
mHolder.txt_fName.setBackgroundResource(R.drawable.absent);
    }
                else               {
                	mHolder.txt_fName.setBackgroundResource(R.drawable.present);

                }
*/
    return child;
}

public class Holder {
    TextView txt_id;
    TextView txt_fName;
    //TextView sub1;
}

}