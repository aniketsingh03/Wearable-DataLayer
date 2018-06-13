package com.android.wear

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.android.gms.wearable.Wearable
import kotlinx.android.synthetic.main.fragment_main.view.*

class SampleFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = container?.inflate(R.layout.fragment_main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.send_wear.setOnClickListener{
            val stringToSend = "this is string"
            val sendTask: Task<Int> =
                Wearable.getMessageClient(context!!).sendMessage(
                    "*", "/message-path", stringToSend.toByteArray(Charsets.UTF_8))
            sendTask.addOnSuccessListener { Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show() }
        }
    }

    fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(resource, this, attachToRoot)

}