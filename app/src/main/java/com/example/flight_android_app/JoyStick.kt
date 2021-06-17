package com.example.flight_android_app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.jackandphantom.joystickview.JoyStickView
import model.Model

class JoyStick(joyStickView: JoyStickView):AppCompatActivity() {
    var joyStick : JoyStickView  = joyStickView
    val model = Model()

    fun setMove(angle: Double, strength: Float) {
        //var aileron : Float =
        model.strength = strength
        model.angle = angle
    }
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val joyStick : JoyStickView = findViewById<JoyStickView>(R.id.joy)

    }
}
