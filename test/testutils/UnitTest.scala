/* Copyright 2017 Christopher Boucher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package testutils

import org.scalamock.scalatest.MockFactory
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{MustMatchers, WordSpecLike}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import play.api.Application
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.inject.guice.GuiceApplicationBuilder

trait UnitTest extends WordSpecLike with MustMatchers with GeneratorDrivenPropertyChecks
  with MockFactory with ScalaFutures with I18nSupport {
  val app: Application = new GuiceApplicationBuilder().build()
  implicit val messagesApi: MessagesApi = app.injector.instanceOf[MessagesApi]
}
