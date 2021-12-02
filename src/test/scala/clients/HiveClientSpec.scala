package clients


import models.User


import org.scalatest.FunSuite


class HiveClientSepc extends FunSuite {

    test("Connection to Hive") {

        HiveClient.Connect()


    }

    test("") {


    }

    test("Reading Existing Account") {

        val found: User = HiveClient.Read("Admin", "Users")
        val target: User = new User("Admin", "root", "Admin")

        assert(found.toString() == target.toString())

    }

    test("Reading Non-Existent Account") {

    }




}
