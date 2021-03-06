/**
 * This class is generated by jOOQ
 */
package DAO.mysql.generatedclasses.tables.records;


import DAO.mysql.generatedclasses.tables.Itemvenda;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ItemvendaRecord extends UpdatableRecordImpl<ItemvendaRecord> implements Record4<Integer, Integer, Integer, Double> {

	private static final long serialVersionUID = 554975817;

	/**
	 * Setter for <code>matrizdb.itemvenda.Venda_idVenda</code>.
	 */
	public void setVendaIdvenda(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>matrizdb.itemvenda.Venda_idVenda</code>.
	 */
	public Integer getVendaIdvenda() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>matrizdb.itemvenda.Produto_idProduto</code>.
	 */
	public void setProdutoIdproduto(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>matrizdb.itemvenda.Produto_idProduto</code>.
	 */
	public Integer getProdutoIdproduto() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>matrizdb.itemvenda.qtd</code>.
	 */
	public void setQtd(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>matrizdb.itemvenda.qtd</code>.
	 */
	public Integer getQtd() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>matrizdb.itemvenda.total</code>.
	 */
	public void setTotal(Double value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>matrizdb.itemvenda.total</code>.
	 */
	public Double getTotal() {
		return (Double) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record2<Integer, Integer> key() {
		return (Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Integer, Integer, Double> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Integer, Integer, Double> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Itemvenda.ITEMVENDA.VENDA_IDVENDA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Itemvenda.ITEMVENDA.PRODUTO_IDPRODUTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Itemvenda.ITEMVENDA.QTD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field4() {
		return Itemvenda.ITEMVENDA.TOTAL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getVendaIdvenda();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getProdutoIdproduto();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getQtd();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value4() {
		return getTotal();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemvendaRecord value1(Integer value) {
		setVendaIdvenda(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemvendaRecord value2(Integer value) {
		setProdutoIdproduto(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemvendaRecord value3(Integer value) {
		setQtd(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemvendaRecord value4(Double value) {
		setTotal(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemvendaRecord values(Integer value1, Integer value2, Integer value3, Double value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ItemvendaRecord
	 */
	public ItemvendaRecord() {
		super(Itemvenda.ITEMVENDA);
	}

	/**
	 * Create a detached, initialised ItemvendaRecord
	 */
	public ItemvendaRecord(Integer vendaIdvenda, Integer produtoIdproduto, Integer qtd, Double total) {
		super(Itemvenda.ITEMVENDA);

		setValue(0, vendaIdvenda);
		setValue(1, produtoIdproduto);
		setValue(2, qtd);
		setValue(3, total);
	}
}
