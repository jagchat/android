package com.samples.android.passingvaluestoactivity;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SumFragment extends Fragment {

    private SampleData data;

    public SumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = ViewModelProviders.of(getActivity()).get(SampleData.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sum, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        data = ViewModelProviders.of(getActivity()).get(SampleData.class);
        refreshForm();
    }

    private void showResult(View v){

        int sum = data.getFirstValue() + data.getSecondValue();

        //get ref to render
        TextView firstValueTextView = (TextView) v.findViewById(R.id.firstValueTextView);
        TextView secondValueTextView = (TextView) v.findViewById(R.id.secondValueTextView);
        TextView sumValueTextView = (TextView) v.findViewById(R.id.sumValueTextView);

        //render values
        firstValueTextView.setText(Integer.toString(data.getFirstValue()));
        secondValueTextView.setText(Integer.toString(data.getSecondValue()));
        sumValueTextView.setText(Integer.toString(sum));
    }

    public void refreshForm(){
        showResult(getView());
    }
}
