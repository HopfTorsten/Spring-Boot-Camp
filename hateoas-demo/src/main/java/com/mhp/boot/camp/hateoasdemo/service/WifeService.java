package com.mhp.boot.camp.hateoasdemo.service;

import com.mhp.boot.camp.hateoasdemo.repo.Wife;

import javax.validation.constraints.NotNull;

public interface WifeService {
    Wife findWifeById(@NotNull Integer id);

    Iterable<Wife> findAllWifes();

    Wife saveOrUpdate(Wife wife);

    void deleteWife(Integer id);
}
