package example

import com.example.Baz
import com.example.Foo
import com.example.FooMessage

object Hello extends App {
  val baz: Foo = Baz().withName("foobar")
  val msg: Array[Byte] = baz.asMessage.toByteArray
  val foo: Foo = FooMessage.parseFrom(msg).toFoo
}
