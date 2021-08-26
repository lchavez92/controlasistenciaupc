package pe.upc.controlasistencias.ui.registrarsolicitud;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.upc.controlasistencias.R;

public class RegistrarsolicitudFragment extends Fragment {

    private RegistrarsolicitudViewModel mViewModel;

    public static RegistrarsolicitudFragment newInstance() {
        return new RegistrarsolicitudFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.registrarsolicitud_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegistrarsolicitudViewModel.class);
        // TODO: Use the ViewModel
    }

}