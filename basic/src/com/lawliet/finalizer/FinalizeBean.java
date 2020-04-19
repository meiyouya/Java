package com.lawliet.finalizer;

public class FinalizeBean {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
