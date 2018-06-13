package com.android.wear.Services

import android.util.Log
import android.widget.Toast
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService

class DataLayerListener: WearableListenerService(){
    override fun onCreate() {
        super.onCreate()
    }

    override fun onMessageReceived(messageEvent: MessageEvent) {
        Toast.makeText(this, "in On Message Received", Toast.LENGTH_SHORT).show()
        if (messageEvent.path == "/message-path"){
            val stringToShow: String = String(messageEvent.data, Charsets.UTF_8)
            Log.d("Value Received:", stringToShow)

            //val classReceived: SampleModel = deserialise(messageEvent.data)
            //Log.d("second_param", classReceived.getSecond())
            //Toast.makeText(this, classReceived.getFirst(), Toast.LENGTH_SHORT).show()
            //Toast.makeText(this, classReceived.getSecond(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDataChanged(p0: DataEventBuffer?) {
        Toast.makeText(this, "in On Data Changed", Toast.LENGTH_SHORT).show()

    }
}