package com.github.normalitybytes.training.rest.repository;

import com.github.normalitybytes.training.rest.model.Cinema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class CinemaRepository {

    final Map<UUID, Cinema> data = new HashMap<>();

    public Cinema saveOne(Cinema item) {
        if (item == null) throw new NullPointerException("Item required");
        return data.put(item.getId(), item);
    }

    public Cinema deleteOne(Cinema item) {
        return deleteOne(item.getId());
    }

    public Cinema deleteOne(UUID id) {
        return data.remove(id);
    }

    public Optional<Cinema> findOne(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Cinema> findAll() {
        return new ArrayList<>(data.values());
    }

    public boolean contains(UUID id) {
        return data.containsKey(id);
    }

}
