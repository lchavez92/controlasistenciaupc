package pe.upc.controlasistencias.ui.datosempleado;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pe.upc.controlasistencias.R;
import pe.upc.controlasistencias.models.UserInfoModel;
import pe.upc.controlasistencias.models.UserModel;

public class DatosFragment extends Fragment {

    private DatosViewModel mViewModel;

    public static DatosFragment newInstance() {
        return new DatosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_datos, container, false);
        SharedPreferences prefs = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String usuario = prefs.getString("Usuario", "");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        UserInfoModel userModel = gson.fromJson(usuario, UserInfoModel.class);

        String url = "http://18.236.10.184:8596/api/users/" + userModel.getId();

        TextView carnetNombre = (TextView)root.findViewById(R.id.txtCarnetNombre);
        TextView carnetDni = (TextView)root.findViewById(R.id.txtCarnetDni);
        TextView carnetEmail = (TextView)root.findViewById(R.id.txtCarnetEmail);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                response -> {
                    UserModel user = gson.fromJson(response.toString(), UserModel.class);

                    ImageView imageView = (ImageView) root.findViewById(R.id.imageView12);
                    byte[] decodedString = Base64.decode(user.getQr(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    imageView.setImageBitmap(decodedByte);

                    carnetNombre.setText(user.getFirstName() + " " + user.getLastName());
                    carnetDni.setText(user.getPersonId());
                    carnetEmail.setText(user.getEmail());
                },
                error -> {
                    Toast toast = Toast.makeText(root.getContext(), "Hubo un error al momento de consultar los datos.", Toast.LENGTH_LONG);
                    toast.show();
                    Log.i("======>", "Hubo un error al momento de consultar los datos.");
                });


        RequestQueue requestQueue = Volley.newRequestQueue(root.getContext());
        requestQueue.add(stringRequest);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DatosViewModel.class);
        // TODO: Use the ViewModel
    }

}