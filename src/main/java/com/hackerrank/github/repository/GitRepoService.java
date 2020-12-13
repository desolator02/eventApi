package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GitRepoService extends CrudRepository<Event,Long> {

    List<Event> findAll();

    List<Event> findByActorId(Long id);

    List<Event> findByRepoId(Long id);

}
