package com.example.wscubepractice2.MessageReceivingNsending;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;

public class SMS_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//   Now we'll receive messages.........
        Bundle bundle = intent.getExtras();
//        we'll store message in an array Obj.
       Object[] obj =(Object[]) bundle.get("pdus");

//       Now we'll receive those messages in FOR Loop :::::
        for (Object smsObj:obj) {
//            here the values from the obj array will be stored in smsObj.....

//            now we'll get the info  that from where the message is coming and what the is.....
            SmsMessage message = SmsMessage.createFromPdu((byte[]) smsObj);
//            Now we'll take message address and the message from pdu...
            String phonrNo = message.getDisplayOriginatingAddress();
            String msgBody = message.getDisplayMessageBody();

//            Now we'll check it in Log because we are practicing here but once we'll be good in it we can store these messages in recyclerView or in ListView..
            Log.d("THE_MESSAGE","Address : "+phonrNo+" Message : "+msgBody);






        }
    }
}
