package com.example.bkt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText edtUsername;
    EditText edtPassword;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        sharedPreferences = getSharedPreferences("datalogin", MODE_PRIVATE);
        edtUsername.setText(sharedPreferences.getString("taikhoan",""));
        edtPassword.setText(sharedPreferences.getString("matkhau",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked",false));
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.equals("admin") && password.equals("admin")){
                    openActivity2();
                    Toast.makeText(MainActivity.this, "ĐĂNG NHẬP THÀNH CÔNG", Toast.LENGTH_SHORT).show();
                    if (cbRemember.isChecked()) {

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();


                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");

                        editor.remove("checked");

                        editor.commit();

                    }
                } else
                    Toast.makeText(MainActivity.this, "ĐĂNG NHẬP THẤT BẠI", Toast.LENGTH_SHORT).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

    }
    private void AnhXa(){
        btnlogin = (Button) findViewById(R.id.loginbtn);
        edtPassword = (EditText) findViewById(R.id.password);
        edtUsername = (EditText) findViewById(R.id.username);
        cbRemember = (CheckBox) findViewById(R.id.checkBox);
        signup = (TextView) findViewById(R.id.signup);


    }
    public void openActivity2() {
        Intent intent = new Intent(this, Page.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}