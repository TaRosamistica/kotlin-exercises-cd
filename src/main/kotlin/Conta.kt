class Conta (
    val titular: String,
    val numero: Int,
    var saldo: Double)
{
fun deposita (valor: Double) {
    if(valor in 0.0..10.000) {
        this.saldo += valor
    } else throw IllegalArgumentException ("O valor de depósito deve ser entre 1 e 10.000")

}
}