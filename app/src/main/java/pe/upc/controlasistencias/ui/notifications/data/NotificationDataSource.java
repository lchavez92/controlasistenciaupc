package pe.upc.controlasistencias.ui.notifications.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import pe.upc.controlasistencias.ui.notifications.model.NotificationListItem;


public class NotificationDataSource {
    public void getNotifications(String search, Context context, NotificationHandler handler) {
        String url = "http://18.236.10.184:8596/api/notifications?search=" + search;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            /*new Gson().fromJson(response, new TypeToken<List<LeaveListItem>>(){}.getType());
            JSONArray jsonArray = new JSONArray(response);*/
            Log.i("======>", response);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            List<NotificationListItem> items = gson.fromJson(response, new TypeToken<List<NotificationListItem>>(){}.getType());

            handler.fetchNotifications(items);

        },
                error -> Log.i("======>", error.toString())
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
