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

package utils

import play.twirl.api.Html
import testutils.UnitTest
import utils.CompressedHtml._

class CompressedHtmlSpec extends UnitTest {

  val testHtml: Html = Html(
    """
      |<p>hello</p>
      |
      |<p>goodbye</p>
    """.stripMargin)
  val testClass = CompressedHtml(testHtml)
  val expectedResult = Html("<p>hello</p><p>goodbye</p>")

  "htmlToCompressed" must {
    "implicitly convert Html to CompressedHtml" in {
      testHtml.compressed mustBe expectedResult
    }
  }

  "compressed" must {
    "compress the html" in {
      testClass.compressed mustBe expectedResult
    }
  }

}
