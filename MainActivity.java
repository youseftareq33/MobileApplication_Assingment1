package com.example.assingment_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import com.example.assingment_1.classes.*;


public class MainActivity extends AppCompatActivity {
    private List<Subject> subject;
    private List<Test> test;
    //----------------------------
    private Spinner spinnerSubject;
    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for subject
        subject = new ArrayList<>();

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Science");
        Subject subject3 = new Subject("English");

        subject.add(subject1);
        subject.add(subject2);
        subject.add(subject3);

        List<String> subjectData = new ArrayList<>();
        subjectData.add("Select a subject");
        for (Subject subject : subject) {
            subjectData.add(subject.getSubjectName());
        }









        // for Test
        test = new ArrayList<>();

        Test test_Math = new Test("math test","1 + 2  = 3 (true)\n2 + 4 = 5 (false)\n5 + 6 = 11 (true)");
        Test test_Science = new Test("science test","The Sun is a source of light (true)\nPlants need sunlight to grow (true)\n Animals can talk like humans (false)");
        Test test_English = new Test("english test","The alphabet has 26 letters (true)\nAdjectives are words that describe nouns (true)\n\n" +
                "A sentence does not always begin with a capital letter (false)");















        // for spinner(combobox)
        spinnerSubject = findViewById(R.id.spinnerSubject);


        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjectData);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(spinnerAdapter);
        spinnerSubject.setSelection(0);

        // Set a listener to handle spinner item selection
        spinnerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSubject = parent.getItemAtPosition(position).toString();

                TextView textBackground = findViewById(R.id.textBackground);
                String testText = "";
                subjectData.remove("Select a subject");

                if (selectedSubject.equals("Math")) {
                    testText = test_Math.getTestName()+"\n---------------------------------\n"
                +   test_Math.getQuestion();
                } else if (selectedSubject.equals("Science")) {
                    testText = test_Science.getTestName()+"\n---------------------------------\n\n"
                +   test_Science.getQuestion();
                } else if (selectedSubject.equals("English")) {
                    testText = test_English.getTestName()+"\n---------------------------------\n\n"
                +   test_English.getQuestion();
                }

                textBackground.setText(testText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}
