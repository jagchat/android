package com.samples.android.fragmentsdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SumFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "data";

    // TODO: Rename and change types of parameters
    private SampleData mData;


    public SumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param data Parameter 1.
     * @return A new instance of fragment SumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SumFragment newInstance(SampleData data) {
        //create fragment instance here
        SumFragment fragment = new SumFragment();

        //extract data pass to this method and pass to fragment instance
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, data);
        fragment.setArguments(args);

        return fragment;
    }


    private void showResult(View v){
        if(mData !=null){
            int sum = mData.getFirstValue() + mData.getSecondValue();

            //get ref to render
            TextView firstValueTextView = (TextView) v.findViewById(R.id.firstValueTextView);
            TextView secondValueTextView = (TextView) v.findViewById(R.id.secondValueTextView);
            TextView sumValueTextView = (TextView) v.findViewById(R.id.sumValueTextView);

            //render values
            firstValueTextView.setText(Integer.toString(mData.getFirstValue()));
            secondValueTextView.setText(Integer.toString(mData.getSecondValue()));
            sumValueTextView.setText(Integer.toString(sum));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //store data passed to fragment (within the fragment)
            mData = (SampleData) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sum, container, false);
        showResult(v);
        return v;
    }

}
