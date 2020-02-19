package com.example.kovalev_190220_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иван1", "Иванов", 1234567890));
        students.add(new Student("Иван2", "Иванов", 1234567890));
        students.add(new Student("Иван3", "Иванов", 1234567890));
        students.add(new Student("Иван4", "Иванов", 1234567890));
        students.add(new Student("Иван5", "Иванов", 1234567890));
        students.add(new Student("Иван6", "Иванов", 1234567890));

        MyAdapter myAdapter = new MyAdapter(this, students);
        listView.setAdapter(myAdapter);

    }
}
