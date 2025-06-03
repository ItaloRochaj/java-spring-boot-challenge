package java_spring_challenge.controller;

import jakarta.validation.Valid;
import java_spring_challenge.dto.PedidoDTO;
import java_spring_challenge.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PedidoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PedidoDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public PedidoDTO criar(@RequestBody @Valid PedidoDTO dto) {
        return service.criar(dto);
    }

    @PutMapping("/{id}")
    public PedidoDTO atualizar(@PathVariable Long id, @RequestBody @Valid PedidoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
