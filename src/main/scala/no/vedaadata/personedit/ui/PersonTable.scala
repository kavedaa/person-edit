package no.vedaadata.personedit.ui

import javafx.scene.control.TableView
import org.sphix.scene.control.Columns
import no.vedaadata.personedit.model.PersonModel
import org.sphix.scene.control.cell.TextFieldTableCell
import org.sphix.util.IntConverter
import org.sphix.util.DoubleConverter
import java.text.DecimalFormat
import org.sphix.util.BigDecimalConverter

class PersonTable extends TableView[PersonModel] with Columns[PersonModel] {

  setEditable(true)
  
  getSelectionModel setCellSelectionEnabled true
  
  val dcf = new DecimalFormat("0.00")
  
  val firstName = new Column(200)("Fornavn", _.firstName) {
    setCellFactory(TextFieldTableCell())
  }
  
  val lastName = new Column(200)("Etternavn", _.lastName) {
    setCellFactory(TextFieldTableCell())
  }
  
  val age = new Column(50)("Alder", _.age) {
    setCellFactory(TextFieldTableCell(IntConverter))
  }
  
  val height = new Column(50)("Høyde", _.height) {
    setCellFactory(TextFieldTableCell(new DoubleConverter(dcf)))
  }
    
  val savings = new Column(100)("Formue", _.savings) {
    setCellFactory(TextFieldTableCell(new BigDecimalConverter(dcf)))
  }
  
  getColumns addAll(firstName, lastName, age, height, savings)
}