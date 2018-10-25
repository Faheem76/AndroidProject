package com.example.faheemfcm.finalproject;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Fragment;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



ImageButton im,game,world;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:



                  /* HomeFragment homeFragment = new HomeFragment();
                    FragmentManager manager4 = getFragmentManager();
                    manager4.beginTransaction().replace(R.id.contentLayout,homeFragment,homeFragment.getTag()).commit();*/

                 Intent intent=new Intent(MainActivity.this,MainActivity.class);
                  startActivity(intent);
                    return true;

                case R.id.navigation_facebook:
                   FacebookFragment facebookFragment = new FacebookFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentLayout,facebookFragment,facebookFragment.getTag()).commit();
                    return true;

                case R.id.navigation_instagram:

                    InstagramFragment instagramFragmentt = new InstagramFragment();
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.contentLayout,instagramFragmentt,instagramFragmentt.getTag()).commit();
                    return true;

                case R.id.navigation_youtube:
                   YoutubeFragment youtubeFragment = new YoutubeFragment();
                    FragmentManager manager1 = getFragmentManager();
                    manager1.beginTransaction().replace(R.id.contentLayout,youtubeFragment,youtubeFragment.getTag()).commit();
                    return true;

                case R.id.navigation_browser:


                    BrowserFragment browserFragment = new BrowserFragment();
                    FragmentManager manager3 = getFragmentManager();
                    manager3.beginTransaction().replace(R.id.contentLayout,browserFragment,browserFragment.getTag()).commit();
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im=(ImageButton)findViewById(R.id.Site);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Imp_site.class);
                startActivity(intent);
            }
        });

        game=(ImageButton)findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Games.class);
                startActivity(intent);
            }
        });
      /*  world=(ImageButton)findViewById(R.id.world);
        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WolrdWideSite.class);
                startActivity(intent);
            }
        });*/



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Welcome to Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Share:
                Share();
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

    @Override
    public void onBackPressed() {
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to do this?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        android.support.v7.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void Share(){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT,"This Is my new App");
        String appLink ="";
        share.putExtra(Intent.EXTRA_TEXT,"Try my new app"+appLink);
        startActivity(Intent.createChooser(share,"Share Via"));
    }


}

