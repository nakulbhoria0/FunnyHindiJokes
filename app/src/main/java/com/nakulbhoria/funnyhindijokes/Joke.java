package com.nakulbhoria.funnyhindijokes;


public class Joke{

    /** Default translation for the word */
    private String mDefaultJoke;


    /**
     * Create a new Joke object.
     *
     * @param defaultJoke Joke
     */

    public Joke(String defaultJoke) {

        mDefaultJoke = defaultJoke;
    }

    public String getDefaultJoke() {
        return mDefaultJoke;
    }

}