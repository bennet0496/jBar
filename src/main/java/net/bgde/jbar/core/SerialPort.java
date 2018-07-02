package net.bgde.jbar.core;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import net.bgde.jbar.core.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;

@Scope(value = "singleton")
@Component
public class SerialPort {
    private final Configuration configuration;

    private CommPort commPort;

    private PrintStream printStream;

    private BufferedReader bufferedReader;

    @Autowired
    public SerialPort(Configuration configuration) {
        this.configuration = configuration;
    }

    public void connect() throws Exception{
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(configuration.getSerialPortName());
        if(portIdentifier.isCurrentlyOwned()){
            throw new SerialPortCurrentlyUsedException("Error: Port is currently in use");
        }
        CommPort commPort = portIdentifier.open(SerialPort.class.getName(), 2000);

        if(commPort instanceof gnu.io.SerialPort){
            gnu.io.SerialPort serialPort = ((gnu.io.SerialPort) commPort);
            serialPort.setSerialPortParams(configuration.getSerialPortBaudRate(), gnu.io.SerialPort.DATABITS_8, gnu.io.SerialPort.STOPBITS_1, gnu.io.SerialPort.PARITY_NONE);

            printStream = new PrintStream(serialPort.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

        } else {
            throw new Exception("commPort is not an SerialPort instance!");
        }
    }

    public void close() throws IOException {
        printStream.close();
        printStream = null;

        bufferedReader.close();
        bufferedReader = null;

        commPort.close();
        commPort = null;
    }

    public boolean connected() {
        return commPort != null;
    }

    public PrintStream out(){
        return printStream;
    }

    public BufferedReader in() {
        return bufferedReader;
    }

    private class SerialPortCurrentlyUsedException extends IOException {
        public SerialPortCurrentlyUsedException() {
            super();
        }

        public SerialPortCurrentlyUsedException(String message) {
            super(message);
        }

        public SerialPortCurrentlyUsedException(String message, Throwable cause) {
            super(message, cause);
        }

        public SerialPortCurrentlyUsedException(Throwable cause) {
            super(cause);
        }
    }
}
