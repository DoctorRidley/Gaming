package services


import clients.HiveClient
import models.User


import org.scalatest.FunSuite

class UserServiceSpec extends FunSuite {

    HiveClient.Connect()

    test("Logging into Existing Account") {

        UserService.Login("Admin", "root")
    }

}
