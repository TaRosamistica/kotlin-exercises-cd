fun main (){

val contaTalita: Conta = Conta("Talita", 1000, 1000.0)
    println(contaTalita.titular)
    println(contaTalita.getSaldo())

    contaTalita.deposita(500.0)
    println(contaTalita.getSaldo())
    contaTalita.saca(2.00)
    //println(contaTalita.getSaldo())

val contaMonica: Conta = Conta("Monica", 2000, 100.0)
    contaMonica.saca(50.0)
    println(contaMonica.getSaldo())

    println(contaMonica.transfere(11000.0, contaTalita))
    println(contaTalita.getSaldo())

}
