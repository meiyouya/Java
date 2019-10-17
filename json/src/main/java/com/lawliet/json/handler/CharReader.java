package com.lawliet.json.handler;

import java.io.Reader;

public class CharReader {

    private Reader reader;
    private char[] buffer;

    public CharReader(Reader reader) {
        this.reader = reader;
        buffer = new char[32];
    }

}
