package com.example.voting;

import android.widget.Toast;

public class Count {
    private int candid_1 = 0;
    private int candid_2 = 0;
    private int candid_3 = 0;
    private int candid_4 = 0;

    public Count() {
//        Toast.makeText(Count.this,getCandid1()+" "+getBurgercount()+" "+getComedycount(),Toast.LENGTH_SHORT).show();
    }

    public Count(int candid_1, int candid_2, int candid_3, int candid_4) {

        this.candid_1 = candid_1;
        this.candid_2 = candid_2;
        this.candid_3 = candid_3;
        this.candid_4 = candid_4;
    }

    public int getCandid1() {
        return this.candid_1;
    }

    public void setCandid1(int t) {

        this.candid_1 += t;
    }

    public int getCandid2() {
        return this.candid_2;
    }

    public void setCandid2(int t) {
        this.candid_2 += t;
    }

    public int getCandid3() {
        return this.candid_3;
    }

    public void setCandid3(int t) {
        this.candid_3 += t;
    }

    public int getCandid4() {
        return this.candid_4;
    }

    public void setCandid4(int t) {
        this.candid_4 += t;
    }

}
