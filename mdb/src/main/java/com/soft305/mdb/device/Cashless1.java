package com.soft305.mdb.device;

import com.soft305.mdb.MdbManager;
import com.soft305.mdb.MdbPeripheral;
import com.soft305.mdb.input.VmcInput;

/**
 * Created by pablo on 5/22/17.
 */
public class Cashless1 extends MdbPeripheral {



    public Cashless1(MdbManager mdbManager) {
        super(mdbManager);
    }

    @Override
    public boolean processCommand(VmcInput vmcInput) {
        return true;
    }
}