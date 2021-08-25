package pe.upc.controlasistencias.ui.leaves;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

import pe.upc.controlasistencias.R;
import pe.upc.controlasistencias.ui.leaves.model.LeaveListItem;
import pe.upc.controlasistencias.databinding.FragmentLeaveListBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * {@link RecyclerView.Adapter} that can display a {@link LeaveListItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class LeaveListRecyclerViewAdapter extends RecyclerView.Adapter<LeaveListRecyclerViewAdapter.ViewHolder> {

    private final List<LeaveListItem> mValues;

    public LeaveListRecyclerViewAdapter(List<LeaveListItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentLeaveListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTxtTitle.setText(holder.mItem.getTitle());
        holder.mTxtType.setText(holder.mItem.getType());
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yy", new Locale("es", "ES"));

        String startDateStr = dateFormat.format(holder.mItem.getStartDate());
        String endDateStr = dateFormat.format(holder.mItem.getEndDate());

        holder.mTxtDateRange.setText(String.format("%s - %s", startDateStr, endDateStr));
        holder.mTxtNote.setText("\"" + holder.mItem.getNote() + "\"");
        holder.mTxtManagerName.setText(holder.mItem.getManagerName());

        switch (holder.mItem.getStatus()){
            case APPROVED:
                holder.mChipStatus.setText("Aprobado");
                holder.mChipStatus.setChipBackgroundColorResource(R.color.success_100);
                holder.mChipStatus.setTextColor(holder.mChipStatus.getResources().getColor(R.color.success));
                break;
            case PENDING:
                holder.mChipStatus.setText("Pendiente");
                holder.mChipStatus.setChipBackgroundColorResource(R.color.warning_100);
                holder.mChipStatus.setTextColor(holder.mChipStatus.getResources().getColor(R.color.warning));
                break;
            case REJECTED:
                holder.mChipStatus.setText("Rechazado");
                holder.mChipStatus.setChipBackgroundColorResource(R.color.danger_100);
                holder.mChipStatus.setTextColor(holder.mChipStatus.getResources().getColor(R.color.danger));
                break;
            default:
                break;
        }

       ;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTxtTitle;
        public final TextView mTxtType;
        public final TextView mTxtDateRange;
        public final TextView mTxtManagerName;
        public final TextView mTxtNote;
        public final Chip mChipStatus;

        public LeaveListItem mItem;

        public ViewHolder(FragmentLeaveListBinding binding) {
            super(binding.getRoot());
            mTxtTitle = binding.txtTitle;
            mTxtType = binding.txtType;
            mTxtDateRange = binding.txtDateRange;
            mTxtManagerName = binding.txtManagerName;
            mTxtNote = binding.txtNote;
            mChipStatus = binding.chipStatus;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTxtTitle.getText() + "'";
        }
    }
}