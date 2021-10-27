package ir.maktab.flightticket.service;

import ir.maktab.flightticket.base.service.BaseService;
import ir.maktab.flightticket.domain.Coupon;

public interface CouponService extends BaseService<Coupon, Long> {

    Coupon findCouponByCode(String code);
}
