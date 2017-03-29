package com.example.attendance;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//import com.example.stud_attendance.DisplayAdapter.Holder;

public class Maindisplay extends BaseAdapter {
    private Context mContext;
   // private ArrayList<String> id;
    private ArrayList<String> sur_name;
   // private ArrayList<String> sub;
   // private ArrayList<String> /*lastName*/;
    

    public Maindisplay(Context c,ArrayList<String> sur_name) {
        this.mContext = c;

        //this.id = id;
        this.sur_name = sur_name;
       // this.sub = sub;
        //this.lastName = lname;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return sur_name.size();
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
           
            View row = layoutInflater.inflate(R.layout.mainlistcell, parent, false);

             child = layoutInflater.inflate(R.layout.mainlistcell, null);
            mHolder = new Holder();
         //   mHolder.txt_id = (TextView) child.findViewById(R.id.txt_id);
            mHolder.txt_fName = (TextView) child.findViewById(R.id.maintxt1);
            //mHolder.sub1 = (TextView) child.findViewById(R.id.txt_lName);
            
            
            
            
            /*
     holder = new AtomPaymentHolder();
		holder.atomPayment = items.get(position);
		holder.removePaymentButton = (ImageButton)row.findViewById(R.id.atomPay_removePay);
		holder.removePaymentButton.setTag(holder.atomPayment);
       
            
       LayoutInflater inflater = FusionMain.this.getLayoutInflater();
View row = inflater.inflate(R.layout.list_row, parent, false);
TextView item = (TextView)row.findViewById(R.id.tvItems);
item.setText(items.get(position));
return row;
     
            
            
   */         
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
     //   mHolder.txt_id.setText(id.get(pos));
        mHolder.txt_fName.setText(sur_name.get(pos));
      //  mHolder.sub1.setText(sub.get(pos));

        return child;
    }

    public class Holder {
    //    TextView txt_id;
        TextView txt_fName;
        //TextView sub1;
    }

}
