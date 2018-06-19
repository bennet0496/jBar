package net.bgde.jbar.core;

import javax.transaction.Transactional;

public interface DataInitializer {
    @Transactional
    void initialize();
}
