package com.tellesbruno.ProjetoIntegracaoPoaTransporte.services;

import org.springframework.stereotype.Service;

@Service
public class DefaultPageService {
    public String Index() {
        return """
                <!DOCTYPE html>
                <html lang="pt-br">
                <head>
                    <meta charset="UTF-8">
                    <title>Projeto de Integração de POA e Transporte</title>
                </head>
                <body>
                <h1>Projeto de Integração de POA e Transporte</h1>
                                <span>Desenvolvido por Bruno Telles<br>
                                Versão: 1.0<br>
                                Data: 17/12/2021<br><br>
                                
                                Comandos disponíveis:<br>
                                /buslines - Lista as linhas de ônibus<br>
                                /buslines/{id} - Mostra informações sobre a linha de ônibus com base no id<br>
                                /buslines/{id}/itinerary - Mostra as paradas da linha de ônibus com base no id<br>
                                /buslines/search?name={name} - Lista todas as linhas disponiíveis com base no nome da linha<br>
                                /swagger-ui.html - Apresenta a documentação da API<br>
                                </span>
                </body>
                </html>""";
    }
}
