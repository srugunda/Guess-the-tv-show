package com.example.guessthetvshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
    }

    public void goToAnswerActivity(View view) {

        //String stringID = getResources().getResourceName(view.getId());
        //Log.d("ID of image is", stringID);
        Intent intent = new Intent(ImagesActivity.this, AnswerActivity.class);
        intent.putExtra("id", view.getId());
        //intent.putExtra("image", view.getId());
        startActivity(intent);
    }

    public void goToBreakingBadAnswer(View view) {

        Intent intent = new Intent(ImagesActivity.this, AnswerActivity.class);
        intent.putExtra("resId", R.drawable.breaking_bad);
        startActivity(intent);

    }

    public void goToAnswer(View view) {
        Intent answerIntent = new Intent(ImagesActivity.this, AnswerActivity.class);

        switch(view.getId()){
            case R.id.fresh_prince:
                answerIntent.putExtra("resId",R.drawable.fresh_prince);
                startActivity(answerIntent);
                break;

            case R.id.friends:
                answerIntent.putExtra("resId",R.drawable.friends);
                startActivity(answerIntent);
                break;
            default:

                break;
        }
    }
}
