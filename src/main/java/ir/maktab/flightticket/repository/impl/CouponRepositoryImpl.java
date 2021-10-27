package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.Coupon;
import ir.maktab.flightticket.repository.CouponRepository;

import javax.persistence.EntityManager;

public class CouponRepositoryImpl extends BaseRepositoryImpl<Coupon, Long> implements CouponRepository {

    public CouponRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Coupon> getEntityClass() {
        return Coupon.class;
    }

    @Override
    public Coupon findCouponByCode(String code) {
        return entityManager.createQuery("from Coupon where code = :code", Coupon.class)
                .setParameter("code", code).getSingleResult();
    }
}
