package com.giantbomb.adapter;

import com.giantbomb.GamesFragment;
import com.giantbomb.MoviesFragment;
import com.giantbomb.ReviewsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			// Movies fragment activity
			return new MoviesFragment();
		case 1:
			// Games fragment activity
			return new GamesFragment();
		case 2:
			// Movies fragment activity
			return new ReviewsFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
