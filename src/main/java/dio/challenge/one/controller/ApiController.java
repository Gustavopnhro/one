package dio.challenge.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dio.challenge.one.entities.Endereco;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final String cep = "40800500";
    private final RestTemplate restTemplate = new RestTemplate();
    private final String externalApiUrl = "https://viacep.com.br/ws/"+ cep +"/json/"; // Substitua pela URL da API externa que você deseja consumir.

    @GetMapping("/dados-da-api-externa")
    public Endereco obterDadosDaApiExterna() {
        Endereco response = restTemplate.getForObject(externalApiUrl, Endereco.class);
        return response;
    }
}