package com.cse.sabbir.tutorialpoint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by ASUS on 04-Jul-16.
 */
public class Farmer extends Activity {

    Integer ab;



    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer);

        Spinner sp=(Spinner)findViewById(R.id.country_spin);
        String[] items={"Paddy","Jute","Potato","Sugarcane"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                R.layout.spinner_layout,R.id.textview, items);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int
                    position, long id) {
                ab=position;

                ViewGroup vg=(ViewGroup)view;

                TextView tv=(TextView)vg.findViewById(R.id.textview);
                Toast.makeText(Farmer.this, tv.getText().toString(),
                        Toast.LENGTH_LONG).cancel();

            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });




        TextView link = (TextView) findViewById(R.id.WebLink);
        String linkText = "<a href='http://ruet.ac.bd'>Check Price</a>";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());

        // 2) How to place email address
     //   TextView email = (TextView) findViewById(R.id.textView2);
       // String emailText = "Send email: <a href=\"mailto:person@stackoverflow.com\">Click Me!</a>";
      //  email.setText(Html.fromHtml(emailText));
       // email.setMovementMethod(LinkMovementMethod.getInstance());



        Button b = (Button)findViewById(R.id.sell_);
         b.setVisibility(View.INVISIBLE);

    }
    final Context context = this;



    public void INFO(View view) {
        TextView txt= (TextView)findViewById(R.id.info);

        if(ab==0) txt.setText("Information About Paddy");
        if(ab==1) txt.setText("Information About Jute");
        if(ab==2) txt.setText("Information About Potato");
        if(ab==3) txt.setText("Information About Sugarcane");

    }





    public void Back(View view) {
        Intent MainActivityIntent = new Intent(Farmer.this,MainActivity.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }
    public void Sell(View view) {
        Intent MainActivityIntent = new Intent(Farmer.this,DisplayContact.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }


}
