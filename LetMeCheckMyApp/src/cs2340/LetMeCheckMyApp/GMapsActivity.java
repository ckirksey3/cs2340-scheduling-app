package cs2340.LetMeCheckMyApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class GMapsActivity extends MapActivity {

	private MapView mapView;
	private MapController controller;
	private ArrayList<Task> list;
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private MapOverlay itemizedOverlay;
	
	private class MapOverlay extends ItemizedOverlay {

		public MapOverlay() {
			super(boundCenterBottom(getResources().getDrawable(R.drawable.marker)));
		}
		
		public void addOverlay(OverlayItem overlay) {
		    mOverlays.add(overlay);
		    populate();
		}
		
		@Override
		protected OverlayItem createItem(int i) {
		  return mOverlays.get(i);
		}

		@Override
		public int size() {
			return mOverlays.size();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * creates and displays the map
	 */
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		list = (ArrayList<Task>) this.getIntent().getExtras().get("list");
		itemizedOverlay = new MapOverlay();

		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);

		controller = mapView.getController();

		Geocoder geocoder = new Geocoder(this);
		for (int i = 0; i < list.size(); i++) {
			try {
				List<Address> address = geocoder.getFromLocationName(list.get(i).getLocation(), 1);
				if(address.size() > 0) {
					GeoPoint p = new GeoPoint( (int) (address.get(0).getLatitude() * 1E6), 
							(int) (address.get(0).getLongitude() * 1E6));
					itemizedOverlay.addOverlay(new OverlayItem(p,Integer.toString(i),Integer.toString(i)));
				//	mapView.getOverlays().add(new MapOverlay(p));
					controller.animateTo(p);
				//	controller.setZoom(15);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		mapView.getOverlays().add(itemizedOverlay);
		controller.zoomToSpan(itemizedOverlay.getLatSpanE6(),itemizedOverlay.getLonSpanE6());
		mapView.invalidate(); //force update of the view

	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
