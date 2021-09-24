package net.openu.graphql.service;

import org.springframework.stereotype.Service;

@Service
public class LocalIpCheckServiceImpl implements IpCheckService {

    @Override
    public String checkProfiles() {
        System.out.println("LOCAL");
        return "LOCAL";
    }
}
