package com.example.android.sample3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppDevelopmentFragment extends Fragment {

    ArrayList<String> nameList = new ArrayList<>();

    public AppDevelopmentFragment() {
        // Required empty public constructor

    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String name=new String();
        Bundle nameBundle=getArguments();
        if(nameBundle!=null) {
            name = nameBundle.getString("key");
        }


        nameList.add(name);


        View v = inflater.inflate(R.layout.fragment_app_development, container, false);





        // Find the root view so we can add child views to it
        FrameLayout rootView = (FrameLayout) v.findViewById(R.id.app_dev);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        rootView.addView(linearLayout);


        // Create a variable to keep track of the current index position
        int index;
        // Keep looping until we've reached the end of the list (which means keep looping
        // as long as the current index position is less than the length of the list)
       for(index=0;index<nameList.size();index++) {
            // Create a new TextView
            TextView wordView = new TextView(getActivity());
            // Set the text to be word at the current index
            wordView.setText(nameList.get(index));
            wordView.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            wordView.setTextSize(24);
            wordView.setTextColor(getResources().getColor(R.color.white));

            // Add this TextView as another child to the root view of this layout
            linearLayout.addView(wordView);

            // Increment the index variable by 1
            index++;
        }

        // Inflate the layout for this fragment
        return v;

    }


}