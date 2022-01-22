package repos


import clients.HiveClient
import models.User


import scala.util.Try

import java.io.IOException

import java.sql.SQLException
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.sql.DriverManager

// TODO: Find some way to abstract
// object w/ generics or something
object UserRepo extends Repo[User] {

    private var query: String = ""

    def Get_Query(): String = query

    def Create(new_user: User, table: String): Unit = {

        var item: Array[String] = new_user.toArray()

        var insert: String = "" + 
          s"INSERT INTO TABLE $table" +
          s"\nVALUES ("

        for (i <- 0 until item.size - 1) {
            insert += '\"' + item(i) + "\", "
        }

        query += '\"' + item.last + "\")"

        println(query)

        Query(query)
    }

    def Read(username: String, table: String): User = {
        val query: String = 
          s"SELECT * FROM $table" + '\n' +
          "WHERE username = \"" + username + "\""
          // tfw scala doesn't support ANY
          // escape chars w/ string interpolation

        val result: ResultSet = Query(query)

        var found_user: User = null

        while (result.next()) {
            found_user = new User(
                result.getString("username"),
                result.getString("password"),
                result.getString("type")
            )
        }

        return found_user
    }

    def Update(old_user: User) : Unit = {
        
        val item: Array[String] = old_user.toArray()

        query = ""

        return
    }

    def Delete(user: User): Unit = {}

    private def Query(query: String): ResultSet = HiveClient.Query_DB(super.friend)
}
