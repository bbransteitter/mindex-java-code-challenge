package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        compensationRepository.insert(compensation);

        return compensation;
    }

    @Override
    public List<Compensation> getCompensationByEmployeeId(String id) {
        LOG.debug("Creating compensation list for employee with id [{}]", id);

        List<Compensation> compensations = compensationRepository.findByEmployeeEmployeeId(id);

        if (compensations == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensations;
    }
    
}
