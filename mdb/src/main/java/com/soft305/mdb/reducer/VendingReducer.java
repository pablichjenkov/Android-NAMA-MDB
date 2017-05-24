package com.soft305.mdb.reducer;

import android.util.Log;

import com.soft305.mdb.device.Cashless2;
import com.soft305.mdb.Reducer;
import com.soft305.mdb.input.PurchaseInput;
import com.soft305.mdb.input.VmcInput;
import com.soft305.mdb.util.ByteUtil;
import com.soft305.mdb.util.StringUtil;


public class VendingReducer extends Reducer<Cashless2> {


    public VendingReducer(Cashless2 mdbCashless) {
        super(mdbCashless);
    }

    @Override
    public void inputPurchase(PurchaseInput purchaseInput) {

    }

    @Override
    public boolean processVmcInput(VmcInput vmcInput) {
        return true;
    }

    // todo: put this method into inputVmc.
    public void onDataReceived(VmcInput input) {


        if (input.chunkQueue.getAvailableLength() < 4) {
            return;
        }

        byte[] cmdHead = input.chunkQueue.consume(2);
        Log.d("SetupConfiguration", "cmdHead: " + StringUtil.fromByteArrayToHexString(cmdHead));
        input.chunkQueue.getAvailableLength();
        if (!ByteUtil.compare(cmdHead, new byte[]{0x01, 0x63})) {
            return;
        }

        byte[] subCmd = input.chunkQueue.consume(2);

        Log.d("SetupConfiguration", "subCmd: " + StringUtil.fromByteArrayToHexString(subCmd));
        input.chunkQueue.getAvailableLength();

        if (ByteUtil.compare(subCmd, new byte[]{0x00, 0x00})) {
            // Handle Vend Request

        } else if (ByteUtil.compare(subCmd, new byte[]{0x00, 0x01})) {
            // Handle Vend Cancel

        } else if (ByteUtil.compare(subCmd, new byte[]{0x00, 0x02})) {
            // Handle Vend Success

        } else if (ByteUtil.compare(subCmd, new byte[]{0x00, 0x03})) {
            // Handle Vend Failure
        }


    }

}
