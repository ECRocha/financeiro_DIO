# Desafio de projeto DIO
Java RESTFULL API criada para controle financeiro.

## Diagrama de classes

```mermaid
erDiagram
    TRANSACAO {
        Long id PK
        String descricao
        BigDecimal valor
        LocalDate data
        String tipo
    }

    TipoTransacao {
        String tipo
    }

    TRANSACAO ||--|| TipoTransacao : possui
