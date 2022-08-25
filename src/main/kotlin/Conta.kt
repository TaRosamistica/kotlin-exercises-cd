class Conta (val titular: String, val numero: Int, saldo: Double){
    private var saldo: Double = if (saldo > 0) saldo else 0.0

fun getSaldo(): Double {
    return this.saldo
}

fun deposita (valor: Double) {
    if(valor in 0.0..10000.0) {
        this.saldo += valor
    } else throw IllegalArgumentException ("O valor de depósito deve ser entre 1 e 10000.0")

}
fun saca (valor: Double) {
    if (saldo >= valor) {
        saldo -= valor
    } else {
        throw IllegalArgumentException("Saldo insuficiente")
    }
}

fun transfere(valor: Double, destino: Conta): Double{
    try {
        this.saca(valor)
        destino.deposita(valor)
        return this.saldo
    } catch (e: IllegalArgumentException) {
        return this.saldo
    }

}

}






