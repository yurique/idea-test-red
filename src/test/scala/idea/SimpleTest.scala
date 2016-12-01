package idea

import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import org.scalatest.FlatSpec

import scala.concurrent.ExecutionContext

trait ExecutionContextProvider {
  implicit def executionContext: ExecutionContext
}

class TestingBase extends FlatSpec with ScalatestRouteTest {
  trait ContextBase extends ExecutionContextProvider {
    override implicit lazy val executionContext: ExecutionContext = ???
  }
}

class SimpleTest extends TestingBase {

  "IDEA" should "not show errors here because it compiles :)" in new Context {
    Get("/test") ~> route ~> check { fail("just fail") }
  }

  trait Context extends ContextBase {
    def route: Route = ???
  }

}

