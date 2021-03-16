package com.github.normalitybytes.training.rest.repository;

import com.github.normalitybytes.training.rest.model.TimeSlot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class TimeSlotRepository {

    final Map<UUID, TimeSlot> data = new HashMap<>();

    public TimeSlot saveOne(TimeSlot item) {
        if (item == null) throw new NullPointerException("Item required");
        return data.put(item.getId(), item);
    }

    public TimeSlot deleteOne(TimeSlot item) {
        return deleteOne(item.getId());
    }

    public TimeSlot deleteOne(UUID id) {
        return data.remove(id);
    }

    public Optional<TimeSlot> findOne(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<TimeSlot> findAll() {
        return new ArrayList<>(data.values());
    }

    public boolean contains(UUID id) {
        return data.containsKey(id);
    }

}
