fun main (){

val contaTalita: Conta = Conta("Talita", 1000, 1000.00)
    println(contaTalita.titular)

    contaTalita.deposita(10.000)
    println(contaTalita.saldo)


}
