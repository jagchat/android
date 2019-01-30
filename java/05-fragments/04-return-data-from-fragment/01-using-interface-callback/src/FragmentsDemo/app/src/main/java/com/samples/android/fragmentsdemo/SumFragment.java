package com.samples.android.fragmentsdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SumFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SumFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "data";

    // TODO: Rename and change types of parameters
    private SampleData mData;

    private OnFragmentInteractionListener mListener;

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

    private void showValues(View v){
        if(mData !=null){
            int sum = mData.getFirstValue() + mData.getSecondValue();

            //get ref to render
            EditText firstNoEditText = (EditText) v.findViewById(R.id.firstNoEditText);
            EditText secondNoEditText = (EditText) v.findViewById(R.id.secondNoEditText);

            //render values
            firstNoEditText.setText(Integer.toString(mData.getFirstValue()));
            secondNoEditText.setText(Integer.toString(mData.getSecondValue()));
        }
    }

    private SampleData getDataObject(){
        View v = getView();
        //gather data and create custom object
        EditText firstNoEditText = (EditText) v.findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) v.findViewById(R.id.secondNoEditText);
        SampleData d = new SampleData();
        d.setFirstValue(firstNoEditText.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());
        return d;
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
        View v = inflater.inflate(R.layout.fragment_sum, container, false);
        showValues(v);

        //attaching "onclick" method through designer doesn't work, doing it dynamically instead
        Button applyButton = (Button) v.findViewById(R.id.applyButton);
        applyButton.setOnClickListener(applyChangesButtonClick);

        return v;
    }

    private View.OnClickListener applyChangesButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                //execute callback (at Activity)
                //pass back values from here back to Activity
                mListener.onApplyChanges(getDataObject());
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        //implemented as callback in caller Activity)
        //invoked through button click above
        void onApplyChanges(SampleData data);
    }
}
