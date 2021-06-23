package model
import java.io.PrintWriter
import java.net.Socket

class Model {
        var ip = ""
                get() {
                        return field
                }
                set(value) {
                        field = value
                }
        var port = ""
                get() {
                        return field
                }
                set(value) {
                        field = value
                }
        var throttle: Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/engines/current-engine/throttle $field\r\n")
                }
        var rudder : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/flight/rudder $field\r\n")
                }

        var elevator : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/flight/elevator $field\r\n")
                }
        var aileron : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/flight/aileron $field\r\n")
                }

        private lateinit var client : Socket;
        private lateinit var printWrite : PrintWriter

        fun send_data_FG(data_to_send : String) {

                val thread = Thread {
                        try {
                                printWrite.print(data_to_send)
                                printWrite.flush()
                        } catch (e : Exception) {

                        }
                }
                thread.start()
                thread.join()
        }
        fun connect() {
                val thread = Thread {
                        try {
                                client = Socket(ip.toString(), port.toInt())
                                printWrite = PrintWriter(client.getOutputStream(), true)
                        } catch (e: Exception) {

                        }
                }
                thread.start()
                thread.join()
        }
}