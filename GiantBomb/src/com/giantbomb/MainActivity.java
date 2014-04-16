package com.giantbomb;
 
import com.giantbomb.adapter.TabsPagerAdapter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
 
public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	
	private String[] tabs = { "Movies", "Games", "Reviews" };// Tab titles

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	
	
	
	/*private EditText editText;
	private Button button;
	TabHost tHost;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIU();
        setTAB();
        //Intent intent = new Intent(MainActivity.this,TabActivity.class);
        //startActivity(intent);
        
    }
    
    public void setIU(){
        editText = (EditText) findViewById(R.id.EditTextSearch);
        button = (Button) findViewById(R.id.ButtonEnvoyer);

        //on applique un écouteur d'événement au clique sur le bouton
        button.setOnClickListener(new OnClickListener() {
         		public void onClick(View arg0) {
    				String s = editText.getText().toString();
    				Intent intent = new Intent(MainActivity.this,
    						Search_result.class);
    				intent.putExtra("keywords", s);
    				startActivity(intent);
    			}
    		});
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
                else{    
                	//If current tab is apple 
                    if(GamesFragment==null){
                        // Create AppleFragment and adding to fragmenttransaction 
                        ft.add(R.id.realtabcontent,new GamesFragment(), "Games");
                     }else{
                        // Bring to the front, if already exists in the fragmenttransaction 
                        ft.attach(GamesFragment);
                    }
                }
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
    }*/
}