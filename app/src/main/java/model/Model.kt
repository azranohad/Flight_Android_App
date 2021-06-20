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
                        send_data_FG("set /controls/flight/throttle $field\r\n")
                        println("\nthrottle")
                        println(field)

                        //client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())
                }
        var rudder : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/flight/rudder $field\r\n")
                        println("\nrudder")
                        println(field)

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
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/flight/elevator $field\r\n")
                        println("\nelevator")
                        println(field)

                        //client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())
                }
        var aileron : Float = 0.0F
                get() {
                        return field
                }
                set(value) {
                        field = value
                        send_data_FG("set /controls/flight/aileron $field\r\n")
                        println("\naileron")
                        println(field)

                        //client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())
                }
        var throttleS : String = "0000000"

        private lateinit var client : Socket;
        private lateinit var printWrite : PrintWriter

        fun send_data_FG(data_to_send : String) {
       /*                 client.outputStream.write("set /controls/flight/aileron ".toByteArray() +aileron.toString().toByteArray() + "\r\n".toByteArray())
                        client.outputStream.write("set /controls/flight/elevator ".toByteArray() +elevator.toString().toByteArray() + "\r\n".toByteArray())
                        client.outputStream.write("set /controls/flight/rudder ".toByteArray() +rudder.toString().toByteArray() + "\r\n".toByteArray())
                        client.outputStream.write("set /controls/flight/throttle ".toByteArray() +throttle.toString().toByteArray() + "\r\n".toByteArray())*/

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
                                print("connect to server!!!!!!!!!\n")
                                send_data_FG("set /controls/flight/throttle 1\r\n")

                        } catch (e: Exception) {

                        }
                }
                thread.start()
                thread.join()
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
        fun set_ip(new_ip: String) {
                ip = new_ip
        }
        fun set_port(new_port: String) {
                port = new_port
        }

}