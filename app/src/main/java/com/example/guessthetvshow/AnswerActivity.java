package com.example.guessthetvshow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class AnswerActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView tv;
    private TextView firstBlankTv;
    private TextView secondBlankTv;
    private TextView thirdBlankTv;
    private TextView fourthBlankTv;
    private TextView fifthBlankTv;
    private TextView sixthBlankTv;
    private TextView seventhBlankTv;
    String nameOfShow;
    int showNameSize;
    ArrayList<String> movieArray;
    private int numCharacters;
    HashMap<Integer, TextView> positions;
    int nextEmptySpace=1;
    private TextView current_tv;
    private String checkerString="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        mImageView = findViewById(R.id.imageView1);
        firstBlankTv = findViewById(R.id.first_blank);
        secondBlankTv= findViewById(R.id.second_blank);
        thirdBlankTv = findViewById(R.id.third_blank);
        fourthBlankTv = findViewById(R.id.fourth_blank);
        fifthBlankTv = findViewById(R.id.fifth_blank);
        sixthBlankTv = findViewById(R.id.sixth_blank);
        seventhBlankTv = findViewById(R.id.seventh_blank);

        nameOfShow="";
        movieArray = new ArrayList<>();
        positions = new HashMap<>();

        positions.put(1,firstBlankTv);
        positions.put(2,secondBlankTv);
        positions.put(3,thirdBlankTv);
        positions.put(4,fourthBlankTv);
        positions.put(5,fifthBlankTv);
        positions.put(6,sixthBlankTv);
        positions.put(7,seventhBlankTv);

        //Intent sendingIntent = getIntent();
        //int id = sendingIntent.getIntExtra("id",0);
        //mImageView.setImageResource(id);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("resId");
            mImageView.setImageResource(resId);

            //set the show the name
            switch(resId){
                case R.drawable.breaking_bad:
                    nameOfShow="Breaking Bad";
                    break;
                case R.drawable.fresh_prince:
                    nameOfShow="Fresh Prince";
                    break;
                case R.drawable.friends:
                    nameOfShow="Friends";
                    //numCharacters=
                default:
                    break;
            }

        }
        /*
        tv = findViewById(R.id.textView1);

        String stringID = getResources().getResourceName(id);
        tv.setText(stringID);
*/
        //Glide.with(this).load(getIntent().getIntExtra("image",0)).into(mImageView);
        //Glide.with(mContext).load(currentSport.getBannerImage()).into(mSportsImage);
        //mImageView.setImageResource(id);
        // imageView.setImageResource(getIntent().getIntExtra(MainActivity.IMAGE_RES_ID_KEY, 0));
    }

    public void fillIn(View view) {
        int resId = view.getId();
        //String stringID = getResources().getResourceName(resId);
        //int index = stringID.indexOf("/");
        //stringID.substring(index+1);

        //check for next empty space

        switch (resId){
            case (R.id.f_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("F");
                //checkerString.concat("F");
                nextEmptySpace++;
                break;

            case (R.id.r_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("R");
                nextEmptySpace++;
                break;

            case (R.id.i_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("I");
                nextEmptySpace++;
                break;

            case (R.id.e_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("E");
                nextEmptySpace++;
                break;

            case (R.id.n_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("N");
                nextEmptySpace++;
                break;

            case (R.id.d_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("D");
                nextEmptySpace++;
                break;

            case (R.id.s_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("S");
                nextEmptySpace++;
                showAlertDialog();
                break;

            case (R.id.z_button):
                current_tv = positions.get(nextEmptySpace);
                current_tv.setText("Z");
                nextEmptySpace++;
                break;
            default:

                break;
        }

        //check if the filled in movie name is complete or is what was sent
        //TODO  the above



    }

    private void showAlertDialog(){
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(AnswerActivity.this);
        // Set the dialog title and message.
        myAlertBuilder.setTitle("Correct!");
        myAlertBuilder.setMessage("You are doing great so far!");

        // Add the dialog buttons.
        myAlertBuilder.setPositiveButton(R.string.ok_button, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                        Toast.makeText(getApplicationContext(), "Pressed OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton(R.string.cancel_button, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), "Pressed Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        // Create and show the AlertDialog.
        myAlertBuilder.show();

    }

}
