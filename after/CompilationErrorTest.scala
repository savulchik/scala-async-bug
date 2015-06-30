import scala.async.Async._
import scala.concurrent._

case class Foo(str: String) extends AnyVal

object CompilationErrorTest {
  def foo(implicit ec: ExecutionContext): Future[String] = async {
    "whatever value" match {
      case _ =>
        await(Future("whatever return type"))
        // Foo("value class matters")
    }
    "whatever return type"
  }

  def bar(implicit ec: ExecutionContext): Future[String] = async {
    "whatever value" match {
      case _ =>
        await(Future("whatever return type"))
        "not value class"
    }
    "whatever return type"
  }

  def foobar(implicit ec: ExecutionContext): Future[Unit] = async {
    "whatever value" match {
      case _ =>
        await(Future("whatever return type"))
        Foo("value class matters")
    }
  }
}

