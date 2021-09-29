package pe.upc.controlasistencias.ui.leaves.data;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import pe.upc.controlasistencias.ui.leaves.model.LeaveListItem;
import pe.upc.controlasistencias.ui.leaves.model.LeaveStatus;

public class DataSource {
    public void getLeaves(String search, Context context, LeaveHandler handler) {
        String url = "http://18.236.10.184:8596/api/leaves?search=" + search;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            /*new Gson().fromJson(response, new TypeToken<List<LeaveListItem>>(){}.getType());
            JSONArray jsonArray = new JSONArray(response);*/
            Log.i("======>", response);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            List<LeaveListItem> items = gson.fromJson(response, new TypeToken<List<LeaveListItem>>() {
            }.getType());

            handler.fetchLeaves(items);

        },
                error -> Log.i("======>", error.toString())
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
