package com.pascutron.eurotrip.country;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pascutron.eurotrip.utils.Constants;

import pascutron.eurotrip.R;

/**
 * Created by spascual on 06/01/2015.
 */
public class PlaceholderFragment extends Fragment {

    public static PlaceholderFragment newInstance(){
        return new PlaceholderFragment();}

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Crear y asignar boton1

        Button button1 = (Button)rootView.findViewById(R.id.button1);
        onClickWithParameters(Constants.MADRID, button1);

        //Crear y asignar boton2

        Button button2 = (Button)rootView.findViewById(R.id.button2);
        onClickWithParameters(Constants.BARCELONA, button2);

        //Crear y asignar boton3

        Button button3 = (Button)rootView.findViewById(R.id.button3);
        onClickWithParameters(Constants.PARIS, button3);

        //Crear y asignar boton4

        Button button4 = (Button)rootView.findViewById(R.id.button4);
        onClickWithParameters(Constants.LONDON, button4);



        return rootView;
    }




    private void onClickWithParameters(final int y, Button b){

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, CountryView.newInstance(y)).addToBackStack(null).commit();
            }
        });

    }


}