package org.example.behavioral;

interface OfficeInternetAccess {
    void giveInternetAccess();
}

class RealInternetAccess implements OfficeInternetAccess {
    private String mEmpName;

    public RealInternetAccess(String employeeName) {
        this.mEmpName = employeeName;
    }

    @Override
    public void giveInternetAccess() {
        System.out.println("Access granted to employee " + mEmpName);
    }
}

class ProxyInternetAccess implements OfficeInternetAccess {

    private String mEmpName;
    private RealInternetAccess mRealNetAccess;

    public ProxyInternetAccess(String employeeName) {
        this.mEmpName = employeeName;
    }

    public int getRole(String employeeName) {
        return employeeName.length();
    }

    @Override
    public void giveInternetAccess() {

        if (getRole(mEmpName) > 4) {
            mRealNetAccess = new RealInternetAccess(mEmpName);
            mRealNetAccess.giveInternetAccess();
        } else
            System.out.println("Access not granted. Your job level is below 5");
    }
}

public class Proxy {

    public static void main(String args[]) {

        OfficeInternetAccess mOfficeNetAccess = new ProxyInternetAccess("Nikhil Dhupar");
        mOfficeNetAccess.giveInternetAccess();
    }
}
