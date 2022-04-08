package com.example.apple.scifinamegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                generator();
            }
        });
    }





















    public void generator() {
        //first name first 3 letters + last name first 2 letters = sci first name
        //city first 2 letters + school first 3 letters = sci last name

        TextView Result = findViewById(R.id.Result);

        EditText FirstNameET = findViewById(R.id.FirstName);
        EditText LastNameET = findViewById(R.id.LastName);
        EditText SchoolET = findViewById(R.id.School);
        EditText CityET = findViewById(R.id.City);

        String FirstName = FirstNameET.getText().toString();
        String LastName = LastNameET.getText().toString();
        String School = SchoolET.getText().toString();
        String City = CityET.getText().toString();

        String SciFiFirstName;
        String SciFiLastName;


        if (FirstName.length() < 3) {
            FirstNameET.setError("Word length cannot be less than 3.");
            return;
        } else {
            FirstNameET.setError(null);
        }

        if (LastName.length() < 2) {
            LastNameET.setError("Word length cannot be less than 2.");
            return;
        } else {
            LastNameET.setError(null);
        }

        if (City.length() < 2) {
            CityET.setError("Word length cannot be less than 2.");
            return;
        } else {
            CityET.setError(null);
        }

        if (School.length() < 3) {
            SchoolET.setError("Word length cannot be less than 3.");
            return;
        } else {
            SchoolET.setError(null);
        }


        LastName = LastName.toLowerCase();
        School = School.toLowerCase();

        SciFiFirstName = FirstName.substring(0, 3) + LastName.substring(0, 2);
        SciFiLastName = City.substring(0, 2) + School.substring(0, 3);

        String text = "Welcome" +  " " + SciFiFirstName + " " + SciFiLastName + " !";

        Result.setText(text);
    }
}
