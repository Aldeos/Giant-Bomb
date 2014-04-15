package com.giantbomb;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ViewData extends Activity {
	private TextView name, prep0, servNb0, rating;

	private ImageView img;
	private RatingBar ratB;
	private Map<String, Map<String, String>> recipeData = new HashMap<String, Map<String, String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_view_data);
		retrieveData();
		setUI();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_data, menu);
		return true;
	}

	protected void retrieveData() {
		/*String NAMESPACE = "http://www.kraftfoods.com/ws/";
		String METHOD_NAME = "GetRecipeByRecipeID";
		String URL = "http://www.kraftfoods.com/ws/RecipeWS.asmx?WSDL";
		String SOAP_ACTION = "http://www.kraftfoods.com/ws/GetRecipeByRecipeID";
		Intent intent = getIntent();
		int ID = Integer.parseInt(intent.getStringExtra("ID"));

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("iRecipeID", ID);
		request.addProperty("bStripHTML", true);
		request.addProperty("iBrandID", 1);
		request.addProperty("iLangID", 1);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE httpTransport = new HttpTransportSE(URL);
		httpTransport.debug = true;

		try {
			httpTransport.call(SOAP_ACTION, envelope);
			SoapObject result = (SoapObject) envelope.getResponse();
			int type = intent.getIntExtra("type", 0);
			parseRecipeInfo((SoapObject) result.getProperty(1), type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This sends a soap
		*/
	}

	/*protected void parseRecipeInfo(SoapObject summary, int type) {
		Log.i("result---->", Integer.toString(type));
		for (int i = 0; i < summary.getPropertyCount(); i++) {
			int order = i - type;
			switch (order) {
			case 0:
				recipeData.put("RecipeType", creatDefault(summary, order));
				break;
			case 4:
				recipeData.put("RecipeID", creatDefault(summary, order));
				break;
			case 5:
				recipeData.put("RecipeName", creatDefault(summary, order));
				break;
			case 6:
				recipeData.put("PrepTime", creatDefault(summary, order));
				break;
			case 7:
				recipeData.put("TotalTime", creatDefault(summary, order));
				break;
			case 8:
				recipeData
						.put("NumberOfServings", creatDefault(summary, order));
				break;
			case 9:
				recipeData.put("NumberOfIngredients",
						creatDefault(summary, order));
				break;
			case 10:
				recipeData.put("AvgRating", creatDefault(summary, order));
				break;
			case 12:
				recipeData.put("IsHealthy", creatDefault(summary, order));
				break;
			case 13:
				recipeData.put("PhotoURL", creatDefault(summary, order));
				break;
			case 16:
				loadIngre((SoapObject) summary.getProperty(order));
				break;
			case 17:
				loadInstruct((SoapObject) summary.getProperty(order));
				break;
			default:
				break;
			}
		}
	}

	protected Map<String, String> creatDefault(SoapObject summary, int i) {
		Map<String, String> def = new HashMap<String, String>();
		def.put("line", summary.getProperty(i).toString());
		return def;
	}
*/

	protected void setUI() {
		// Log.i("result---->", recipeData.get("RecipeType").toString());
		name = (TextView) this.findViewById(R.id.name);
		prep0 = (TextView) this.findViewById(R.id.prep0);
		servNb0 = (TextView) this.findViewById(R.id.servNb0);
		rating = (TextView) this.findViewById(R.id.rating);
		img = (ImageView) this.findViewById(R.id.img1);
		
		// Log.i("result---->", recipeData.get("RecipeName").get("line"));
		name.setText(recipeData.get("RecipeName").get("line"));
		prep0.setText(recipeData.get("PrepTime").get("line") + "mins");
		servNb0.setText(recipeData.get("NumberOfServings").get("line"));
		rating.setText(recipeData.get("AvgRating").get("line"));
		loadImage();

	}

	protected void loadImage() {
		/*try {
			IconFactory iconFactory = new IconFactory(recipeData
					.get("PhotoURL").get("line"));
			InputStream inputStream = iconFactory.getImageInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			img.setImageBitmap(bitmap);
		} catch (IOException e) {
		}*/
	}

	/*protected void loadIngre(SoapObject summary) {
		for (int i = 0; i < summary.getPropertyCount()&& i < 11; i++) {
			SoapObject so = (SoapObject) summary.getProperty(i);
			String s = "";
			for (int j = 0; j < so.getPropertyCount(); j++) {
				switch (j) {
				case (2):
					if (so.getProperty(j).equals("anyType{}"))
						return;
					s = s + so.getProperty(j).toString() + " ";
					break;
				case (3):
					if (so.getProperty(j).equals("anyType{}"))
						return;
					s = s + so.getProperty(j).toString() + " ";
					break;
				case (5):
					if (so.getProperty(j).equals("anyType{}"))
						return;
					s = s + so.getProperty(j).toString() + " ";
					break;
				default:
					break;
				}
			}
			String ingreID = "ingre" + i;
			int resID = getResources().getIdentifier(ingreID, "id",
					"ift2905.recipe_finder");
			TextView ingredients = (TextView) this.findViewById(resID);
			ingredients.setText(s);
		}
	}

	protected void loadInstruct(SoapObject summary) {
		for (int i = 0; i < summary.getPropertyCount()&& i < 11; i++) {
			SoapObject so = (SoapObject) summary.getProperty(i);
			String s = so.getProperty(0).toString();
		
			String instID = "inst" + i;
			int resID = getResources().getIdentifier(instID, "id",
					"ift2905.recipe_finder");
			TextView instruct = (TextView) this.findViewById(resID);
			instruct.setText(s);
		}
	}*/
}
