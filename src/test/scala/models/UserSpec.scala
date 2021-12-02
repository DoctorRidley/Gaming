package models

import org.scalatest.FunSuite

class UserSpec extends FunSuite {

    test("Getters") {

        val test1: User = new User("Noob", "Jeep Stuff", "I got little birdie legs")
        assert(test1.Username() == "Noob")
        assert(test1.Password() == "Jeep Stuff")
        assert(test1.Type() == "I got little birdie legs")

        val test2: User = new User("Noob", "PROMOOOOTEEEDDDD", "Colonel Killer")
        assert(test2.Username() == "Noob")
        assert(test2.Password() != "PROMOTED!")
        assert(test2.Type() != "Col Killer")
    }
}
