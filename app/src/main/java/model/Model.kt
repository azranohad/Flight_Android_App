package model

import androidx.lifecycle.MutableLiveData
import java.net.Socket

class Model {
        var ip = MutableLiveData<String>()
        var port = MutableLiveData<String>()
        var throttle: Float = 0.0F
        var rudder : Float = 0.0F
        var elevator : Float = 0.0F
        var aileron : Float = 0.0F
        lateinit var client : Socket;

        fun send_data_FG() {
                while (true) {
                        client.outputStream.write("set /controls/flight/aileron ".toByteArray() +aileron.toString().toByteArray() + "\r\n".toByteArray())
                        client.outputStream.write("set /controls/flight/elevator ".toByteArray() +elevator.toString().toByteArray() + "\r\n".toByteArray())
                        client.outputStream.write("set /controls/flight/rudder ".toByteArray() +rudder.toString().toByteArray() + "\r\n".toByteArray())
                        client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())
                }
        }
        fun connect() {
                try {
                        client = Socket(ip.toString(), port.toString().toInt())
                        //send_data_FG()
                        //client.close()
                } catch (e: Exception){
                        //Toast.makeText(context, "failed to connect, try again!", Toast.LENGTH_SHORT).show()
                }
        }
        fun get_aileron(): Float {
                return aileron
        }
        fun set_aileron(new_aileron: Float) {
                aileron = new_aileron
                client.outputStream.write("set /controls/flight/aileron ".toByteArray() +aileron.toString().toByteArray() + "\r\n".toByteArray())
        }
        fun get_elevator(): Float {
                return elevator
        }
        fun set_elevator(new_elevator: Float) {
                elevator = new_elevator
                client.outputStream.write("set /controls/flight/elevator ".toByteArray() +elevator.toString().toByteArray() + "\r\n".toByteArray())
        }
        fun get_rudder(): Float {
                return rudder
        }
        fun set_rudder(new_rudder: Float) {
                rudder = new_rudder
                client.outputStream.write("set /controls/flight/rudder ".toByteArray() +rudder.toString().toByteArray() + "\r\n".toByteArray())
        }
        fun get_throttle(): Float {
                return throttle
        }
        fun set_throttle(new_throttle: Float) {
                throttle = new_throttle
                client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())
        }
        fun set_ip(new_ip: MutableLiveData<String>) {
                ip = new_ip
        }
        fun set_port(new_port: MutableLiveData<String>) {
                port = new_port
        }

}