package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Practical3Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_practical3, container, false);
        TextView textView = view.findViewById(R.id.fragment_text);
        textView.setText("This is a Fragment in Practical 3");
        return view;
    }
}