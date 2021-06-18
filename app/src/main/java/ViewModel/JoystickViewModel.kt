package ViewModel

import androidx.lifecycle.ViewModel
import model.Model

class JoystickViewModel(model: Model) : ViewModel() {
    var m : Model = model
    fun setAileron(aileron : Float) {
        m.aileron = aileron
    }
    fun setElevator(elevator : Float) {
        m.elevator = elevator
    }

}