package com.tellesbruno.ProjetoIntegracaoPoaTransporte.controllers;


import com.tellesbruno.ProjetoIntegracaoPoaTransporte.services.DefaultPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Pagina de introdução ao projeto")
public class DefaultPageController {

    @Autowired
    DefaultPageService defaultPage;

    @ApiOperation("Retorna a pagina de introdução ao projeto")
    @GetMapping("/")
    public String index() {
        return defaultPage.Index();
    }

}
