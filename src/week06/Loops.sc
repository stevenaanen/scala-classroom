var count = 0

WHILE(count < 3) {
  count += 1
  println(count)
}

def WHILE(condition: => Boolean)(command: => Unit): Unit = {
  if (condition) {
    command
    WHILE(condition)(command)
  } else ()
}



//REPEAT {
//  COMMAND
//} UNTIL ( condition )
//
//def repeat()
//
//
