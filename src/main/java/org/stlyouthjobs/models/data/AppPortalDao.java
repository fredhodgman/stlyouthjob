package org.stlyouthjobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stlyouthjobs.models.AppPortal;


import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppPortalDao extends CrudRepository<AppPortal, Integer> {
}