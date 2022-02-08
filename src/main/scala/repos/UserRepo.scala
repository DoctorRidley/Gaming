package repos


import models.User


import scala.util.Try

import java.io.IOException

import java.sql.SQLException
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.sql.DriverManager

object UserRepo extends Repo[User] {

    def Create(new_user: User): Unit = {

        query_str = "" + 
          s"INSERT INTO TABLE Users" +
          s"\nVALUES (${new_user.toString()})"

        println(query_str)

        Query_DB()
        Close()
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

    def Update(update: User): Unit = {

        query_str = 
          "UPDATE Users\n" +
          "SET username = ${update.Username}, password = ${update.Password}" +
          s" WHERE Users.ID = ${update.ID}"

        println(query_str)

        Query_DB()

        Close()
    }

    def Delete(user: User): Unit = {

        query_str = 
          "DELETE Users\n"
          s"WHERE Users.ID = ${user.ID}"

        Query_DB()
        Close()
    }

    def Max_ID: Int = {
        query_str = "SELECT MAX(id) FROM Users"
        var count: Int = 0
        val result: ResultSet = Query_DB()

        while (result.next()) {
            count = result.getInt("id")
        }

        Close()

        return count
    }
}
