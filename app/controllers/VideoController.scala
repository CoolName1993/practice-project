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

package controllers

import javax.inject.{Inject, Singleton}

import models.Video
import play.api.i18n.MessagesApi
import play.api.mvc.{Action, AnyContent}
import utils.CompressedHtml._

@Singleton
class VideoController @Inject()()(implicit val messagesApi: MessagesApi) extends FrontendController {

  def show(id: String): Action[AnyContent] = Action { implicit request =>
    Ok(views.html.video(Video(id,"TEST")).compressed)
  }

}
