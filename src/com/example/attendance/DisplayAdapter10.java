package com.example.attendance;
//package com.example.stud_attendance;

//package com.example.stud_attendance;

import java.util.ArrayList;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

////import com.example.stud_attendance.DisplayAdapter.Holder;

public class DisplayAdapter10 extends BaseAdapter {
  private Context mContext;
  private ArrayList<String> date;
  private ArrayList<String> status1;
  //private ArrayList<String> status2;

 // private ArrayList<String> sub;
 // private ArrayList<String> /*lastName*/;
  

  public DisplayAdapter10(Context c, ArrayList<String> date,ArrayList<String> status1) {
      this.mContext = c;

      this.date = date;
      this.status1 = status1;
    //  this.status2 = status2;

     // this.sub = sub;
      //this.lastName = lname;
  }

  public int getCount() {
      // TODO Auto-generated method stub
      return date.size();
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
          child = layoutInflater.inflate(R.layout.list4, null);
          mHolder = new Holder();
          mHolder.txt_id = (TextView) child.findViewById(R.id.textdisp1);
          mHolder.txt_fName = (TextView) child.findViewById(R.id.textdisp2);
         // mHolder.txt_lName = (TextView) child.findViewById(R.id.chut3);
          
          //mHolder.sub1 = (TextView) child.findViewById(R.id.txt_lName);
    
          
                      child.setTag(mHolder);

          
      } else {
          mHolder = (Holder) child.getTag();
      }
    //if(status1.)
      if(status1.get(pos).equals("Absent"))
      {
      	//mHolder.txt_fName.setVisibility(View.INVISIBLE);
mHolder.txt_fName.setBackgroundResource(R.drawable.absent);
      }
                  else if(status1.get(pos).equals("Present"))
                  {
                  	mHolder.txt_fName.setBackgroundResource(R.drawable.present);

                  }

      
      
      
      
      mHolder.txt_id.setText(date.get(pos));
      mHolder.txt_fName.setText(status1.get(pos));
  //  mHolder.txt_lName.setText(status2.get(pos));
      //  mHolder.sub1.setText(sub.get(pos));

      
      
      
      return child;
  }

  
  
  public class Holder {
    //  public TextView txt_lName;
		TextView txt_id;
      TextView txt_fName;
     // TextView txt_lName;
  }

}
