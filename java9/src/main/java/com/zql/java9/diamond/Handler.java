package com.zql.java9.diamond;

public abstract class Handler<T> {

    public T content;

    public Handler(T content) {
        this.content = content;
    }

    abstract void handler();
}
