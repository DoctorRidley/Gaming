package repos


trait Repo[T] {
    
    final class Friend { private def Friend(): Unit = {} }
    protected final var friend: Friend = new Friend()

    def Get_Query(): String
    def Create(t: T): Unit
    def Read(t: T): T
    def Update(t: T): Unit
    def Delete(t: T): Unit
}
