package com.fyu.gatling.test


import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class Test extends Simulation{
  //设置请求的根路径
//  val httpConf = http.baseUrl("http://localhost:8080")
//  val blockPath = "/test/block?id=1"
//  val forkPath = "/test/fork?id=1"
  val sim_users = 200

//  var blockRequestName = "block"
//  var blockScenarioName = "block"
//  var forkRequestName = "fork"
//  var forkScenarioName = "fork"
//  val blockRequest = repeat(30){
//    exec(http(blockRequestName)
//    .get(blockPath)).pause(1,2)
//  }
//
//  val forkRequest = repeat(30){
//    exec(http(forkRequestName)
//      .get(forkPath)).pause(1,2)
//  }

//  val block = scenario(blockScenarioName).exec(blockRequest)
//  val fork = scenario(forkScenarioName).exec(forkRequest)
//  setUp(
//    block.inject(rampUsers(sim_users).during(30 seconds)
//    ).protocols(httpConf))

  val request = repeat(30){
//    exec(http("fork")
//    .get("http://localhost:8080/test/fork?id=1"))
//      .pause(1)
      exec(http("block")
      .get("http://localhost:8080/test/aggregate/1"))
      .pause(1)
  }

  val scn = scenario("test").exec(request)
  setUp(
    scn.inject(rampUsers(sim_users).during(30 seconds))
  )

}