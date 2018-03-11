package com.cse.sabbir.tutorialpoint;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
   // DBHelper mydb;


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
        setContentView(R.layout.activity_main);









      //  super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_display_contact);
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


               // Button b = (Button)findViewById(R.id.save);
               // b.setVisibility(View.VISIBLE);

             //   roll.setText((CharSequence)sroll);
                roll.setFocusable(true);
                roll.setClickable(true);

              //  ct1.setText((CharSequence)sct1);
                ct1.setFocusable(true);
                ct1.setClickable(true);


            }
        }






    }

    public void signin(View view) {
        Intent MainActivityIntent = new Intent(MainActivity.this,Farmer.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }


   /* public void add_data(View view) {
        Bundle dataBundle = new Bundle();
        dataBundle.putInt("id", 0);

        Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
        intent.putExtras(dataBundle);

        startActivity(intent);


    }*/

  public void final_result(View view) {
      setContentView(R.layout.result);
     // Intent MainActivityIntent = new Intent(MainActivity.this,Result.class);
    //  startActivity(MainActivityIntent);
    //  super.onBackPressed();



       mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        obj = (ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(getApplicationContext(),DisplayContact.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });



    }




    public void run(View view)
    {

      //  Toast.makeText(getApplicationContext(), "New Account Created", Toast.LENGTH_SHORT).show();
            //  Toast.makeText(getApplicationContext(), "Error found!! Please check input data!!", Toast.LENGTH_LONG).show();

            //  if(val!=-1.0){
         //   Bundle extras = getIntent().getExtras();
          //  if(extras !=null)
           // {
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
                if(mydb.insertContact("0.0","1117" )){
                    Toast.makeText(getApplicationContext(), "New Account Created", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
          //  }

      //  else Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
        }










    public void back(View view) {
        setContentView(R.layout.activity_main);

    }

   public void exit(View v) {
        finish();
        System.exit(0);
   }



}