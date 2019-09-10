package com.annotation.unsafe;

import sun.misc.Unsafe;

public class AtomicInteger extends Number {

    private volatile int value;

    private static final Unsafe UNSAFE = Unsafe.getUnsafe();

    private static final long VALUE;
    static {
        try {
            VALUE = UNSAFE.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    private volatile long initialValue;

    public AtomicInteger(long initialValue) {
        this.initialValue = initialValue;
    }





    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
