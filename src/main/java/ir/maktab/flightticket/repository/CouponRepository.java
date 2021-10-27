package ir.maktab.flightticket.repository;

import ir.maktab.flightticket.base.repository.BaseRepository;
import ir.maktab.flightticket.domain.Coupon;

public interface CouponRepository extends BaseRepository<Coupon, Long> {

    Coupon findCouponByCode(String code);
}
