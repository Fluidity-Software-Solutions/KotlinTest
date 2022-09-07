package solutions.fluidity.test.exception

class Exceptions

class BootStrapStaticException(val theMessage: String) : RuntimeException(theMessage)
class EventPointsException(val theMessage: String) : RuntimeException(theMessage)
class FixturesException(val theMessage: String) : RuntimeException(theMessage)
