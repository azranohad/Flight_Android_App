package model

import androidx.lifecycle.MutableLiveData
import java.net.Socket

class Model {
        var ip = MutableLiveData<String>()
        var port = MutableLiveData<String>()
        var throttle: Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        //client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())
                }
        var rudder : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        //client.outputStream.write("set /controls/flight/throttle ".toByteArray() +rudderSend.toString().toByteArray() + "\r\n".toByteArray())
                }
        var angle : Double = 0.0
                get() {
                        return field
                }
                set(value) {
                        field = value
                }
        var strength : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                }
        var elevator : Float = 0.0F
        var aileron : Float = 0.0F
        var throttleS : String = "0000000"

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
        fun get_throttleS(): String {
                return throttle.toString()
        }
        fun set_throttle(new_throttle: Float) {
                throttle = new_throttle
        }
        fun set_ip(new_ip: MutableLiveData<String>) {
                ip = new_ip
        }
        fun set_port(new_port: MutableLiveData<String>) {
                port = new_port
        }

}