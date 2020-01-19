package com.rishi.GanGaG;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link GhatFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link GhatFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class GhatFragment extends Fragment {


    public GhatFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment GhatFragment.
//     */
//


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ghat, container, false);
    }

}
