package it.its.diceplayerdatatransfer;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView savedGameText;
    ActivityResultLauncher<Intent> launcher;
    Integer savedCountPlayer, savedCountAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedGameText = findViewById(R.id.savedGameText);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new GetGameResultCallBack());

    }

    public void onClickPlayDice(View view) {
        Intent mainIntent = new Intent(this,DiceActivity.class);
        launcher.launch(mainIntent);
    }

    public class GetGameResultCallBack implements ActivityResultCallback<ActivityResult> {

        @Override
        public void onActivityResult(ActivityResult result) {
            Log.d("Main","VAI CALLBACK");
            if (result.getResultCode() == 0) {
                Intent savedGameData = result.getData();
                savedCountPlayer = savedGameData.getIntExtra(KeyConstants.COUNT_PLAYER_KEY,0);
                savedCountAndroid = savedGameData.getIntExtra(KeyConstants.COUNT_ANDROID_KEY,0);
                Log.d("Main","savedCountPlayer: "+savedCountPlayer);
                Log.d("Main","savedCountAndroid: "+savedCountAndroid);
                savedGameText.setText("Last game result:\n" +
                        "Player: " + savedCountPlayer.toString() + "\nCPU: " + savedCountAndroid.toString());

            }
        }
    }
}