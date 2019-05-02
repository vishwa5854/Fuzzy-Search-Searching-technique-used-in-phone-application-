package com.company;

import java.awt.*;

class Contacts extends Frame {
    String actualName;
    StringBuilder numericalName;


    Contacts(String aname){
        this.actualName = aname;
        this.numericalName = new StringBuilder();
    }

    Contacts(){}
}
