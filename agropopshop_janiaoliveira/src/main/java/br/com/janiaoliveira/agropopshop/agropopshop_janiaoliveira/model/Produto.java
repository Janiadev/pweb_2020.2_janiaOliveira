package br.com.janiaoliveira.agropopshop.agropopshop_janiaoliveira.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String marca;
	private double altura;
	private double largura;
	private double profundidade;
	private double peso;
	private double preco;

	private Calendar dataCadastro;

	@OneToMany(mappedBy = "produto", cascade = { CascadeType.REMOVE }, targetEntity = Pedido.class)
	private List<Pedido> pedidos;

	public Long getId() {
		return id;
	}

	public BigDecimal getVolumeDoProduto() {
		double volume = altura * largura * profundidade;
		BigDecimal v2 = new BigDecimal(volume);
		return v2.setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getFreteParaMarte() {
		double frete = getPeso() * 123456.00;
		return new BigDecimal(frete).setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getDesconto() {
		double porcentagem = 3.018735 / 100;
		double desconto = preco * (1 - porcentagem);
		return new BigDecimal(desconto).setScale(2, RoundingMode.HALF_EVEN);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
