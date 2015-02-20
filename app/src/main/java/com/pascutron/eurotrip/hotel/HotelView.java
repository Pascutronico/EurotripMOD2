package com.pascutron.eurotrip.hotel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pascutron.eurotrip.maps.Maps;
import com.pascutron.eurotrip.model.Hotel;
import com.pascutron.eurotrip.utils.Constants;

import pascutron.eurotrip.R;

/**
 * Created by spascual on 07/01/2015.
 */
public class HotelView extends Fragment {

    private static final String COUNTRY = "country";

    public static HotelView newInstance(int country){

        HotelView fragment = new HotelView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }

    public HotelView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotel, container, false);

        Hotel h = new Hotel();

        switch (getArguments().getInt(COUNTRY)){

            case Constants.MADRID:
                h.setAddress(getResources().getString(R.string.address_madrid));
                h.setName(getResources().getString(R.string.hotel_madrid));
                h.setLatitud(40.4169646);
                h.setLongitud(-3.7073943);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.hotel_main, Maps.newInstance(h)).commit();
                break;
            case Constants.BARCELONA:
                h.setAddress(getResources().getString(R.string.address_barce));
                h.setName(getResources().getString(R.string.hotel_barce));
                h.setLatitud(41.4216805);
                h.setLongitud(2.1805097);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.hotel_main, Maps.newInstance(h)).commit();
                break;
            case Constants.PARIS:
                h.setAddress(getResources().getString(R.string.address_paris));
                h.setName(getResources().getString(R.string.hotel_paris));
                h.setLatitud(48.8224009);
                h.setLongitud(2.2955953);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.hotel_main, Maps.newInstance(h)).commit();
                break;
            case Constants.LONDON:
                h.setAddress(getResources().getString(R.string.address_london));
                h.setName(getResources().getString(R.string.hotel_london));
                h.setLatitud(51.5144756);
                h.setLongitud(-0.1635618);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.hotel_main, Maps.newInstance(h)).commit();
                break;
        }



        return rootView;
    }



};



