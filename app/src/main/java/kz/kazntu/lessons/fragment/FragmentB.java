package kz.kazntu.lessons.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {
    private TextView textView ;
    private String data ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false) ;
        if(savedInstanceState == null){

        }else{
            data = savedInstanceState.getString("text") ;
        }
        textView = (TextView)view.findViewById(R.id.textViewOnFragmentB) ;
        textView.setText(data);

        return view ;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView)getActivity().findViewById(R.id.textViewOnFragmentB) ;
    }

    public void changeData(String data){
        this.data = data ;
        textView.setText(data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);
    }
}
