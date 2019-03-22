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

public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("ME", "One onViewCreated, size=" + getActivity().getSupportFragmentManager().getFragments().size());
        Log.v("ME", "Ctx: " + getActivity().getApplicationContext());

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, FragmentTwo.create(), "TWO")
                    .addToBackStack(null)
                    .commit();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("ME", "One onResume");
    }

    public static FragmentOne create() {
        return new FragmentOne();
    }
}