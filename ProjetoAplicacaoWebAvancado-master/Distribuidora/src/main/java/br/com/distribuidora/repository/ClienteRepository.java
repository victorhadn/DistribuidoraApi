/**
 * 
 */
package br.com.distribuidora.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidora.mode.Cliente;

/**
 * @author victorhadn
 *
 */


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
