package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.repository.OperatorRepository;

import javax.persistence.EntityManager;

public class OperatorRepositoryImpl extends BaseRepositoryImpl<Operator, Long> implements OperatorRepository {

    public OperatorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Operator> getEntityClass() {
        return Operator.class;
    }
}
