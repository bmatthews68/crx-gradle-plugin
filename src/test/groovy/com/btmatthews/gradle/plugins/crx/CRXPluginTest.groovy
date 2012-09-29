package com.btmatthews.gradle.plugins.crx

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import com.btmatthews.gradle.plugins.crx.tasks.CRXTask

import static org.junit.Assert.assertTrue

/**
 * Created with IntelliJ IDEA.
 * User: Brian
 * Date: 29/09/12
 * Time: 00:55
 * To change this template use File | Settings | File Templates.
 */
class CRXPluginTest {
    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'crx'

        assertTrue(project.tasks.crx instanceof CRXTask)
    }
}
