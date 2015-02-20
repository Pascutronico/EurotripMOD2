package com.pascutron.eurotrip.viaje;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.pascutron.eurotrip.utils.Constants;

import java.util.ArrayList;

import pascutron.eurotrip.R;

/**
 * Created by spascual on 07/01/2015.
 */
public class ViajeView extends Fragment{

    private static final String COUNTRY = "country";

    public static ViajeView newInstance(int country){

        ViajeView fragment = new ViajeView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }

    public ViajeView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viaje, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView_viaje);

        ArrayList<String> information = new ArrayList<String>();

        switch (getArguments().getInt(COUNTRY)){

            case Constants.MADRID:
                information.add(getResources().getString(R.string.partida));
                information.add(getResources().getString(R.string.destino));
                information.add(getResources().getString(R.string.viaje_madrid_1));
                information.add(getResources().getString(R.string.viaje_madrid_2));
                information.add(getResources().getString(R.string.salida));
                information.add(getResources().getString(R.string.llegada));
                information.add(getResources().getString(R.string.viaje_madrid_3));
                information.add(getResources().getString(R.string.viaje_madrid_4));
                break;
            case Constants.BARCELONA:
                information.add(getResources().getString(R.string.partida));
                information.add(getResources().getString(R.string.destino));
                information.add(getResources().getString(R.string.viaje_barce_1));
                information.add(getResources().getString(R.string.viaje_barce_2));
                information.add(getResources().getString(R.string.salida));
                information.add(getResources().getString(R.string.llegada));
                information.add(getResources().getString(R.string.viaje_barce_3));
                information.add(getResources().getString(R.string.viaje_barce_4));
                break;
            case Constants.PARIS:
                information.add(getResources().getString(R.string.partida));
                information.add(getResources().getString(R.string.destino));
                information.add(getResources().getString(R.string.viaje_paris_1));
                information.add(getResources().getString(R.string.viaje_paris_2));
                information.add(getResources().getString(R.string.salida));
                information.add(getResources().getString(R.string.llegada));
                information.add(getResources().getString(R.string.viaje_paris_3));
                information.add(getResources().getString(R.string.viaje_paris_4));
                break;
            case Constants.LONDON:
                information.add(getResources().getString(R.string.partida));
                information.add(getResources().getString(R.string.destino));
                information.add(getResources().getString(R.string.viaje_london_1));
                information.add(getResources().getString(R.string.viaje_london_2));
                information.add(getResources().getString(R.string.salida));
                information.add(getResources().getString(R.string.llegada));
                information.add(getResources().getString(R.string.viaje_london_3));
                information.add(getResources().getString(R.string.viaje_london_4));
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, information);

        gridView.setAdapter(adapter);

        return rootView;
    }



}
