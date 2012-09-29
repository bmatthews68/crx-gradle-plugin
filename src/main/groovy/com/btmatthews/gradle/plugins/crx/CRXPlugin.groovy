package com.btmatthews.gradle.plugins.crx

import org.gradle.api.Project
import org.gradle.api.Plugin
import com.btmatthews.gradle.plugins.crx.tasks.CRXTask

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 28/09/12
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
class CRXPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("crx", CRXPluginExtension)
        project.task('crx', type: CRXTask)
    }
}
