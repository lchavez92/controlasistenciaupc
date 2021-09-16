package pe.upc.controlasistencias.ui.leaves.data;

import java.util.List;

import pe.upc.controlasistencias.ui.leaves.model.LeaveListItem;

public interface LeaveHandler {
    public void fetchLeaves(List<LeaveListItem> items);
}
