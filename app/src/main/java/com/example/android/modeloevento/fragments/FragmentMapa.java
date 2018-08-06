package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.modeloevento.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentMapa extends BaseFragment implements OnMapReadyCallback {

    private GoogleMap gMap;

    public FragmentMapa() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewMapa = inflater.inflate(R.layout.mapa_fragment, container, false);
        return viewMapa;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle(R.string.mapa);

        setUpMap();
    }

    public void setUpMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        LatLng latLng = new LatLng(-22.951922, -43.210487);
        gMap.addMarker(new MarkerOptions().position(latLng).title("PARTY HARD!!!").snippet("Join us.").icon(BitmapDescriptorFactory.fromResource(R.drawable.placeholder))).showInfoWindow();
        gMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }

    private class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

        private final View mWindow;

        public CustomInfoWindowAdapter() {
            mWindow = getLayoutInflater().inflate(R.layout.info_window_mapa, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        private void render(Marker marker, View view){
            String title = marker.getTitle();
            String snippet = marker.getSnippet();
            TextView titleUi = ((TextView) view.findViewById(R.id.tv_title_info_window));
            TextView descUi = ((TextView) view.findViewById(R.id.tv_desc_info_window));
            titleUi.setText(title);
            descUi.setText(snippet);
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker, mWindow);
            return mWindow;
        }
    }
}
