package com.example.austin.campuscalories;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.view.inputmethod.InputMethodManager;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.Context;


public class LocationActivity extends AppCompatActivity implements OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mFreshFoodsDining;
    private Marker mLakesideDining;
    private Marker mBurkeDining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLngBounds uaCampus = new LatLngBounds(new LatLng(33.210, -87.559), new LatLng(33.220, -87.525));
        mMap.setLatLngBoundsForCameraTarget(uaCampus);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uaCampus.getCenter(), 15));
        mMap.setMinZoomPreference(15f);
        mMap.setMaxZoomPreference(16f);

        //Marker creation
        createAllMarkers();
        mMap.setOnMarkerClickListener(this);
    }

    public void createAllMarkers() {
        //Lakeside Dining
        createLakesideMarker();

        //Burke Dining
        createBurkeMarker();

        //Fresh Foods
        createFreshFoodsMarker();
    }

    public void createFreshFoodsMarker (){
        LatLng freshFoodsDining = new LatLng(33.213156, -87.543436);
        mFreshFoodsDining = mMap.addMarker(new MarkerOptions()
                .position(freshFoodsDining)
                .title("Fresh Foods Dining")
                .snippet("Click for more info"));
        LocationClass freshFoodsDiningLocation = new LocationClass("The Fresh Food Company");
        mFreshFoodsDining.setTag(freshFoodsDiningLocation);
        mFreshFoodsDining.showInfoWindow();
    }

    public void createLakesideMarker (){
        LatLng lakesideDining = new LatLng(33.217651, -87.546219);
        mLakesideDining =  mMap.addMarker(new MarkerOptions()
                .position(lakesideDining)
                .title("Lakeside Dining")
                .snippet("Click for more info"));
        LocationClass lakesideDiningLocation = new LocationClass("Lakeside Dining");
        mLakesideDining.setTag(lakesideDiningLocation);
        mLakesideDining.showInfoWindow();
    }

    public void createBurkeMarker (){
        LatLng burkeDining = new LatLng(33.206650, -87.543418);
        mBurkeDining =  mMap.addMarker(new MarkerOptions()
                .position(burkeDining)
                .title("Burke Dining")
                .snippet("Click for more info"));
        LocationClass burkeDiningLocation = new LocationClass("Burke Dining");
        mBurkeDining.setTag(burkeDiningLocation);
        mBurkeDining.showInfoWindow();
    }

    public void onMapSearch(View view) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();

        switch(location) {
            case "fresh":
            case "Fresh":
            case "food":
            case "Food":
            case "foods":
            case "Foods":
            case "fresh foods":
            case "fresh Foods":
            case "Fresh foods":
            case "Fresh Foods":
            case "fresh foods dining":
            case "fresh Foods dining":
            case "Fresh foods dining":
            case "Fresh Foods dining":
            case "Fresh Foods Dining":
                mMap.clear();
                createFreshFoodsMarker();
                break;
            case "lakeside":
            case "Lakeside":
            case "lakeside dining":
            case "lakeside Dining":
            case "Lakeside dining":
            case "Lakeside Dining":
                mMap.clear();
                createLakesideMarker();
                break;
            case "burke":
            case "Burke":
            case "burke dining":
            case "burke Dining":
            case "Burke dining":
            case "Burke Dining":
                mMap.clear();
                createBurkeMarker();
                break;
            default:
                mMap.clear();
                createAllMarkers();
        }
    }

    public void onMapShowAllLocations (View view) {
        mMap.clear();
        createAllMarkers();
    }

    /** Called when the user clicks a marker. */
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Retrieve the data from the marker.
        LocationClass newLocation = (LocationClass) marker.getTag();
        Intent i = new Intent(this,DisplayInfoActivity.class);
        i.putExtra("Object", newLocation);
        startActivity(i);

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }
}
