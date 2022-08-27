fun main (){

val contaTalita: Conta = Conta("Talita", 1000, 100.0)
    println(contaTalita)

    contaTalita.deposita(200.0)
    println("Depósito recebido. Novo saldo da conta de ${contaTalita.titular} é de ${contaTalita.getSaldo()}")

    contaTalita.saca(100.00)
    println("Saque realizado. Novo saldo da conta de ${contaTalita.titular} é de ${contaTalita.getSaldo()}")

val contaMonica: Conta = Conta("Monica", 2000, 20000.0)

    contaMonica.transfere(9000.0, contaTalita)
    println("Saldo da conta da  ${contaTalita.titular} após receber transferência é de ${contaTalita.getSaldo()}")
    println("Saldo da conta  da ${contaMonica.titular} após realizar transferência é  de ${contaMonica.getSaldo()}")

}
