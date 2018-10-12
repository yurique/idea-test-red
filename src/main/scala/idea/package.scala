import shapeless.tag
import shapeless.tag.@@

package object idea {

  trait TypedId[T] {
    type Id = String @@ T
  }

  def newId[T](): String @@ T = tag[T][String]("something")

  case class Test1(
    id: Test1.Id = newId(),
  )
  case class Test2(
    id: Test2.Id = newId[Test2](),
  )

  object Test1 extends TypedId[Test1]
  object Test2 extends TypedId[Test2]


  val test1 = Test1()



  val test2 = Test2()

  def testFn1(id: Test1.Id = newId()): Unit = { }
  def testFn2(id: Test1.Id = newId[Test1]()): Unit = { }

  testFn1()
  testFn2()

}
