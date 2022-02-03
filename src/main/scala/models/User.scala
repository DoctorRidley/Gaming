package models

import sessions.UserSession

class User(i: Int, u: String, p: String, t: String) {

    private var id: Int = i
    private val username: String = u
    private val password: String = p
    private val user_type: String = t

    def this(u: String, p: String) = this(-1, u, p, "Standard")

    def ID: Int = id
    def Username: String = username
    def Password: String = password
    def Type: String = user_type

    def toArray(): Array[String] = {
        return Array(id.toString, username, password, user_type)
    }

    override def toString(): String = {
        return s"$id, $username, $password, $user_type"
    }
}
