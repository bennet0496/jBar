package net.bgde.jbar.core;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializerInvoker implements ApplicationRunner {
    private final List<DataInitializer> dataInitializerList;

    public DataInitializerInvoker(List<DataInitializer> dataInitializerList) {
        this.dataInitializerList = dataInitializerList;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dataInitializerList.forEach(DataInitializer::initialize);
    }

    @Component
    static class NoOpDataInitializer implements DataInitializer {

        @Override
        public void initialize() {}
    }
}
