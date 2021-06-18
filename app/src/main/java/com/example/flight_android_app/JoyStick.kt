package com.example.flight_android_app

import ViewModel.JoystickViewModel
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.jackandphantom.joystickview.JoyStickView
import kotlin.math.cos
import kotlin.math.sin

class JoyStick(joyStickView: JoyStickView, viewModelJ: JoystickViewModel):AppCompatActivity() {
    var joyStick : JoyStickView  = joyStickView
    var joystickVM : JoystickViewModel = viewModelJ

    fun setMove(angle: Double, strength: Float) {
        val aileron : Float = (strength * cos(angle)).toFloat()/100
        val elevator : Float = (strength * sin(angle)).toFloat()/100
        joystickVM.setAileron(aileron)
        joystickVM.setElevator(elevator)
    }
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val joyStick : JoyStickView = findViewById<JoyStickView>(R.id.joy)
    }
}
