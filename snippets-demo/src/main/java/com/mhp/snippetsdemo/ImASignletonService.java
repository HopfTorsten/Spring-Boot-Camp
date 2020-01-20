package com.mhp.snippetsdemo;

public class ImASignletonService {

    private static ImASignletonService  INSTANCE;

    private ImASignletonService(){
        // don't even think about making it public
    }

    public static synchronized ImASignletonService instance(){
        if(null == INSTANCE){
            INSTANCE = new ImASignletonService();
        }
        return INSTANCE;
    }

    public void tellHowGreatYouAre(){
        System.out.println("I'm a great singleton!");
    }

}
