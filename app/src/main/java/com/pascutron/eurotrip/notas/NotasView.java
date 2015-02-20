package com.pascutron.eurotrip.notas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pascutron.eurotrip.utils.Constants;

import pascutron.eurotrip.R;

/**
 * Created by spascual on 07/01/2015.
 */
public class NotasView extends Fragment{

    private static final String COUNTRY = "country";

    public static NotasView newInstance(int country){

        NotasView fragment = new NotasView();
        Bundle b = fragment.getArguments();
        if (b == null)
            b = new Bundle();

        b.putInt(COUNTRY, country);
        fragment.setArguments(b);

        return fragment;

    }

    public NotasView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notas, container, false);
        TextView notas = (TextView) rootView.findViewById(R.id.notas);

        switch (getArguments().getInt(COUNTRY)){

            case Constants.MADRID:
                notas.setText(getResources().getString(R.string.notas_madrid));
                break;
            case Constants.BARCELONA:
                notas.setText(getResources().getString(R.string.notas_barce));
                break;
            case Constants.PARIS:
                notas.setText(getResources().getString(R.string.notas_paris));
                break;
            case Constants.LONDON:
                notas.setText(getResources().getString(R.string.notas_london));
                break;
        }

        return rootView;
    }


}
