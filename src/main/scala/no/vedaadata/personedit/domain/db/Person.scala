package no.vedaadata.personedit.domain.db

case class Person(
  firstName: String,
  lastName: String,
  age: Int,
  height: Double,
  savings: BigDecimal)