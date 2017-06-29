package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}


/**
  * Created by mituba on 2017/06/29.
  */
class ParamController @Inject() extends Controller  {
  def getParam = Action { request =>
    val params : Map[String, Seq[String]] = request.queryString
    val message = params("message").head


    Ok(message)
  }
}
