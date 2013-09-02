package no.vedaadata.personedit

import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.layout.BorderPane
import no.vedaadata.personedit.ui.PersonTable
import no.vedaadata.personedit.store.PersonStore
import javafx.scene.Scene

object PersonEdit {
  def main(args: Array[String]) {
    Application launch classOf[PersonEdit]
  }
}

class PersonEdit extends Application {

  def start(stage: Stage) {
    
    val root = new BorderPane
    
    val personTable = new PersonTable {
      setItems(PersonStore.items)
    }
    
    root setCenter personTable
    
    stage setScene new Scene(root, 1200, 900)
    stage show()
  }
}