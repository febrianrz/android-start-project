package alterindonesia.project.com.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alterindonesia.project.com.ListMerchantActivity;
import alterindonesia.project.com.R;
import alterindonesia.project.com.TerimaUangActivity;
import alterindonesia.project.com.TopUpActivity;
import alterindonesia.project.com.TransferActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View rootView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView    = inflater.inflate(R.layout.fragment_home, container, false);
        rootView.findViewById(R.id.icTopup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TopUpActivity.class);
                startActivity(intent);
            }
        });
        rootView.findViewById(R.id.icTransfer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TransferActivity.class);
                startActivity(intent);
            }
        });
        rootView.findViewById(R.id.icTerimaUang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TerimaUangActivity.class);
                startActivity(intent);
            }
        });
        rootView.findViewById(R.id.icMerchant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ListMerchantActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
