package com.mhp.snippetsdemo;

public class NoInversionOfControl {


    private final Service mySmartService = new ServiceImpl();

    public void doSomething() {

    }


    protected interface Service {
        void doSomethingSmart();
    }

    protected class ServiceImpl implements Service {

        @Override
        public void doSomethingSmart() {

            System.out.println("I am Groot");

        }
    }


}
