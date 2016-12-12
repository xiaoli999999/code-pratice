import scala.swing._
class UI extends MainFrame {
	title = "LianXi"

	val button = new Button("Click"){}

	contents = new BoxPanel(Orientation.Vertical){
		contents += new BoxPanel(Orientation.Horizontal) {
			contents += Swing.HStrut(5)
			contents += button
		}
	}

}

object GuiProgramFive {
  def main(args: Array[String]) {
    val ui = new UI
    ui.visible = true
  }
}