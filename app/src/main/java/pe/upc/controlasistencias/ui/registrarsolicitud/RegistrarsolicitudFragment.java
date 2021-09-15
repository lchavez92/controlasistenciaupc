package pe.upc.controlasistencias.ui.registrarsolicitud;

import androidx.constraintlayout.widget.Placeholder;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.upc.controlasistencias.R;
import pe.upc.controlasistencias.ui.leaves.LeaveListFragment;
import pe.upc.controlasistencias.ui.leaves.LeaveListRecyclerViewAdapter;

public class RegistrarsolicitudFragment extends Fragment {

    private RegistrarsolicitudViewModel mViewModel;
    private Log log;
    private Object Placeholder;

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

    public void guardar (View v) {

        log.i("===>", "guardado");

    }

}