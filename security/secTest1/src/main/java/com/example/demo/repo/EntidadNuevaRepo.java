/**
 * 
 */
package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EntidadNueva;

/**
 * @author Emmanuel Neiza
 *
 */
public interface EntidadNuevaRepo extends JpaRepository<EntidadNueva, Integer> {

}
