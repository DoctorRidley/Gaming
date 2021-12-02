package models

class User(u: String, p: String, t: String) {

    private val username: String = u
    private val password: String = p
    private val user_type: String = t

    def Username(): String = username
    def Password(): String = password
    def Type(): String = user_type


    def toArray(): Array[String] = {
        return Array(username, password, user_type)
    }

    override def toString(): String = {
        return s"$username, $password, $user_type"
    }
}
