package com.example.attendance;
//package com.example.stud_attendance;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class DisplayAdapter15 extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> no;
    private ArrayList<String> name;
    private ArrayList<String> sta;

   // private ArrayList<String> sub;
   // private ArrayList<String> /*lastName*/;
    

    public DisplayAdapter15(Context c, ArrayList<String> no,ArrayList<String> sta,ArrayList<String> name) {
        this.mContext = c;

        this.no = no;
        this.name = name;
        this.sta = sta;

       // this.sub = sub;
        //this.lastName = lname;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return no.size();
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
            child = layoutInflater.inflate(R.layout.todaylistcell, null);
            mHolder = new Holder();
            mHolder.txt_no = (TextView) child.findViewById(R.id.chut1000);
            mHolder.txt_name = (TextView) child.findViewById(R.id.chut3000);
            mHolder.txt_sta = (TextView) child.findViewById(R.id.chut2000);
            
            //mHolder.sub1 = (TextView) child.findViewById(R.id.txt_lName);
            
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
      
        
       
        
        if(sta.get(pos).equals("Absent"))
        {
        	//mHolder.txt_fName.setVisibility(View.INVISIBLE);
mHolder.txt_sta.setBackgroundResource(R.drawable.absent);
mHolder.txt_no.setText(no.get(pos));
mHolder.txt_name.setText(name.get(pos));
mHolder.txt_sta.setText(sta.get(pos));

        }
                    else if(sta.get(pos).equals("Present"))
                    {
                    	mHolder.txt_sta.setBackgroundResource(R.drawable.present);
                    	 mHolder.txt_no.setText(no.get(pos));
                         mHolder.txt_name.setText(name.get(pos));
                       mHolder.txt_sta.setText(sta.get(pos));


                    }

        
        
        
        /*
        mHolder.txt_no.setText(no.get(pos));
        mHolder.txt_name.setText(name.get(pos));
      mHolder.txt_sta.setText(sta.get(pos));
        //  mHolder.sub1.setText(sub.get(pos));
*/
        return child;
    }

    public class Holder {
        public TextView txt_name;
		TextView txt_no;
        TextView txt_sta;
       // TextView txt_lName;
    }

}
