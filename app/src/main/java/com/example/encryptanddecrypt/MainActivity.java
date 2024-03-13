package com.example.encryptanddecrypt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {


    EditText et_msg,et_key;
    Button bt_encrypt, bt_decrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_key = findViewById(R.id.et_key);
        et_msg = findViewById(R.id.et_msg);
        bt_encrypt = findViewById(R.id.bt_Encrypt);
        bt_decrypt = findViewById(R.id.bt_Decrypt);

        bt_encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String encrypt = AESCrypt.encrypt(et_key.getText().toString(),et_msg.getText().toString());
                    et_msg.setText(encrypt);
                } catch (GeneralSecurityException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        bt_decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String decrypt = AESCrypt.decrypt(et_key.getText().toString(),et_msg.getText().toString());
                    et_msg.setText(decrypt);
                } catch (GeneralSecurityException e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }
}