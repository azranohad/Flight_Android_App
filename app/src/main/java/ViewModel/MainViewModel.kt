package ViewModel

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Model

class MainViewModel(model: Model) : ViewModel() {
    private val _displayedEditTextContent = MutableLiveData<String>()
    @SuppressLint("StaticFieldLeak")
    private var ip: EditText? = null
    @SuppressLint("StaticFieldLeak")
    var port: EditText? = null
    val editTextContentIP = MutableLiveData<String>()
    val editTextContentPort = MutableLiveData<String>()

    fun onChangeconnect(model: Model) {
        model.set_ip(editTextContentIP)
        model.set_port(editTextContentPort)
        model.connect()
        //_displayedEditTextContent.value = 1.toString();
    }
}