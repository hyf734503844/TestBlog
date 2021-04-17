package com.lrm.po;

public class Sms {
    String phoneNumber;
    String code;
    int min;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", code='" + code + '\'' +
                ", min=" + min +
                '}';
    }
}
