package services

import repos.UserRepo
import models.User
import sessions.UserSession

object UserService {

    def Login(username: String, password: String): Unit = {

        val target: User = UserRepo.Read(username)

        if (target != null && username == target.Username && password == target.Password) {
            println('\n' + s"Logged in: $username" + '\n')
            UserSession.Start(target.ID, username, "User")
        }

        else {
            println("\nInvalid credentials\n")

            // TODO: figure out a way to return to login screen
            System.exit(0)
        }
    }

    def Register(username: String, password: String): Unit = {

        val new_user: User = new User(username, password)
        println("CREATED USER")
        UserRepo.Create(new_user)
        println("ADDED USER TO TABLE")

    }

    def Change_Username(new_name: String): Unit = {}

    def Change_Password(new_pass: String): Unit = {

        val target: User = UserRepo.Read(UserSession.User)

        if (new_pass != target.Password) {
          println("INCORRECT PASSWORD")
          return
        }

        val updated: User = new User(UserSession.ID, UserSession.User, new_pass, UserSession.Type)

        UserRepo.Update(updated)

    }

    def Hash_Password(p: String): String = {
        return ""
    }
}
