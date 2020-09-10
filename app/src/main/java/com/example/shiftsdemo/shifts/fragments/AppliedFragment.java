package com.example.shiftsdemo.shifts.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shiftsdemo.R;
import com.example.shiftsdemo.database.AcceptedData;
import com.example.shiftsdemo.database.AppliedData;
import com.example.shiftsdemo.shifts.MyListData;

import java.util.ArrayList;

public class AppliedFragment extends Fragment
{
    private final String TAG = "AppliedFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        Log.d(TAG, "onCreateView: inside method");
        View lView = inflater.inflate(R.layout.frag_applied, container, false);

        AppliedData appliedData = AppliedData.getInstance();

        RecyclerView recyclerView = (RecyclerView) lView.findViewById(R.id.recyclerView);
        MyListAdapter adapter = MyListAdapter.getInstance(appliedData.appliedList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return lView;
    }

    static class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
        private ArrayList<MyListData> listdata = new ArrayList<>();
        private static MyListAdapter mMyListAdapter = null;

        // RecyclerView recyclerView;
        private MyListAdapter(ArrayList<MyListData> listdata) {
            this.listdata = listdata;
        }

        public static MyListAdapter getInstance(ArrayList<MyListData> listdata) {
            if (mMyListAdapter == null) {
                mMyListAdapter = new MyListAdapter(listdata);
            }
            return mMyListAdapter;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final MyListData myListData = listdata.get(position);
            holder.currentTime.setText(listdata.get(position).getCurrentTime());
            holder.hospitalName.setText(listdata.get(position).getHospitalName());
            holder.inOutTime.setText(listdata.get(position).getIn_out_time());
            holder.location.setText(listdata.get(position).getLocation());
            holder.department.setText(listdata.get(position).getDepartment());
            holder.applyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MyListAdapter", "onClick: clicked on apply for "+myListData.getHospitalName());
                    AcceptedData.getInstance().acceptedList.add(myListData);
                    AcceptedFragment.MyListAdapter.getInstance(AcceptedData.getInstance().acceptedList).notifyDataSetChanged();
                    listdata.remove(position);
                    notifyDataSetChanged();

                }
            });
        }


        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView currentTime;
            public TextView hospitalName;
            public TextView inOutTime;
            public TextView location;
            public TextView department;
            public Button applyButton;

            public CardView cardView;

            public ViewHolder(View itemView) {
                super(itemView);
                this.currentTime = (TextView) itemView.findViewById(R.id.current_time_TV);
                this.hospitalName = (TextView) itemView.findViewById(R.id.hospital_name_TV);
                this.inOutTime = (TextView) itemView.findViewById(R.id.time_date_TV);
                this.location = (TextView) itemView.findViewById(R.id.location_TV);
                this.department = (TextView) itemView.findViewById(R.id.department_TV);
                this.applyButton = (Button) itemView.findViewById(R.id.apply_button);
                this.applyButton.setText(R.string.accept);
                cardView = (CardView)itemView.findViewById(R.id.cardView);
            }
        }
    }

}
