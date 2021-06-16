package ViewModel

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _displayedEditTextContent = MutableLiveData<String>()
    @SuppressLint("StaticFieldLeak")
    private var ip: EditText? = null
    @SuppressLint("StaticFieldLeak")
    var port: EditText? = null


    val editTextContentIP = MutableLiveData<String>()
    val editTextContentPort = MutableLiveData<String>()
    fun onChangeconnect() {
        //_displayedEditTextContent.value = 1.toString();
    }
}