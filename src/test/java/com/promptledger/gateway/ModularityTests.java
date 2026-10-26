package com.promptledger.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityTests {

    ApplicationModules modules = ApplicationModules.of(GatewayApplication.class);

    @Test
    void verifiesModularStructure() {
        modules.forEach(System.out::println);
        modules.verify();
    }
}
