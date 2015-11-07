/**
 * This class is generated by jOOQ
 */
package DAO.mysql.generatedclasses.tables;


import DAO.mysql.generatedclasses.Keys;
import DAO.mysql.generatedclasses.Matrizdb;
import DAO.mysql.generatedclasses.tables.records.ProdutoRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Produto extends TableImpl<ProdutoRecord> {

	private static final long serialVersionUID = 1299962479;

	/**
	 * The reference instance of <code>matrizdb.produto</code>
	 */
	public static final Produto PRODUTO = new Produto();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ProdutoRecord> getRecordType() {
		return ProdutoRecord.class;
	}

	/**
	 * The column <code>matrizdb.produto.idProduto</code>.
	 */
	public final TableField<ProdutoRecord, Integer> IDPRODUTO = createField("idProduto", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>matrizdb.produto.nome</code>.
	 */
	public final TableField<ProdutoRecord, String> NOME = createField("nome", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>matrizdb.produto.valor</code>.
	 */
	public final TableField<ProdutoRecord, Double> VALOR = createField("valor", org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

	/**
	 * The column <code>matrizdb.produto.apagado</code>.
	 */
	public final TableField<ProdutoRecord, Byte> APAGADO = createField("apagado", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

	/**
	 * Create a <code>matrizdb.produto</code> table reference
	 */
	public Produto() {
		this("produto", null);
	}

	/**
	 * Create an aliased <code>matrizdb.produto</code> table reference
	 */
	public Produto(String alias) {
		this(alias, PRODUTO);
	}

	private Produto(String alias, Table<ProdutoRecord> aliased) {
		this(alias, aliased, null);
	}

	private Produto(String alias, Table<ProdutoRecord> aliased, Field<?>[] parameters) {
		super(alias, Matrizdb.MATRIZDB, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ProdutoRecord, Integer> getIdentity() {
		return Keys.IDENTITY_PRODUTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ProdutoRecord> getPrimaryKey() {
		return Keys.KEY_PRODUTO_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ProdutoRecord>> getKeys() {
		return Arrays.<UniqueKey<ProdutoRecord>>asList(Keys.KEY_PRODUTO_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Produto as(String alias) {
		return new Produto(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Produto rename(String name) {
		return new Produto(name, null);
	}
}
