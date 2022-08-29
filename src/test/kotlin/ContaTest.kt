import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

class ContaTest {

    @Test
    fun `Quando criar uma conta, o valor do saldo não pode ser negativo`() {
        val contaMaria = Conta("Maria", 1000, -100.0)
        assertEquals(contaMaria.getSaldo(), 0.0)
    }

    @Test
    fun `Quando criar uma conta, o valor do saldo deve ser maior ou igual a zero`() {
        val contaMaria = Conta("Maria", 1000, 100.0)
        assertEquals(contaMaria.getSaldo(), 100.0)
    }

    // TODO - Cenario feliz de saldo

    @Test
    fun `Quando o valor depositado for maior que dez mil (10000), deve lançar uma exceção`() {
        val contaMonica = Conta("Monica", 2000, 20000.0)
        assertThrows<IllegalArgumentException> { contaMonica.deposita(11000.0) }
    }

    @Test
    fun `Quando o valor depositado for menor que zero, deve lançar exceção`() {
        val contaMonica = Conta("Monica", 2000, 20000.0)
        assertThrows<IllegalArgumentException> { contaMonica.deposita(-10.0) }
    }

    @Test
    fun `Quando valor depositado for entre zero e dez mil, o valor deve ser adicionado ao saldo da conta`() {
        val contaTalita = Conta("Talita", 3000, 10.0)
        assertTrue(contaTalita.deposita(200.0))
        assertEquals(contaTalita.getSaldo(), 210.0)
    }

    @Test
    fun `Quando o valor de saque for maior que o saldo da conta, deve lançar uma exceção`() {
        val contaMaria = Conta("Maria", 1000, -100.0)
        assertThrows<IllegalArgumentException> { contaMaria.saca(20.0) }
    }

    @Test
    fun `Quando valor de saque for menor que zero, deve lançar uma exceção`() {
        val contaMonica = Conta("Monica", 2000, 20000.0)
        assertThrows<IllegalArgumentException> { contaMonica.saca(-1.0) }
    }

    @Test
    fun `Quando valor de saque for igual que o valor do saldo, deve executar o saque`() {
        val contaTalita = Conta("Talita", 3000, 10.0)
        assertTrue(contaTalita.saca(10.0))
        assertEquals(contaTalita.getSaldo(),0.0)
    }

    @Test
    fun `Quando valor de saque for menor que o valor do saldo, deve executar o saque`() {
        val contaTalita = Conta("Talita", 3000, 10.0)
        assertTrue(contaTalita.saca(5.0))
        assertEquals(contaTalita.getSaldo(), 5.0)
    }

    @Test
    fun `Quando valor da transferência for maior que o valor do saldo, deve lançar uma exceção`() {
        val contaMaria = Conta("Maria", 1000, 10.0)
        val contaTalita = Conta("Talita", 3000, 20.0)
        assertThrows<IllegalArgumentException> { contaMaria.transfere(100.0, contaTalita) }
    }

    @Test
    fun `Quando valor da transferência for maior que dez mil, deve lançar uma exceção`() {
        val contaMonica = Conta("Monica", 2000, 20000.0)
        val contaTalita = Conta("Talita", 3000, 10.0)
        assertThrows<IllegalArgumentException> { contaMonica.transfere(11000.0, contaTalita) }
    }

    @Test
    fun `Quando valor da transferência for negativo, deve lançar uma exceção`() {
        val contaTalita = Conta("Talita", 3000, 10.0)
        val contaMaria = Conta("Maria", 1000, -100.0)
        assertThrows<IllegalArgumentException> { contaTalita.transfere(-200.0, contaMaria) }
    }

    @Test
    fun `Quando valor da transferência for igual ao valor do saldo, deve realizar a transferência`() {
        val contaTalita = Conta("Talita", 3000, 10.0)
        val contaMonica = Conta("Monica", 2000, 20000.0)
        assertTrue(contaTalita.transfere(10.0, contaMonica))
        assertEquals(contaTalita.getSaldo(), 0.0)

    }
    @Test
    fun `Quando valor da transferência for menor que o valor do saldo, deve deve realizar a transferência`() {
        val contaTalita = Conta("Talita", 3000, 500.0)
        val contaMonica = Conta("Monica", 2000, 20000.0)
        assertTrue(contaTalita.transfere(100.0, contaMonica))
        assertEquals(contaTalita.getSaldo(), 400.0)
    }
}