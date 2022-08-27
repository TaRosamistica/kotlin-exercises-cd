class Conta(val titular: String, val numero: Int, saldo: Double) {
    private var saldo: Double = if (saldo > 0) saldo else 0.0
    var valorLimiteTransacao = 10000.0

    fun getSaldo(): Double {
        return this.saldo
    }

    fun deposita(valor: Double): Boolean {
        //if (valor > valorLimiteTransacao) {
        if (valor <= 0 || valor > 10000) {
            throw IllegalArgumentException("O valor de depósito deve ser entre 1 e 10000.0")
        } else {
            this.saldo += valor
            return true
        }

    }

    fun saca(valor: Double): Boolean {
        if (saldo < valor) {
            throw IllegalArgumentException("Saldo insuficiente")
        } else if (valor < 0) {
            throw IllegalArgumentException("Valor incorreto")
        } else {
            saldo -= valor
            return true
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        this.saca(valor)
        destino.deposita(valor)
        return true
    }

    override fun toString(): String {
        return "Número da conta: $numero, Titular: $titular, Saldo: $saldo"
    }

}