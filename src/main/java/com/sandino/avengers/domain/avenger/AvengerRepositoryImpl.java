package com.sandino.avengers.domain.avenger;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import com.sandino.avengers.resource.avenger.AvengerEntity;
import com.sandino.avengers.resource.avenger.AvengerEntityRepository;

import org.springframework.stereotype.Component;

@Component
public class AvengerRepositoryImpl implements AvengerRepository {

    private AvengerEntityRepository repository;

    public AvengerRepositoryImpl(AvengerEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Avenger> getDetail(long id) {
        return repository.findById(id).map(AvengerEntity::toAvenger);
    }

    @Override
    public List<Avenger> getAvengers() {
        return repository.findAll().stream().map(AvengerEntity::toAvenger).collect(toList());
    }

    @Override
    public Avenger create(Avenger avenger) {
        return repository.save(AvengerEntity.from(avenger)).toAvenger();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Avenger update(Avenger avenger) {
        return repository.save(AvengerEntity.from(avenger)).toAvenger();
    }

}
