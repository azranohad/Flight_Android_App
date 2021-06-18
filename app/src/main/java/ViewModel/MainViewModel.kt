package ViewModel

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Model

class MainViewModel(model: Model) : ViewModel() {
    var m : Model = model

    //private val _displayedEditTextContent = MutableLiveData<String>()
    @SuppressLint("StaticFieldLeak")
    private var ip: EditText? = null
    @SuppressLint("StaticFieldLeak")
    var port: EditText? = null
    val editTextContentIP = MutableLiveData<String>()
    val editTextContentPort = MutableLiveData<String>()
    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get() = _displayedEditTextContent
    fun onChangeConnect(model: Model) {
       // model.set_ip(editTextContentIP)
       // model.set_port(editTextContentPort)
        model.connect()
        //_displayedEditTextContent.value = 1.toString();
    }

    fun setThrottle(throttle : Float) {
        m.throttle = throttle
    }
    fun setRudder(rudder : Float) {
        m.rudder = rudder
    }
    fun setIP(IP : String) {
        m.ip = IP
    }
    fun setPort(port : String) {
        m.port = port
    }
    fun connectModel() {
        m.connect()
    }


}