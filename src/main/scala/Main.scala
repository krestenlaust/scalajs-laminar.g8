import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom

@main def hello(): Unit =
  // Laminar initialization
  renderOnDomContentLoaded(dom.document.querySelector("#app"), appElement())

def appElement(): HtmlElement =
  div(
    h1("Hello Vite!"),
    h2(msg),
    ul(
      li("Item 1"),
      li("Item 2"),
    ),
  )

def msg = "I was compiled by Scala 3. :)"
