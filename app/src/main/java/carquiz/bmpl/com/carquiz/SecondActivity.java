package carquiz.bmpl.com.carquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txt;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt=(TextView)findViewById(R.id.textView3);
        image=(ImageView)findViewById(R.id.img);



        Intent intent=getIntent();
        intent.getIntExtra("j",0);
        String s=intent.getStringExtra("i");
       // Log.i(s, s);

        if(s.equals("GRAND i10")){
            txt.setText("U LIKE Grand i10 ");
            image.setImageResource(R.drawable.i10);
        }

        if(s.equals("RITZ")){
            txt.setText("U LIKE Ritz");
            image.setImageResource(R.drawable.ritz);

        }
        if(s.equals("BALENO")){
            txt.setText("U LIKE Baleno");
            image.setImageResource(R.drawable.baleno);

        }
        if(s.equals("KWID")){
            txt.setText("U LIKE Kwid");
            image.setImageResource(R.drawable.kwid);

        }
    }
}
