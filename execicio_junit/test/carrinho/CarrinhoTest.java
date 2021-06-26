package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	
	Carrinho carrinho;
	private ArrayList items;
	Produto arroz = new Produto("Arroz integral", 20.00);
	Produto feijao = new Produto("Feijão carioca", 12.00);
	Produto acucar = new Produto("Açucar demerara", 8.00);
	Produto farinha = new Produto("Farinha de trigo", 5.00);
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		items = new ArrayList();
		carrinho.addItem(arroz);
		items.add(arroz);
		carrinho.addItem(feijao);
		items.add(feijao);
		carrinho.addItem(acucar);
		items.add(acucar);
	}
	
	@DisplayName("Testa o valor total do carrinho")
	@Test
	public void testValorTotal() {
		double total = carrinho.getValorTotal();	
		int tamanho = items.size();
		double vTotal = 0;
		for (int i = 0; i < tamanho; i++) {
			Produto item = (Produto) items.get(i);
			vTotal += item.getPreco();
		}		
		assertEquals(vTotal, total);		
	}
	
	@DisplayName("Testa add item no carrinho")
	@Test
	public void testAddItem() {
		int tamInicial = carrinho.getQtdeItems();
		carrinho.addItem(farinha);
		int tamFinal = carrinho.getQtdeItems();		
		assertEquals(tamInicial, tamFinal - 1);		
	}
	
	@DisplayName("Testa remover item do carrinho")
	@Test
	public void testRemoveItem() throws ProdutoNaoEncontradoException {
		try {
			int tamInicial = carrinho.getQtdeItems();
			carrinho.removeItem(farinha);
			int tamFinal = carrinho.getQtdeItems();		
			assertEquals(tamInicial, tamFinal + 1);	
		}catch (ProdutoNaoEncontradoException e) {
			assertEquals(null, e.getMessage());
		}
	}
	
	@DisplayName("Testa a quantidade de itens no carrinho")
	@Test
	public void testGetQtdeItems() {
		int tamCarrinho = carrinho.getQtdeItems();
		int tamItems = items.size();		
		assertEquals(tamCarrinho, tamItems);		
	}
	
	@DisplayName("Testa esvaziar carrinho")
	@Test
	public void testEsvazia() {
		carrinho.esvazia();
		int tamCarrinho = carrinho.getQtdeItems();		
		assertEquals(0, tamCarrinho);		
	}
}
