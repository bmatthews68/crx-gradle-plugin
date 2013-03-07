package com.btmatthews.gradle.plugins.crx

import org.gradle.api.Project
import org.gradle.api.Plugin
import com.btmatthews.gradle.plugins.crx.tasks.CRXTask

/**
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 */
class CRXPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("crx", CRXPluginExtension)
        project.task('crx', type: CRXTask)
    }
}
