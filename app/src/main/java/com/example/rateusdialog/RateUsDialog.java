package com.example.rateusdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class RateUsDialog  extends Dialog {
    private  float userRate=0;
    public RateUsDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_us_dialog_layout);
        final AppCompatButton rateButton=findViewById(R.id.rateNowBtn);
        final AppCompatButton laterBtn=findViewById(R.id.latertn);
        final RatingBar ratingBar=findViewById(R.id.ratingBar);
        final ImageView ratingBarImg=findViewById(R.id.ratingImg);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating<=1){
                    ratingBarImg.setImageResource(R.drawable.ic_launcher_background);//replace with emoi
                }
              else  if(rating<=2){
                    ratingBarImg.setImageResource(R.drawable.ic_launcher_background);//replace with emoi
                }
             else   if(rating<=3){
                    ratingBarImg.setImageResource(R.drawable.ic_launcher_background);//replace with emoi
                }
                if(rating<=4){
                    ratingBarImg.setImageResource(R.drawable.ic_launcher_background);//replace with emoi
                }
                animateImage(ratingBarImg);
                //selected rating
                userRate=rating;
            }
        });
    }
    private void animateImage(ImageView ratingImage)
    {
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImage.startAnimation(scaleAnimation);
    }
}
