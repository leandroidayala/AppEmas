package com.example.leo_i019213.appemas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leo_i019213.appemas.Data.DataUser;
import com.example.leo_i019213.appemas.Models.User;
import com.example.leo_i019213.appemas.Views.ContainerActivity;
import com.example.leo_i019213.appemas.Views.CreateAccountActivity;

import java.util.List;

;

public class LoginActivity extends AppCompatActivity {

    DataUser dataUser;
    Button login;
    EditText usernameLogin,passwordLogin;
    public static User userLogin;
    List<User> userList;
    String[] findUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.buttonLogin);
        usernameLogin = (EditText) findViewById(R .id.id_login_username);
        passwordLogin = (EditText) findViewById(R.id.id_login_password);
        dataUser = new DataUser(this);
        dataUser.open();

        userLogin = dataUser.checkStatusLogin();
        if(userLogin == null ){

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(usernameLogin.getText().toString().equals("")||passwordLogin.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(), getString(R.string.txt_field_vaccant), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        findUser = new String[2];
                        findUser = dataUser.findUser(usernameLogin.getText().toString(),passwordLogin.getText().toString());
                        if (findUser[0].equals((usernameLogin.getText().toString())) && findUser[1].equals((passwordLogin.getText().toString())) ){
                            dataUser.statusOn(usernameLogin.getText().toString(),passwordLogin.getText().toString());
                            Toast.makeText(getApplicationContext(), getString(R.string.txt_validation_login), Toast.LENGTH_SHORT).show();
                            goCreateContainer();
                        }else
                        {Toast.makeText(getApplicationContext(), getString(R.string.txt_no_validation_login) , Toast.LENGTH_SHORT).show();}

                    }
                }
            });

        }else {
            goCreateContainer();
        }

    }

    public void onShowAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goCreateContainer(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }


}