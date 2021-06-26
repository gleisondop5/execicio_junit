package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubDoisNumeros() {
		int sub = calc.subtracao(10, 4);		
		assertEquals(6, sub);		
	}
	
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiDoisNumeros() {
		int multi = calc.multiplicacao(2, 9);		
		assertEquals(18, multi);		
	}
	
	@Test
	@DisplayName("Testa a divisão de dois números")
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	@DisplayName("Testa se a divisão é por zero")
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa somario de 0 até n")
	@Test
	public void testSomatoria() {
		int somatorio = calc.somatoria(10);	
		int soma = 0;
		for (int i = 0; i <= 10; i++) {
			soma += i;
		}
		assertEquals(soma, somatorio);		
	}
	
	@DisplayName("Testa se um número é positivo")
	@Test
	public void testEhPositivo() {
		boolean ehPositivo = calc.ehPositivo(10);	
		assertTrue(ehPositivo);		
	}
	
	@DisplayName("Testa se dois números são iguais")
	@Test
	public void testComparaIgual() {
		int igual = calc.compara(10, 10);	
		assertEquals(0, igual);		
	}
	
	@DisplayName("Testa se um número é maior que o outro")
	@Test
	public void testComparaMaior() {
		int igual = calc.compara(11, 10);	
		assertEquals(1, igual);		
	}
	
	@DisplayName("Testa se um número é menor que o outro")
	@Test
	public void testComparaMenor() {
		int igual = calc.compara(9, 10);	
		assertEquals(-1, igual);		
	}
}
