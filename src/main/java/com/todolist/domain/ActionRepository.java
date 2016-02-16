package com.todolist.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by elena on 06.02.16.
 */
public interface ActionRepository extends PagingAndSortingRepository<Action, Long> {
    Page<Action> findByIsMade(Pageable pageable, Boolean isMade);

}
