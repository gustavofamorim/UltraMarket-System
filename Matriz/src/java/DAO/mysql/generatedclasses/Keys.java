/**
 * This class is generated by jOOQ
 */
package DAO.mysql.generatedclasses;


import DAO.mysql.generatedclasses.tables.Cliente;
import DAO.mysql.generatedclasses.tables.Filial;
import DAO.mysql.generatedclasses.tables.FilialProduto;
import DAO.mysql.generatedclasses.tables.Itemvenda;
import DAO.mysql.generatedclasses.tables.Produto;
import DAO.mysql.generatedclasses.tables.Venda;
import DAO.mysql.generatedclasses.tables.records.ClienteRecord;
import DAO.mysql.generatedclasses.tables.records.FilialProdutoRecord;
import DAO.mysql.generatedclasses.tables.records.FilialRecord;
import DAO.mysql.generatedclasses.tables.records.ItemvendaRecord;
import DAO.mysql.generatedclasses.tables.records.ProdutoRecord;
import DAO.mysql.generatedclasses.tables.records.VendaRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>matrizdb</code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final Identity<ClienteRecord, Integer> IDENTITY_CLIENTE = Identities0.IDENTITY_CLIENTE;
	public static final Identity<FilialRecord, Integer> IDENTITY_FILIAL = Identities0.IDENTITY_FILIAL;
	public static final Identity<ProdutoRecord, Integer> IDENTITY_PRODUTO = Identities0.IDENTITY_PRODUTO;
	public static final Identity<VendaRecord, Integer> IDENTITY_VENDA = Identities0.IDENTITY_VENDA;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<ClienteRecord> KEY_CLIENTE_PRIMARY = UniqueKeys0.KEY_CLIENTE_PRIMARY;
	public static final UniqueKey<ClienteRecord> KEY_CLIENTE_CPF_UNIQUE = UniqueKeys0.KEY_CLIENTE_CPF_UNIQUE;
	public static final UniqueKey<FilialRecord> KEY_FILIAL_PRIMARY = UniqueKeys0.KEY_FILIAL_PRIMARY;
	public static final UniqueKey<FilialProdutoRecord> KEY_FILIAL_PRODUTO_PRIMARY = UniqueKeys0.KEY_FILIAL_PRODUTO_PRIMARY;
	public static final UniqueKey<ItemvendaRecord> KEY_ITEMVENDA_PRIMARY = UniqueKeys0.KEY_ITEMVENDA_PRIMARY;
	public static final UniqueKey<ProdutoRecord> KEY_PRODUTO_PRIMARY = UniqueKeys0.KEY_PRODUTO_PRIMARY;
	public static final UniqueKey<VendaRecord> KEY_VENDA_PRIMARY = UniqueKeys0.KEY_VENDA_PRIMARY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<FilialProdutoRecord, FilialRecord> FK_FILIAL_HAS_PRODUTO_FILIAL1 = ForeignKeys0.FK_FILIAL_HAS_PRODUTO_FILIAL1;
	public static final ForeignKey<FilialProdutoRecord, ProdutoRecord> FK_FILIAL_HAS_PRODUTO_PRODUTO1 = ForeignKeys0.FK_FILIAL_HAS_PRODUTO_PRODUTO1;
	public static final ForeignKey<ItemvendaRecord, VendaRecord> FK_VENDA_HAS_PRODUTO_VENDA = ForeignKeys0.FK_VENDA_HAS_PRODUTO_VENDA;
	public static final ForeignKey<ItemvendaRecord, ProdutoRecord> FK_VENDA_HAS_PRODUTO_PRODUTO1 = ForeignKeys0.FK_VENDA_HAS_PRODUTO_PRODUTO1;
	public static final ForeignKey<VendaRecord, ClienteRecord> FK_VENDA_CLIENTE1 = ForeignKeys0.FK_VENDA_CLIENTE1;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends AbstractKeys {
		public static Identity<ClienteRecord, Integer> IDENTITY_CLIENTE = createIdentity(Cliente.CLIENTE, Cliente.CLIENTE.IDCLIENTE);
		public static Identity<FilialRecord, Integer> IDENTITY_FILIAL = createIdentity(Filial.FILIAL, Filial.FILIAL.IDFILIAL);
		public static Identity<ProdutoRecord, Integer> IDENTITY_PRODUTO = createIdentity(Produto.PRODUTO, Produto.PRODUTO.IDPRODUTO);
		public static Identity<VendaRecord, Integer> IDENTITY_VENDA = createIdentity(Venda.VENDA, Venda.VENDA.IDVENDA);
	}

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<ClienteRecord> KEY_CLIENTE_PRIMARY = createUniqueKey(Cliente.CLIENTE, Cliente.CLIENTE.IDCLIENTE);
		public static final UniqueKey<ClienteRecord> KEY_CLIENTE_CPF_UNIQUE = createUniqueKey(Cliente.CLIENTE, Cliente.CLIENTE.CPF);
		public static final UniqueKey<FilialRecord> KEY_FILIAL_PRIMARY = createUniqueKey(Filial.FILIAL, Filial.FILIAL.IDFILIAL);
		public static final UniqueKey<FilialProdutoRecord> KEY_FILIAL_PRODUTO_PRIMARY = createUniqueKey(FilialProduto.FILIAL_PRODUTO, FilialProduto.FILIAL_PRODUTO.IDFILIAL, FilialProduto.FILIAL_PRODUTO.IDPRODUTO);
		public static final UniqueKey<ItemvendaRecord> KEY_ITEMVENDA_PRIMARY = createUniqueKey(Itemvenda.ITEMVENDA, Itemvenda.ITEMVENDA.VENDA_IDVENDA, Itemvenda.ITEMVENDA.PRODUTO_IDPRODUTO);
		public static final UniqueKey<ProdutoRecord> KEY_PRODUTO_PRIMARY = createUniqueKey(Produto.PRODUTO, Produto.PRODUTO.IDPRODUTO);
		public static final UniqueKey<VendaRecord> KEY_VENDA_PRIMARY = createUniqueKey(Venda.VENDA, Venda.VENDA.IDVENDA, Venda.VENDA.IDCIENTE);
	}

	private static class ForeignKeys0 extends AbstractKeys {
		public static final ForeignKey<FilialProdutoRecord, FilialRecord> FK_FILIAL_HAS_PRODUTO_FILIAL1 = createForeignKey(DAO.mysql.generatedclasses.Keys.KEY_FILIAL_PRIMARY, FilialProduto.FILIAL_PRODUTO, FilialProduto.FILIAL_PRODUTO.IDFILIAL);
		public static final ForeignKey<FilialProdutoRecord, ProdutoRecord> FK_FILIAL_HAS_PRODUTO_PRODUTO1 = createForeignKey(DAO.mysql.generatedclasses.Keys.KEY_PRODUTO_PRIMARY, FilialProduto.FILIAL_PRODUTO, FilialProduto.FILIAL_PRODUTO.IDPRODUTO);
		public static final ForeignKey<ItemvendaRecord, VendaRecord> FK_VENDA_HAS_PRODUTO_VENDA = createForeignKey(DAO.mysql.generatedclasses.Keys.KEY_VENDA_PRIMARY, Itemvenda.ITEMVENDA, Itemvenda.ITEMVENDA.VENDA_IDVENDA);
		public static final ForeignKey<ItemvendaRecord, ProdutoRecord> FK_VENDA_HAS_PRODUTO_PRODUTO1 = createForeignKey(DAO.mysql.generatedclasses.Keys.KEY_PRODUTO_PRIMARY, Itemvenda.ITEMVENDA, Itemvenda.ITEMVENDA.PRODUTO_IDPRODUTO);
		public static final ForeignKey<VendaRecord, ClienteRecord> FK_VENDA_CLIENTE1 = createForeignKey(DAO.mysql.generatedclasses.Keys.KEY_CLIENTE_PRIMARY, Venda.VENDA, Venda.VENDA.IDCIENTE);
	}
}
