package net.openu.graphql.service;

import org.springframework.stereotype.Service;

@Service
public class ProductIpCheckServiceImpl implements IpCheckService {

    @Override
    public String checkProfiles() {
        return "PRODUCT";

    }
}
