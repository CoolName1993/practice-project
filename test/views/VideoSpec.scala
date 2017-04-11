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
import testutils.UnitTest
import views.html.video

class VideoSpec extends UnitTest {

  val input: Video = Video("abc123","Video 1")
  val document: Document = Jsoup.parse(video(input).body)

  "show" must {
    "use the name of the video for the title" in {
      document.title mustBe input.name
    }
    "use the name of the video for the heading" in {
      document.getElementById("heading").text mustBe input.name
    }
    "display the video from file" in {
      document.getElementById("video").attr("src") mustBe controllers.routes.Assets.at(s"videos/${input.id}.webm").url
    }
  }

}
