/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.core.check.extractor.substring

import io.gatling.core.check.DefaultMultipleFindCheckBuilder
import io.gatling.core.session.Expression

trait SubstringCheckType

class SubstringCheckBuilder(pattern: Expression[String]) extends DefaultMultipleFindCheckBuilder[SubstringCheckType, String, Int] {
  import SubstringExtractorFactory._
  override def findExtractor(occurrence: Int) = pattern.map(newSingleExtractor[Int](_, occurrence))
  override def findAllExtractor = pattern.map(newMultipleExtractor[Int])
  override def countExtractor = pattern.map(newCountExtractor)
}
