package models

import sessions.UserSession

import java.time.LocalDateTime

class User(i: Int, u: String, p: String, t: String) {

    private var id: Int = i
    private val username: String = u
    private val password: String = p
    private val user_type: String = t
    private val temp_date: LocalDateTime = null

    def this(u: String, p: String) = this(-1, u, p, "Standard")

    def ID: Int = id
    def Username: String = username
    def Password: String = password
    def Type: String = user_type

    def toArray(): Array[String] = {
        return Array(id.toString, username, password, user_type)
    }

    override def toString(): String = {
        return s"$id, " + 
               '\"' + s"$username" + "\", " + 
               '\"' + s"$password" + "\", " + 
               '\"' + s"$user_type" + '\"'
    }
}
