package com.tellesbruno.ProjetoIntegracaoPoaTransporte.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class BusItineraryModel {

    @SerializedName("idlinha")
    private Integer idLine;
    @SerializedName("nome")
    private String name;
    @SerializedName("codigo")
    private String code;

    private Map<String, BusStopModel> itinerary;

    @Override
    public String toString() {
        return "BusItineraryModel{" +
                "idlinha=" + idLine +
                ", nome='" + name + '\'' +
                ", codigo='" + code + '\'' +
                ", itinerary=" + itinerary +
                '}';
    }
}
