package ir.maktab.flightticket.service.impl;

import ir.maktab.flightticket.base.service.impl.BaseServiceImpl;
import ir.maktab.flightticket.domain.Admin;
import ir.maktab.flightticket.repository.AdminRepository;
import ir.maktab.flightticket.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository>
        implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
}
