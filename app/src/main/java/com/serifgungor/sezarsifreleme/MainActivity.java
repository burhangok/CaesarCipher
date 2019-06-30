package com.serifgungor.sezarsifreleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText metinET;
    Button sifreleBTN;
    TextView sifreliMetinTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        init();

        sifreleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(metinET.getText().toString().equals(""))
                {
                    metinET.setError("Please write something...");
                }
                else
                {
                    String metin = metinET.getText().toString();
                    metin = metin.trim();
                    String sifrelimetin = encrypt(metin,3).toString();
                    sifreliMetinTV.setText( sifrelimetin);

                }
            }
        });



    }

    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    private void init() {

        sifreleBTN = findViewById(R.id.sifreleBTN);
        sifreliMetinTV = findViewById(R.id.sifreliMetinTV);
        metinET = findViewById(R.id.metinET);
    }
}
