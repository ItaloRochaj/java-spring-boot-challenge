Claro! Vou criar um **relatório didático e aprofundado** para que você possa estudar e se preparar para entrevistas técnicas usando como base o repositório [java-spring-boot-challenge](https://github.com/ItaloRochaj/java-spring-boot-challenge).  
O objetivo é transformar o conteúdo do desafio em um **guia de estudo estruturado**, cobrindo conceitos, arquitetura, boas práticas e possíveis perguntas de entrevista.

---

# 📚 Relatório de Estudo – Java Spring Boot Challenge

## 1. 🎯 Objetivo do Projeto
O repositório propõe um **desafio prático** de backend com **Java + Spring Boot**, cujo objetivo é:
- Criar uma **API RESTful** com **duas entidades relacionadas**.
- Persistir dados em **PostgreSQL** usando **Docker**.
- Seguir **boas práticas** do ecossistema Spring.

Esse tipo de desafio é comum em entrevistas para desenvolvedores backend, pois avalia:
- Conhecimento técnico em Java e Spring.
- Capacidade de modelar dados e criar relacionamentos.
- Uso de ferramentas modernas como Docker.
- Organização e boas práticas de código.

---

## 2. 🏗 Arquitetura Esperada

Embora o repositório não traga todos os arquivos de implementação, o desafio sugere uma arquitetura típica de **Spring Boot**:

### 2.1. Camadas
| Camada | Responsabilidade | Tecnologias/Anotações |
|--------|------------------|-----------------------|
| **Controller** | Receber requisições HTTP e retornar respostas | `@RestController`, `@RequestMapping` |
| **Service** | Contém a lógica de negócio | `@Service` |
| **Repository** | Comunicação com o banco de dados | `@Repository`, `JpaRepository` |
| **Model/Entity** | Representação das tabelas do banco | `@Entity`, `@Table`, `@Id` |

---

## 3. 🗄 Banco de Dados e Docker

### 3.1. PostgreSQL com Docker
Um `docker-compose.yml` típico para esse cenário poderia ser:

```yaml
version: '3.1'
services:
  db:
    image: postgres:15
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin
      POSTGRES_DB: challenge_db
    ports:
      - "5432:5432"
```

**Pontos de entrevista:**
- Como conectar o Spring Boot ao PostgreSQL (`application.properties` ou `application.yml`).
- Diferença entre `spring.jpa.hibernate.ddl-auto=update` e `create-drop`.
- Vantagens de usar Docker para desenvolvimento.

---

## 4. 🔗 Relacionamento entre Entidades

O desafio pede **duas entidades relacionadas**.  
Exemplo comum: `Cliente` e `Pedido`.

```java
@Entity
public class Cliente {
    @Id @GeneratedValue
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}

@Entity
public class Pedido {
    @Id @GeneratedValue
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
```

**Perguntas que podem surgir:**
- Diferença entre `@OneToMany` e `@ManyToOne`.
- Como evitar **LazyInitializationException**.
- Diferença entre `EAGER` e `LAZY` loading.

---

## 5. 🌐 API RESTful

### 5.1. Endpoints esperados
- `GET /clientes` → Lista todos os clientes.
- `POST /clientes` → Cria um cliente.
- `GET /clientes/{id}` → Busca cliente por ID.
- `GET /clientes/{id}/pedidos` → Lista pedidos de um cliente.
- `POST /pedidos` → Cria um pedido vinculado a um cliente.

**Boas práticas:**
- Uso de **DTOs** para evitar expor entidades diretamente.
- Validação com `@Valid` e `@NotNull`.
- Tratamento de erros com `@ControllerAdvice`.

---

## 6. 🛠 Boas Práticas no Spring Boot

- **Injeção de dependência** via construtor (evita problemas com testes).
- **Separação de responsabilidades** (Controller não deve conter lógica de negócio).
- **Uso de `ResponseEntity`** para respostas HTTP.
- **Configuração de CORS** quando necessário.
- **Versionamento de API** (`/api/v1/...`).

---

## 7. 📌 Tópicos para Revisar Antes da Entrevista

1. **Java**
   - Streams API
   - Optional
   - Record vs Class
   - Equals e HashCode
2. **Spring Boot**
   - Ciclo de vida de um Bean
   - Profiles (`@Profile`)
   - Spring Data JPA
3. **Banco de Dados**
   - Joins
   - Índices
   - Normalização
4. **Docker**
   - Volumes
   - Redes
   - Multi-stage builds
5. **Testes**
   - JUnit 5
   - Mockito
   - Testes de integração com Spring Boot

---

## 8. 🎤 Possíveis Perguntas de Entrevista

- Como você modelaria o relacionamento entre as entidades?
- Qual a diferença entre `@Component`, `@Service` e `@Repository`?
- Como configurar variáveis de ambiente no Docker para o Spring Boot?
- O que é o `application.yml` e como ele difere do `application.properties`?
- Como implementar paginação e ordenação com Spring Data JPA?

---

## 9. 📈 Próximos Passos para Estudo

- Implementar o desafio do zero, seguindo o enunciado.
- Criar testes unitários e de integração.
- Adicionar autenticação com **Spring Security**.
- Documentar a API com **Swagger/OpenAPI**.
- Simular deploy em um serviço como **Heroku** ou **Render**.

---

### 👨🏻‍💻 Autor:
<table style="border=0">
  <tr>
    <td align="left">
      <a href="https://github.com/ItaloRochaj">
        <span><b>Italo Rocha</b></span>
      </a>
      <br>
      <span>Full-Stack Development</span>
    </td>
  </tr>
</table>
