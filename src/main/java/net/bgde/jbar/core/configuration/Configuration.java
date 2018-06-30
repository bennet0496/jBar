package net.bgde.jbar.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class Configuration {
    private final ConfigurationRepository configurationRepository;

    @Autowired
    public Configuration(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public String getSerialPortName() {
        return (String) configurationRepository.findByName("SerialPortName")
                .map(ConfigurationEntry::getValue)
                .orElse("/dev/ttyS0");
    }

    public void setSerialPortName(String portName){
        ConfigurationEntry c = configurationRepository.findByName("SerialPortName")
                .orElse(new ConfigurationEntry("SerialPortName", portName));

        c.setValue(portName);
        configurationRepository.save(c);
    }

    public int getSerialPortBaudRate() {
        return (int) configurationRepository.findByName("SerialPortBaudRate")
                .map(ConfigurationEntry::getValue)
                .orElse(9600);
    }

    public void setSerialPortBaudRate(int baudRate){
        ConfigurationEntry c = configurationRepository.findByName("SerialPortBaudRate")
                .orElse(new ConfigurationEntry("SerialPortBaudRate", baudRate));

        c.setValue(baudRate);
        configurationRepository.save(c);
    }
}
