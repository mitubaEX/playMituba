package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}

/**
  * Created by mituba on 2017/06/29.
  */
class TestController @Inject() extends Controller {
  def test = Action {
    Ok("hello")
  }
}
