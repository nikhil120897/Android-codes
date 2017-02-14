package carquiz.bmpl.com.carquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView text;
    Button bt,sub;
    RadioGroup rdgrp;
    RadioButton rb1,rb2,rb3,rb4,bt1;
    String ques[];
    int i10count=0,ritzcount=0,kwidcount=0,balenocount=0,i=0;
    void increment(){
        if(bt1.getText().equals("Grand i10"))
        {
            i10count++;
        }
        else if(bt1.getText().equals("Ritz"))
        {
            ritzcount++;
        }
        else if(bt1.getText().equals("Baleno"))
        {
            balenocount++;
        }
        else if(bt1.getText().equals("Kwid"))
        {
            kwidcount++;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ques=new String[]{"What is your favourite car on the basis of ENGINE","What is your favourite car on the basis of BODY DESIGN","What is your favourite car on the basis of ACCELARATION","What is your favourite car on the basis of COMFORT","What is your favourite car on the basis of DAMAGE CONTROL"};
        rb1=(RadioButton)findViewById(R.id.i10);
        rb2=(RadioButton)findViewById(R.id.ritz);
        rb3=(RadioButton)findViewById(R.id.baleno);
        rb4=(RadioButton)findViewById(R.id.kwid);
        text=(TextView)findViewById(R.id.textView);
        rdgrp=(RadioGroup)findViewById(R.id.rdg);
        bt=(Button)findViewById(R.id.next);
        sub=(Button)findViewById(R.id.submit);
        sub.setVisibility(View.INVISIBLE);

        text.setText(ques[0]);

        rdgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                bt1=(RadioButton)findViewById(i);


            }
        });


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               increment();
                i++;

                text.setText(ques[i]);

                rdgrp.clearCheck();

                if(i==4) {


                    bt.setVisibility(View.INVISIBLE);
                    sub.setVisibility(View.VISIBLE);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);

                if(i10count>=ritzcount && i10count>=kwidcount && i10count>=balenocount ) {
                    intent.putExtra("i", "GRAND i10");
                    intent.putExtra("j", i10count);
                }
                else if(ritzcount>=i10count && ritzcount>=balenocount && ritzcount>=kwidcount) {
                    intent.putExtra("i", "RITZ");
                    intent.putExtra("j", ritzcount);
                }

                else if(balenocount>=i10count && ritzcount<=balenocount && balenocount>=kwidcount) {
                    intent.putExtra("i", "BALENO");
                    intent.putExtra("j", balenocount);
                }

                else if(kwidcount>=i10count && kwidcount>=balenocount && ritzcount<=kwidcount) {
                    intent.putExtra("i", "KWID");
                    intent.putExtra("j", kwidcount);
                }

                startActivity(intent);
            }
        });

    }
}
