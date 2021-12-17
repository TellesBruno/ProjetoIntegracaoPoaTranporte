package com.tellesbruno.ProjetoIntegracaoPoaTransporte.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BusLineModel {
    private int id;
    @SerializedName("codigo")
    private String code;
    @SerializedName("nome")
    private String name;

    @Override
    public String toString() {
        return "Linha de Ônibus:  ID = " + id + ", Código = " + code + ", Nome = " + name;
    }
}
