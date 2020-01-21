package com.mhp.beansdemo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
class TalkativeService {

    private final List<Integer> myList = new LinkedList<>();

    @Autowired
    private Logger logger;

    @PostConstruct
    public void init() {
        myList.add(5);
        myList.add(187);
        myList.add(4711);
        myList.add(33);
        logger.error("Look who's in da house");
        System.out.println("Look at my List, my list is amazing " + myList);
    }

    @PreDestroy
    public void die() {
        Collections.reverse(myList);
        System.out.println("Look at my List, my list was amazing " + myList);

    }

}
