package com.example.faheemfcm.finalproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Imp_site extends AppCompatActivity {

    ImageButton BdECom,Nid,PostCode,git;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_site);

        BdECom=(ImageButton)findViewById(R.id.bdelectioncomission);
   BdECom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Imp_site.this,Bd_E_Comission.class);
                startActivity(intent);
            }
        });
        Nid=(ImageButton)findViewById(R.id.nid);
        Nid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Imp_site.this,Bd_Nid.class);
                startActivity(intent);
            }
        });

        PostCode=(ImageButton)findViewById(R.id.postcode);
        PostCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Imp_site.this,Bd_postcode.class);
                startActivity(intent);
            }
        });
        git=(ImageButton)findViewById(R.id.git);
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Imp_site.this,WolrdWideSite.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.About:
                showAlertDialog();
                break;

            case R.id.Home:
                Intent intent=new Intent(Imp_site.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Welcome to Home", Toast.LENGTH_SHORT).show();
                break;



        }
        return super.onOptionsItemSelected(item);
    }
    private void showAlertDialog() {


        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.abou);
        builder.setTitle("About Developer");











        builder.setMessage("Md. Mahbub Morshed Chowdhury\nB.S.c In Computer Science\nDaffodil International University");
        builder.setCancelable(false);
        builder.setNegativeButton("Cancle",null);

        builder.show();
    }



}