package pe.upc.controlasistencias.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import pe.upc.controlasistencias.MainActivity;
import pe.upc.controlasistencias.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            final EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
            final EditText editTextNumberPassword = findViewById(R.id.editTextNumberPassword);

            String url = "http://18.236.10.184:8596/api/users/login";

            JSONObject jsonobject = new JSONObject();
            try {
                jsonobject.put("userName", editTextTextPersonName.getText());
                jsonobject.put("password", editTextNumberPassword.getText());
                Log.i("======>", jsonobject.toString());
            } catch (JSONException e) {
                Log.i("======>", e.getMessage());
            }

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, jsonobject,
                    response -> {
                        SharedPreferences prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("Usuario", response.toString());
                        editor.commit();
                        Toast toast = Toast.makeText(view.getContext(), "Se inició sesión correctamente.", Toast.LENGTH_LONG);
                        toast.show();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    },
                    error -> {
                        Toast toast = Toast.makeText(view.getContext(), "Credenciales incorrectas.", Toast.LENGTH_LONG);
                        toast.show();
                        Log.i("======>", "Credenciales incorrectas.");
                    });


            RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
            requestQueue.add(jsonObjReq);
        });
    }
}