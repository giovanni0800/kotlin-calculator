package calculadora

import java.util.Scanner
import java.util.Locale
import kotlin.math.pow

class Calculadora{

    init {
        Locale.setDefault(Locale("pt", "BR"))
    }

    private fun apresentarBoasVindas() {
        println("\n===================================================================")
        println("\t======= SEJA BEM VINDO(A) A CALCULADORA KOTLIN 2.0 !! =======")
        println("===================================================================")
    }

    private fun menu(): Int?{
        val opcao: Int? = try {
            println("\n\t---- Selecione o número referente a operação que deseja realizar ----\n")
            println("1 - Adição -> (Ex.: Num1 + Num2)\n" +
                    "2 - Subtração -> (Ex.: Num1 - Num2)\n" +
                    "3 - Multiplicação -> (Ex.: Num1 * Num2)\n" +
                    "4 - Divisão -> (Ex.: Num1 / Num2)\n" +
                    "5 - Potenciação -> (Ex.: Num1 ^ (Elevado) Num2)")
            print("Escolha: ")
            Scanner(System.`in`).nextInt()

        }catch(exception: Exception){
            println("\nOpção selecionada inválida... Por favor, tente novamente!")
            null
        }

        return opcao
    }

    private fun menuValidado(): Int{
        var opcaoValidada: Int?

        do{
            //Apresentar as opções das operações disponíveis para cálculo e receber uma escolha
            opcaoValidada = menu()
        } while ((opcaoValidada) == null || ((opcaoValidada != 1) && (opcaoValidada != 2) &&
            (opcaoValidada != 3) && (opcaoValidada != 4) && (opcaoValidada != 5))
        )

        //Pular uma linha após a exibição do Menu de operações disponíveis
        print("\n")
        return opcaoValidada
    }

    private fun ajustarVirgulaemPonto(numero: String): Double{
        var numeroComVirgula = numero
        numeroComVirgula = numeroComVirgula.replace(",", ".")

        return numeroComVirgula.toDouble()
    }

    private fun lerNumero(): Double? {
        val numeroDigitado: Double? = try {
            print("Digite um valor numérico para seguirmos com o cálculo: ")
            ajustarVirgulaemPonto(Scanner(System.`in`).nextLine())

        } catch (exeption: Exception) {
            println("!!!! POR GENTILEZA, DIGITE UM VALOR NUMÉRICO !!!!")
            null
        }

        return numeroDigitado
    }

    private fun lerNumeroValidado(): Double{
        var numeroValidado: Double?

        do {
            numeroValidado = lerNumero()
        }while (numeroValidado == null)

        return numeroValidado
    }

    private fun adicao(numero1: Double, numero2: Double): Double{
        return numero1 + numero2
    }

    private fun subtracao(numero1: Double, numero2: Double): Double{
        return numero1 - numero2
    }

    private fun multiplicacao(numero1: Double, numero2: Double): Double{
        return numero1 * numero2
    }

    private fun divisao(numero1: Double, numero2: Double): Double{
        return numero1 / numero2
    }

    private fun escolhaOperacao(): Double?{

        when(menuValidado()){
            1 -> return adicao(lerNumeroValidado(), lerNumeroValidado())
            2 -> return subtracao(lerNumeroValidado(), lerNumeroValidado())
            3 -> return multiplicacao(lerNumeroValidado(), lerNumeroValidado())
            4 -> return divisao(lerNumeroValidado(), lerNumeroValidado())
            5 -> return lerNumeroValidado().pow(lerNumeroValidado())
            else -> return null
        }
    }

    private fun imprimir(){
        println("\n------- O resultado de sua operação é: ${escolhaOperacao()} -------")
    }

    private fun executarCalculadora(){
        imprimir()
    }

    private fun escolhaRepetirExecucaoCalculadora(): String{
        print("\nGostaria de realziar uma nova operação? (S/N): ")
        return Scanner(System.`in`).nextLine()
    }

    fun execucaoCalculadoraComRepeticao(){
        apresentarBoasVindas()
        var repetir: String

        try {
            do{
                executarCalculadora()
                repetir = escolhaRepetirExecucaoCalculadora()
            }while(repetir.uppercase() == "S")

            if(repetir.uppercase() == "N") println("Encerrando aplicação...")
            else println("\nPor gentileza, considerar executar comandos conforme instruções do programa...\nAplicação encerrada...")

        } catch (_: Exception){
            //Nada a tratar a respeito do erro neste trecho
            println("Encerrando software abruptamente!")
        }
    }
}