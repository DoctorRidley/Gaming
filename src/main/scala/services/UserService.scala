package services

import clients.HiveClient
import models.User
import sessions.UserSession

object UserService {

    def Login(username: String, password: String): Unit = {

        val target: User = HiveClient.Read(username, "Users")

        if (target != null && username == target.Username() && password == target.Password()) {
            println('\n' + s"Logged in: $username" + '\n')
            UserSession.Start(username, "User")
        }

        else {
            println("\nInvalid credentials\n")

            // TODO: figure out a way to return to login screen
            System.exit(0)
        }
    }

    def Register(username: String, password: String): Unit = {

        val new_user: User = new User(username, password, "User")
        println("CREATED USER")
        HiveClient.Create(new_user, "Users")
        println("ADDED USER TO TABLE")

    }

    def Change_Password(new_pass: String): Unit = {

        val target: User = HiveClient.Read(UserSession.User(), "Users")

        if (new_pass != target.Password()) {
          println("INCORRECT PASSWORD")
          return
        }

        val updated: User = new User(UserSession.User(), new_pass, "User")

        HiveClient.Update(updated)

    }
}
