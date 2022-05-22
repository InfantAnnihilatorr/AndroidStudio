package com.mirea.lukyanovea.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnUri;
    private Button btnSendData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUri = (Button) findViewById(R.id.buttonUri);
        btnSendData = (Button) findViewById(R.id.buttonSendData);

        View.OnClickListener onBtnUri = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address = Uri.parse("https://www.mirea.ru/");
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
            }
        };

        View.OnClickListener onBtnSendData = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "ЛУКЬЯНОВ ЕГОР АЛЕКСЕЕВИЧ");
                startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
            }
        };

        btnUri.setOnClickListener(onBtnUri);
        btnSendData.setOnClickListener(onBtnSendData);
    }
}