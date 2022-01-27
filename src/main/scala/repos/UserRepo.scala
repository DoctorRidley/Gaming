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

        var item: Array[String] = new_user.toArray()

        var insert: String = "" + 
          s"INSERT INTO TABLE Users" +
          s"\nVALUES ("

        for (i <- 0 until item.size - 1) {
            insert += '\"' + item(i) + "\", "
        }

        query_str += '\"' + item.last + "\")"

        println(query_str)

        Query_DB()
    }

    def Read(username: String): User = {

        query_str = 
          "SELECT * FROM Users" + '\n' +
          "WHERE username = \"" + username + "\""

        val result: ResultSet = Query_DB()

        var found_user: User = null

        println("result:", result)

        while (result.next()) {
            println(result.getString("username"))
            found_user = new User(
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
}
