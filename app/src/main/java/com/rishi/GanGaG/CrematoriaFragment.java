package com.rishi.GanGaG;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link CrematoriaFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link CrematoriaFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CrematoriaFragment extends Fragment {

    public CrematoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crematoria, container, false);
    }


}
