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

public class Markclass extends BaseAdapter {
  private Context mContext;
  private ArrayList<String> id;
  private ArrayList<String> name;
  private ArrayList<String> mark;

 // private ArrayList<String> sub;
 // private ArrayList<String> /*lastName*/;
  

  public Markclass(Context c, ArrayList<String> id,ArrayList<String> name,ArrayList<String> mark) {
      this.mContext = c;

      this.id = id;
      this.name = name;
      this.mark = mark;

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
          child = layoutInflater.inflate(R.layout.markcell, null);
          mHolder = new Holder();
          mHolder.txt_id = (TextView) child.findViewById(R.id.markid);
          mHolder.txt_fName = (TextView) child.findViewById(R.id.markname);
          mHolder.txt_lName = (TextView) child.findViewById(R.id.mark);
          
          //mHolder.sub1 = (TextView) child.findViewById(R.id.txt_lName);
          
          child.setTag(mHolder);
      } else {
          mHolder = (Holder) child.getTag();
      }
      mHolder.txt_id.setText(id.get(pos));
      mHolder.txt_fName.setText(name.get(pos));
    mHolder.txt_lName.setText(mark.get(pos));
      //  mHolder.sub1.setText(sub.get(pos));

      return child;
  }

  public class Holder {
      public TextView txt_lName;
		TextView txt_id;
      TextView txt_fName;
     // TextView txt_lName;
  }

}
