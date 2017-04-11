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

package views

import models.Video
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import play.api.i18n.Messages
import testutils.UnitTest
import views.html.index

class IndexSpec extends UnitTest {

  val videos: Seq[Video] = Seq(Video("abc123","Video 1"), Video("def456","Video 2"), Video("ghi789","Video 3"))
  val document: Document = Jsoup.parse(index(videos).body)

  "index" must {
    "use the title defined in the messages file" in {
      document.title mustBe Messages("index.title")
    }
    "use the heading defined in the messages file" in {
      document.getElementById("heading").text mustBe Messages("index.heading")
    }
    "display all videos in an unordered list" in {
      document.getElementById("videos").children.size mustBe videos.size
      videos.zipWithIndex.map { case (video, index) =>
        val elem = document.getElementById("videos").child(index).child(0)
        elem.id() mustBe s"watch-${video.id}"
        elem.text mustBe video.name
        elem.attr("href") mustBe controllers.routes.VideoController.show(video.id).url
      }
    }
  }

}
