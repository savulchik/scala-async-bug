import scala.async.Async._
import scala.concurrent._

case class Foo(str: String) extends AnyVal

object CompilationErrorTest {
  def foo(implicit ec: ExecutionContext): Future[String] = async {
    "whatever value" match {
      case _ =>
        await(Future("whatever return type"))
        Foo("value class matters")
    }
    "whatever return type"
  }
}

