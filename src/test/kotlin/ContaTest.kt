import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ContaTest {

    private lateinit var contaTalita: Conta
    private lateinit var contaMonica: Conta
    private lateinit var contaNegativa: Conta

    // TODO - Verificar organizacao de testes por cenario

    @BeforeEach
    fun setUp() {
        contaTalita = Conta("Talita", 0, 10.0)
        contaMonica = Conta("Monica", 0, 20000.0)
        contaNegativa = Conta("Maria", 0, -100.0)
    }

    @Test
    fun getSaldo() {
        assertEquals(contaTalita.getSaldo(), 10.0)
        assertEquals(contaMonica.getSaldo(), 20000.0)
        assertEquals(contaNegativa.getSaldo(), 0.0)

    }

    @Test
    fun deposita() {
        assertThrows<IllegalArgumentException> { contaMonica.deposita(11000.0) }
        assertThrows<IllegalArgumentException> { contaMonica.deposita(-10.0) }
        assertTrue(contaMonica.deposita(10.0))
    }

    @Test
    fun saca() {
        assertEquals(contaMonica.getSaldo(), 20000.0)
        assertThrows<IllegalArgumentException> { contaMonica.saca(-1.0) }
        assertEquals(contaMonica.getSaldo(), 20000.0)

        assertThrows<IllegalArgumentException> { contaNegativa.saca(10.0) }
        assertEquals(contaNegativa.getSaldo(), 0.0)

        assertTrue(contaTalita.saca(10.0))
        assertEquals(contaTalita.getSaldo(), 0.0)
    }

    @Test
    fun transfere() {
        assertEquals(contaTalita.getSaldo(), 10.0)
        assertEquals(contaMonica.getSaldo(), 20000.0)
        assertTrue(contaTalita.transfere(10.0, contaMonica))
        assertEquals(contaTalita.getSaldo(), 0.0)
        assertEquals(contaMonica.getSaldo(), 20010.0)

        assertTrue(contaMonica.transfere(10000.0, contaTalita))
        assertEquals(contaMonica.getSaldo(), 10010.0)
        assertEquals(contaTalita.getSaldo(), 10000.0)

        assertThrows<IllegalArgumentException> { contaMonica.transfere(10010.0, contaTalita) }
        assertThrows<IllegalArgumentException> { contaNegativa.transfere(100.0, contaTalita) }
        assertThrows<IllegalArgumentException> { contaNegativa.transfere(-100.0, contaTalita) }
    }

}