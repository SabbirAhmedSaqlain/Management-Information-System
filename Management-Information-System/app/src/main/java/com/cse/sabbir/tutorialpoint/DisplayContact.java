package com.cse.sabbir.tutorialpoint;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class DisplayContact extends Activity {
    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb ;

    TextView ct1 ;
    TextView ct2;
    TextView ct3;
    TextView ct4;
    TextView days;
    TextView exam;
    TextView present;
    TextView roll;



    Double dct1=0.0,droll,add,total,val;

    String cg="0.0",address="-1.0",sid="1117",stest;

    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        roll = (TextView) findViewById(R.id.data_roll);
        ct1 = (TextView) findViewById(R.id.data_ct1);


        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int Value = extras.getInt("id");

            if(Value>0){
                //means this is the view part not the add contact part.
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String sroll = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_ROLL));
                String sct1 = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CT1));




                droll = Double.parseDouble(sroll);
                add = Double.parseDouble(sct1);
             //   val=add;

                if (!rs.isClosed())
                {
                    rs.close();
                }




             //   roll.setText((CharSequence)sroll);
                roll.setFocusable(true);
                roll.setClickable(true);

               // ct1.setText((CharSequence)sct1);
                ct1.setFocusable(true);
                ct1.setClickable(true);


            }
        }


        TextView link = (TextView) findViewById(R.id.WebLink);
        String linkText = "<a href='http://ruet.ac.bd'>Check Price</a>";
        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }








    public void CGPA(View view) {

       // Toast.makeText(getApplicationContext(),"It's ok ", Toast.LENGTH_SHORT).show();
        TextView txt= (TextView)findViewById(R.id.data_cgpa);

       EditText quantity=(EditText)findViewById(R.id.data_roll);
        EditText price=(EditText)findViewById(R.id.data_ct1);
        try {

            Double num1= Double.parseDouble(quantity.getText().toString());
             Double num2= Double.parseDouble(price.getText().toString());
        total=num1*num2;
        total=total+droll;
         txt.setText(total.toString());



       cg = Double.toString(total);
       // cg = Double.toString(t);
        //  cg = Integer.toString(total);
        //  txt.setText(cg);

      //  stest = Integer.toString(id_To_Update);
        //  txt.setText(cg);

        //Toast.makeText(getApplicationContext(), cg, Toast.LENGTH_SHORT).show();



       // cg = Double.toString(cgpa);
      //  txt.setText(cg);

            val=add;
        //   stest = ct1.getText().toString();
         //   val = Double.parseDouble(stest);
           // cg = Double.toString(stest);


            if (mydb.updateContact(id_To_Update, cg, sid)) {
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
            }
       }
        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please at first create an account then fill all text field", Toast.LENGTH_SHORT).show();
            }


    }


    public void run(View view)
    {

        //num2=add;
      // val = Double.parseDouble(address);

       //   val = Double.parseDouble(stest);

       // EditText quantity=(EditText)findViewById(R.id.data_roll);
       // EditText price=(EditText)findViewById(R.id.data_ct1);
       // Double num1= Double.parseDouble(quantity.getText().toString());
      //
       // total=num1*num2;
       // total=total+dct1;
        // txt.setText(total.toString());

      //  cg = Double.toString(total);

        try {
            stest = ct1.getText().toString();
            val = Double.parseDouble(stest);
           // val = add;

            //   Double num2= add;
            // cg = Double.toString(add);

            Toast.makeText(getApplicationContext(), "New ", Toast.LENGTH_SHORT).show();

            if (mydb.updateContact(id_To_Update, cg, sid)) {
                Toast.makeText(getApplicationContext(), "New ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
            }
        }
            catch (NumberFormatException e) {
              //  Toast.makeText(getApplicationContext(), "Error found!! Please check input data!!", Toast.LENGTH_LONG).show();

      //  if(val!=-1.0){
            Bundle extras = getIntent().getExtras();
            if(extras !=null)
            {
          /*  int Value = extras.getInt("id");
            if(Value>0){
                if(mydb.updateContact(id_To_Update,cg, ct1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            else{*/
                if(mydb.insertContact(cg,sid )){
                    Toast.makeText(getApplicationContext(), "New Account Created", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            }

     //   else {
           // Toast.makeText(getApplicationContext(), "Error found!! Please check input data!!", Toast.LENGTH_LONG).show();
      //  }
     //  catch (NumberFormatException e) {
              //  Toast.makeText(getApplicationContext(), "Error found!! Please check input data!!", Toast.LENGTH_LONG).show();
   //  }









    }





    public void back(View v) {
        Intent MainActivityIntent = new Intent(DisplayContact.this,MainActivity.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();

    }

    public void total(View view) {
        // Toast.makeText(getApplicationContext(),"It's ok ", Toast.LENGTH_SHORT).show();
        TextView txt = (TextView) findViewById(R.id.data_cgpa);

        EditText quantity = (EditText) findViewById(R.id.data_roll);
        EditText price = (EditText) findViewById(R.id.data_ct1);
        try {

            Double num1 = Double.parseDouble(quantity.getText().toString());
            Double num2 = Double.parseDouble(price.getText().toString());
            total = num1 * num2;
            total = total + droll;
            txt.setText(total.toString());

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please Fill all text filled", Toast.LENGTH_LONG).show();
        }
    }
}


