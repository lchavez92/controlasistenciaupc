package pe.upc.controlasistencias.ui.marcarasistencia;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.upc.controlasistencias.R;

public class marcarasistenciaFragment extends Fragment {

    private MarcarasistenciaViewModel mViewModel;

    public static marcarasistenciaFragment newInstance() {
        return new marcarasistenciaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.marcarasistencia_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MarcarasistenciaViewModel.class);
        // TODO: Use the ViewModel
    }

}