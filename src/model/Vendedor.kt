package model

class Vendedor(
    nome: String,
    cpf: String,
    dataNascimento: String,
    override val matricula: String,
    override val salarioBase: Double,
    val sessaoVendas: String
) : Pessoa(nome, cpf, dataNascimento), Funcionario {

    var salario: Double? = null

    override fun calcularSalario(valor: Double) {
        salario = salarioBase + valor
    }

    override fun exibirSalario(): String {
        return "O salário do vendedor $nome é R$ $salario"
    }
}
