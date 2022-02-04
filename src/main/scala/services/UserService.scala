package services

import repos.UserRepo
import models.User
import sessions.UserSession


import scala.io.StdIn.readLine


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

    def Logout(): Unit = {

        return
    }

    def Change_Username(new_name: String): Unit = {}

    def Change_Password(): Unit = {

        val target: User = UserRepo.Read(UserSession.User)

        print("Confirm your password: ")
        val confirm: String = readLine()

        if (confirm != target.Password) {
          println("INCORRECT PASSWORD")
          return
        }

        val new_pass: String = Hash_Password(Confirm_Password(), "")

        val updated: User = new User(UserSession.ID, UserSession.User, new_pass, UserSession.Type)
        UserRepo.Update(updated)

        // TODO: maybe use a logger when handling unit tests
    }

    def Hash_Password(p: String, salt: String): String = {
        return p
    }

    private def Confirm_Password(): String = {

        var new_pass, confirm: String = ""


        do {
            print("Enter new password: ")
            new_pass = readLine()
            print("Confirm: ")
            confirm = readLine()
            if (new_pass != confirm) { println("Passwords do not match") }
        } while (new_pass != confirm)
        
        return new_pass
    }
}
