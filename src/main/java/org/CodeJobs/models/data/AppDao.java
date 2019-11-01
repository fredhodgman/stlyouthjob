package org.CodeJobs.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.CodeJobs.models.App;

@Repository
@Transactional
public interface AppDao extends CrudRepository <App, Integer> {
}