package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Extra;

@ApplicationScoped
public class ExtraService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Extra createExtra(Extra extra) {
        entityManager.merge(extra);
        return extra;
    }
}
