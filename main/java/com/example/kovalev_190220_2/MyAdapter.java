package com.example.kovalev_190220_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Student> {
    public MyAdapter(@NonNull Context context, ArrayList<Student> students) {
        super(context, R.layout.adapter_item, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.tv_name)).setText(student.getName());
        ((TextView) convertView.findViewById(R.id.tv_secondName)).setText(student.getSecondName());
        ((TextView) convertView.findViewById(R.id.tv_phone)).setText(String.valueOf(student.getPhone()));

        return convertView;
    }
}
