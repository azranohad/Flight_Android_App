package com.example.flight_android_app
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.flight_android_app.databinding.ActivityMainBinding
import com.jackandphantom.joystickview.JoyStickView
import model.Model




/*class com.example.flight_android_app.MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/


class MainActivity : AppCompatActivity() {
    var ip: EditText? = null
    var port: EditText? = null
    var port_erase: EditText? = null
    val model = Model()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var joyStick : JoyStick = JoyStick(findViewById<JoyStickView>(R.id.joy))

        val joyStickView = findViewById<JoyStickView>(R.id.joy)
        joyStickView.setOnMoveListener(object : JoyStickView.OnMoveListener {
            fun onMove(angle: Int, strength: Int) {
            }
            override fun onMove(angle: Double, strength: Float) {
                joyStick.setMove(angle, strength)
            }
        })
        /*val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)*/
/*        val port = findViewById<EditText>(R.id.port)
        port.setOnEditorActionListener(object : editText {

        }


        )*/
        val port = findViewById<EditText>(R.id.port)
        val IP = findViewById<EditText>(R.id.IP)
        val connect = findViewById<Button>(R.id.button)
        connect.setOnClickListener() {
            var bb = port.text.toString()
            if (port == null || port.text.toString() == "") {
                Toast.makeText(
                    this,
                    "Please enter IP and port number",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                model.set_ip(IP.text.toString())
                model.set_port(port.text.toString())
                model.connect()
            }
        }

        val throttleSeek = findViewById<SeekBar>(R.id.throttleSeek)
        throttleSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                model.throttle = progress.toFloat()/1000
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
        val rudderSeek = findViewById<SeekBar>(R.id.rudderSeek)
        rudderSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                model.rudder = progress.toFloat()/1000
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })

    }
}
