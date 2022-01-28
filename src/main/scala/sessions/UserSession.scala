package sessions


object UserSession {

    private var id: Int = 0
    private var name: String = ""
    private var user_type: String = ""

    def Start(i: Int, username: String, u_type: String): Unit = {
        id = i
        name = username
        user_type = u_type
    }

    def ID: Int = id

    def User: String = name

    def Type: String = user_type

    def End(): Unit = { 

        println('\n' + s"Logged out: $name" + '\n')
        // Mult assignment DNE in Scala 
        // in this context for some reason
        name = ""
        user_type = ""
    }

}
