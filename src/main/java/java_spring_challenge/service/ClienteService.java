package java_spring_challenge.service;

import java_spring_challenge.dto.ClienteDTO;
import java_spring_challenge.model.Cliente;
import java_spring_challenge.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<ClienteDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ClienteDTO buscar(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return toDTO(cliente);
    }

    public ClienteDTO criar(ClienteDTO dto) {
        Cliente cliente = new Cliente(null, dto.getNome(), dto.getEmail(), null);
        return toDTO(repository.save(cliente));
    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        return toDTO(repository.save(cliente));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        return dto;
    }
}
