package it.its.diceplayerdatatransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiceActivity extends AppCompatActivity {
    DiceLogic diceLogic = new DiceLogic();
    TextView textDicePlayer;
    TextView textDiceAndroid;
    TextView textPointsPlayer;
    TextView textPointsAndroid;
    TextView resultText;
    Button playButton;
    Intent savePlayIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        textDicePlayer = findViewById(R.id.textDicePlayer);
        textDiceAndroid = findViewById(R.id.textDiceAndroid);
        textPointsPlayer = findViewById(R.id.textPointsPlayer);
        textPointsAndroid = findViewById(R.id.textPointsAndroid);
        resultText = findViewById(R.id.resultText);
        playButton = findViewById(R.id.playButton);
        savePlayIntent = new Intent();
    }

    public void onClickPlay(View view) {
        if (diceLogic.getCountPlayer() < 5 && diceLogic.getCountAndroid() < 5) {
            byte resDiceGame = diceLogic.getRandom();
            textDicePlayer.setText(diceLogic.getDicePlayer().toString());
            textDiceAndroid.setText(diceLogic.getDiceAndroid().toString());
            if (diceLogic.getCountPlayer() == 5 || diceLogic.getCountAndroid() == 5) {
                if (diceLogic.getCountPlayer() == 5) {
                    resultText.setText("Player won!");
                } else {
                    resultText.setText("CPU won");
                }
                playButton.setText("Save results");
                savePlayIntent.putExtra(KeyConstants.COUNT_PLAYER_KEY, diceLogic.getCountPlayer());
                savePlayIntent.putExtra(KeyConstants.COUNT_ANDROID_KEY, diceLogic.getCountAndroid());

            } else {
                if (resDiceGame == 0) {
                    resultText.setText("Player +1");
                } else if (resDiceGame == 1) {
                    resultText.setText("CPU +1");
                } else {
                    resultText.setText("Draw");
                }
            }
            textPointsPlayer.setText(diceLogic.getCountPlayer().toString());
            textPointsAndroid.setText(diceLogic.getCountAndroid().toString());
        } else {
            setResult(0,savePlayIntent);
            finish();
        }
    }

    public void onClickGoBack(View view) {
        setResult(1);
        finish();
    }
}