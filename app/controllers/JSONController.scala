package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}

import play.api.libs.json._

case class Person(username: String, password: String)
object Person {
  implicit def jsonWrites = Json.writes[Person]
  implicit def jsonReads = Json.reads[Person]
}

/**
  * Created by mituba on 2017/06/30.
  */
class JSONController @Inject() extends Controller {
  def jsonParse = Action { request =>
    // getRequestJson
    val params : Option[JsValue] = request.body.asJson
    val json = params.get

    // encode
    val result: JsResult[Person] = json.validate[Person]
    val person: Person = result.get
    println(person.username + " " + person.password)

    // decode
    val decodeJson: JsValue = Json.toJson(person)
    println(decodeJson.toString())

    Ok(decodeJson.toString())
  }
}
