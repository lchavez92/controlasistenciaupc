package pe.upc.controlasistencias.ui.notifications.data;

import java.util.List;

import pe.upc.controlasistencias.ui.notifications.model.NotificationListItem;

public interface NotificationHandler {
    public void fetchNotifications(List<NotificationListItem> items);
}
