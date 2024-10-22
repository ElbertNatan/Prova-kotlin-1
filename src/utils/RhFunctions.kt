package utils

import DAO.BancoDAO
import model.Gerente
import model.Pessoa
import model.Vendedor

object RhFunctions {
    private var banco: BancoDAO = BancoDAO.getInstance()

    fun cadastrarFuncionario(nome: String, cpf: String, dataNascimento: String, matricula: String) {
        val gerente = Gerente(nome, cpf, dataNascimento, matricula, salarioBase = 3000.0)
        banco.getArrayPessoas().add(gerente)
        println("Cadastro de gerente realizado com sucesso")
    }

    fun cadastrarFuncionario(nome: String, cpf: String, dataNascimento: String, matricula: String, sessaoVendas: String) {
        val vendedor = Vendedor(nome, cpf, dataNascimento, matricula, salarioBase = 1500.0, sessaoVendas = sessaoVendas)
        banco.getArrayPessoas().add(vendedor)
        println("Cadastro de vendedor realizado com sucesso")
    }

    fun pesquisarFuncionario(cpf: String): Pessoa? {
        for (pessoa in banco.getArrayPessoas()) {
            if (pessoa.cpf == cpf) {
                when (pessoa) {
                    is Gerente -> println("Gerente localizado: ${pessoa.nome}")
                    is Vendedor -> println("Vendedor localizado: ${pessoa.nome}")
                }
                return pessoa
            }
        }
        println("Nenhum funcionário encontrado para o cpf $cpf")
        return null
    }


    fun excluirFuncionario(cpf: String) {
        val pessoa = buscarPessoa(cpf)
        if (pessoa != null) {
            banco.getArrayPessoas().remove(pessoa)
            println("Funcionário ${pessoa.nome} removido com sucesso.")
        } else {
            println("Funcionário com CPF $cpf não encontrado.")
        }
    }

    fun imprimirInformacoesFuncionario(cpf: String) {
        val pessoa = buscarPessoa(cpf)
        if (pessoa != null) {
            println("************************************")
            println("Nome: ${pessoa.nome}")
            println("CPF: ${pessoa.cpf}")
            println("Nascimento: ${pessoa.dataNascimento}")

            when (pessoa) {
                is Gerente -> {
                    println("Matrícula: ${pessoa.matricula}")
                    println("Salário do gerente: ${pessoa.salario}")
                }
                is Vendedor -> {
                    println("Matrícula: ${pessoa.matricula}")
                    println("Setor: ${pessoa.sessaoVendas}")
                    println("Salário do vendedor: ${pessoa.salario}")
                }
            }
        } else {
            println("Funcionário com CPF $cpf não encontrado.")
        }
    }


    private fun buscarPessoa(cpf: String): Pessoa? {
        return banco.getArrayPessoas().find { it.cpf == cpf }
    }

    fun listarFuncionarios() {
        println("########## - Gerentes - ##########")
        for (pessoa in banco.getArrayPessoas()) {
            if (pessoa is Gerente) {
                println("Nome: ${pessoa.nome}")
                println("Matrícula: ${pessoa.matricula}\n")
            }
        }

        println("########## - Vendedores - ##########")
        for (pessoa in banco.getArrayPessoas()) {
            if (pessoa is Vendedor) {
                println("Nome: ${pessoa.nome}")
                println("Matrícula: ${pessoa.matricula}\n")
            }
        }
    }


    fun calcularSalario(cpf: String, valor: Double) {
        val pessoa = buscarPessoa(cpf)
        if (pessoa != null) {
            when (pessoa) {
                is Gerente -> pessoa.calcularSalario(valor)
                is Vendedor -> pessoa.calcularSalario(valor)
                else -> println("Não é possível calcular o salário para essa pessoa.")
            }
        } else {
            println("Funcionário com CPF $cpf não encontrado.")
        }
    }
}
