
object composition {

  def id[A](x: A) = x

  def composition[A, B, C](f: A => B, g: B => C) = (x: A) => g(f(x))

}
