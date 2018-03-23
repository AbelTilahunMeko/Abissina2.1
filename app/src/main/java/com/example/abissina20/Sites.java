package com.example.abissina20;

import android.media.Image;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;



/**
 * Created by BelA on 6/24/2017.
 */

public class Sites extends Fragment {
    private ImageSwitcher switcher;
    private Button forward, backward;
    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {
            R.drawable.image1,
            R.drawable.high2,
            R.drawable.highlands,
            R.drawable.semen1,
            R.drawable.semen2,
            R.drawable.semen3};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = -1;
    int backIndex=6;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.sites,container,false);


        forward = (Button)view.findViewById(R.id.forward);
        backward = (Button)view.findViewById(R.id.back);


        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher




        switcher = (ImageSwitcher)view.findViewById(R.id.imageSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                switcher.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backIndex--;
                String x = String.valueOf(backIndex);
                //Toast.makeText(getActivity(),x, Toast.LENGTH_SHORT).show();
                //  Check If index reaches maximum then reset it
                if (backIndex == count)
                    backIndex = 6;
                    switcher.setImageResource(imageIds[backIndex]); // set the image in ImageSwitcher
                    if(backIndex==0){
                        backIndex=6;
                    }
                }
        });

        return view;
    }


}
