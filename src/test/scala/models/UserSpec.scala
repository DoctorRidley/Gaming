package models


import org.scalatest.FunSuite

class UserSpec extends FunSuite {

    val test1: User = new User(1, "Noob", "Jeep Stuff", "I got little birdie legs")
    val test2: User = new User(123, "Noob", "PROMOOOOTEEEDDDD", "Colonel Killer")
    val test3: User = new User("Noob", "Tug Tank", "Dip dip potato chip")

    test ("Getters") {
        assert(test1.ID == 1)
        assert(test1.Username == "Noob")
        assert(test1.Password == "Jeep Stuff")
        assert(test1.Type == "I got little birdie legs")

        assert(test2.ID == 123)
        assert(test2.Username == "Noob")
        assert(test2.Password != "PROMOTED!")
        assert(test2.Type != "Col Killer")
    }

    test ("Constructor Overload") {
        assert(test3.ID == -1)
    }

    test ("To Array") {

        val arr1: Array[String] = Array("1", "Noob", "Jeep Stuff", "I got little birdie legs")
        val arr2: Array[String] = Array("123", "Noob", "PROMOOOOTEEEDDDD", "Colonel Killer")
        val arr3: Array[String] = Array("-1", "Noob", "Tug Tank", "Dip Dip Potato Chip")

        assert(test1.toArray().sameElements(arr1))
        assert(test2.toArray().sameElements(arr2))
        assert(!test3.toArray().sameElements(arr3))
    }

    test ("To String") {
        val str1: String = "1, Noob, Jeep Stuff, I got little birdie legs"
        val str2: String = "123, Noob, PROMOOOOTEEEDDDD, Colonel Killer"
        val str3: String = "-1, Noob, Tug Tank, Dip Dip Potato Chip"

        assert(test1.toString() == str1)
        assert(test2.toString() == str2)
        assert(test3.toString() != str3)
    }
}
