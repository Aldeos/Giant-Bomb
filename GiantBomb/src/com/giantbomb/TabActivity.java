package com.giantbomb;
 

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;

 
public class TabActivity extends FragmentActivity{
	TabHost tHost;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        setTAB();
 
    }
   
    protected void setTAB() {
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

        // Setting tabchangelistener for the tab 
        tHost.setOnTabChangedListener(tabChangeListener);
 
        // Defining tab builder for News tab 
        TabHost.TabSpec tSpecNews = tHost.newTabSpec("News");
        tSpecNews.setIndicator("News",getResources().getDrawable(R.drawable.news));
        tSpecNews.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecNews);

        // Defining tab builder for Games tab 
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