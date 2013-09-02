package no.vedaadata.personedit.model

import no.vedaadata.personedit.domain.db.Person
import org.sphix.Var
import no.vedaadata.personedit.store.Store

case class PersonModel(person: Person, store: Store[PersonModel]) {

  val firstName = Var(person.firstName)
  val lastName = Var(person.lastName)
  val age = Var(person.age)
  val height = Var(person.height)
  val savings = Var(person.savings)

  def fields = Seq(firstName, lastName, age, height, savings)
  
  fields foreach { f =>
  	f observe { store save this }
  }
  
  def toPerson = Person(
    firstName(),
    lastName(),
    age(),
    height(),
    savings())
}