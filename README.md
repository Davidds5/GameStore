# 🎮 GameStore

Sistema de loja de jogos desenvolvido em **Java**, executado via **console**, com foco em aplicar conceitos de **POO**, organização em camadas e boas práticas básicas de estruturação.

O projeto simula o funcionamento de uma loja de games, permitindo gerenciar produtos, clientes e vendas.

---

## 📌 Objetivo do Projeto

Este projeto tem como objetivo praticar:

- Programação Orientada a Objetos (POO)
- Separação de responsabilidades (Domain, Service, App, Util)
- Manipulação de listas em memória
- Tratamento de exceções personalizadas
- Simulação de fluxo de vendas

---

## 🧱 Estrutura do Projeto

```bash
br.com.gamestore
│
├── App
│   └── Main.java
│
├── Domain
│   ├── Produto.java
│   ├── Jogo.java
│   ├── Console.java
│   ├── Acessorio.java
│   ├── Cliente.java
│   └── Categoria.java
│
├── Service
│   ├── ProdutoService.java
│   ├── ClienteService.java
│   └── VendaService.java
│
├── Exceptions
│   └── EstoqueInsuficiente.java
│
└── Util
    └── Menu.java
