package ir.maktab.flightticket.service.impl;

import ir.maktab.flightticket.base.service.impl.BaseServiceImpl;
import ir.maktab.flightticket.domain.Coupon;
import ir.maktab.flightticket.repository.CouponRepository;
import ir.maktab.flightticket.service.CouponService;

public class CouponServiceImpl extends BaseServiceImpl<Coupon, Long, CouponRepository> implements CouponService {

    public CouponServiceImpl(CouponRepository repository) {
        super(repository);
    }

    @Override
    public Coupon findCouponByCode(String code) {
        return repository.findCouponByCode(code);
    }
}
