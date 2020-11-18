
package br.com.distribuidora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidora.mode.Produto;

/**
 * @author victorhadn
 *
 */


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
