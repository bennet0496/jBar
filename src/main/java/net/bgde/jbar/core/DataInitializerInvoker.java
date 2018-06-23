package net.bgde.jbar.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializerInvoker implements ApplicationRunner {
    private final List<DataInitializer> dataInitializerList;
    private static final Logger logger = LoggerFactory.getLogger(DataInitializerInvoker.class);

    @Autowired
    public DataInitializerInvoker(List<DataInitializer> dataInitializerList) {
        this.dataInitializerList = dataInitializerList;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info(String.format("Running %d DataInitializers", (long) dataInitializerList.size()));
        dataInitializerList.forEach(DataInitializer::initialize);
    }

    @Component
    static class NoOpDataInitializer implements DataInitializer {

        @Override
        public void initialize() {}
    }
}
