package ViewModel

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.Socket

class MainViewModel : ViewModel() {
    private val _displayedEditTextContent = MutableLiveData<String>()
    @SuppressLint("StaticFieldLeak")
    private var ip: EditText? = null
    @SuppressLint("StaticFieldLeak")
    var port: EditText? = null
    lateinit var client :  Socket;


    val editTextContentIP = MutableLiveData<String>()
    val editTextContentPort = MutableLiveData<String>()
    fun onChangeconnect() {
        client = Socket("127.0.0.1", 9999)
        client.outputStream.write("Hello from the client!".toByteArray())
        client.close()
    //_displayedEditTextContent.value = 1.toString();
    }
}