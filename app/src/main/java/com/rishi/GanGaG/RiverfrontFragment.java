package com.rishi.GanGaG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link RiverfrontFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link RiverfrontFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class RiverfrontFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference ghatRef;


    public RiverfrontFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment RiverfrontFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_riverfront, container, false);
        ghatRef= FirebaseDatabase.getInstance().getReference().child("Riverfronts");
        recyclerView=root.findViewById(R.id.showRiverFront);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<GhatsList> options= new FirebaseRecyclerOptions.Builder<GhatsList>()
                .setQuery(ghatRef,GhatsList.class)
                .build();

        FirebaseRecyclerAdapter<GhatsList, GhatFragment.showAllGhats> adapter=new FirebaseRecyclerAdapter<GhatsList, GhatFragment.showAllGhats>(options) {
            @Override
            protected void onBindViewHolder(@NonNull GhatFragment.showAllGhats holder, int position, @NonNull GhatsList model)
            {

                holder.ghatName.setText(model.Name);
                holder.ghatLocation.setText(model.Location);
            }

            @NonNull
            @Override
            public GhatFragment.showAllGhats onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ghats,viewGroup,false) ;
                GhatFragment.showAllGhats allGhats=new GhatFragment.showAllGhats(view);
                return allGhats;
            }
        };


        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }


    public static class showAllGhats extends RecyclerView.ViewHolder
    {

        TextView ghatName,ghatLocation,ghatSpecific,ghatAbout;
        public showAllGhats(@NonNull View itemView) {
            super(itemView);

            ghatName=itemView.findViewById(R.id.ghatName);
            ghatLocation=itemView.findViewById(R.id.ghatLocation);
            ghatSpecific=itemView.findViewById(R.id.ghatSpecific);
            ghatAbout=itemView.findViewById(R.id.ghatAbout);
        }
    }

}
