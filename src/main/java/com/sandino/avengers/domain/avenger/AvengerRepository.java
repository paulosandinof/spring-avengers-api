package com.sandino.avengers.domain.avenger;

import java.util.List;
import java.util.Optional;

public interface AvengerRepository {
    public Optional<Avenger> getDetail(long id);
    public List<Avenger> getAvengers();
    public Avenger create(Avenger avenger);
    public void delete(long id);
    public Avenger update(Avenger avenger);
}
