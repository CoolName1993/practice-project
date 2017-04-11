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

import com.googlecode.htmlcompressor.compressor.HtmlCompressor
import play.twirl.api.Html

case class CompressedHtml(html: Html) {
  def compressed: Html = {
    val compressor = new HtmlCompressor()
    compressor.setRemoveIntertagSpaces(true)
    Html(compressor.compress(html.body))
  }
}

object CompressedHtml {
  implicit def htmlToCompressed(html: Html): CompressedHtml = CompressedHtml(html)
}
