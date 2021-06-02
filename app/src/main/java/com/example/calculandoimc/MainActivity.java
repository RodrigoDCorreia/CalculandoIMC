package com.example.calculandoimc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    public static final String REPLY_VISIBLE = "REPLY_VISIBLE";
    public static final String REPLY_TEXT = "REPLY_TEXT";
    private TextView mReplyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReplyTextView = findViewById(R.id.resultado);

        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean(REPLY_VISIBLE);
            if (isVisible){
                mReplyTextView.setText(savedInstanceState.getString(REPLY_TEXT));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(REPLY_VISIBLE,true);
        outState.putString(REPLY_TEXT, mReplyTextView.getText().toString());
    }


    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent,TEXT_REQUEST);

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String editPeso = data.getStringExtra(SecondActivity.EXTRA_RESULTADO_IMC);
                String editAltura = data.getStringExtra(SecondActivity.EXTRA_RESULTADO_IMC);
                mReplyTextView.setText(editAltura);
                mReplyTextView.setText(editPeso);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}