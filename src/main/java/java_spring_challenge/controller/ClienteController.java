package java_spring_challenge.controller;

import jakarta.validation.Valid;
import java_spring_challenge.dto.ClienteDTO;
import java_spring_challenge.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ClienteDTO criar(@RequestBody @Valid ClienteDTO dto) {
        return service.criar(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizar(@PathVariable Long id, @RequestBody @Valid ClienteDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
