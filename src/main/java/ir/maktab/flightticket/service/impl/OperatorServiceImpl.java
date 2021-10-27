package ir.maktab.flightticket.service.impl;

import ir.maktab.flightticket.base.service.impl.BaseServiceImpl;
import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.repository.OperatorRepository;
import ir.maktab.flightticket.service.OperatorService;

public class OperatorServiceImpl extends BaseServiceImpl<Operator, Long, OperatorRepository>
        implements OperatorService {

    public OperatorServiceImpl(OperatorRepository repository) {
        super(repository);
    }
}
