package no.vedaadata.personedit.store

import org.sphix.collection.mutable.ObservableBuffer
import no.vedaadata.personedit.domain.db.Person
import no.vedaadata.personedit.model.PersonModel

abstract class Store[A] {
  def save(model: A)
} 


object PersonStore extends Store[PersonModel] {

  val init = Seq(
    Person("Per", "Hansen", 30, 1.73, 300000),
    Person("Jens", "Nilsen", 54, 1.82, 550000),
    Person("Anne", "Jensen", 43, 1.64, 400000))

 val items = (init map(p => PersonModel(p, this))).to[ObservableBuffer]
    
  
  def save(model: PersonModel) = {
    println("Saving " + model.toPerson)
  }
}