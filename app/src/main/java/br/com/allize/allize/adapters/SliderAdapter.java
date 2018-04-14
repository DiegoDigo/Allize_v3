package br.com.allize.allize.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.allize.allize.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){
        this.context = context;
    }


    private int[] slider_image = {
            R.drawable.agenda,
            R.drawable.organize,
            R.drawable.persobalize
    };

    private String[] slider_headers = {
            "Agenda",
            "Organize-se",
            "Personalise"
    };


    private String[] slider_subheader = {
            "Já Pensou em ter todos o seus agendamentos na palma da sua mao em so um click ?",
            "Já Pesnsou que conseguiria organizar seu estoque e sua comandas e seu dia com so um toque ?",
            "Personalize o seu dia com o app do Allize , click no finalizar e descubra como !"
    };


    @Override
    public int getCount() {

        return slider_headers.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }




    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Typeface fontHeader = Typeface.createFromAsset(context.getAssets(), "Pacifico-Regular.ttf");
        Typeface fontSubHeader = Typeface.createFromAsset(context.getAssets(), "PoiretOne-Regular.ttf");

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView slideImageView = view.findViewById(R.id.image_slide);
        TextView headerTextView = view.findViewById(R.id.title_slide);
        TextView subHeaderTextView = view.findViewById(R.id.sub_title_slide);

        slideImageView.setImageResource(slider_image[position]);
        headerTextView.setText(slider_headers[position]);
        headerTextView.setTypeface(fontHeader);
        subHeaderTextView.setText(slider_subheader[position]);
        subHeaderTextView.setTypeface(fontSubHeader);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
