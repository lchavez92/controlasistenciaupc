package pe.upc.controlasistencias.ui.configuracion;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.upc.controlasistencias.R;

public class configuracion_Fragment extends Fragment {

    private ConfiguracionViewModel mViewModel;

    public static configuracion_Fragment newInstance() {
        return new configuracion_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.configuracion__fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ConfiguracionViewModel.class);
        // TODO: Use the ViewModel
    }

}