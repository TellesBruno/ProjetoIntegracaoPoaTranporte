package com.tellesbruno.ProjetoIntegracaoPoaTransporte.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tellesbruno.ProjetoIntegracaoPoaTransporte.models.BusItineraryModel;
import com.tellesbruno.ProjetoIntegracaoPoaTransporte.models.BusLineModel;
import com.tellesbruno.ProjetoIntegracaoPoaTransporte.models.BusStopModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@Service
public class BusLinesService {
    final String uri ="http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o";

    public List<BusLineModel> getAllBusLines() {
        List<BusLineModel> busLines;
        Gson gson = new Gson();
        RestTemplate restTemplate = new RestTemplate();

        String result = Objects.requireNonNull(restTemplate.getForObject(uri, String.class));
        BusLineModel[] arrayBusLineModel = gson.fromJson(result, BusLineModel[].class);

        busLines = Arrays.stream(arrayBusLineModel).toList();

        return busLines;
    }

    public BusLineModel getBusLineById(int id) {
        List<BusLineModel> busLines = getAllBusLines();
        BusLineModel busLine;

        busLine = busLines.stream().filter(busLineModel -> busLineModel.getId() == id).findAny().orElse(null);

        return busLine;
    }

    public BusItineraryModel getBusLineItinerary(int id) {
        String uriItinerary = "http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + id;
        Gson gson = new Gson();
        RestTemplate restTemplate = new RestTemplate();

        String result = Objects.requireNonNull(restTemplate.getForObject(uriItinerary, String.class));
        BusItineraryModel busItineraryModel = gson.fromJson(result, BusItineraryModel.class);
        JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
        jsonObject.remove("idlinha");
        jsonObject.remove("nome");
        jsonObject.remove("codigo");

        Map<String, BusStopModel> map = gson.fromJson(jsonObject, Map.class);
        busItineraryModel.setItinerary(map);

        return busItineraryModel;
    }

    public List<BusLineModel> searchBusLineByName(String name) {
        List<BusLineModel> busLines = getAllBusLines();
        List<BusLineModel> busLinesFound = new ArrayList<>();

        busLines.forEach(busLine -> {
            if (busLine.getName().toLowerCase().contains(name.toLowerCase())) {
                busLinesFound.add(busLine);
            }
        });

        return busLinesFound;
    }

}
