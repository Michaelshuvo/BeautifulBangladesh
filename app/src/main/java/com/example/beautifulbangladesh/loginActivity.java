package com.example.beautifulbangladesh;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText fulname,email,pass1,pass2;
    TextView notify;


    int c=0;
    Button signin;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(loginActivity.this,MainActivity.class));
            return;
        }
        fulname=findViewById(R.id.fullname);
        email=findViewById(R.id.loginEmail);
        pass1=findViewById(R.id.loginPass);
        pass2=findViewById(R.id.rewritePass);
        notify=findViewById(R.id.notify);
        signin=findViewById(R.id.signin);
        notify.setOnClickListener(this);
        signin.setOnClickListener(this);
        progressDialog=new ProgressDialog(this);



    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.notify){

            if(c==0) {
                c=1;
                setter();
                fulname.setVisibility(View.VISIBLE);
                pass2.setVisibility(View.VISIBLE);
                notify.setText("Already you have account click Here");
                signin.setText("Create Account");
                Toast.makeText(getApplicationContext(),"at login",Toast.LENGTH_LONG).show();
            }
            else{
                c=0;
                setter();
                fulname.setVisibility(View.GONE);
                pass2.setVisibility(View.GONE);
                notify.setText("If you have no Account Click Here");
                signin.setText("sign in");

            }
        }
        if(view.getId()==R.id.signin){

            if(c==0){
                userLogin();
                //Toast.makeText(getApplicationContext(),"at login",Toast.LENGTH_LONG).show();
            }
            else{
                registerUser();
                //Toast.makeText(getApplicationContext(),"at registration",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void login(){
        c=0;
        setter();
        fulname.setVisibility(View.GONE);
        pass2.setVisibility(View.GONE);
        notify.setText("If you have no Account Click Here");
        signin.setText("sign in");
    }
    private void setter(){
        fulname.setText("");
        email.setText("");
        pass1.setText("");
        pass2.setText("");


    }
    private void registerUser() {
        final String Fullname=fulname.getText().toString().trim();
        final String emails=email.getText().toString().trim();
        final String pass=pass1.getText().toString();
        String passv=pass2.getText().toString();
        if(TextUtils.isEmpty(emails)){
            Toast.makeText(getApplicationContext(),"Please enter your email",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(Fullname)){
            Toast.makeText(getApplicationContext(),"Please enter your fulname",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(),"Please enter your password",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(passv)){
            Toast.makeText(getApplicationContext(),"Please enter your Re-password",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!pass.equals(passv)){
            Toast.makeText(getApplicationContext(),"Don't match your password ",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();




        SharedPrefManager.getInstance(getApplicationContext()).Register(Fullname,emails,pass);
        progressDialog.dismiss();
        login();
        Toast.makeText(
                getApplicationContext(),
               "Registration Completed Successfully",
                Toast.LENGTH_LONG
        ).show();

    }
    private void userLogin(){
        final String emails = email.getText().toString().trim();
        final String password = pass1.getText().toString().trim();
        if(TextUtils.isEmpty(emails)){
            Toast.makeText(getApplicationContext(),"Please enter your email",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please enter your password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Login user...");
        progressDialog.show();


                               if(SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(emails,password)){

                                   progressDialog.dismiss();
                                   startActivity(new Intent(loginActivity.this,MainActivity.class));
                                   progressDialog.dismiss();
                               }
                               else{
                                   progressDialog.dismiss();
                                   Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
                               }




    }

}
