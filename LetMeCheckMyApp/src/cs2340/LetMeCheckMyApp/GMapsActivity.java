package cs2340.LetMeCheckMyApp;

import java.io.IOException;
import java.util.List;

import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class GMapsActivity extends MapActivity {

	private MapView mapView;
	private MapController controller;
	
	@Override
	
	/**
	 * creates and displays the map
	 */
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);

		controller = mapView.getController();
		
		Geocoder geocoder = new Geocoder(this);
		try {
			List<Address> address = geocoder.getFromLocationName("Georgia Tech", 1);
			if(address.size() > 0) {
				GeoPoint p = new GeoPoint( (int) (address.get(0).getLatitude() * 1E6), 
	                    (int) (address.get(0).getLongitude() * 1E6));
				controller.animateTo(p);
				controller.setZoom(15);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
