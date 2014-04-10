package com.giantbomb;
 
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends FragmentActivity {
	private EditText editText;
	private Button button;
	private String search;
	TabHost tHost;
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        //récupération de l'EditText grâce à  son ID
        editText = (EditText) findViewById(R.id.EditTextSearch);
        
        //récupération du bouton grâce à  son ID
        button = (Button) findViewById(R.id.ButtonEnvoyer);

        //on applique un écouteur d'événement au clique sur le bouton
        button.setOnClickListener(
             new OnClickListener() {
             public void onClick(View v) {
                 //on récupère le texte écrit dans l'EditText
                 search = editText.getText().toString();
                 Toast.makeText(MainActivity.this,  "Resultat : " + search + " !", Toast.LENGTH_LONG).show();
                 //((TextView)findViewById(R.id.EditTextSearch)).setText(search);
             }
         }
         );

        
        tHost = (TabHost) findViewById(android.R.id.tabhost);
        tHost.setup();
 
        // Defining Tab Change Listener event. This is invoked when tab is changed 
        TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
 
            public void onTabChanged(String tabId) {
                android.support.v4.app.FragmentManager fm =   getSupportFragmentManager();
                NewsFragment NewsFragment = (NewsFragment) fm.findFragmentByTag("News");
                GamesFragment GamesFragment = (GamesFragment) fm.findFragmentByTag("Games");
                ReviewsFragment ReviewsFragment = (ReviewsFragment) fm.findFragmentByTag("Reviews");
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
               
                
                // Detaches the Newsfragment if exists 
                if(NewsFragment!=null)
                    ft.detach(NewsFragment);
 
                // Detaches the Gamesfragment if exists 
                if(GamesFragment!=null)
                    ft.detach(GamesFragment);
 
                // Detaches the Reviewsfragment if exists 
                if(ReviewsFragment!=null)
                    ft.detach(ReviewsFragment);
               
                // If current tab is News 
                if(tabId.equalsIgnoreCase("News")){
                    if(NewsFragment==null){
                        //Create NewsFragment and adding to fragment transaction 
                        ft.add(R.id.realtabcontent,new NewsFragment(), "News");
                    }else{
                        // Bring to the front, if already exists in the fragmenttransaction 
                        ft.attach(NewsFragment);
                    }
 
                }
                /*else{    
                	//If current tab is apple 
                    if(GamesFragment==null){
                        // Create AppleFragment and adding to fragmenttransaction 
                        ft.add(R.id.realtabcontent,new GamesFragment(), "Games");
                     }else{
                        // Bring to the front, if already exists in the fragmenttransaction 
                        ft.attach(GamesFragment);
                    }
                }*/
                ft.commit();
            }
        };

        /** Setting tabchangelistener for the tab */
        tHost.setOnTabChangedListener(tabChangeListener);
 
        /** Defining tab builder for News tab */
        TabHost.TabSpec tSpecNews = tHost.newTabSpec("News");
        tSpecNews.setIndicator("News",getResources().getDrawable(R.drawable.news));
        tSpecNews.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecNews);

        /** Defining tab builder for Games tab */
        TabHost.TabSpec tSpecGames = tHost.newTabSpec("Games");
        tSpecGames.setIndicator("Games",getResources().getDrawable(R.drawable.games));
        tSpecGames.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecGames);
        
        // Defining tab builder for Reviews tab 
        TabHost.TabSpec tSpecReviews = tHost.newTabSpec("Reviews");
        tSpecReviews.setIndicator("Reviews",getResources().getDrawable(R.drawable.reviews));
        tSpecReviews.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecReviews);
 
    }
}