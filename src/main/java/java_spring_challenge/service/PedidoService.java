package java_spring_challenge.service;

import java_spring_challenge.dto.PedidoDTO;
import java_spring_challenge.model.Cliente;
import java_spring_challenge.model.Pedido;
import java_spring_challenge.repository.ClienteRepository;
import java_spring_challenge.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepo;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRepo) {
        this.repository = repository;
        this.clienteRepo = clienteRepo;
    }

    public List<PedidoDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public PedidoDTO buscar(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return toDTO(pedido);
    }

    public PedidoDTO criar(PedidoDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido(null, dto.getDescricao(), dto.getData(), cliente);
        return toDTO(repository.save(pedido));
    }

    public PedidoDTO atualizar(Long id, PedidoDTO dto) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setDescricao(dto.getDescricao());
        pedido.setData(dto.getData());

        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        pedido.setCliente(cliente);

        return toDTO(repository.save(pedido));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setDescricao(pedido.getDescricao());
        dto.setData(pedido.getData());
        dto.setClienteId(pedido.getCliente().getId());
        return dto;
    }
}
