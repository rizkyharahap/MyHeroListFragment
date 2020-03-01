package com.haphap.recycleview.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haphap.recycleview.Model.Hero;
import com.haphap.recycleview.Adapter.HeroAdapter;
import com.haphap.recycleview.Model.HeroesData;
import com.haphap.recycleview.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Hero> heroes = new ArrayList<>();
    private HeroAdapter adapterHorizontal, adapterVertical;
    private RecyclerView rvHorizontal, rvVertical;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        rvHorizontal = view.findViewById(R.id.rv_horizontal_list);
        rvVertical = view.findViewById(R.id.rv_vertical_list);

        adapterHorizontal = new HeroAdapter(heroes, getActivity(),1);
        adapterVertical = new HeroAdapter(heroes, getActivity(),2);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        heroes.addAll(HeroesData.getListData());

        rvHorizontal.setHasFixedSize(true);
        rvVertical.setHasFixedSize(true);
        rvHorizontal.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvVertical.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvHorizontal.setAdapter(adapterHorizontal);
        rvVertical.setAdapter(adapterVertical);
    }
}
