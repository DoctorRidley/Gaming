package repos

import java.io.IOException

import java.sql.SQLException
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.sql.DriverManager

abstract class Repo[T] {

    protected var connection: Connection = null;
    protected val driver_name: String = "org.apache.hive.jdbc.HiveDriver";
    protected val con_uri: String = "jdbc:hive2://localhost:10000/gaming";

    protected var query_str: String = ""

    protected def Connect(): Unit = {

        try {
            Class.forName(driver_name)
            connection = DriverManager.getConnection(con_uri, "", "")
        }

        catch {
              case e: ClassNotFoundException => {
                  throw new ClassNotFoundException(s"${e.getMessage}")
              }
              case e: SQLException => {
                  throw new SQLException(s"${e.getMessage}")
              }
        }
    }

    protected def Close(): Unit = {

        try { if (connection != null) { connection.close(); } }

        catch {
            case e: SQLException => {
                throw new SQLException(s"${e.getMessage}")
            }
        }
    }

    // Helper method to handle exceptions
    protected def Query_DB(): ResultSet = {

        Connect()
        var result: ResultSet = null

        try {
            val query: Statement = connection.createStatement()
            result = query.executeQuery(query_str)
        }

        catch {
            case e: SQLException => {
                throw new SQLException(s"${e.getMessage}")
            }
        }

        finally {
            Close()
        }

        return result
    }

    def Create(t: T): Unit
    def Read(s: String): T
    def Update(t: T): Unit
    def Delete(t: T): Unit
}
