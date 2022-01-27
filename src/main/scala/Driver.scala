import repos.UserRepo
import models.User
import services.UserService
import sessions.UserSession


import scala.io.StdIn.readLine


object Driver {

    def main(args: Array[String]): Unit = {

        Account_Prompt()
        Account_Actions()
    }

    def Account_Prompt() {

        print("\nEnter Username: ")
        var username: String = readLine()

        print("Enter password: ")
        var password: String = readLine()


        val prompt: String = 
          "1. Login" +
          "\n2. Register" +
          "\n3. Quit" +
          "\n\nSelect an option: "

        print(prompt)

        var choice: Int = readInt()

        choice match {
            case 1 => UserService.Login(username, password)
            case 2 => UserService.Register(username, password)
            case 3 => return
            case _ => println("Invalid option")
        }
    }

    def Account_Actions(): Unit = {

        val prompt: String = 
          "1. Get Data" +
          "\n2. Change Password" +
          "\n3. Sign Out" +
          "\n\nSelect an option: "

        print(prompt)

        var choice: Int = readInt()

        choice match {
            case 2 => {
                print("Enter new password: ")
                val new_pass: String = readLine()
                UserService.Change_Password(new_pass)

            }
            case 3 => UserSession.End()
            case _ => println("Invalid option")
        }
    }
}
