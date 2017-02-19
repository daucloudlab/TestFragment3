package kz.kazntu.lessons.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment implements View.OnClickListener{
    private Button button ;
    private int counter ;
    private Communicator communicator ;

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            counter = 0 ;
        }else{
            counter = savedInstanceState.getInt("counter") ;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false) ;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = (Button)getActivity().findViewById(R.id.buttonOnFragmentA) ;
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++ ;
        communicator.respond("Батырма " + counter + " рет басылды!") ;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    public interface Communicator{
        public void respond(String data) ;
    }
}
