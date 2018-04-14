package br.com.allize.allize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.allize.allize.adapters.SliderAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager sliderViewPage;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private SliderAdapter sliderAdapter;
    private Button btnPrev;
    private Button btnNext;
    private Intent intentLogin;
    private int pageCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderViewPage = findViewById(R.id.viewPageSlide);
        dotsLayout = findViewById(R.id.linearLayoutDots);
        btnNext = findViewById(R.id.btnnext);
        btnPrev = findViewById(R.id.btnprev);

        sliderAdapter = new SliderAdapter(this);
        sliderViewPage.setAdapter(sliderAdapter);


        btnPrev.setVisibility(View.INVISIBLE);

        sliderViewPage.addOnPageChangeListener(viewPageListener);

        intentLogin = new Intent(this, LoginActivity.class);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textButton = btnNext.getText().toString().toLowerCase();
                if (textButton.equals("acessar")) {
                    startActivity(intentLogin);

                }
                sliderViewPage.setCurrentItem(pageCurrent + 1);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderViewPage.setCurrentItem(pageCurrent - 1);
            }
        });

    }


    ViewPager.OnPageChangeListener viewPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            pageCurrent = position;
            if (pageCurrent == 0) {
                btnNext.setEnabled(true);
                btnPrev.setEnabled(false);
                btnPrev.setVisibility(View.INVISIBLE);
                btnNext.setText("Prox.");
                btnPrev.setText("");

            } else if (position == 2) {
                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);
                btnNext.setText("Acessar");
                btnPrev.setText("Ant.");
            } else {
                btnNext.setEnabled(true);
                btnPrev.setEnabled(true);
                btnPrev.setVisibility(View.VISIBLE);
                btnNext.setText("Prox.");
                btnPrev.setText("Ant.");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
