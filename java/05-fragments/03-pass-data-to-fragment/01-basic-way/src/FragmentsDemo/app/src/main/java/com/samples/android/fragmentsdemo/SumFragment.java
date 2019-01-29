package com.samples.android.fragmentsdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment {


    public SumFragment() {
        // Required empty public constructor
    }

    private void showResult(Bundle b, View v){
        SampleData d = (SampleData) b.getSerializable("data"); //retrieve the custom object

        int sum = d.getFirstValue() + d.getSecondValue();

        //get ref to render
        TextView firstValueTextView = (TextView) v.findViewById(R.id.firstValueTextView);
        TextView secondValueTextView = (TextView) v.findViewById(R.id.secondValueTextView);
        TextView sumValueTextView = (TextView) v.findViewById(R.id.sumValueTextView);

        //render values
        firstValueTextView.setText(Integer.toString(d.getFirstValue()));
        secondValueTextView.setText(Integer.toString(d.getSecondValue()));
        sumValueTextView.setText(Integer.toString(sum));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sum, container, false);

        Bundle b = getArguments(); //get the passed bundle (works only once the frag is added)
        showResult(b, v);

        return v;    }

}
