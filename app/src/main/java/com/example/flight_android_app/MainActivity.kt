package com.example.flight_android_app
import ViewModel.JoystickViewModel
import ViewModel.MainViewModel
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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
    var joystickVM : JoystickViewModel = JoystickViewModel(model)
    var mainVM : MainViewModel = MainViewModel(model)



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var joyStick : JoyStick = JoyStick(findViewById<JoyStickView>(R.id.joy), joystickVM)

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
            if (IP.text.toString() == "" || port.text.toString() == "") {
                Toast.makeText(
                    this,
                    "Please enter IP and port number",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                mainVM.setIP(IP.text.toString())
                mainVM.setPort(port.text.toString())
                mainVM.connectModel()
            }
        }

        val throttleSeek = findViewById<SeekBar>(R.id.throttleSeek)
        val throttleValueView = findViewById<TextView>(R.id.throttleValueView)
        throttleSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                mainVM.setThrottle(progress.toFloat()/1000)
                throttleValueView.text = (progress.toFloat()/1000).toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
        val rudderSeek = findViewById<SeekBar>(R.id.rudderSeek)
        val rudderValueView = findViewById<TextView>(R.id.rudderValueView)
        rudderSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                mainVM.setRudder(progress.toFloat()/100)
                rudderValueView.text = (progress.toFloat()/100).toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
        val set_0 = findViewById<Button>(R.id.rudderButton)
        set_0.setOnClickListener() {
            rudderSeek.progress = 0;
            mainVM.setRudder(rudderSeek.progress.toFloat()/1000)
            rudderValueView.text = (rudderSeek.progress.toFloat()/1000).toString()
        }
    }
}
