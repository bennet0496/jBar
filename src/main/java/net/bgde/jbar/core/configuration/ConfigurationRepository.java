package net.bgde.jbar.core.configuration;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface ConfigurationRepository extends CrudRepository<ConfigurationEntry, String> {
    @Override
    <S extends ConfigurationEntry> S save(S entity);

    @Override
    <S extends ConfigurationEntry> Iterable<S> saveAll(Iterable<S> entities);


    Optional<ConfigurationEntry> findByName(String s);

    boolean existsByName(String s);

    @Override
    Iterable<ConfigurationEntry> findAll();


    Iterable<ConfigurationEntry> findAllByName(Iterable<String> strings);

    @Override
    long count();

    void deleteByName(String s);

    @Override
    void delete(ConfigurationEntry entity);

    @Override
    void deleteAll(Iterable<? extends ConfigurationEntry> entities);

    @Override
    void deleteAll();
}
