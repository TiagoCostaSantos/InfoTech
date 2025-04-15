package br.com.infotech.controller;

import br.com.infotech.controller.requests.CaracteristicaRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("caracteristicas")
public class CaracteristicaController {

    // listar todas as características
    @GetMapping("/listar")
    public List<String> listarCaracteristicas() {
        return Arrays.asList("caracteristicas ok");
    }

    // listar características por UUID (em teste está para id)
    @GetMapping("/listar/{id}")
    public List<String> listarCaracteristicasPorId(@PathVariable Long id) {
        return Arrays.asList("Característica relacionada ao ID: " + id);
    }

    // cadastrar nova característica
    @PostMapping("/cadastrar")
    public List<String> cadastrarCaracteristica(@RequestBody CaracteristicaRequest caracteristicaRequest) {
        // Método hipotético para salvar
        // salvarCaracteristica(caracteristicaRequest);
        return Arrays.asList("Característica cadastrada: OK" );
    }

    // atualizar característica
    @PatchMapping("/atualizar/{id}")
    public List<String> atualizarCaracteristica(@RequestBody CaracteristicaRequest caracteristicaRequest) {
        // Método hipotético para atualizar
        return Arrays.asList("Característica atualizada: por id" );
    }


}
//get all
///get uuid
//post
//update
