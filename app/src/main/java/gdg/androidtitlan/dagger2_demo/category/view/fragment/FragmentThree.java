package gdg.androidtitlan.dagger2_demo.category.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gdg.androidtitlan.dagger2_demo.R;

public class FragmentThree extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("ME","Three onViewCreated, size=" + getActivity().getSupportFragmentManager().getFragments().size());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("ME","Three onResume");
    }

    public static FragmentThree create() {
        return new FragmentThree();
    }
}
