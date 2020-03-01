package com.haphap.recycleview.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.haphap.recycleview.Model.Hero;
import com.haphap.recycleview.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public static final String EXTRA_DETAIL = "extra_detail" ;

    private ImageView ivPhoto;
    private TextView tvName, tvDescription;

    private Hero heroes;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        heroes = new Hero();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            heroes = bundle.getParcelable(EXTRA_DETAIL);
        }

        ivPhoto = view.findViewById(R.id.iv_photo);
        tvName = view.findViewById(R.id.tv_name);
        tvDescription = view.findViewById(R.id.tv_description);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert heroes != null;
        tvName.setText(heroes.getName());
        tvDescription.setText(heroes.getDetail());
        Glide.with(getActivity())
                .load(heroes.getPhoto())
                .apply(new RequestOptions().override(200,200))
                .into(ivPhoto);

    }
}
