# CRUD Framework

- **InMemoryRepository**: Armazena as entidades em memória.
- **InFileRepository**: Armazena as entidades em um arquivo (usando serialização).

Entidades:

- **Produto**
- **Cliente**

## Estrutura do Projeto

```text
meu-framework-crud/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── meuprojeto/
│                   ├── entity/
│                   │   ├── Identifiable.java
│                   │   ├── Produto.java
│                   │   └── Cliente.java
│                   ├── repository/
│                   │   ├── CrudRepository.java
│                   │   ├── InMemoryRepository.java
│                   │   └── InFileRepository.java
│                   └── main/
│                       └── Main.java
├── README.md
└── build.gradle
```

## Como Executar

1. **Compilar o Projeto:**  
   Se estiver utilizando Gradle:
   ```bash
   gradle clean build
   ```
   Ou, se estiver utilizando Maven:
   ```bash
   mvn clean package
   ```
