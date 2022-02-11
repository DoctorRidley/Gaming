package repos


import models.User


import org.scalatest.FunSuite


class UserRepoSpec extends FunSuite {


    test ("Create User Account") {

        val username: String = "asdlfjaw0ei89y234aslkfashdf"
        val new_user: User = new User(username, "password")
        UserRepo.Create(new_user)
        val read: User = UserRepo.Read(username)
//        assert(new_user == read)
        assert(false)
    }

    test ("Reading Existing Account") {

//        val found: User = UserRepo.Read("Admin", "Users")
//        val target: User = new User("Admin", "root")

//        assert(found.toString() == target.toString())
        assert(false)

    }

    test ("Reading Non-Existent Account") {

        // Assumes this user does not exist
        val found: User = UserRepo.Read("34w8y9eafUioleiofuowabvhds")

        assert(found == null)
    }

    test ("Update User Account") {
        assert(false)
    }

    test ("Delete User Account") {
        val del: User = new User("aw8efhoisn043weiga", "password")
        UserRepo.Create(del)
        UserRepo.Delete(del)

        val found: User = UserRepo.Read(del.Username)
        assert(found == null)
    }

    test ("HiveQL Injection") {
        val inject: User = new User("test", "test\"; SELECT * FROM Users;")
        //UserRepo.Create()
        assert(false)
    }




}
