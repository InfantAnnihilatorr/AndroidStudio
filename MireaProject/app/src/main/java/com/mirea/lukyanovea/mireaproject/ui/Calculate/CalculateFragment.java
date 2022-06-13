package com.mirea.lukyanovea.mireaproject.ui.Calculate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.lukyanovea.mireaproject.R;


public class CalculateFragment extends Fragment {

    TextView resultText;
    String text1;
    String text2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculate, null);


        resultText = v.findViewById(R.id.Result);
        EditText element1 = v.findViewById(R.id.Num1);
        EditText element2 = v.findViewById(R.id.Num2);
        element1.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    text1 = element1.getText().toString();
                    return true;
                }
                return false;
            }
        });
        element2.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    text2 = element2.getText().toString();
                    return true;
                }
                return false;
            }
        });
        ((Button)v.findViewById(R.id.Sum)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(text1 != null && text2 != null)
                    resultText.setText(Integer.toString(Integer.parseInt(text1) + Integer.parseInt(text2)));
            }
        });
        ((Button)v.findViewById(R.id.Subtraction)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(text1 != null && text2 != null)
                    resultText.setText(Integer.toString(Integer.parseInt(text1) - Integer.parseInt(text2)));
            }
        });
        ((Button)v.findViewById(R.id.Div)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(text1 != null && text2 != null)
                {
                    if(Integer.parseInt(text2) == 0)
                    {
                        resultText.setText("На ноль делить нельзя");
                    }
                    else
                    {
                        resultText.setText(Integer.toString(Integer.parseInt(text1) / Integer.parseInt(text2)));
                    }
                }
            }
        });
        ((Button)v.findViewById(R.id.Multiplication)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(text1 != null && text2 != null)
                    resultText.setText(Integer.toString(Integer.parseInt(text1) * Integer.parseInt(text2)));
            }
        });

        return v;
    }

}
