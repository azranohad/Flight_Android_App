package ViewModel

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _displayedEditTextContent = MutableLiveData<String>()
    fun onChangeconnect() {
        _displayedEditTextContent.value = 1.toString();
    }

}