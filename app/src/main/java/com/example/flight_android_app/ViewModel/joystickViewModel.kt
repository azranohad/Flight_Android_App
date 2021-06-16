package com.example.flight_android_app.ViewModel

import android.widget.SeekBar
import androidx.lifecycle.ViewModel
import com.example.flight_android_app.model.Model

class joystickViewModel(model: Model) : ViewModel(), SeekBar.OnSeekBarChangeListener {
    var m : Model = model
    var throttleVM: Float
        get() {
            return this.m.throttle
        }
        set(value) {
            m.throttle = value
        }
    var rudderVM : Float
        get() {
            return this.m.rudder
        }
        set(value) {
            m.rudder = value
        }
    var elevatorVM : Float
        get() {
            return this.m.elevator
        }
        set(value) {
            m.elevator = value
        }
    var aileronVM : Float
        get() {
            return this.m.aileron
        }
        set(value) {
            m.aileron = value
        }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }
}