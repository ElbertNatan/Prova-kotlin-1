package model

class Gerente(
    nome: String,
    cpf: String,
    dataNascimento: String,
    override val matricula: String,
    override val salarioBase: Double
) : Pessoa(nome, cpf, dataNascimento), Funcionario {

    var salario: Double? = null

    override fun calcularSalario(valor: Double) {
        salario = salarioBase + valor
    }

    override fun exibirSalario(): String {
        return "O salário do gerente $nome é R$ $salario"
    }
}
