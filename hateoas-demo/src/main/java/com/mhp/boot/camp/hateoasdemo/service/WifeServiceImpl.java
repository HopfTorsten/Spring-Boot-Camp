package com.mhp.boot.camp.hateoasdemo.service;

import com.mhp.boot.camp.hateoasdemo.repo.Wife;
import com.mhp.boot.camp.hateoasdemo.repo.WifeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@Service
public class WifeServiceImpl implements WifeService {

    private final WifeRepo wifeRepo;


    public WifeServiceImpl(@Autowired WifeRepo wifeRepo) {
        this.wifeRepo = wifeRepo;
    }

    @PostConstruct
    public void generateSomeEntries() {
        Wife wife1 = new Wife();
        wife1.setAge(23);
        wife1.setBreastSize("DD");
        wife1.setNickName("Wilde Hilde");
        wifeRepo.save(wife1);

        Wife wife2 = new Wife();
        wife2.setAge(18);
        wife2.setBreastSize("C");
        wife2.setNickName("Gelangweilte Heidi");

        wifeRepo.save(wife2);

    }

    @Override
    public Wife findWifeById(@NotNull Integer id) {
        return wifeRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Iterable<Wife> findAllWifes() {
        return wifeRepo.findAll();
    }

    @Override
    public Wife saveOrUpdate(Wife wife) {
        return wifeRepo.save(wife);
    }

    @Override
    public void deleteWife(Integer id) {
        wifeRepo.deleteById(id);
    }

}
