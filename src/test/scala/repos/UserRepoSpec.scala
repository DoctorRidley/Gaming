package repos


import models.User


import org.scalatest.FunSuite


class UserRepoSpec extends FunSuite {

    test ("Reading Existing Account") {

//        val found: User = UserRepo.Read("Admin", "Users")
//        val target: User = new User("Admin", "root", "Admin")

//        assert(found.toString() == target.toString())

    }

    test ("Reading Non-Existent Account") {

        // Assumes this user does not exist
        val found: User = UserRepo.Read("34w8y9eaf_(Ui;oleiofuowabvhds")

        assert(found == null)
    }

    test ("HiveQL Injection") {


    }




}
