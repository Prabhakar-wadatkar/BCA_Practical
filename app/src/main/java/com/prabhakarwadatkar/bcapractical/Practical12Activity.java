package com.prabhakarwadatkar.bcapractical;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Practical12Activity extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 3;
    private TextView locationTextView;
    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical12);

        locationTextView = findViewById(R.id.location_text);
        Button getLocationButton = findViewById(R.id.get_location_button);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        getLocationButton.setOnClickListener(v -> checkAndGetLocation());

        // Initialize LocationListener
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                locationTextView.setText("Location: Latitude " + latitude + ", Longitude " + longitude);
                // Stop updates after getting a location to keep it simple
                locationManager.removeUpdates(this);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            @Override
            public void onProviderEnabled(String provider) {}
            @Override
            public void onProviderDisabled(String provider) {}
        };

        // Check permission and location services on start
        checkAndGetLocation();
    }

    private void checkAndGetLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
        } else if (!isLocationEnabled()) {
            Toast.makeText(this, "Please enable location services", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        } else {
            getLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (isLocationEnabled()) {
                getLocation();
            } else {
                Toast.makeText(this, "Please enable location services", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Permission denied to access location", Toast.LENGTH_SHORT).show();
            locationTextView.setText("Location: Permission denied");
        }
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void getLocation() {
        try {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                // Try GPS provider first
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    locationTextView.setText("Location: Latitude " + latitude + ", Longitude " + longitude);
                    return;
                }

                // Fallback to Network provider
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    locationTextView.setText("Location: Latitude " + latitude + ", Longitude " + longitude);
                    return;
                }

                // Request location updates if last known location is null
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                } else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                } else {
                    Toast.makeText(this, "No location provider available", Toast.LENGTH_SHORT).show();
                    locationTextView.setText("Location: Not available");
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error getting location", Toast.LENGTH_SHORT).show();
            locationTextView.setText("Location: Error");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Remove location updates to prevent battery drain
        if (locationManager != null && locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
    }
}