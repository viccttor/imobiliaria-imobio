package br.com.imobio.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, B> {

    List<T> listAll();

    Optional<T> findById(Long id);

    T create( B request);
    T save(T entity);

    T delete(Long id);

}
