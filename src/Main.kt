import utils.RhFunctions

fun main(){

    //Cadastrando os funcionários
    //Gerentes
    RhFunctions.cadastrarFuncionario("Francisco de Souza", "000.000.000-00", "01/01/2001", "1234")
    RhFunctions.cadastrarFuncionario("Maximus Decimus Meridius", "111.111.111-11", "02/02/2002", "5678")

    //Vendedores
    RhFunctions.cadastrarFuncionario("Augusto dos Anjos", "222.222.222-22", "03/03/2003", "8910", "Brinquedos")
    RhFunctions.cadastrarFuncionario("Pedro Alvares Cabral", "333.333.333-33", "04/04/2004", "1112", "Eletrodomesticos")
    RhFunctions.cadastrarFuncionario("Airton Sena de Souza", "444.444.444-44", "05/05/2005", "1314", "Alimentação")
    RhFunctions.cadastrarFuncionario("Antonio Gonçaves da Silva", "555.555.555-55", "06/06/2006", "1516", "Papelaria")

    //Calculando os salarios
    RhFunctions.calcularSalario("000.000.000-00", 2500.0)
    RhFunctions.calcularSalario("444.444.444-44", 1500.0)

    println("\nImprimindo informações de funcionarios (individual)\n")
    //Imprimindo informações de funcionário
    //Gerentes
    RhFunctions.imprimirInformacoesFuncionario("000.000.000-00")
    //Vendedor
    RhFunctions.imprimirInformacoesFuncionario("444.444.444-44")

    println("\nImprimindo lista de todos os funcionarios")
    //Lista todos os funcionarios
    RhFunctions.listarFuncionarios()

    println("\nPesquisando funcionarios\n")
    //Lista todos os funcionarios
    RhFunctions.pesquisarFuncionario("444.444.444-44") //Achar
    RhFunctions.pesquisarFuncionario("111.111.111-11") //Achar
    RhFunctions.pesquisarFuncionario("777.777.777-77") //Não achar

    println("\nExcluindo funcionario\n")
    //Excluindo o usuario 444.444.444-44
    RhFunctions.excluirFuncionario("444.444.444-44") //Achar


    println("\nPesquisando funcionario excluído\n")
    //pesquisando o usuario 444.444.444-44 excluido anteriormente
    RhFunctions.pesquisarFuncionario("444.444.444-44") //Não achar


}