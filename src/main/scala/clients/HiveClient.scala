package clients


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
object HiveClient {

    private var connection: Connection = null
    private var driver_name: String = "org.apache.hive.jdbc.HiveDriver"
    private val con_uri = "jdbc:hive2://localhost:10000/gaming"

    def Connect(): Unit = {

        try {
            Class.forName(driver_name)
            connection = DriverManager.getConnection(con_uri, "", "")
        } catch {
              case e: ClassNotFoundException => {
                  e.printStackTrace()
                  throw new ClassNotFoundException(s"${e.getMessage}")
              }

              case e : SQLException => {
                  e.printStackTrace()
                  throw new SQLException(s"${e.getMessage}")
              }
        }
    }

    def Create(new_user: User, table: String): Unit = {

        var item: Array[String] = new_user.toArray()

        var insert: String = "" + 
          s"INSERT INTO TABLE $table" +
          s"\nVALUES ("

        for (i <- 0 until item.size - 1) {
            insert += '\"' + item(i) + "\", "
        }

        insert += '\"' + item.last + "\")"

        println(insert)

        Query_DB(insert)
    }

    def Read(username: String, table: String): User = {
        val read: String = 
          s"SELECT * FROM $table" + '\n' +
          "WHERE username = \"" + username + "\""
          // tfw scala doesn't support ANY
          // escape chars w/ string interpolation

        val result: ResultSet = Query_DB(read)

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

        val update: String = ""

        return
    }

    def Close(): Unit = {

        try { if (connection != null) { connection.close() } }

        catch {
            case e : SQLException => {
                e.printStackTrace()
                throw new SQLException(s"${e.getMessage}")
            }
        }
    }

    // Helper method to handle exceptions
    private def Query_DB(q: String): ResultSet = {

        var result: ResultSet = null

        try {
            val query: Statement = connection.createStatement()
            result = query.executeQuery(q)
        }

        catch {
            case e : SQLException => {
                Close()
                e.printStackTrace()
                throw new SQLException(s"${e.getMessage}")
            }
        }
        
        return result
    }
}
