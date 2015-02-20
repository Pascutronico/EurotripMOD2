package com.pascutron.eurotrip.maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pascutron.eurotrip.model.Hotel;

import pascutron.eurotrip.R;

/**
 * Created by spascual on 07/01/2015.
 */
public class Maps extends Fragment {

    private static final String LOC = "loc";

    private Hotel hotel;
    private MapView mapView;
    private GoogleMap map;

    public static Maps newInstance(Hotel l){

        Maps fragment = new Maps();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putParcelable(LOC, l);
        fragment.setArguments(b);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapsInitializer.initialize(getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_maps, container, false);
        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        map = mapView.getMap();

        hotel = getArguments().getParcelable(LOC);

        LatLng mapCenter = new LatLng(hotel.getLatitud(), hotel.getLongitud());

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter, 13));

        CameraPosition cameraPosition = CameraPosition.builder().target(mapCenter).zoom(13).bearing(90).build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 2000, null);

        map.addMarker(new MarkerOptions().position(mapCenter).title(hotel.getName().toUpperCase())
                .snippet(hotel.getAddress())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pushpin)));
        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

   }

