package model

interface Funcionario {
    val matricula: String
    val salarioBase: Double

    fun calcularSalario(valor: Double)
    fun exibirSalario(): String
}
