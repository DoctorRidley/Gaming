package repos


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

    def Create(new_user: User): Unit = {

        var values: Array[String] = new_user.toArray()

        query_str = "" + 
          s"INSERT INTO TABLE Users" +
          s"\nVALUES ("

        for (i <- 0 to values.size) {
            query_str += '\"' + values(i) + "\", "
        }

        query_str += '\"' + values.last + "\")"

        println(query_str)

        Query_DB()
    }

    def Read(username: String): User = {

        query_str = 
          "SELECT * FROM Users" + '\n' +
          "WHERE username = \"" + username + "\""

        val result: ResultSet = Query_DB()

        var found_user: User = null

        while (result.next()) {
            println(result.getString("username"))
            found_user = new User(
                result.getString("id").toInt,
                result.getString("username"),
                result.getString("password"),
                result.getString("type")
            )
        }

        Close()

        return found_user
    }

    def Update(old_user: User): Unit = {
        
        val item: Array[String] = old_user.toArray()

        query_str = ""

        return
    }

    def Delete(user: User): Unit = {}

    def Max_ID: Int = {
        query_str = "SELECT MAX(id) FROM Users"
        var id: Int = 0
        val result: ResultSet = Query_DB()

        while (result.next()) {
            result.getInt("id")
        }

        Close()

        return id
    }
}
