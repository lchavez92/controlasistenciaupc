package pe.upc.controlasistencias.ui.registrarsolicitud;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import pe.upc.controlasistencias.MainActivity;
import pe.upc.controlasistencias.R;
import pe.upc.controlasistencias.ui.leaves.LeaveListFragment;

public class RegistrarsolicitudFragment extends Fragment {

    private RegistrarsolicitudViewModel mViewModel;

    public static RegistrarsolicitudFragment newInstance() {
        return new RegistrarsolicitudFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.registrarsolicitud_fragment, container, false);

        Button btn = root.findViewById(R.id.btnguardar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText txtMotivo = getActivity().findViewById(R.id.txt_motivo);
                final Spinner txtTipo = getActivity().findViewById(R.id.sp_tipo);
                final EditText txtNota = getActivity().findViewById(R.id.txt_nota);
                final Spinner txtJefe = getActivity().findViewById(R.id.sp_jefe);

                String url = "http://18.236.10.184:8596/api/leaves";


                JSONObject jsonobject = new JSONObject();
                try {
                    jsonobject.put("title", txtMotivo.getText());
                    jsonobject.put("type",txtTipo.getSelectedItem().toString());
                    jsonobject.put("startDate","2021-09-15");
                    jsonobject.put("endDate","2021-09-15");
                    jsonobject.put("managerName", txtJefe.getSelectedItem().toString());
                    jsonobject.put("note", txtNota.getText());
                    Log.i("======>", jsonobject.toString());
                } catch (JSONException e) {
                    Log.i("======>", e.getMessage());
                }

                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        url, jsonobject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast toast = Toast.makeText(getActivity(), "Se insertó correctamente", Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();

                                Navigation.findNavController(view).navigate(R.id.nav_leaves);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("======>", error.getMessage());
                            }
                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.add(jsonObjReq);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegistrarsolicitudViewModel.class);
        // TODO: Use the ViewModel
    }

}