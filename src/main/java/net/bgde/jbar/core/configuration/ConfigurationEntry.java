package net.bgde.jbar.core.configuration;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class ConfigurationEntry {
    @Id
    private String name;

    @Embedded
    private Object value;

    @Deprecated
    private ConfigurationEntry() {
    }

    public ConfigurationEntry(String name, Object value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
