fun main (){

val contaTalita: Conta = Conta("Talita", 1000, 1000.0)
    println(contaTalita)

    contaTalita.deposita(500.0)
    println(contaTalita.getSaldo())
    contaTalita.saca(2.00)
    println(contaTalita.getSaldo())

val contaMonica: Conta = Conta("Monica", 2000, 100.0)
    println(contaMonica)
    contaMonica.saca(50.0)
    println(contaMonica.getSaldo())

    println(contaMonica.transfere(11000.0, contaTalita))
    println(contaTalita.getSaldo())

}
