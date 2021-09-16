package pe.upc.controlasistencias.ui.leaves.model;

import com.google.gson.annotations.SerializedName;

public enum LeaveStatus {
    @SerializedName("0")
    NONE,

    @SerializedName("1")
    PENDING,

    @SerializedName("2")
    APPROVED,

    @SerializedName("3")
    REJECTED
}
