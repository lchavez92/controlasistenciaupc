package pe.upc.controlasistencias.ui.notifications;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.upc.controlasistencias.R;
import pe.upc.controlasistencias.ui.leaves.LeaveListRecyclerViewAdapter;
import pe.upc.controlasistencias.ui.leaves.data.DataSource;
import pe.upc.controlasistencias.ui.leaves.data.LeaveHandler;
import pe.upc.controlasistencias.ui.leaves.model.LeaveListItem;
import pe.upc.controlasistencias.ui.notifications.data.NotificationDataSource;
import pe.upc.controlasistencias.ui.notifications.data.NotificationHandler;
import pe.upc.controlasistencias.ui.notifications.model.NotificationListItem;
import pe.upc.controlasistencias.ui.notifications.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class NotificationFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotificationFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotificationFragment newInstance(int columnCount) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            NotificationDataSource ds = new NotificationDataSource();
            ds.getNotifications("", getContext(), new NotificationHandler() {
                @Override
                public void fetchNotifications(List<NotificationListItem> items) {
                    recyclerView.setAdapter(new MyNotificationRecyclerViewAdapter(items));
                }
            });

        }
        return view;
    }
}