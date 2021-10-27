package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.Admin;
import ir.maktab.flightticket.repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
