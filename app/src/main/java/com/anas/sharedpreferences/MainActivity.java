package com.anas.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtName;
    EditText eName;
    Button btnAdd,btnDelete,btnView;

    SharedPreferences sp;
    SharedPreferences.Editor sp_editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName=findViewById(R.id.txtName);
        eName=findViewById(R.id.eName);
        btnAdd=findViewById(R.id.btnAdd);
        btnDelete=findViewById(R.id.btnDelete);
        btnView=findViewById(R.id.btnView);


        btnAdd.setOnClickListener(v -> {

            sp=getSharedPreferences("attendee",MODE_PRIVATE);
            sp_editor=sp.edit();

            sp_editor.putString("Name",eName.getText().toString());
            sp_editor.commit();
            Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
        });


        btnView.setOnClickListener(v -> {
            if (sp.contains("Name")){
                txtName.setText(sp.getString("Name",""));
            }
            else {
                Toast.makeText(MainActivity.this, "No data", Toast.LENGTH_SHORT).show();
            }
        });


        btnDelete.setOnClickListener(v -> {

            if (sp.contains("Name")){
                sp_editor.remove("Name");
                txtName.setText("");
                sp_editor.commit();
                Toast.makeText(MainActivity.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "No data exits", Toast.LENGTH_SHORT).show();
            }
        });
    }
}