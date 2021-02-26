package com.dasithvidanage.formapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import com.google.android.material.textview.MaterialTextView;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner menu;
    private Button sumitbtn;
    private RelativeLayout parent;
    //theboxes
    private  TextInputLayout thename;
    private  TextInputLayout email;
    private TextInputLayout phone;
    private TextInputLayout pasw;
    private RadioGroup radioGroup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu);

        ArrayList<String> country = new ArrayList<>();
        country.add("Sri Lanka");
        country.add("India");
        country.add("China");
        country.add("USA");

        ArrayAdapter<String> Countryadd = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                country
        );

        menu.setAdapter(Countryadd);
        sumitbtn = findViewById(R.id.sumitbtn);

       //values
        thename = findViewById(R.id.thename);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        pasw = findViewById(R.id.passw);
        radioGroup = findViewById(R.id.radioGroup);
        parent = findViewById(R.id.themainthingidedlk);

        sumitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validate();
            }
        });
    }
    public void validate(){
        String uname = thename.getEditText().getText().toString();
        String uemail = email.getEditText().getText().toString().trim();
        String uphone = phone.getEditText().getText().toString().trim();
        String upassw = pasw.getEditText().getText().toString().trim();

        if(uname.isEmpty() || uemail.isEmpty() || uphone.isEmpty() || upassw.isEmpty()){
            Snackbar.make(parent,"Please fill all the fields", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "please check the fields again.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }else if(!(uemail.contains("@"))){
            Snackbar.make(parent, "E-Mail is invalid", Snackbar.LENGTH_SHORT).show();

        } else if((upassw.length()  < 8)){
            Snackbar.make(parent, "passowrd should contain at least 8 chatactors" , Snackbar.LENGTH_SHORT).show();

        }else if((uphone.length() != 10)){
            Snackbar.make(parent,"phone number should contain 10 numbers ", Snackbar.LENGTH_SHORT).show();

        }else if(radioGroup.getCheckedRadioButtonId() == -1){
            Snackbar.make(parent,"please select your gender", Snackbar.LENGTH_SHORT).show();

        }else{
            Snackbar.make(parent, "You Have Signed Up Sucessfully Login" , Snackbar.LENGTH_INDEFINITE)
                    .setAction("Log-In", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Thanks for SignUp ", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }
    }

}
