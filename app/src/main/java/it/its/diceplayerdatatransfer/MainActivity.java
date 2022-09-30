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

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        }
    }
}