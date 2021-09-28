package pe.upc.controlasistencias.ui.carneempleado;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.upc.controlasistencias.R;

public class carneempleadoFragment extends Fragment {

    private CarneempleadoViewModel mViewModel;

    public static carneempleadoFragment newInstance() {
        return new carneempleadoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.carneempleado_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CarneempleadoViewModel.class);
        // TODO: Use the ViewModel
    }

}