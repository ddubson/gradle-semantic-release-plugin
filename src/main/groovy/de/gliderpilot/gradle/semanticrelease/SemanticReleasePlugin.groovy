/*
 * Copyright 2015 the original author or authors.
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
package de.gliderpilot.gradle.semanticrelease

import org.ajoberstar.gradle.git.release.base.ReleasePluginExtension
import org.ajoberstar.gradle.git.release.semver.PartialSemVerStrategy
import org.ajoberstar.gradle.git.release.semver.StrategyUtil
import org.gradle.api.Plugin
import org.gradle.api.Project

class SemanticReleasePlugin implements Plugin<Project> {

    void apply(Project project) {
        project.with {
            plugins.apply SemanticReleaseBasePlugin
            ReleasePluginExtension releaseExtension = project.extensions.findByType(ReleasePluginExtension)
            SemanticReleasePluginExtension semanticReleaseExtension = project.extensions.findByType(SemanticReleasePluginExtension)
            releaseExtension.with {
                versionStrategy semanticReleaseExtension.releaseStrategy
                defaultVersionStrategy = semanticReleaseExtension.snapshotStrategy
            }
        }
    }
}
