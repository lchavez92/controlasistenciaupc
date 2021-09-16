package pe.upc.controlasistencias.ui.notifications;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pe.upc.controlasistencias.ui.notifications.model.NotificationListItem;
import pe.upc.controlasistencias.ui.notifications.placeholder.PlaceholderContent.PlaceholderItem;
import pe.upc.controlasistencias.databinding.FragmentNotificationBinding;

import java.util.List;


public class MyNotificationRecyclerViewAdapter extends RecyclerView.Adapter<MyNotificationRecyclerViewAdapter.ViewHolder> {

    private final List<NotificationListItem> mValues;

    public MyNotificationRecyclerViewAdapter(List<NotificationListItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentNotificationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).getTitle());
        holder.mDetailsView.setText(mValues.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mDetailsView;
        public NotificationListItem mItem;

        public ViewHolder(FragmentNotificationBinding binding) {
            super(binding.getRoot());
            //mIdView = binding.itemNumber;
            mContentView = binding.content;
            mDetailsView = binding.details;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}