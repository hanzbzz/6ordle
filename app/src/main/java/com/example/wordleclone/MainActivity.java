package com.example.wordleclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wordleclone.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private int current_position = 1;
    private int current_row = 1;
    private HashMap<Button, String> buttons;
    public void initiateButtons(){
        buttons = new HashMap<Button, String>();
        buttons.put(binding.buttonA, "A");
        buttons.put(binding.buttonB, "B");
        buttons.put(binding.buttonC, "C");
        buttons.put(binding.buttonD, "D");
        buttons.put(binding.buttonE, "E");
        buttons.put(binding.buttonF, "F");
        buttons.put(binding.buttonG, "G");
        buttons.put(binding.buttonH, "H");
        buttons.put(binding.buttonI, "I");
        buttons.put(binding.buttonJ, "J");
        buttons.put(binding.buttonK, "K");
        buttons.put(binding.buttonL, "L");
        buttons.put(binding.buttonM, "M");
        buttons.put(binding.buttonN, "N");
        buttons.put(binding.buttonO, "O");
        buttons.put(binding.buttonP, "P");
        buttons.put(binding.buttonQ, "Q");
        buttons.put(binding.buttonR, "R");
        buttons.put(binding.buttonS, "S");
        buttons.put(binding.buttonT, "T");
        buttons.put(binding.buttonU, "U");
        buttons.put(binding.buttonV, "V");
        buttons.put(binding.buttonW, "W");
        buttons.put(binding.buttonX, "X");
        buttons.put(binding.buttonY, "Y");
        buttons.put(binding.buttonZ, "Z");
    }

    public void setButtonsOnClick(){
        for (Button button : buttons.keySet()){
            button.setOnClickListener(this);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initiateButtons();
        setButtonsOnClick();

    }

    @Override
    public void onClick(View view) {
        TextView current_letter = binding.textViewRow1Col1;
        switch (current_position){
            case 1:
                current_letter = binding.textViewRow1Col1;
                break;
            case 2:
                current_letter = binding.textViewRow1Col2;
                break;
            case 3:
                current_letter = binding.textViewRow1Col3;
                break;
            case 4:
                current_letter = binding.textViewRow1Col4;
                break;
            case 5:
                current_letter = binding.textViewRow1Col5;
                break;
            case 6:
                current_letter = binding.textViewRow1Col6;
                break;
            case 7:
                current_letter = binding.textViewRow2Col1;
                break;
            case 8:
                current_letter = binding.textViewRow2Col2;
                break;
            case 9:
                current_letter = binding.textViewRow2Col3;
                break;
            case 10:
                current_letter = binding.textViewRow2Col4;
                break;
            case 11:
                current_letter = binding.textViewRow2Col5;
                break;
            case 12:
                current_letter = binding.textViewRow2Col6;
                break;
            case 13:
                current_letter = binding.textViewRow3Col1;
                break;
            case 14:
                current_letter = binding.textViewRow3Col2;
                break;
            case 15:
                current_letter = binding.textViewRow3Col3;
                break;
            case 16:
                current_letter = binding.textViewRow3Col4;
                break;
            case 17:
                current_letter = binding.textViewRow3Col5;
                break;
            case 18:
                current_letter = binding.textViewRow3Col6;
                break;
            case 19:
                current_letter = binding.textViewRow4Col1;
                break;
            case 20:
                current_letter = binding.textViewRow4Col2;
                break;
            case 21:
                current_letter = binding.textViewRow4Col3;
                break;
            case 22:
                current_letter = binding.textViewRow4Col4;
                break;
            case 23:
                current_letter = binding.textViewRow4Col5;
                break;
            case 24:
                current_letter = binding.textViewRow4Col6;
                break;
            case 25:
                current_letter = binding.textViewRow5Col1;
                break;
            case 26:
                current_letter = binding.textViewRow5Col2;
                break;
            case 27:
                current_letter = binding.textViewRow5Col3;
                break;
            case 28:
                current_letter = binding.textViewRow5Col4;
                break;
            case 29:
                current_letter = binding.textViewRow5Col5;
                break;
            case 30:
                current_letter = binding.textViewRow5Col6;
                break;
            case 31:
                current_letter = binding.textViewRow6Col1;
                break;
            case 32:
                current_letter = binding.textViewRow6Col2;
                break;
            case 33:
                current_letter = binding.textViewRow6Col3;
                break;
            case 34:
                current_letter = binding.textViewRow6Col4;
                break;
            case 35:
                current_letter = binding.textViewRow6Col5;
                break;
            case 36:
                current_letter = binding.textViewRow6Col6;
                break;
        }
        for (Button button : buttons.keySet()){
            if (view.getId() == button.getId()){
                current_letter.setText(buttons.get(button));
                current_position += 1;
            }
        }


    }
}