package com.rishi.GanGaG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link CrematoriaFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link CrematoriaFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CrematoriaFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference ghatRef;
    ProgressBar progressBar;

    public CrematoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_crematoria, container, false);
        ghatRef= FirebaseDatabase.getInstance().getReference().child("Crematorium");
        recyclerView=root.findViewById(R.id.showCrematoria);
        progressBar=root.findViewById(R.id.progress_bar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<GhatsList> options= new FirebaseRecyclerOptions.Builder<GhatsList>()
                .setQuery(ghatRef,GhatsList.class)
                .build();

        FirebaseRecyclerAdapter<GhatsList, CrematoriaFragment.showAllGhats> adapter=new FirebaseRecyclerAdapter<GhatsList, CrematoriaFragment.showAllGhats>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CrematoriaFragment.showAllGhats holder, int position, @NonNull GhatsList model)
            {

                holder.ghatName.setText(model.Name);
                holder.ghatLocation.setText(model.Location);
                holder.ghatSpecific.setText(model.Specific);
                holder.ghatAbout.setText(model.About);
            }


            @Override
            public void onDataChanged() {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }

            @NonNull
            @Override
            public CrematoriaFragment.showAllGhats onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ghats,viewGroup,false) ;
                final CrematoriaFragment.showAllGhats allGhats=new CrematoriaFragment.showAllGhats(view);

                allGhats.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sLoction;

                        sLoction=allGhats.ghatLocation.getText().toString();
                        Intent intent=new Intent(getContext(),Details.class);
                        intent.putExtra("sLocation",sLoction);
                        intent.putExtra("sName",allGhats.ghatName.getText().toString());
                        intent.putExtra("sSpecific",allGhats.ghatSpecific.getText().toString());
                        intent.putExtra("sAbout",allGhats.ghatAbout.getText().toString());
                        //Toast.makeText(getContext(),sLoction,Toast.LENGTH_SHORT).show();
                        getContext().startActivity(intent);
                    }
                });

                return allGhats;
            }
        };


        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }


    public static class showAllGhats extends RecyclerView.ViewHolder
    {

        TextView ghatName,ghatLocation,ghatSpecific,ghatAbout;
        RelativeLayout relativeLayout;
        public showAllGhats(@NonNull View itemView) {
            super(itemView);

            ghatName=itemView.findViewById(R.id.ghatName);
            ghatLocation=itemView.findViewById(R.id.ghatLocation);
            ghatSpecific=itemView.findViewById(R.id.ghatSpecific);
            ghatAbout=itemView.findViewById(R.id.ghatAbout);
            relativeLayout=itemView.findViewById(R.id.list_item_view);
        }
    }

}
