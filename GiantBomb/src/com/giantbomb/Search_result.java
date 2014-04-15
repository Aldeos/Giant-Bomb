package com.giantbomb;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Search_result extends Activity {
	TextView key;
	private List<Map<String, String>> SearchData = new ArrayList<Map<String, String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);
		Intent intent = this.getIntent();
		int action = intent.getIntExtra("catID", 0);
		if (action != 0) {
			retrieveCatData(action);
		} else {
			retrieveSearchData();
		}
		setUI();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_search_result, menu);
		return true;
	}

	protected void setUI() {
		key = (TextView) this.findViewById(R.id.keyword);
		if (SearchData.isEmpty()) {
			key.setText("Search result for " + '"' + getSearchKey() + '"'
					+ " is empty");
		} else {

			for (int i = 0; i < SearchData.size() && i < 10; i++) {
				String imageID = "sec" + i;
				ImageView image = (ImageView) findView(imageID);
				String nameID = "sec_name" + i;
				TextView name = (TextView) findView(nameID);
				loadImage(image, i);
				name.setText(SearchData.get(i).get("RecipeName"));
				String ratingID = "sec_ratting" + i;
				TextView rating = (TextView) findView(ratingID);
				rating.setText(SearchData.get(i).get("AvgRating"));
				String prepID = "sec_prep" + i;
				TextView prep = (TextView) findView(prepID);
				prep.setText(SearchData.get(i).get("PrepTime") + " mins");

			}
		}
		key.setText("Search result for " + '"' + getSearchKey() + '"');
	}

	protected View findView(String name) {
		// Log.i("result---->", name);
		int resID = getResources().getIdentifier(name, "id",
				"com.giantbomb");
		View view = this.findViewById(resID);
		return view;
	}

	protected void retrieveCatData(int action) {
		/*String NAMESPACE = "http://www.kraftfoods.com/ws/";
		String METHOD_NAME = "GetRecipesByCategory";
		String URL = "http://www.kraftfoods.com/ws/RecipeWS.asmx?WSDL";
		String SOAP_ACTION = "http://www.kraftfoods.com/ws/GetRecipesByCategory";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("iCatID", action);
		request.addProperty("iSubCatID", 0);
		request.addProperty("bIsRecipePhotoRequired", true);
		request.addProperty("bIsReadyIn30Mins", true);
		request.addProperty("bOnlyHealthyRecipes", false);
		request.addProperty("iBrandID", 1);
		request.addProperty("iLangID", 1);
		request.addProperty("iStartRow", 1);
		request.addProperty("iEndRow", 10);
		request.addProperty("bIncludeExtraInformation", false);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(URL);
		httpTransport.debug = true;
		try {
			httpTransport.call(SOAP_ACTION, envelope);
			SoapObject result = (SoapObject) envelope.getResponse();
			parseSummuryInfo((SoapObject) result.getProperty(2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This sends a soap
		*/
	}

	protected void retrieveSearchData() {
		/*String NAMESPACE = "http://www.kraftfoods.com/ws/";
		String METHOD_NAME = "GetRecipesByKeywords";
		String URL = "http://www.kraftfoods.com/ws/RecipeWS.asmx?WSDL";
		String SOAP_ACTION = "http://www.kraftfoods.com/ws/GetRecipesByKeywords";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		String[] keywords = getSearchKey().split("\\s+");
		for (int i = 0; i < keywords.length; i++) {
			String searchKey = "sKeyword" + Integer.toString(i + 1);
			request.addProperty(searchKey, keywords[i]);
			// Log.i("result---->", searchKey);
		}

		request.addProperty("bIsRecipePhotoRequired", true);
		request.addProperty("bIsReadyIn30Mins", getTiming());
		request.addProperty("iBrandID", 1);
		request.addProperty("iLangID", 1);
		request.addProperty("iStartRow", 1);
		request.addProperty("iEndRow", 10);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(URL);
		httpTransport.debug = true;
		try {
			httpTransport.call(SOAP_ACTION, envelope);
			SoapObject result = (SoapObject) envelope.getResponse();
			parseSummuryInfo((SoapObject) result.getProperty(2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This sends a soap
		*/
	}

	/*protected void parseSummuryInfo(SoapObject response) {
		if (response.getPropertyCount() == 0) {
			Log.i("result---->", "no content");
		}
		for (int i = 0; i < response.getPropertyCount(); i++) {
			Map<String, String> recipe = new HashMap<String, String>();
			recipe = parseRecipeInfo((SoapObject) response.getProperty(i));
			SearchData.add(recipe);
		}
	}

	protected Map<String, String> parseRecipeInfo(SoapObject summary) {
		Map<String, String> recipe = new HashMap<String, String>();
		for (int i = 0; i < summary.getPropertyCount(); i++) {
			switch (i) {
			case 0:
				recipe.put("RecipeType", summary.getProperty(i).toString());
				break;
			case 1:
				recipe.put("LanguageID", summary.getProperty(i).toString());
				break;
			case 2:
				recipe.put("WebPageName", summary.getProperty(i).toString());
				break;
			case 3:
				recipe.put("RecipeID", summary.getProperty(i).toString());
				break;
			case 4:
				recipe.put("RecipeName", summary.getProperty(i).toString());
				break;
			case 5:
				recipe.put("PrepTime", summary.getProperty(i).toString());
				break;
			case 6:
				recipe.put("TotalTime", summary.getProperty(i).toString());
				break;
			case 7:
				recipe.put("NumberOfServings", summary.getProperty(i)
						.toString());
				break;
			case 8:
				recipe.put("NumberOfIngredients", summary.getProperty(i)
						.toString());
				break;
			case 9:
				recipe.put("AvgRating", summary.getProperty(i).toString());
				break;
			case 10:
				recipe.put("NumberOfRatings", summary.getProperty(i).toString());
				break;
			case 11:
				recipe.put("IsHealthy", summary.getProperty(i).toString());
				break;
			case 12:
				recipe.put("PhotoURL", summary.getProperty(i).toString());
				break;
			case 13:
				recipe.put("RecipeClassifications", summary.getProperty(i)
						.toString());
				break;
			case 14:
				recipe.put("RecipeCategories", summary.getProperty(i)
						.toString());
				break;
			default:
				break;
			}
		}
		return recipe;
	}
*/
	protected void loadImage(ImageView image, int i) {
	/*	try {
			// Log.i("result---->", SearchData.get(i).get("PhotoURL"));
			IconFactory iconFactory = new IconFactory(SearchData.get(i).get(
					"PhotoURL"));
			InputStream inputStream = iconFactory.getImageInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			image.setImageBitmap(bitmap);
			setOnClick(image, i);
		} catch (IOException e) {
			Log.i("result---->", "exception");
		}
	*/}

	protected void setOnClick(View view, int i) {
		final int order = i;
		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String recipeID = SearchData.get(order).get("RecipeID");
				// Log.i("result---->", recipeID);
				Intent intent = new Intent(Search_result.this, ViewData.class);
				intent.putExtra("ID", recipeID);
				intent.putExtra("type", 1);
				startActivity(intent);
			}
		});
	}

	protected String getSearchKey() {
		Intent intent = getIntent();
		String keyWords = intent.getStringExtra("keywords");
		return keyWords;
	}

	protected boolean getTiming() {
		Intent intent = getIntent();
		boolean time = intent.getBooleanExtra("time", true);
		return time;
	}
}
