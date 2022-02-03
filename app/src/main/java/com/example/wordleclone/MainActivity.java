package com.example.wordleclone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wordleclone.databinding.ActivityMainBinding;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private int currentPosition = 0;
    private int lettersRegistered = 0;
    private HashMap<Button, String> buttons;
    private final ArrayList<String> mWords = new ArrayList<>();
    private final StringBuilder inputWord = new StringBuilder();
    private String targetWord;

    private void initiateButtons() {
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

    private void setButtonsOnClick() {
        for (Button button : buttons.keySet()) {
            button.setOnClickListener(this);
        }
        binding.buttonEnter.setOnClickListener(this);
        binding.buttonDelete.setOnClickListener(this);
    }

    private void getWords() {
        InputStream is = (this.getResources().openRawResource(R.raw.word_list));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                mWords.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getRandomWord() {
        Random rnd = new Random();
        return mWords.get(rnd.nextInt(mWords.size() + 1));

    }

    private TextView getTextViewFromPosition(int position) {
        TextView current_letter;
        switch (position) {
            case 0:
                current_letter = binding.textViewRow0Col0;
                break;
            case 1:
                current_letter = binding.textViewRow0Col1;
                break;
            case 2:
                current_letter = binding.textViewRow0Col2;
                break;
            case 3:
                current_letter = binding.textViewRow0Col3;
                break;
            case 4:
                current_letter = binding.textViewRow0Col4;
                break;
            case 5:
                current_letter = binding.textViewRow0Col5;
                break;
            case 6:
                current_letter = binding.textViewRow1Col0;
                break;
            case 7:
                current_letter = binding.textViewRow1Col1;
                break;
            case 8:
                current_letter = binding.textViewRow1Col2;
                break;
            case 9:
                current_letter = binding.textViewRow1Col3;
                break;
            case 10:
                current_letter = binding.textViewRow1Col4;
                break;
            case 11:
                current_letter = binding.textViewRow1Col5;
                break;
            case 12:
                current_letter = binding.textViewRow2Col0;
                break;
            case 13:
                current_letter = binding.textViewRow2Col1;
                break;
            case 14:
                current_letter = binding.textViewRow2Col2;
                break;
            case 15:
                current_letter = binding.textViewRow2Col3;
                break;
            case 16:
                current_letter = binding.textViewRow2Col4;
                break;
            case 17:
                current_letter = binding.textViewRow2Col5;
                break;
            case 18:
                current_letter = binding.textViewRow3Col0;
                break;
            case 19:
                current_letter = binding.textViewRow3Col1;
                break;
            case 20:
                current_letter = binding.textViewRow3Col2;
                break;
            case 21:
                current_letter = binding.textViewRow3Col3;
                break;
            case 22:
                current_letter = binding.textViewRow3Col4;
                break;
            case 23:
                current_letter = binding.textViewRow3Col5;
                break;
            case 24:
                current_letter = binding.textViewRow4Col0;
                break;
            case 25:
                current_letter = binding.textViewRow4Col1;
                break;
            case 26:
                current_letter = binding.textViewRow4Col2;
                break;
            case 27:
                current_letter = binding.textViewRow4Col3;
                break;
            case 28:
                current_letter = binding.textViewRow4Col4;
                break;
            case 29:
                current_letter = binding.textViewRow4Col5;
                break;
            case 30:
                current_letter = binding.textViewRow5Col0;
                break;
            case 31:
                current_letter = binding.textViewRow5Col1;
                break;
            case 32:
                current_letter = binding.textViewRow5Col2;
                break;
            case 33:
                current_letter = binding.textViewRow5Col3;
                break;
            case 34:
                current_letter = binding.textViewRow5Col4;
                break;
            default:
                current_letter = binding.textViewRow5Col5;
                break;
        }
        return current_letter;
    }
    private Button getButtonFromLetter(String letter){
        for (Map.Entry<Button, String> entry : buttons.entrySet()){
            if (entry.getValue().toLowerCase(Locale.ROOT).equals(letter)){
                return entry.getKey();
            }
        }
    return null;
    }
    private void validateWord(int position){
        int j = 0;
        for (int i  = position -6; i < position; i++){
            TextView letterTextView = getTextViewFromPosition(i);
            String letter = letterTextView.getText().toString().toLowerCase(Locale.ROOT);
            int orange = getResources().getColor(R.color.orange);
            int grey = getResources().getColor(R.color.dark_theme_btn_bg);
            int green = getResources().getColor(R.color.green);
            int black = getResources().getColor(R.color.dark_theme_bg);
            if (targetWord.contains(letter)){
                letterTextView.setBackgroundColor(orange);
                getButtonFromLetter(letter).setBackgroundColor(orange);
            }
            else{
                letterTextView.setBackgroundColor(getResources().getColor(R.color.dark_theme_btn_bg));
                getButtonFromLetter(letter).setBackgroundColor(grey);
                getButtonFromLetter(letter).setBackgroundColor(black);
            }
            if (Character.toString(targetWord.charAt(j)).equals(letterTextView.getText().toString().toLowerCase(Locale.ROOT))){
                letterTextView.setBackgroundColor(green);
                getButtonFromLetter(letter).setBackgroundColor(green);
            }
            j+=1;
        }

    }

    private boolean isWordInWordList(String word){
        return mWords.contains(word.toLowerCase(Locale.ROOT));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initiateButtons();
        setButtonsOnClick();
        getWords();
        targetWord = getRandomWord();

    }

    @Override
    public void onClick(View view) {
        TextView current_letter = getTextViewFromPosition(currentPosition);
        // allow user to input letters if less than 6 letters are present in current row
        if (lettersRegistered < 6) {
            for (Button button : buttons.keySet()) {
                if (view.getId() == button.getId()) {
                    current_letter.setText(buttons.get(button));
                    currentPosition += 1;
                    lettersRegistered += 1;
                    inputWord.append(current_letter.getText().toString());
                    break;
                }
            }
        }
        // allow user to enter word if exactly 6 letters are present in current row

        if (lettersRegistered == 6) {
            if (view.getId() == binding.buttonEnter.getId()) {
                if (isWordInWordList(inputWord.toString().toLowerCase(Locale.ROOT))){
                    validateWord(currentPosition);
                    lettersRegistered = 0;
                    inputWord.setLength(0);
                }
                else{
                    Toast.makeText(this,
                            "Word is not in word list",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
        // allow user to delete letters if more than one letter in current row is present
        if (lettersRegistered != 0) {
            if (view.getId() == binding.buttonDelete.getId()) {
                TextView previousLetter = getTextViewFromPosition(currentPosition - 1);
                previousLetter.setText("");
                currentPosition -= 1;
                lettersRegistered -= 1;
                inputWord.deleteCharAt(inputWord.length()-1);
            }
        }

    }
}