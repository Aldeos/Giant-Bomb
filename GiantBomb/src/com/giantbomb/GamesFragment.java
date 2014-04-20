package com.giantbomb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GamesFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//View rootView = inflater.inflate(R.layout.fragment_games, container, false);
		View rootView = inflater.inflate(R.layout.fragment_games, container, false);
		return rootView;
	}
	
	/*assignedtask
	 * activity result
	 * start activity with parametre
	 * 1activity => 1 ecran*/
}
