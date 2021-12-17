package com.tellesbruno.ProjetoIntegracaoPoaTransporte.controllers;

import com.tellesbruno.ProjetoIntegracaoPoaTransporte.models.BusItineraryModel;
import com.tellesbruno.ProjetoIntegracaoPoaTransporte.models.BusLineModel;
import com.tellesbruno.ProjetoIntegracaoPoaTransporte.services.BusLinesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buslines")
@Api(value = "API REST Bus Lines")
public class BusLinesController {

    @Autowired
    BusLinesService busLines;

    @ApiOperation(value = "Return all bus lines")
    @GetMapping()
    public List<BusLineModel> getBusLines() {
        return busLines.getAllBusLines();
    }

    @ApiOperation(value = "Return bus line by id")
    @GetMapping("/{id}")
    public BusLineModel getBusLine(@PathVariable("id") int id) {
        return busLines.getBusLineById(id);
    }

    @ApiOperation(value = "Return bus itinerary by id")
    @GetMapping("/{id}/itinerary")
    public BusItineraryModel getBusLineItinerary(@PathVariable("id") int id) {
        return busLines.getBusLineItinerary(id);
    }

    @ApiOperation(value = "Return a list of bus lines by name research")
    @GetMapping("/search")
    public List<BusLineModel> searchBusLineByName(@RequestParam(name = "name") String name) {
        return busLines.searchBusLineByName(name);
    }


}
