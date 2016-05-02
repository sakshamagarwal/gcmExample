package gcm.play.android.samples.com.gcmquickstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String EXTRA_LAT = "extra_lat";
    public static final String EXTRA_LON = "extra_lon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment fragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent i = getIntent();
        Double lat = Double.parseDouble(i.getStringExtra(EXTRA_LAT));
        Double lon = Double.parseDouble(i.getStringExtra(EXTRA_LON));

        MarkerOptions options = new MarkerOptions().position(new LatLng(lat, lon)).title("Heaven");
        googleMap.addMarker(options);
        CameraPosition target = CameraPosition.builder().target(new LatLng(lat, lon)).zoom(14).build();
        if (googleMap != null) {
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        }

    }
}
