package alterindonesia.project.com.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import alterindonesia.project.com.Adapter.AdapterListExpand;
import alterindonesia.project.com.Helpers.DataGenerator;
import alterindonesia.project.com.Model.Social;
import alterindonesia.project.com.R;
import alterindonesia.project.com.widget.LineItemDecoration;

public class RiwayatFragment extends Fragment {
    private View rootView;

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterListExpand mAdapter;

    public RiwayatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_riwayat, container, false);
        initComponent();
        return rootView;
    }

    private void initComponent() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new LineItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);

        List<Social> items = DataGenerator.getSocialData(getContext());

        //set data and list adapter
        mAdapter = new AdapterListExpand(getContext(), items);
        recyclerView.setAdapter(mAdapter);
    }
}
