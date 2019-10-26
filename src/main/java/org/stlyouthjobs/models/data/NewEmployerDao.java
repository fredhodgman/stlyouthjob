package org.stlyouthjobs.models.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.stlyouthjobs.models.NewEmployer;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NewEmployerDao extends CrudRepository<NewEmployer, Integer> {
}