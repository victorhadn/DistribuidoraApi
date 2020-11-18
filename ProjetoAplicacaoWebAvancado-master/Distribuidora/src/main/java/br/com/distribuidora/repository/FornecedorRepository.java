/**
 * 
 */
package br.com.distribuidora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidora.mode.Fornecedor;

/**
 * @author victorhadn
 *
 */
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
