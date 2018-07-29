package com.ubs.opsit.interviews;

public interface CustomTime {
    Object getHour();
    Object getMin();
    Object getSec();

    boolean isValidDate();
}
