package pe.upc.controlasistencias.ui.leaves.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import pe.upc.controlasistencias.ui.leaves.model.LeaveListItem;
import pe.upc.controlasistencias.ui.leaves.model.LeaveStatus;

public class DataSource {
    public List<LeaveListItem> getLeaves() {
        List<LeaveListItem> items = new ArrayList<LeaveListItem>();
        items.add(new LeaveListItem(
                "Permiso por resfrío común",
                "Licencia por Salud",
                new GregorianCalendar(2020, 12, 5).getTime(),
                new GregorianCalendar(2020, 12, 5).getTime(),
                "Leonel Chavez",
                LeaveStatus.APPROVED,
                "Tuve un pequeño resfriado y por prevención me fui al doctor."));

        items.add(new LeaveListItem(
                "Permiso por viaje de emergencia",
                "Licencia Ocasional",
                new GregorianCalendar(2021, 1, 5).getTime(),
                new GregorianCalendar(2021, 1, 12).getTime(),
                "Luis Ramirez",
                LeaveStatus.APPROVED,
                "Me voy de viaje a Cusco por la salud de mi madre."));

        items.add(new LeaveListItem(
                "Me iré de vacaciones",
                "Licencia Ocasional",
                new GregorianCalendar(2021, 9, 5).getTime(),
                new GregorianCalendar(2021, 9, 10).getTime(),
                "Luis Ramirez",
                LeaveStatus.REJECTED,
                "Me voy de viaje a Colombia con mis amigos. Por favor, concédeme un permiso para lo mismo."));

        items.add(new LeaveListItem(
                "Me iré de vacaciones",
                "Licencia Ocasional",
                new GregorianCalendar(2021, 12, 5).getTime(),
                new GregorianCalendar(2021, 12, 31).getTime(),
                "Luis Ramirez",
                LeaveStatus.PENDING,
                "Me voy de viaje a Chile por navidad."));
        return items;
    }
}
