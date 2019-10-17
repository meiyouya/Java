package com.lawliet.json.handler;

import java.io.IOException;
import java.io.Reader;

/**
 * @author lawliet.L
 */
public class CharReader {

    private static final int BUFFER_SIZE = 1024;
    private int pos;
    private int size;

    private Reader reader;
    private char[] buffer;

    public CharReader(Reader reader) {
        this.reader = reader;
        buffer = new char[BUFFER_SIZE];
    }

    public char peek() {
        if (pos - 1 >= size) {
            return (char) -1;
        }
        return buffer[Math.max(0, pos - 1)];
    }

    public char next() throws IOException {
        if (!hasMore()) {
            return (char) -1;
        }
        return buffer[pos++];
    }

    public void back() {
        pos = Math.max(0, --pos);
    }

    public boolean hasMore() throws IOException {
        if (pos < size) {
            return true;
        }
        fillBuffer();
        return pos < size;
    }

    private void fillBuffer() throws IOException {
        int n = reader.read(buffer);
        if (n == -1) {
            return;
        }
        pos = 0;
        size = n;
    }


}
